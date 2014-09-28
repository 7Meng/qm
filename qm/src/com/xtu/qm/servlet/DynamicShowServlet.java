package com.xtu.qm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		// 简单的显示，并没有根据阅读量排序
		List<NewsInformation> list = service.getOnePage(NewsInformation.class, 0, 10);
		if (list == null || list.size() == 0) {
			response.sendRedirect("dynamic.jsp");
			return;
		}
		
		for (NewsInformation n: list) {
			List<NewsInformation> l = n.getResponse();
			System.out.println(l.size());
		}
		
		request.setAttribute("DynamicSet", list);
		RequestDispatcher ds = request.getRequestDispatcher("dynamic.jsp");
		ds.forward(request, response);
	}
}
