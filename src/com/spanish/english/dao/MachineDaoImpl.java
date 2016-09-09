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

import com.spanish.english.form.Machine;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MachineDaoImpl implements MachineDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public boolean addOrUpdateMachine(Machine machine) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(machine);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public Set<Machine> getMachineList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Machine.class);
		
		List<Machine> list =  c.list();
		Set<Machine> machineList = new HashSet<Machine>(list);

		tx.commit();
		session.close();
		return machineList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public Machine getMachineById(long id) {
		Session session;
		Machine  machine = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Machine.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 machine = (Machine)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return machine;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public boolean deleteMachine(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(Machine.class, Id);
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
	public Set<Machine> getMachineListByStatus(String status) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Machine.class);
		c.add(Restrictions.eq("machineStatus",status));
		
		List<Machine> list =  c.list();
		Set<Machine> machineList = new HashSet<Machine>(list);

		tx.commit();
		session.close();
		return machineList;
	}

	@Override
	public Set<Machine> getMachineListByOperatorId(long id) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Machine.class);
		c.createAlias("operator", "o");
		c.add(Restrictions.eq("o.id", id));
		
		List<Machine> list = c.list();
		Set<Machine> machineList = new HashSet<Machine>(list);
		tx.commit();
		session.close();
		return machineList;
	}

	@Override
	public boolean machineUpdate(Machine mahine) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.merge(mahine);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<Machine> getMachineListByEstablishmentId(long id) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Machine.class);
		c.createAlias("establishment", "e");
		c.add(Restrictions.eq("e.id", id));
		
		List<Machine> list = c.list();
		Set<Machine> machineList = new HashSet<Machine>(list);
		tx.commit();
		session.close();
		return machineList;
	}

}
