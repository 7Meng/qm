package com.xtu.qm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xtu.qm.pojo.AccountInfo;

@Repository("userDao")
public class UserDaoImp  extends BaseDaoImp<AccountInfo> implements UserDao{

	public AccountInfo loginByusername(String username, String password) {
		// TODO Auto-generated method stub
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria ql=session.createCriteria(AccountInfo.class);
		ql.add(Restrictions.eq("username", username));
		ql.add(Restrictions.eq("password", password));
		try{
		List<AccountInfo> list=ql.list();
		if(list != null && list.size() != 0){
			AccountInfo accountInfo=list.get(0);
			return accountInfo;
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	public AccountInfo loginByemail(String email, String password) {
		// TODO Auto-generated method stub
	    Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria ql=session.createCriteria(AccountInfo.class);
		ql.add(Restrictions.eq("email", email));
		ql.add(Restrictions.eq("password", password));
		try{
		List<AccountInfo> list=ql.list();
		if(list != null && list.size() != 0){
			AccountInfo accountInfo=list.get(0);
			return accountInfo;
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public AccountInfo findPasswordByEmail(long id, String email,
			String password) {
		// TODO Auto-generated method stub
		
		AccountInfo accountInfo =find(AccountInfo.class, id);
		if(accountInfo.getEmail().equals(email))
		{
			accountInfo.setPassword(password);
			accountInfo =update(accountInfo);
			return accountInfo;
		}else
		{
			return null;
		}
		
	}

	public AccountInfo findaccountByusername(String username) {
		// TODO Auto-generated method stub
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(AccountInfo.class);
		criteria.add(Restrictions.eq("username", username));
		try{
		List<AccountInfo> list=criteria.list();
		if(list.size()>0)
		{
			AccountInfo accountinfo=list.get(0);
			return accountinfo;
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	
	

}
