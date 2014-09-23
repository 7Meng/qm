package com.xtu.qm.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xtu.qm.pojo.AccountInfo;
import com.xtu.qm.pojo.NewsInformation;
import com.xtu.qm.pojo.NewsInformation.NewsInfoType;
import com.xtu.qm.pojo.PersonalSpace;
import com.xtu.qm.pojo.UserInfo;
import com.xtu.qm.service.BaseService;
import com.xtu.qm.utils.BeanFactory;

public class PublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final BaseService<NewsInformation> service = BeanFactory.getBaseservice();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String dynamicMsg = request.getParameter("dynamicMsg");
		if (dynamicMsg == null) {
			response.sendRedirect(request.getServletPath());
		}
		
		HttpSession session = request.getSession();

		AccountInfo account = (AccountInfo) session.getAttribute("AccountInfo");
		UserInfo user = account.getUserinfo();
		PersonalSpace zone = user.getPersonalspace();
		List<NewsInformation> list = zone.getNews();
		System.out.println(list.size());
		NewsInformation news = new NewsInformation();
		// 设置发布时间
		Date date = new Date();
		news.setReleasetime(date);
		// 初始化阅读量
		news.setReadnumber(0);
		// 设置内容
		news.setContent(dynamicMsg);
		news.setAuthor(account);
		news.setType(NewsInfoType.DYNAMIC);
		// 更新httpSession的account info
		list.add(news);
		// 只需保存news即可
		service.save(news);
		
		response.sendRedirect("dynamic.jsp");
	}
}
