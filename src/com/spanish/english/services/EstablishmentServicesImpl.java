package com.spanish.english.services;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.EstablishmentDao;
import com.spanish.english.form.Establishment;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("establishmentServices")
public class EstablishmentServicesImpl implements EstablishmentServices{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Autowired
	EstablishmentDao establishmentDao;

	@Override
	public boolean addOrUpdateEstablishment(Establishment establishment) {
		return establishmentDao.addOrUpdateEstablishment(establishment);
	}

	@Override
	public Set<Establishment> getEstablishmentList() {
		return establishmentDao.getEstablishmentList();
	}

	@Override
	public Establishment getEstablishmentById(long id) {
		return establishmentDao.getEstablishmentById(id);
	}

	@Override
	public boolean deleteEstablishment(long Id) {
		
		return establishmentDao.deleteEstablishment(Id);
	}
}
