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

import com.spanish.english.form.CountryCoinsValue;
import com.spanish.english.form.CountryTokensValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CountryTokensValueDaoImpl implements CountryTokensValueDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateCountryTokensValue(
			CountryTokensValue countryTokensValue) {
			boolean flag = false;
		    try{    
		    	session = sessionFactory.openSession();
				tx = session.beginTransaction();
				session.saveOrUpdate(countryTokensValue);
				tx.commit();
				session.close();
				flag = true;
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;
	}

	@Override
	public Set<CountryTokensValue> getCountryTokensValueList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CountryTokensValue.class);
		
		List<CountryTokensValue> list =  c.list();
		Set<CountryTokensValue> countryTokensValueList = new HashSet<CountryTokensValue>(list);

		tx.commit();
		session.close();
		return countryTokensValueList;
	}

	@Override
	public CountryTokensValue getCountryTokensValueById(long id) {
		Session session;
		CountryTokensValue  countryTokensValue = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(CountryTokensValue.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 countryTokensValue = (CountryTokensValue)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return countryTokensValue;
	}

	@Override
	public boolean deleteCountryTokensValue(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(CountryTokensValue.class, Id);
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
	public CountryTokensValue getLastCountryTokensValue() {
		Session session=sessionFactory.openSession();
		CountryTokensValue result = (CountryTokensValue) session.createQuery("from CountryTokensValue ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public Set<CountryTokensValue> getCountryTokensValueListByTokensValue(
			long cvid) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CountryTokensValue.class);
		c.createAlias("tokensValue", "t");
		c.add(Restrictions.eq("t.id", cvid));
		
		List<CountryTokensValue> list =  c.list();
		Set<CountryTokensValue> countryTokensValueList = new HashSet<CountryTokensValue>(list);

		tx.commit();
		session.close();
		return countryTokensValueList;
	}

}
