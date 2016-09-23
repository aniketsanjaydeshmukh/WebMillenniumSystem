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

import com.spanish.english.form.BillsName;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BillsNameDaoImpl implements BillsNameDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateBillsName(BillsName billsName) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(billsName);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<BillsName> getBillsNameList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(BillsName.class);
		
		List<BillsName> list =  c.list();
		Set<BillsName> billsNameList = new HashSet<BillsName>(list);

		tx.commit();
		session.close();
		return billsNameList;
	}

	@Override
	public BillsName getBillsNameById(long id) {
		Session session;
		BillsName  billsName = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(BillsName.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 billsName = (BillsName)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return billsName;
	}

	@Override
	public boolean deleteBillsName(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(BillsName.class, Id);
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

}
