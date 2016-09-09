package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.CountryTokensValue;

public interface CountryTokensValueServices {
	boolean addOrUpdateCountryTokensValue(CountryTokensValue countryTokensValue);
	Set<CountryTokensValue> getCountryTokensValueList();
	CountryTokensValue getCountryTokensValueById(long id);
	boolean deleteCountryTokensValue(long Id);
	CountryTokensValue getLastCountryTokensValue();
	Set<CountryTokensValue> getCountryTokensValueListByTokensValue(long cvid);
}
