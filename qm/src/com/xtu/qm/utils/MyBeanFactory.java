package com.xtu.qm.utils;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanFactory {
	private static ApplicationContext appContext =
			new ClassPathXmlApplicationContext( "beans.xml");

public synchronized static ApplicationContext getBeanFactroy() {
if (null == appContext)
	appContext = new ClassPathXmlApplicationContext(
			"beans.xml");

return appContext;
}

public static void main(String args[])
{
	MyBeanFactory.getBeanFactroy();
	
	
}
}
