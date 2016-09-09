package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.CountryTokensValue;

public interface CountryTokensValueDao {
	boolean addOrUpdateCountryTokensValue(CountryTokensValue countryTokensValue);
	Set<CountryTokensValue> getCountryTokensValueList();
	CountryTokensValue getCountryTokensValueById(long id);
	boolean deleteCountryTokensValue(long Id);
	CountryTokensValue getLastCountryTokensValue();
	Set<CountryTokensValue> getCountryTokensValueListByTokensValue(long cvid);
}
