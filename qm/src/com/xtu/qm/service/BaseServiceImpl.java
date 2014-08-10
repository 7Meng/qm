package com.xtu.qm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xtu.qm.dao.BaseDao;

@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T> {

	@Resource(name="baseDao")
	private BaseDao basedao;
	public T save(T t) {
		// TODO Auto-generated method stub
		return (T)basedao.save(t);
	}

	public T update(T t) {
		// TODO Auto-generated method stub
		return (T)basedao.update(t);
	}

	public T delete(T t) {
		// TODO Auto-generated method stub
		return (T)basedao.delete(t);
	}

	public T find(Class cla, long id) {
		// TODO Auto-generated method stub
		return (T)basedao.find(cla, id);
	}

	public List<T> findAll(String sql) {
		// TODO Auto-generated method stub
		return basedao.findAll(sql);
	}

}
