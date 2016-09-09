package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.CountryCoinsValue;

public interface CountryCoinsValueDao {
	boolean addOrUpdateCountryCoinsValue(CountryCoinsValue countryCoinsValue);
	Set<CountryCoinsValue> getCountryCoinsValueList();
	CountryCoinsValue getCountryCoinsValueById(long id);
	boolean deleteCountryCoinsValue(long Id);
	CountryCoinsValue getLastCountryCoinsValue();
	Set<CountryCoinsValue> getCountryCoinsValueListByCoinsValue(long cvid);
}
