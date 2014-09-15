package com.xtu.qm.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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
import com.xtu.qm.pojo.UserInfo;
import com.xtu.qm.service.UploadService;
import com.xtu.qm.service.UserService;
import com.xtu.qm.utils.BeanFactory;

public class UploadLifePhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final UserService userService = BeanFactory.getUserservice();
	private static final UploadService uploadService = BeanFactory.getUploadService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		// 检查是否有上传文件
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			response.sendRedirect("setting.jsp");
		}
		
		try {
			doSetSignaturePicture(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("setting.jsp");
	}
	
	private void doSetSignaturePicture(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
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
			    	uploadService.uploadImage(this.getServletContext(), item, 
			    			user, UploadService.LIFE_PHOTO_RELATIVE_PATH);
			    }
			}
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		
		userService.update(account);
	}	
}
