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
import com.spanish.english.form.CountryCoinsValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CountryCoinsValueDaoImpl implements CountryCoinsValueDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateCountryCoinsValue(
			CountryCoinsValue countryCoinsValue) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(countryCoinsValue);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<CountryCoinsValue> getCountryCoinsValueList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CountryCoinsValue.class);
		
		List<CountryCoinsValue> list =  c.list();
		Set<CountryCoinsValue> countryCoinsValueList = new HashSet<CountryCoinsValue>(list);

		tx.commit();
		session.close();
		return countryCoinsValueList;
	}

	@Override
	public CountryCoinsValue getCountryCoinsValueById(long id) {
		Session session;
		CountryCoinsValue  countryCoinsValue = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(CountryCoinsValue.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 countryCoinsValue = (CountryCoinsValue)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return countryCoinsValue;
	}

	@Override
	public boolean deleteCountryCoinsValue(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(CountryCoinsValue.class, Id);
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
	public CountryCoinsValue getLastCountryCoinsValue() {
		Session session=sessionFactory.openSession();
		CountryCoinsValue result = (CountryCoinsValue) session.createQuery("from CountryCoinsValue ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public Set<CountryCoinsValue> getCountryCoinsValueListByCoinsValue(long cvid) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CountryCoinsValue.class);
		c.createAlias("coinsValue", "c");
		c.add(Restrictions.eq("c.id", cvid));
		
		List<CountryCoinsValue> list =  c.list();
		Set<CountryCoinsValue> countryCoinsValueList = new HashSet<CountryCoinsValue>(list);

		tx.commit();
		session.close();
		return countryCoinsValueList;
	}

}
