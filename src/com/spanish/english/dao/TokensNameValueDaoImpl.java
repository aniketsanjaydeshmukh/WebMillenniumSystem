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

import com.spanish.english.form.TokensNameValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TokensNameValueDaoImpl implements TokensNameValueDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateTokensNameValue(TokensNameValue tokensNameValue) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(tokensNameValue);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<TokensNameValue> getTokensNameValueList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(TokensNameValue.class);
		
		List<TokensNameValue> list =  c.list();
		Set<TokensNameValue> tokensNameValueList = new HashSet<TokensNameValue>(list);

		tx.commit();
		session.close();
		return tokensNameValueList;
	}

	@Override
	public TokensNameValue getTokensNameValueById(long id) {
		Session session;
		TokensNameValue  tokensNameValue = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(TokensNameValue.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 tokensNameValue = (TokensNameValue)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return tokensNameValue;
	}

	@Override
	public boolean deleteTokensNameValue(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(TokensNameValue.class, Id);
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
	public Set<TokensNameValue> getTokensNameValueByCountry(long cID) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(TokensNameValue.class);
		c.createAlias("country", "c");
		c.add(Restrictions.eq("c.id", cID));
		
		List<TokensNameValue> list =  c.list();
		Set<TokensNameValue> coinsValueList = new HashSet<TokensNameValue>(list);

		tx.commit();
		session.close();
		return coinsValueList;
	}

	@Override
	public TokensNameValue getTokensNameValueByCountryAndTokensName(
			long countryID, long tokensNameID) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(TokensNameValue.class);
		c.createAlias("country", "c");
		c.add(Restrictions.eq("c.id", countryID));
		c.createAlias("tokensName", "t");
		c.add(Restrictions.eq("t.id", tokensNameID));
		
		Object result=c.uniqueResult();
		TokensNameValue tokensNameValue = (TokensNameValue)result;

		tx.commit();
		session.close();
		return tokensNameValue;
	}

}
