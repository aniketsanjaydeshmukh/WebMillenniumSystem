package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.CountryBillsValueDao;
import com.spanish.english.form.CountryBillsValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("countryBillsValueServices")
public class CountryBillsValueServicesImpl implements CountryBillsValueServices{

	@Autowired
	CountryBillsValueDao countryBillsValueDao;
	
	@Override
	public boolean addOrUpdateCountryBillsValue(
			CountryBillsValue countryBillsValue) {
	return countryBillsValueDao.addOrUpdateCountryBillsValue(countryBillsValue);
	}

	@Override
	public Set<CountryBillsValue> getCountryBillsValueList() {
		return countryBillsValueDao.getCountryBillsValueList();
	}

	@Override
	public CountryBillsValue getCountryBillsValueById(long id) {
		return countryBillsValueDao.getCountryBillsValueById(id);
	}

	@Override
	public boolean deleteCountryBillsValue(long Id) {
		return countryBillsValueDao.deleteCountryBillsValue(Id);
	}

	@Override
	public CountryBillsValue getLastCountryBillsValue() {
		return countryBillsValueDao.getLastCountryBillsValue();
	}

	@Override
	public Set<CountryBillsValue> getCountryBillsValueListByBillsValue(long bvid) {
		return countryBillsValueDao.getCountryBillsValueListByBillsValue(bvid);
	}

}
