package com.xtu.qm.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xtu.qm.pojo.AccountInfo;
import com.xtu.qm.pojo.PersonalSpace;
import com.xtu.qm.pojo.StuInformation;
import com.xtu.qm.pojo.UserImage;
import com.xtu.qm.pojo.UserInfo;
import com.xtu.qm.service.UserService;
import com.xtu.qm.utils.BeanFactory;
import com.xtu.qm.utils.Loginhist;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String DEFAULT_MALE_IMAGE = "image/boy.jpg"; 
	private static final String DEFAULT_FEMALE_IMAGE = "image/girl.jpg";
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
		
		HttpSession session = request.getSession();
		
		String username=request.getParameter("usernamesignup");
		String password=request.getParameter("passwordsignup");
		String sex=request.getParameter("sex");
		
		// 学籍信息
		StuInformation stuInfo = new StuInformation();
		
		// 设置个人空间
		PersonalSpace zone = new PersonalSpace();
		//zone
		
		// 设置用户信息
		UserImage logo = new UserImage();
		UserInfo userInfo = new UserInfo();
		if ("male".equals(sex)) {	
			logo.setBigimageUrl(DEFAULT_MALE_IMAGE);
			logo.setSmallimageUrl(DEFAULT_MALE_IMAGE);
		} else {
			logo.setBigimageUrl(DEFAULT_FEMALE_IMAGE);
			logo.setSmallimageUrl(DEFAULT_FEMALE_IMAGE);
		}
		userInfo.setUserLogo(logo);
		userInfo.setPersonalspace(zone);
		userInfo.setStuInfo(stuInfo);
		
		// 设置账户信息
		AccountInfo account=new AccountInfo();
		account.setCreditvalue(40);
		account.setPassword(password);
		account.setRegisterTime(new Date());
		account.setUsername(username);
		account.setSex(sex);
		account.setState(1);
		account.setUserinfo(userInfo);
		
		UserService service=BeanFactory.getUserservice();
		AccountInfo accou=service.save(account);
		
		if(accou!=null)
		{
			Loginhist login=new Loginhist();
			login.addAccountInfo(account);
			session.setAttribute("currentlist", login);
			session.setAttribute("AccountInfo", account);
			response.sendRedirect("dynamic.jsp");
		}
	}
}
