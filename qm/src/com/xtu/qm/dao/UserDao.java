package com.xtu.qm.dao;

import com.xtu.qm.pojo.AccountInfo;

public interface UserDao extends BaseDao<AccountInfo>{

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
	 * ͨ�����������һ�����
	 */
	
	public AccountInfo findPasswordByEmail(long id,String email,String password);
	
	/**
	 * ͨ���û��ǳƲ����û�
	 * @param username
	 * @return
	 */
	public AccountInfo findaccountByusername(String username);
	
}
