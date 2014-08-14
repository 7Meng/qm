package com.xtu.qm.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xtu.qm.pojo.AccountInfo;
import com.xtu.qm.service.BaseService;
import com.xtu.qm.utils.MyBeanFactory;

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
		String username=request.getParameter("usernamesignup");
		String password=request.getParameter("passwordsignup");
		String sex=request.getParameter("sex");
		BaseService service=(BaseService)MyBeanFactory.getBeanFactroy().getBean("baseService");
		AccountInfo accountinfo=new AccountInfo();
		accountinfo.setUsername(username);
		accountinfo.setPassword(password);
		accountinfo.setState(1);
        accountinfo.setRegisterTime(new Date());
        accountinfo.setCreditvalue(40);
		AccountInfo accoun=(AccountInfo)service.save(accountinfo);
		if(accoun!=null){
			response.sendRedirect("");
		}
		
		
	}

}
