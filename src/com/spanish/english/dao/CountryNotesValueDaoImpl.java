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
import com.spanish.english.form.CountryNotesValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CountryNotesValueDaoImpl implements CountryNotesValueDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	
	@Override
	public boolean addOrUpdateCountryNotesValue(
			CountryNotesValue countryNotesValue) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(countryNotesValue);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<CountryNotesValue> getCountryNotesValueList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CountryNotesValue.class);
		
		List<CountryNotesValue> list =  c.list();
		Set<CountryNotesValue> countryCoinsValueList = new HashSet<CountryNotesValue>(list);

		tx.commit();
		session.close();
		return countryCoinsValueList;
	}

	@Override
	public CountryNotesValue getCountryNotesValueById(long id) {
		Session session;
		CountryNotesValue  countryCoinsValue = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(CountryNotesValue.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 countryCoinsValue = (CountryNotesValue)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return countryCoinsValue;
	}

	@Override
	public boolean deleteCountryNotesValue(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(CountryNotesValue.class, Id);
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
	public CountryNotesValue getLastCountryNotesValue() {
		Session session=sessionFactory.openSession();
		CountryNotesValue result = (CountryNotesValue) session.createQuery("from CountryNotesValue ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public Set<CountryNotesValue> getCountryNotesValueListByCoinsValue(long cvid) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CountryNotesValue.class);
		c.createAlias("coinsValue", "c");
		c.add(Restrictions.eq("c.id", cvid));
		
		List<CountryNotesValue> list =  c.list();
		Set<CountryNotesValue> countryCoinsValueList = new HashSet<CountryNotesValue>(list);

		tx.commit();
		session.close();
		return countryCoinsValueList;
	}

}
