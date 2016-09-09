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

import com.spanish.english.form.CoinsType;
import com.spanish.english.form.CountryCoinsValue;
import com.spanish.english.form.TokensType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TokensTypeDaoImpl implements TokensTypeDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	
	@Override
	public boolean addOrUpdateTokensType(TokensType tokensType) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(tokensType);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<TokensType> getTokensTypeList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(TokensType.class);
		
		List<TokensType> list =  c.list();
		Set<TokensType> tokensTypeList = new HashSet<TokensType>(list);

		tx.commit();
		session.close();
		return tokensTypeList;
	}

	@Override
	public TokensType getTokensTypeById(long id) {
		Session session;
		TokensType  tokensType = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(TokensType.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 tokensType = (TokensType)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return tokensType;
	}

	@Override
	public boolean deleteTokensType(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(TokensType.class, Id);
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
	public TokensType getLastTokensType() {
		Session session=sessionFactory.openSession();
		TokensType result = (TokensType) session.createQuery("from TokensType ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public TokensType getTokensTypeByHopperType(long hopperTypeID) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(TokensType.class);
		c.createAlias("hopperType", "h");
		c.add(Restrictions.eq("h.id", hopperTypeID));
		
		Object result=c.uniqueResult();
		TokensType tokensType = (TokensType)result;
		 

		tx.commit();
		session.close();
		return tokensType;
	}

}
