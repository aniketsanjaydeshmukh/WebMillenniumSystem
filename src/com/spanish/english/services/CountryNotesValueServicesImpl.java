package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.CountryNotesValueDao;
import com.spanish.english.form.CountryNotesValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("countryNotesValueServices")
public class CountryNotesValueServicesImpl implements CountryNotesValueServices{

	@Autowired
	CountryNotesValueDao countryNotesValueDao;
	
	@Override
	public boolean addOrUpdateCountryNotesValue(
			CountryNotesValue countryNotesValue) {
		return countryNotesValueDao.addOrUpdateCountryNotesValue(countryNotesValue);
	}

	@Override
	public Set<CountryNotesValue> getCountryNotesValueList() {
		return countryNotesValueDao.getCountryNotesValueList();
	}

	@Override
	public CountryNotesValue getCountryNotesValueById(long id) {
		return countryNotesValueDao.getCountryNotesValueById(id);
	}

	@Override
	public boolean deleteCountryNotesValue(long Id) {
		return countryNotesValueDao.deleteCountryNotesValue(Id);
	}

	@Override
	public CountryNotesValue getLastCountryNotesValue() {
		return countryNotesValueDao.getLastCountryNotesValue();
	}

	@Override
	public Set<CountryNotesValue> getCountryNotesValueListByCoinsValue(long cvid) {
		return countryNotesValueDao.getCountryNotesValueListByCoinsValue(cvid);
	}

}
