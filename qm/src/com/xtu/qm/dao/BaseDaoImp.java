package com.xtu.qm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("baseDao")
public class BaseDaoImp<T> extends HibernateDaoSupport implements BaseDao<T>{

    @Resource(name="sessionFacotry")
	public void anyway(SessionFactory sessionFactory)
	{
		setSessionFactory(sessionFactory);
	}
	
	
	public T save(T t) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().save(t);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return t;
	}

	public T update(T t) {
		// TODO Auto-generated method stub
		T tt=null;
		try{
		tt=(T)this.getHibernateTemplate().merge(t);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return tt;
	}

	public T delete(T t) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().delete(t);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return t;
	}

	public T find(Class cla, long id) {
		// TODO Auto-generated method stub
		T t=null;
		try{
	    t=(T)this.getHibernateTemplate().load(cla, id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return t;
	}

	public List<T> findAll(String sql) {
		// TODO Auto-generated method stub
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		Query ql=session.createQuery(sql);
		return ql.list();
	}

}
