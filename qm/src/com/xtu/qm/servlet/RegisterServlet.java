package com.xtu.qm.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtu.qm.pojo.AccountInfo;
import com.xtu.qm.service.UserService;
import com.xtu.qm.utils.BeanFactory;
import com.xtu.qm.utils.Loginhist;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		response.setHeader("content-type", "text/html;charset=utf-8");
		String username=request.getParameter("usernamesignup");
		String password=request.getParameter("passwordsignup");
		String sex=request.getParameter("sex");
		AccountInfo account=new AccountInfo();
		account.setCreditvalue(40);
		account.setPassword(password);
		account.setRegisterTime(new Date());
		account.setUsername(username);
		account.setSex(sex);
		account.setState(1);
		UserService service=BeanFactory.getUserservice();
		AccountInfo accou=service.save(account);
		if(accou!=null)
		{
			Loginhist login=new Loginhist();
			login.addAccountInfo(account);
			request.getSession().setAttribute("currentlist", login);
			response.sendRedirect("");
		}
		
	}

}
