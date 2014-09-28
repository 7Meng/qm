package com.xtu.qm.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanFactory {
	private static ApplicationContext appContext =
			new ClassPathXmlApplicationContext("beans.xml");

	public synchronized static ApplicationContext getBeanFactroy() {
		if (null == appContext)
			appContext = new ClassPathXmlApplicationContext("beans.xml");

		return appContext;
	}
}
