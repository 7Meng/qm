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
	 * ͨ��ָ��sql��ѯ������Ӧ����
	 * @param sql
	 * @return
	 */
	public List<T> findAll(String sql);
	
	
}
