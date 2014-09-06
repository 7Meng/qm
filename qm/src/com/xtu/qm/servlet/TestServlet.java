package com.xtu.qm.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("response get");
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//String q = request.getParameter("q");
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			Object param = e.nextElement();
			System.out.println(param + "---" + request.getParameter(param.toString()));
		}
/*		
		JsonObject root = new JsonObject();
		
		JsonObject json = new JsonObject();
		json.addProperty("name", "÷‹«Á”Ó");
		json.addProperty("email", "zhouqingyu@7meng.org");
		
		JsonObject json2 = new JsonObject();
		json2.addProperty("name", "—Óª≥÷–");
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
