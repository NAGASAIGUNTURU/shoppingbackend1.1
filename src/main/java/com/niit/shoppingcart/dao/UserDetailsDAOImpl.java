package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;

@Repository(value="userDetailsDAO")
@SuppressWarnings("deprecation")
public class UserDetailsDAOImpl implements UserDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean save(UserDetails userDetails){
		try {
			sessionFactory.getCurrentSession().save(userDetails);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean update(UserDetails userDetails){
		try {
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(UserDetails userDetails){
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  UserDetails get(String id){
		
		String hql = "from UserDetails where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  List<UserDetails> list(){
		
		String hql ="from UserDetails";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
	}
	public java.util.List<UserDetails> List() {
		// TODO Auto-generated method stub
		return null;
	}
		
	
}
