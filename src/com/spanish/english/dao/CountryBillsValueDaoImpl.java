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

import com.spanish.english.form.CountryBillsValue;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CountryBillsValueDaoImpl implements CountryBillsValueDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateCountryBillsValue(
			CountryBillsValue countryBillsValue) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(countryBillsValue);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<CountryBillsValue> getCountryBillsValueList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CountryBillsValue.class);
		
		List<CountryBillsValue> list =  c.list();
		Set<CountryBillsValue> countryBillsValueList = new HashSet<CountryBillsValue>(list);

		tx.commit();
		session.close();
		return countryBillsValueList;
	}

	@Override
	public CountryBillsValue getCountryBillsValueById(long id) {
		Session session;
		CountryBillsValue  countryBillsValue = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(CountryBillsValue.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 countryBillsValue = (CountryBillsValue)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return countryBillsValue;
	}

	@Override
	public boolean deleteCountryBillsValue(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(CountryBillsValue.class, Id);
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
	public CountryBillsValue getLastCountryBillsValue() {
		Session session=sessionFactory.openSession();
		CountryBillsValue result = (CountryBillsValue) session.createQuery("from CountryBillsValue ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public Set<CountryBillsValue> getCountryBillsValueListByBillsValue(long bvid) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CountryBillsValue.class);
		c.createAlias("billsValue", "b");
		c.add(Restrictions.eq("b.id", bvid));
		
		List<CountryBillsValue> list =  c.list();
		Set<CountryBillsValue> countryBillsValueList = new HashSet<CountryBillsValue>(list);

		tx.commit();
		session.close();
		return countryBillsValueList;
	}

}
