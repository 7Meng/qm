package com.xtu.qm.service;

import java.util.Set;

public interface PageService {
	/**
	 * 获取一页更新
	 * @param offset
	 * @param pageSize
	 * @return 消息集合
	 */
	public <T> Set<T> getOnePage(Class<T> type, int offset, int pageSize);
}
