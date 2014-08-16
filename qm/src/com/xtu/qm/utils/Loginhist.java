package com.xtu.qm.utils;

import java.util.HashMap;

import com.xtu.qm.pojo.AccountInfo;
/**
 * ��¼�û���������
 * @author feng
 *
 */
public class Loginhist {

	HashMap<String,AccountInfo> currentaccount=new HashMap<String,AccountInfo>();
	
	
	
	public Loginhist() {
		super();
		if(currentaccount==null)
		{
			currentaccount=new HashMap<String,AccountInfo>();
		}
	}

	public void addAccountInfo(AccountInfo account)
	{
		currentaccount.put(account.getUsername(), account);
	}
	
	public void removeAccountInfo(String username)
	{
		currentaccount.remove(username);
	}
	
	public AccountInfo getCurrentInfo(String username)
	{
		return currentaccount.get(username);
	}
	
	public int getCurrentnumber()
	{
		return currentaccount.size();
	}
	
}
