package com.spanish.english.services;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.OperatorDao;
import com.spanish.english.form.Operator;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("operatorServices")
public class OperatorServicesImpl implements OperatorServices{

	@Autowired
	OperatorDao operatorDao;
	
	Session session = null;
	Transaction tx = null;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public boolean addOrUpdateOperator(Operator operator) {
		return operatorDao.addOrUpdateOperator(operator);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public Set<Operator> getOperatorList() {
		return operatorDao.getOperatorList();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public Operator getOperatorById(long operatorId) {
		return operatorDao.getOperatorById(operatorId);
	}

	@Override
	public boolean deleteOperator(long operatorId) {
		return operatorDao.deleteOperator(operatorId);
	}

}
