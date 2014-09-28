package com.xtu.qm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;

import com.xtu.qm.pojo.AccountInfo;
import com.xtu.qm.pojo.NewsInformation;
import com.xtu.qm.pojo.NewsInformation.NewsInfoType;
import com.xtu.qm.service.BaseService;
import com.xtu.qm.utils.BeanFactory;

public class PostCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final BaseService<NewsInformation> service = BeanFactory.getBaseservice();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String actionType = request.getParameter("actionType");
		String commentId = request.getParameter("commentId");
		String commentContent = request.getParameter("commentContent");
		
		// ��������Ϊ��
		if (commentContent == null || commentContent.length() == 0) {
			response.sendRedirect("DynamicShowServlet");
			return;
		}
		
		// ��̬��Ϣ�Ļظ�
		if ("postDynamicComment".equals(actionType)) {
			int id = Integer.parseInt(commentId);
			
			NewsInformation news = service.find(NewsInformation.class, id);
			// ������
			HttpSession session = request.getSession(); 
			AccountInfo account = (AccountInfo) session.getAttribute("AccountInfo");
			
			NewsInformation comment = new NewsInformation();
			// ����comment
			comment.setAuthor(account);
			comment.setReleasetime(new Date());
			comment.setContent(commentContent);
			comment.setType(NewsInfoType.DYNAMIC_RESPONSE);
			comment.setResponseTo(news);
			// �־û�
			service.save(comment);
		}
		
		response.sendRedirect("DynamicShowServlet");
		return;
	}
}
