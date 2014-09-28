package com.xtu.qm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xtu.qm.pojo.NewsInformation;

@Repository("DynamicMsgDao")
public class DynamicMsgDaoImp extends BaseDaoImp<NewsInformation> 
			implements DynamicMsgDao {

	public List<NewsInformation> findByPage(int offset, int pageSize) {
		String hql = " from " + NewsInformation.class.getName() + " news "
				+ " where news.type = "+ NewsInformation.NewsInfoType.DYNAMIC
				+ " order by news.releasetime desc ";
		
		return (List<NewsInformation>)this.findByPage(hql, offset, pageSize);
	}
}
