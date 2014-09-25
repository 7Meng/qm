package com.xtu.qm.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtu.qm.pojo.AccountInfo;
import com.xtu.qm.pojo.NewsInformation;
import com.xtu.qm.pojo.UserImage;
import com.xtu.qm.pojo.UserInfo;
import com.xtu.qm.service.PageService;
import com.xtu.qm.utils.BeanFactory;

public class DynamicUpdateServlet extends HttpServlet {
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
		
		List<NewsInformation> list = service.getOnePage(NewsInformation.class, 0, 10);
		if (list == null || list.size() == 0) {
			response.sendRedirect("haha.html");
		}
		System.out.println(list.size());
		
		for (NewsInformation n: list) {
			UserInfo user = n.getAuthor().getUserinfo();
			UserImage image = user.getUserLogo();
			String url = image.getSmallimageUrl();
			System.out.println(url);
		}
		
		response.sendRedirect("haha.html");
	}

}
