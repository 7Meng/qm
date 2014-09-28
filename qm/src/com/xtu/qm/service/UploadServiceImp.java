package com.xtu.qm.service;

import static java.lang.System.out;

import java.io.File;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.springframework.stereotype.Service;

import com.xtu.qm.pojo.UserImage;
import com.xtu.qm.pojo.UserInfo;
import com.xtu.qm.utils.ImageUtil;
import com.xtu.qm.utils.ToStringUtil;

@Service("UploadService")
public class UploadServiceImp implements UploadService {
	private final Pattern IMAGE_TYPE = Pattern.compile("image/(?:png|jpeg|bmp)");
	/**
	 * 小图的压缩比例
	 */
	private final float RATIO = 0.33F;
	/**
	 * 压缩质量
	 */
	private final float QUALITY = 0.7F;
	/**
	 * 图像大小的上限
	 * 200K Byte
	 */
	private final long IMAGE_MAX_BYTE = 200 * 1024;
	
	public boolean uploadImage(ServletContext context, FileItem item, 
			UserInfo user, String savedPath) throws Exception {
		//String fieldName = item.getFieldName();
        //String fileName = item.getName();
        String contentType = item.getContentType(); // 我们支持类型 image/png, image/jpeg, image/bmp
        long sizeInBytes = item.getSize();
        
        // 检查图像大小
        if (sizeInBytes > IMAGE_MAX_BYTE) {
        	// log-- 超出最大限制
        }
        
        // 类型检查
        Matcher matcher = IMAGE_TYPE.matcher(contentType);
        if (!matcher.find()) {
        	return false;
        }
        String[] group = contentType.split("/");
        String type = null;
        if (group.length == 2) {
        	type = group[1];
        } else {
        	// log-- type 信息丢失
        }
        
        // 设置图像存储位置
        String uploadDir = context.getRealPath("/" + savedPath);
        String uploadPath = null;
        
        // 对图像进行MD5计算，获得的数据签名做为图像的文件名
     	MessageDigest md5 = MessageDigest.getInstance("MD5");
     	
     	md5.update(item.get());		
     	String uploadFileName = ToStringUtil.byteArrayToHexString(md5.digest());
     	uploadPath = uploadDir + File.separator + uploadFileName + "." + type;
        
     	// 存储图像
        File file = new File(uploadPath);
        if (!file.exists()) {
        	item.write(file);
        } else {
        	// log--
        	out.println("file exist");
        }
        
        // 获取小图
        String smallFileName = uploadFileName + "-S";
        String smallFilePath = uploadDir + File.separator + smallFileName + "." + type;
     	ImageUtil.resize(uploadPath, smallFilePath, RATIO, QUALITY);
     	
     	UserImage image = user.getUserimage();
     	if (image == null) {
     		image = new UserImage();
     	}
     	
     	image.setBigimageUrl(savedPath + "/" + uploadFileName + "." + type);
     	image.setSmallimageUrl(savedPath + "/" + smallFileName + "." + type);
     	user.setUserimage(image);
		return true;
	}

}
