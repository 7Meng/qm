package com.xtu.qm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xtu.qm.dao.UserDao;
import com.xtu.qm.pojo.AccountInfo;

@Service("userService")
public class UserServiceImp extends BaseServiceImpl<AccountInfo> implements UserService{

	@Resource(name="userDao")
	private UserDao userdao;
	
	public AccountInfo loginByusername(String username, String password) {
		// TODO Auto-generated method stub
		return userdao.loginByusername(username, password);
	}

	public AccountInfo loginByemail(String email, String password) {
		// TODO Auto-generated method stub
		return userdao.loginByemail(email, password);
	}

	public AccountInfo findaccountByusername(String username) {
		// TODO Auto-generated method stub
		return userdao.findaccountByusername(username);
	}

}
