package com.xtu.qm.servlet;

import static java.lang.System.out;

import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xtu.qm.pojo.AccountInfo;
import com.xtu.qm.pojo.StuInformation;
import com.xtu.qm.pojo.UserInfo;
import com.xtu.qm.service.UserService;
import com.xtu.qm.utils.BeanFactory;


public class SettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Pattern DECIMAL = Pattern.compile("\\d+");

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		UserService service = BeanFactory.getUserservice();
		String action = request.getParameter("action");
		
		if ("PersonalInfo".equals(action)) {
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				Object param = e.nextElement();
				System.out.println(param + "---" + request.getParameter(param.toString()));
			}
			
			doSetPersonalInfo(request, response, service);
		}
		
		
		response.sendRedirect("setting.jsp");
	}
	
	private void doSetPersonalInfo(HttpServletRequest request, 
			HttpServletResponse response, UserService service) {
		// �������
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String date = request.getParameter("date");
		String calendar = request.getParameter("calendar");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String college = request.getParameter("college");
		String grade = request.getParameter("grade");
		String[] interests = request.getParameterValues("interests");
		String[] types = request.getParameterValues("types");
		
		// �˻���Ϣ
		HttpSession session = request.getSession();
		AccountInfo account = (AccountInfo)session.getAttribute("AccountInfo");
		UserInfo user = account.getUserinfo();
		StuInformation stuInfo = user.getStuInfo();
		
		// ������������
		Calendar cal = Calendar.getInstance();
		int y = -1, m = -1, d = -1;
		if (year != null) {
			Matcher matcher = DECIMAL.matcher(year);
			if (matcher.find()) {
				y = Integer.parseInt(matcher.group());
			}
		}
		if (month != null) {
			Matcher matcher = DECIMAL.matcher(month);
			if (matcher.find()) {
				m = Integer.parseInt(matcher.group()) - 1;
			}
		}
		if (date != null) {
			Matcher matcher = DECIMAL.matcher(date);
			if (matcher.find()) {
				d = Integer.parseInt(matcher.group());
			}
		}
		// ������������
		if (y != -1 && m != -1 && d != -1) {
			cal.set(y, m, d, 0, 0, 0);
			user.setBirthday(cal.getTime());
		}
		// ���ֻ��������ݣ�û�������·ݻ�����
		// ����Ϊ1��1��
		else if (y != -1 && (m == -1 || d == -1)) { 
			cal.set(y, 0, 1, 0, 0, 0);
			user.setBirthday(cal.getTime());
		} 
		// û���������,����������
		else if (y == -1) {
			user.setBirthday(null);
		}
		
		if (calendar != null) {
			user.setBirthdayType(calendar);
		}
		// ���õ�ַ
		String address = null;
		if (province != null) {
			address = province + "&&";
			if (city != null) {
				address += city;
			}
		}
		if (address != null) {
			user.setHomeAddress(address);
		}
		
		// ���ò���ѧ����Ϣ
		if (college != null) {
			stuInfo.setDepartment(college);
		} else {
			stuInfo.setDepartment(null);
		}
		if (grade != null) {
			stuInfo.setEntranceYear(grade);
		} else {
			stuInfo.setEntranceYear(null);
		}
		
		// ���˱�ǩ
		if (interests != null && interests.length != 0) {
			String intr = "";
			for (String interest: interests) {
				intr += (interest + "&&");
			}
			user.setInterests(intr);
		} else {
			user.setInterests(null);
		}
		
		if (types != null && types.length != 0) {
			String tp = "";
			for (String type: types) {
				tp += (type + "&&");
			}
			user.setType(tp);
		} else {
			user.setType(null);
		}
		service.update(account);
	}
}
