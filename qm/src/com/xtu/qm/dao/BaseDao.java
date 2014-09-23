package com.xtu.qm.dao;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * ����һ������
	 * @param t
	 * @return
	 */
	public T save(T t);
	
	/**
	 * ����һ������
	 * @param t
	 * @return
	 */
	public T update(T t);
	
	/**
	 * ɾ��һ������
	 * @param t
	 * @return
	 */
	public T delete(T t);
	
	/**
	 * ͨ��id����һ������
	 * @param cla
	 * @param id
	 * @return
	 */
	public T find(Class cla,long id);
	
	/**
	 * ͨ��ָ��hql��ѯ������Ӧ����
	 * @param hql
	 * @return
	 */
	public List<T> findAll(String hql);
	
	/**
	 * ��ҳ��ѯ
	 * @param hql
	 * @param offset ��һ����¼����
	 * @param pageSize ÿҳ��¼��
	 * @return ��ǰҳ���¼
	 */
	public List<T> findByPage(String hql, final int offset, 
			final int pageSize);
	
	/**
	 * 
	 * @param hql
	 * @param value hql�еĲ���
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<T> findByPage(final String hql, final Object value, 
			final int offset, final int pageSize);
	
	/**
	 * 
	 * @param hql
	 * @param values hql�еĲ����б�
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<T> findByPage(final String hql, final Object[] values, 
			final int offset, final int pageSize);
}
