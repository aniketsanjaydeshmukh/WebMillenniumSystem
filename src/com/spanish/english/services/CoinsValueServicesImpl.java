package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.CoinsValueDao;
import com.spanish.english.form.CoinsValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("coinsValueServices")
public class CoinsValueServicesImpl implements CoinsValueServices{

	@Autowired
	CoinsValueDao coinsValueDao;
	
	@Override
	public boolean addOrUpdateCoinsValue(CoinsValue coinsValue) {
		return coinsValueDao.addOrUpdateCoinsValue(coinsValue);
	}

	@Override
	public Set<CoinsValue> getCoinsValueList() {
		return coinsValueDao.getCoinsValueList();
	}

	@Override
	public CoinsValue getCoinsValueById(long id) {
		return coinsValueDao.getCoinsValueById(id);
	}

	@Override
	public boolean deleteCoinsValue(long Id) {
		return coinsValueDao.deleteCoinsValue(Id);
	}

	@Override
	public CoinsValue getLastCoinsValue() {
		return coinsValueDao.getLastCoinsValue();
	}

	@Override
	public Set<CoinsValue> getCoinsValueListByCoinsType(long ctid) {
		return coinsValueDao.getCoinsValueListByCoinsType(ctid);
	}

}
