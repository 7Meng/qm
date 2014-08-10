package com.xtu.qm.dao;

import java.util.List;

public interface BaseDao<T> {

	public T save(T t);
	
	public T update(T t);
	
	public T delete(T t);
	
	public T find(Class cla,long id);
	
	public List<T> findAll(String sql);
	
	
}
