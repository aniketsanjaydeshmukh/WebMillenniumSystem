package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.CoinsTypeDao;
import com.spanish.english.form.CoinsType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("coinsTypeServices")
public class CoinsTypeServicesImpl implements CoinsTypeServices{

	@Autowired
	CoinsTypeDao coinsTypeDao;

	@Override
	public boolean addOrUpdateCoinsType(CoinsType machineType) {
		return coinsTypeDao.addOrUpdateCoinsType(machineType);
	}

	@Override
	public Set<CoinsType> getCoinsTypeList() {
		return coinsTypeDao.getCoinsTypeList();
	}

	@Override
	public CoinsType getCoinsTypeById(long id) {
		return coinsTypeDao.getCoinsTypeById(id);
	}

	@Override
	public boolean deleteCoinsType(long Id) {
		return coinsTypeDao.deleteCoinsType(Id);
	}

	@Override
	public CoinsType getLastCoinsType() {
		return coinsTypeDao.getLastCoinsType();
	}

	@Override
	public CoinsType getCoinsTypeByCoinValidatorType(long cvtId) {
		return coinsTypeDao.getCoinsTypeByCoinValidatorType(cvtId);
	}
	
	

}
