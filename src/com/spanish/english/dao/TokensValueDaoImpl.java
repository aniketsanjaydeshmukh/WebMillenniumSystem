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

import com.spanish.english.form.CoinsValue;
import com.spanish.english.form.TokensValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TokensValueDaoImpl implements TokensValueDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateTokensValue(TokensValue tokensValue) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(tokensValue);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<TokensValue> getTokensValueList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(TokensValue.class);
		
		List<TokensValue> list =  c.list();
		Set<TokensValue> tokensValueList = new HashSet<TokensValue>(list);

		tx.commit();
		session.close();
		return tokensValueList;
	}

	@Override
	public TokensValue getTokensValueById(long id) {
		Session session;
		TokensValue  tokensValue = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(TokensValue.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 tokensValue = (TokensValue)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return tokensValue;
	}

	@Override
	public boolean deleteTokensValue(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(TokensValue.class, Id);
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

	@Override
	public TokensValue getLastTokensValue() {
		Session session=sessionFactory.openSession();
		TokensValue result = (TokensValue) session.createQuery("from TokensValue ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public Set<TokensValue> getTokensValueListByTokensType(long ctid) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(TokensValue.class);
		c.createAlias("tokensType", "t");
		c.add(Restrictions.eq("t.id", ctid));
		
		List<TokensValue> list =  c.list();
		Set<TokensValue> tokensValueList = new HashSet<TokensValue>(list);

		tx.commit();
		session.close();
		return tokensValueList;
	}

}
