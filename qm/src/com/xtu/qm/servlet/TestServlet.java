package com.xtu.qm.servlet;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.xtu.qm.utils.ToStringUtil;

import static java.lang.System.out;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
			// 输出参数
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				Object param = e.nextElement();
				System.out.println(param + "---" + request.getParameter(param.toString()));
			}
			response.sendRedirect("setting.jsp");
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		 
		ServletContext servletContext = this.getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
			    FileItem item = iter.next();

			    if (item.isFormField()) {
			    	String name = item.getFieldName();
			        String value = item.getString("utf-8");
			        out.println(name+"---"+value);
			        //processFormField(item);
			    } else {
			    	String fieldName = item.getFieldName();
			        String fileName = item.getName();
			        String contentType = item.getContentType(); // 我们支持类型 image/png, image/jpeg, image/bmp
			        boolean isInMemory = item.isInMemory();
			        
			        // 类型检查
			        String[] group = contentType.split("/");
			        String type = null;
			        // 
			        if (group.length == 2) {
			        	type = group[1];
			        	// log -- type 信息丢失
			        }
			        long sizeInBytes = item.getSize();
			        out.println(fieldName+"---"+fileName+"---"+contentType+"---"+isInMemory+"---"+sizeInBytes);
			        //servletContext.get
			        String uploadDir = servletContext.getRealPath("/customer-images/life-photo");
			        String uploadPath = null;
			        try {
						MessageDigest md5 = MessageDigest.getInstance("MD5");
						md5.update(item.get());
						
						String uploadFileName = ToStringUtil.byteArrayToHexString(md5.digest());
						uploadPath = uploadDir + File.separator + uploadFileName + "." + type;
						out.println(uploadPath);
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        File file = new File(uploadPath);
			        if (!file.exists()) {
			        	try {
							item.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        } else {
			        	// log 
			        	out.println("file exist");
			        }
			         
			        
			        //out.println(uploadPath);
			        //processUploadedFile(item);
			        
			    }
			}
			
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*
		JsonObject root = new JsonObject();
		
		JsonObject json = new JsonObject();
		json.addProperty("name", "周晴宇");
		json.addProperty("email", "zhouqingyu@7meng.org");
		
		JsonObject json2 = new JsonObject();
		json2.addProperty("name", "杨怀中");
		json2.addProperty("email", "yanghuaizhong@7meng.org");
		
		JsonArray array = new JsonArray();
		array.add(json);
		array.add(json2);
		
		root.add("persons", array);
		
		System.out.println(root.toString());
		
		response.getWriter().append(root.toString());*/
		response.sendRedirect("setting.jsp");
	}
}
