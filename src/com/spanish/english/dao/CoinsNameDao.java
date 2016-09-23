package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.CoinsName;

public interface CoinsNameDao {
	boolean addOrUpdateCoinsName(CoinsName coinsName);
	Set<CoinsName> getCoinsNameList();
	CoinsName getCoinsNameById(long id);
	boolean deleteCoinsName(long Id);
	Set<CoinsName> getCoinsNameByCountry(long cID);
}
