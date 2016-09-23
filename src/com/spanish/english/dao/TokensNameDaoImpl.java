package com.spanish.english.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.form.TokensName;
import com.spanish.english.form.TokensType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TokensNameDaoImpl implements TokensNameDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateTokensName(TokensName tokensName) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(tokensName);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<TokensName> getTokensNameList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(TokensName.class);
		
		List<TokensName> list =  c.list();
		Set<TokensName> tokensNameList = new HashSet<TokensName>(list);

		tx.commit();
		session.close();
		return tokensNameList;
	}

	@Override
	public TokensName getTokensNameById(long id) {
		Session session;
		TokensName  tokensName = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(TokensName.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 tokensName = (TokensName)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return tokensName;
	}

	@Override
	public boolean deleteTokensName(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(TokensName.class, Id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

}
