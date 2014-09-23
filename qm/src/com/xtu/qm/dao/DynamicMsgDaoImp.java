package com.xtu.qm.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.xtu.qm.pojo.NewsInformation;

@Repository("DynamicMsgDao")
public class DynamicMsgDaoImp extends BaseDaoImp<NewsInformation> 
			implements DynamicMsgDao {

	public Set<NewsInformation> findByPage(int offset, int pageSize) {
		String hql = "from " + NewsInformation.class.getName() + " news "
				+ " order by news.releasetime desc ";
		Set<NewsInformation> set = new HashSet<NewsInformation>();
		
		List<NewsInformation> list = this.findByPage(hql, offset, pageSize);
		set.addAll(list);
		
		return set;
	}

}
