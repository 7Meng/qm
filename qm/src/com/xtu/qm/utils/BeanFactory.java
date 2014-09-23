package com.xtu.qm.utils;

import com.xtu.qm.service.BaseService;
import com.xtu.qm.service.PageService;
import com.xtu.qm.service.UploadService;
import com.xtu.qm.service.UserService;

public class BeanFactory {

	
	public static UserService getUserservice()
	{
		return (UserService) MyBeanFactory.getBeanFactroy().getBean("userService");
	}
	
	@SuppressWarnings("unchecked")
	public static <T> BaseService<T> getBaseservice()
	{
		return (BaseService<T>) MyBeanFactory.getBeanFactroy().getBean("baseService");
	}
	
	public static UploadService getUploadService() {
		return (UploadService)MyBeanFactory.getBeanFactroy().getBean("UploadService");
	}
	
	public static PageService getPageService() {
		return (PageService) MyBeanFactory.getBeanFactroy().getBean("PageService");
	}
}
