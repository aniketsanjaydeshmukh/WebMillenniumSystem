package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.CountryCoinsValueDao;
import com.spanish.english.form.CountryCoinsValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("countryCoinsValueServices")
public class CountryCoinsValueServicesImpl implements CountryCoinsValueServices{

	@Autowired
	CountryCoinsValueDao countryCoinsValueDao;
	
	@Override
	public boolean addOrUpdateCountryCoinsValue(
			CountryCoinsValue countryCoinsValue) {
		return countryCoinsValueDao.addOrUpdateCountryCoinsValue(countryCoinsValue);
	}

	@Override
	public Set<CountryCoinsValue> getCountryCoinsValueList() {
		return countryCoinsValueDao.getCountryCoinsValueList();
	}

	@Override
	public CountryCoinsValue getCountryCoinsValueById(long id) {
		return countryCoinsValueDao.getCountryCoinsValueById(id);
	}

	@Override
	public boolean deleteCountryCoinsValue(long Id) {
		return countryCoinsValueDao.deleteCountryCoinsValue(Id);
	}

	@Override
	public CountryCoinsValue getLastCountryCoinsValue() {
		return countryCoinsValueDao.getLastCountryCoinsValue();
	}

	@Override
	public Set<CountryCoinsValue> getCountryCoinsValueListByCoinsValue(long cvid) {
		return countryCoinsValueDao.getCountryCoinsValueListByCoinsValue(cvid);
	}

}
