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

import com.spanish.english.form.BillsValue;
import com.spanish.english.form.CoinsValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BillsValueDaoImpl implements BillsValueDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateBillsValue(BillsValue billsValue) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(billsValue);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<BillsValue> getBillsValueList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(BillsValue.class);
		
		List<BillsValue> list =  c.list();
		Set<BillsValue> billsValueList = new HashSet<BillsValue>(list);

		tx.commit();
		session.close();
		return billsValueList;
	}

	@Override
	public BillsValue getBillsValueById(long id) {
		Session session;
		BillsValue  billsValue = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(BillsValue.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 billsValue = (BillsValue)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return billsValue;
	}

	@Override
	public boolean deleteBillsValue(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(BillsValue.class, Id);
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
	public BillsValue getLastBillsValue() {
		Session session=sessionFactory.openSession();
		BillsValue result = (BillsValue) session.createQuery("from BillsValue ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public Set<BillsValue> getBillsValueListByBillsType(long btid) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(BillsValue.class);
		c.createAlias("billsType", "b");
		c.add(Restrictions.eq("b.id", btid));
		
		List<BillsValue> list =  c.list();
		Set<BillsValue> coinsValueList = new HashSet<BillsValue>(list);

		tx.commit();
		session.close();
		return coinsValueList;
	}

}
