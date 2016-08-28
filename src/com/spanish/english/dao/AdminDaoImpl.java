package com.spanish.english.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.form.Admin;
import com.spanish.english.form.Role;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminDaoImpl implements AdminDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean login(String username, String password) {
		boolean flag=true;
	    try{  	
	    session = sessionFactory.openSession();
		Criteria c = session.createCriteria(Admin.class);
		c.add(Restrictions.eq("adminUsername",username));
		c.add(Restrictions.eq("adminPassword", password));
		Object o = c.uniqueResult();
			if(o==null){
				flag=false;
			}
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    session.close();
		return flag;	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Admin getAdminByUsername(String username) {
		Session session;
		Admin  admin = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Admin.class);
			 criteria.add(Restrictions.eq("adminUsername", username));
			 Object result=criteria.uniqueResult();
			 admin = (Admin)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return admin;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Admin getUserByUsername(String username) {
		Admin admin = null;
	    try{  	
	    session = sessionFactory.openSession();
		Criteria c = session.createCriteria(Admin.class);
		c.add(Restrictions.eq("adminUsername",username));
		
		 admin =(Admin) c.uniqueResult();
			
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    session.close();
	    Role r = new Role();
        r.setName("ROLE_ADMIN");
        List<Role> roles = new ArrayList<Role>();
        roles.add(r);
        admin.setAuthorities(roles);
		return admin;	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean addOrUpdateAdmin(Admin admin) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(admin);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}
	
	
}
