package com.xtu.qm.service;

import java.util.Set;

public interface PageService {
	/**
	 * ��ȡһҳ����
	 * @param offset
	 * @param pageSize
	 * @return ��Ϣ����
	 */
	public <T> Set<T> getOnePage(Class<T> type, int offset, int pageSize);
}
