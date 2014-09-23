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
	 * 通过指定hql查询所有相应数据
	 * @param hql
	 * @return
	 */
	public List<T> findAll(String hql);
	
	/**
	 * 分页查询
	 * @param hql
	 * @param offset 第一条记录索引
	 * @param pageSize 每页记录数
	 * @return 当前页面记录
	 */
	public List<T> findByPage(String hql, final int offset, 
			final int pageSize);
	
	/**
	 * 
	 * @param hql
	 * @param value hql中的参数
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<T> findByPage(final String hql, final Object value, 
			final int offset, final int pageSize);
	
	/**
	 * 
	 * @param hql
	 * @param values hql中的参数列表
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<T> findByPage(final String hql, final Object[] values, 
			final int offset, final int pageSize);
}
