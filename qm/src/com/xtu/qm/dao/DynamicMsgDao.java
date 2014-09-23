package com.xtu.qm.dao;

import java.util.Set;

import com.xtu.qm.pojo.NewsInformation;

public interface DynamicMsgDao {
	Set<NewsInformation> findByPage(int offset, int pageSize);
}
