package com.xtu.qm.dao;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * 保存一个数据
	 * @param t
	 * @return
	 */
	public T save(T t);
	
	/**
	 * 更新一个数据
	 * @param t
	 * @return
	 */
	public T update(T t);
	
	/**
	 * 删除一个数据
	 * @param t
	 * @return
	 */
	public T delete(T t);
	
	/**
	 * 通过id查找一个数据
	 * @param cla
	 * @param id
	 * @return
	 */
	public T find(Class cla,long id);
	
	/**
	 * 通过指定sql查询所有相应数据
	 * @param sql
	 * @return
	 */
	public List<T> findAll(String sql);
	
	
}
