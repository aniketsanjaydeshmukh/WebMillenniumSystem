package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.CountryNotesValue;

public interface CountryNotesValueServices {
	boolean addOrUpdateCountryNotesValue(CountryNotesValue countryNotesValue);
	Set<CountryNotesValue> getCountryNotesValueList();
	CountryNotesValue getCountryNotesValueById(long id);
	boolean deleteCountryNotesValue(long Id);
	CountryNotesValue getLastCountryNotesValue();
	Set<CountryNotesValue> getCountryNotesValueListByCoinsValue(long cvid);
}
