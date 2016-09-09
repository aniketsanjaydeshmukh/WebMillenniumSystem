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

import com.spanish.english.form.BillsType;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BillsTypeDaoImpl implements BillsTypeDao{


	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateBillsType(BillsType billsType) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(billsType);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<BillsType> getBillsTypeList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(BillsType.class);
		
		List<BillsType> list =  c.list();
		Set<BillsType> billsTypeList = new HashSet<BillsType>(list);

		tx.commit();
		session.close();
		return billsTypeList;
	}

	@Override
	public BillsType getBillsTypeById(long id) {
		Session session;
		BillsType  billsType = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(BillsType.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 billsType = (BillsType)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return billsType;
	}

	@Override
	public boolean deleteBillsType(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(BillsType.class, Id);
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
	public BillsType getLastBillsType() {
		Session session=sessionFactory.openSession();
		BillsType result = (BillsType) session.createQuery("from BillsType ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public BillsType getBillsTypeByBillValidatorType(long bvtId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(BillsType.class);
		c.createAlias("billValidatorType", "b");
		c.add(Restrictions.eq("b.id", bvtId));
		
		 Object result=c.uniqueResult();
		 BillsType coinsType = (BillsType)result;

		tx.commit();
		session.close();
		return coinsType;
	}

}
