package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.CountryBillsValue;

public interface CountryBillsValueDao {
	boolean addOrUpdateCountryBillsValue(CountryBillsValue countryBillsValue);
	Set<CountryBillsValue> getCountryBillsValueList();
	CountryBillsValue getCountryBillsValueById(long id);
	boolean deleteCountryBillsValue(long Id);
	CountryBillsValue getLastCountryBillsValue();
	Set<CountryBillsValue> getCountryBillsValueListByBillsValue(long bvid);
}
