package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.CoinsName;

public interface CoinsNameServices {
	boolean addOrUpdateCoinsName(CoinsName coinsName);
	Set<CoinsName> getCoinsNameList();
	CoinsName getCoinsNameById(long id);
	boolean deleteCoinsName(long Id);
	Set<CoinsName> getCoinsNameByCountry(long cID);
}
