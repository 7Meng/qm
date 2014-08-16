package com.xtu.qm.service;

import com.xtu.qm.pojo.AccountInfo;

public interface UserService extends BaseService<AccountInfo> {
	/**
	 * 通过昵称登录
	 * @param username
	 * @param password
	 * @return
	 */
	public AccountInfo loginByusername(String username,String password);
	
	/**
	 * 通过邮箱登录
	 */
	
	public AccountInfo loginByemail(String email,String password);
	
	/**
	 * 通过用户昵称查找用户
	 * @param username
	 * @return
	 */
	public AccountInfo findaccountByusername(String username);
	
	
}
