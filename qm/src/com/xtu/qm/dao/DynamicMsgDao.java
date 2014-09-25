package com.xtu.qm.dao;

import java.util.List;

import com.xtu.qm.pojo.NewsInformation;

public interface DynamicMsgDao {
	List<NewsInformation> findByPage(int offset, int pageSize);
}
