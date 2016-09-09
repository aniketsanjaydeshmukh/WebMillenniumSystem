package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.CountryTokensValueDao;
import com.spanish.english.form.CountryTokensValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("countryTokensValueServices")
public class CountryTokensValueServicesImpl implements CountryTokensValueServices{

	@Autowired
	CountryTokensValueDao countryTokensValueDao;
	
	@Override
	public boolean addOrUpdateCountryTokensValue(
			CountryTokensValue countryTokensValue) {
		return countryTokensValueDao.addOrUpdateCountryTokensValue(countryTokensValue);
	}

	@Override
	public Set<CountryTokensValue> getCountryTokensValueList() {
		return countryTokensValueDao.getCountryTokensValueList();
	}

	@Override
	public CountryTokensValue getCountryTokensValueById(long id) {
		return countryTokensValueDao.getCountryTokensValueById(id);
	}

	@Override
	public boolean deleteCountryTokensValue(long Id) {
		return countryTokensValueDao.deleteCountryTokensValue(Id);
	}

	@Override
	public CountryTokensValue getLastCountryTokensValue() {
		return countryTokensValueDao.getLastCountryTokensValue();
	}

	@Override
	public Set<CountryTokensValue> getCountryTokensValueListByTokensValue(
			long cvid) {
		return countryTokensValueDao.getCountryTokensValueListByTokensValue(cvid);
	}

}
