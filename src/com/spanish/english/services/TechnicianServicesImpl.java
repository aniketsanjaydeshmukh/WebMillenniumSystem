package com.spanish.english.services;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.TechnicianDao;
import com.spanish.english.form.Technician;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("technicianServices")
public class TechnicianServicesImpl implements TechnicianServices{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Autowired
	TechnicianDao technicianDao;
	
	@Override
	public boolean addOrUpdateTechnician(Technician establishment) {
		return technicianDao.addOrUpdateTechnician(establishment);
	}

	@Override
	public Set<Technician> getTechnicianList() {
		return technicianDao.getTechnicianList();
	}

	@Override
	public Technician getTechnicianById(long id) {
		return technicianDao.getTechnicianById(id);
	}

	@Override
	public boolean deleteTechnician(long Id) {
		return technicianDao.deleteTechnician(Id);
	}

}
