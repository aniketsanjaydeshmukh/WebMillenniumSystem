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

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CoinsTypeDaoImpl implements CoinsTypeDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateCoinsType(CoinsType machineType) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(machineType);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}
	
	@Override
	public Set<CoinsType> getCoinsTypeList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CoinsType.class);
		
		List<CoinsType> list =  c.list();
		Set<CoinsType> coinsTypeList = new HashSet<CoinsType>(list);

		tx.commit();
		session.close();
		return coinsTypeList;
	}
	
	@Override
	public CoinsType getCoinsTypeById(long id) {
		Session session;
		CoinsType  coinsType = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(CoinsType.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 coinsType = (CoinsType)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return coinsType;
	}
	
	@Override
	public boolean deleteCoinsType(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(CoinsType.class, Id);
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
	public CoinsType getLastCoinsType() {
		Session session=sessionFactory.openSession();
		CoinsType result = (CoinsType) session.createQuery("from CoinsType ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public CoinsType getCoinsTypeByCoinValidatorType(long cvtId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CoinsType.class);
		c.createAlias("coinValidatorType", "c");
		c.add(Restrictions.eq("c.id", cvtId));
		
		 Object result=c.uniqueResult();
		 CoinsType coinsType = (CoinsType)result;

		tx.commit();
		session.close();
		return coinsType;
	}
	
	

}
