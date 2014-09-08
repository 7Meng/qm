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
	 * Сͼ��ѹ������
	 */
	private static final float RATIO = 0.33F;
	/**
	 * ѹ������
	 */
	private static final float QUALITY = 0.7F;
	/**
	 * ͼ���С������
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
		
		// ����Ƿ����ϴ��ļ�
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
		
		// ���ƾ��
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// �����ϴ�λ�� 
		ServletContext servletContext = this.getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);
		// �ϴο��ƾ��
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// �����������
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
			    FileItem item = iter.next();
			    // �����һ�����
			    if (item.isFormField()) {
			    	// ���ø���ǩ��
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
	 * �����ϴ���������
	 * @param item
	 * @throws Exception
	 */
	private void processUploadedFile(FileItem item, UserInfo user) 
			throws Exception {
		
		//String fieldName = item.getFieldName();
        //String fileName = item.getName();
        String contentType = item.getContentType(); // ����֧������ image/png, image/jpeg, image/bmp
        long sizeInBytes = item.getSize();
        
        // ���ͼ���С
        if (sizeInBytes > IMAGE_MAX_BYTE) {
        	// log-- �����������
        }
        
        // ���ͼ��
        Matcher matcher = IMAGE_TYPE.matcher(contentType);
        if (!matcher.find()) {
        	return;
        }
        String[] group = contentType.split("/");
        String type = null;
        if (group.length == 2) {
        	type = group[1];
        } else {
        	// log-- type ��Ϣ��ʧ
        }
        
        // ����ͼ��洢λ��
        String uploadDir = this.getServletContext().getRealPath("/customer-images/life-photo");
        String uploadPath = null;
        
        // ��ͼ�����MD5���㣬��õ�����ǩ����Ϊͼ����ļ���
     	MessageDigest md5 = MessageDigest.getInstance("MD5");
     	
     	md5.update(item.get());		
     	String uploadFileName = ToStringUtil.byteArrayToHexString(md5.digest());
     	uploadPath = uploadDir + File.separator + uploadFileName + "." + type;
        
     	// �洢ͼ��
        File file = new File(uploadPath);
        if (!file.exists()) {
        	item.write(file);
        } else {
        	// log--
        	out.println("file exist");
        }
        
        // ��ȡСͼ
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
