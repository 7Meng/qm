package com.xtu.qm.servlet;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.xtu.qm.pojo.AccountInfo;
import com.xtu.qm.pojo.UserImage;
import com.xtu.qm.pojo.UserInfo;
import com.xtu.qm.service.UserService;
import com.xtu.qm.utils.BeanFactory;
import com.xtu.qm.utils.ImageUtil;
import com.xtu.qm.utils.ToStringUtil;

public class UploadLifePhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Pattern IMAGE_TYPE = Pattern.compile("image/(?:png|jpeg|bmp)");
	/**
	 * 小图的压缩比例
	 */
	private static final float RATIO = 0.33F;
	/**
	 * 压缩质量
	 */
	private static final float QUALITY = 0.7F;
	/**
	 * 图像大小的上限
	 * 200K Byte
	 */
	private static long IMAGE_MAX_BYTE = 200 * 1024;	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		UserService service = BeanFactory.getUserservice();
		
		// 检查是否有上传文件
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			response.sendRedirect("setting.jsp");
		}
		
		try {
			doSetSignaturePicture(request, response, service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("setting.jsp");
	}
	
	private void doSetSignaturePicture(HttpServletRequest request, 
			HttpServletResponse response, UserService service) throws Exception {
		
		HttpSession session = request.getSession();
		AccountInfo account = (AccountInfo) session.getAttribute("AccountInfo");
		UserInfo user = account.getUserinfo();
		
		// 控制句柄
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 配置上传位置 
		ServletContext servletContext = this.getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);
		// 上次控制句柄
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// 解析请求参数
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
			    FileItem item = iter.next();
			    // 如果是一般表单域
			    if (item.isFormField()) {
			    	// 设置个性签名
			        String field = item.getFieldName();
			        if ("signature".equals(field)) {
			        	user.setSignature(item.getString("utf-8"));
			        }
			    } else {
			    	processUploadedFile(item, user);
			    }
			}
			
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		service.update(account);
	}
	

	/**
	 * 处理上传的生活照
	 * @param item
	 * @throws Exception
	 */
	private void processUploadedFile(FileItem item, UserInfo user) 
			throws Exception {
		
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
        	return;
        }
        String[] group = contentType.split("/");
        String type = null;
        if (group.length == 2) {
        	type = group[1];
        } else {
        	// log-- type 信息丢失
        }
        
        // 设置图像存储位置
        String uploadDir = this.getServletContext().getRealPath("/customer-images/life-photo");
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
     	
     	image.setBigimageUrl("customer-images/life-photo" + "/" + uploadFileName + "." + type);
     	image.setSmallimageUrl("customer-images/life-photo" + "/" + smallFileName + "." + type);
     	user.setUserimage(image);
	}	
}
