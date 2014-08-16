package com.xtu.qm.service;

import com.xtu.qm.pojo.AccountInfo;

public interface UserService extends BaseService<AccountInfo> {
	/**
	 * ͨ���ǳƵ�¼
	 * @param username
	 * @param password
	 * @return
	 */
	public AccountInfo loginByusername(String username,String password);
	
	/**
	 * ͨ�������¼
	 */
	
	public AccountInfo loginByemail(String email,String password);
	
	/**
	 * ͨ���û��ǳƲ����û�
	 * @param username
	 * @return
	 */
	public AccountInfo findaccountByusername(String username);
	
	
}
