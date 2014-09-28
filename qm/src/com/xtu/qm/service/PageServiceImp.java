package com.xtu.qm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xtu.qm.dao.DynamicMsgDao;
import com.xtu.qm.pojo.NewsInformation;

@Service("PageService")
public class PageServiceImp implements PageService {
	
	@Resource(name="DynamicMsgDao")
	DynamicMsgDao dynamicDao;
	
	/**
	 * 因为type 决定了返回值，所以是类型安全的
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getOnePage(Class<T> type, int offset, int pageSize) {
		if (type.equals(NewsInformation.class))
			return (List<T>) dynamicDao.findByPage(offset, pageSize);
		
		return null;
	}

}
