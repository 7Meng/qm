package com.xtu.qm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtu.qm.pojo.AccountInfo;
import com.xtu.qm.service.UserService;
import com.xtu.qm.utils.BeanFactory;

/**
 * Servlet implementation class validateusernameServlet
 */
public class validateusernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validateusernameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		UserService userservice=BeanFactory.getUserservice();
		AccountInfo accountinfo=userservice.findaccountByusername(username);
		if(accountinfo!=null){
			response.getWriter().print("no");
		}else
		{
			response.getWriter().print("yes");
		}
		
	}

}
