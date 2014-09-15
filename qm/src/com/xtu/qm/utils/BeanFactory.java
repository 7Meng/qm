package com.xtu.qm.utils;

import com.xtu.qm.service.BaseService;
import com.xtu.qm.service.UploadService;
import com.xtu.qm.service.UserService;

public class BeanFactory {

	
	public static UserService getUserservice()
	{
		return (UserService) MyBeanFactory.getBeanFactroy().getBean("userService");
	}
	
	public static BaseService getBaseservice()
	{
		return (BaseService)MyBeanFactory.getBeanFactroy().getBean("baseService");
	}
	
	public static UploadService getUploadService()
	{
		return (UploadService)MyBeanFactory.getBeanFactroy().getBean("UploadService");
	}
}
