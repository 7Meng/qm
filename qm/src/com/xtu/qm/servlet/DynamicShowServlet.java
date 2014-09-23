package com.xtu.qm.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtu.qm.pojo.AccountInfo;
import com.xtu.qm.pojo.NewsInformation;
import com.xtu.qm.service.PageService;
import com.xtu.qm.utils.BeanFactory;

public class DynamicShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static PageService service = BeanFactory.getPageService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		Set<NewsInformation> set = service.getOnePage(NewsInformation.class, 0, 2);
		
		if (set == null || set.size() == 0) {
			response.sendRedirect("haha.html");
		}
		
		for (NewsInformation news: set) {
			System.out.println(news.getReleasetime());
			AccountInfo account = news.getAuthor();
			System.out.println(account.getUsername());
		}
		
		response.sendRedirect("haha.html");
	}
}
