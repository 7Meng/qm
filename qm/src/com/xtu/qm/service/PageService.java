package com.xtu.qm.service;

import java.util.List;

public interface PageService {
	/**
	 * ��ȡһҳ����
	 * @param offset
	 * @param pageSize
	 * @return ��Ϣ����
	 */
	public <T> List<T> getOnePage(Class<T> type, int offset, int pageSize);
}
