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

import com.spanish.english.form.BillsNameValue;
import com.spanish.english.form.TokensNameValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BillsNameValueDaoImpl implements BillsNameValueDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateBillsNameValue(BillsNameValue tokensName) {
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
	public Set<BillsNameValue> getBillsNameValueList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(BillsNameValue.class);
		
		List<BillsNameValue> list =  c.list();
		Set<BillsNameValue> tokensNameValueList = new HashSet<BillsNameValue>(list);

		tx.commit();
		session.close();
		return tokensNameValueList;
	}

	@Override
	public BillsNameValue getBillsNameValueById(long id) {
		Session session;
		BillsNameValue  tokensNameValue = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(BillsNameValue.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 tokensNameValue = (BillsNameValue)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return tokensNameValue;
	}

	@Override
	public boolean deleteBillsNameValue(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(BillsNameValue.class, Id);
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
	public Set<BillsNameValue> getBillsNameValueByCountry(long cID) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(BillsNameValue.class);
		c.createAlias("country", "c");
		c.add(Restrictions.eq("c.id", cID));
		
		List<BillsNameValue> list =  c.list();
		Set<BillsNameValue> coinsValueList = new HashSet<BillsNameValue>(list);

		tx.commit();
		session.close();
		return coinsValueList;
	}

	@Override
	public BillsNameValue getBillsNameValueByCountryAndBillsName(
			long countryID, long billsNameID) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(BillsNameValue.class);
		c.createAlias("country", "c");
		c.add(Restrictions.eq("c.id", countryID));
		c.createAlias("billsName", "b");
		c.add(Restrictions.eq("b.id", billsNameID));
		
		Object result=c.uniqueResult();
		BillsNameValue tokensNameValue = (BillsNameValue)result;

		tx.commit();
		session.close();
		return tokensNameValue;
	}

}
