package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.CoinsNameDao;
import com.spanish.english.form.CoinsName;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("coinsNameServices")
public class CoinsNameServicesImpl implements CoinsNameServices{
	
	@Autowired
	CoinsNameDao coinsNameDao;

	@Override
	public boolean addOrUpdateCoinsName(CoinsName coinsName) {
		return coinsNameDao.addOrUpdateCoinsName(coinsName);
	}

	@Override
	public Set<CoinsName> getCoinsNameList() {
		return coinsNameDao.getCoinsNameList();
	}

	@Override
	public CoinsName getCoinsNameById(long id) {
		return coinsNameDao.getCoinsNameById(id);
	}

	@Override
	public boolean deleteCoinsName(long Id) {
		return coinsNameDao.deleteCoinsName(Id);
	}

	@Override
	public Set<CoinsName> getCoinsNameByCountry(long cID) {
		return coinsNameDao.getCoinsNameByCountry(cID);
	}

}
