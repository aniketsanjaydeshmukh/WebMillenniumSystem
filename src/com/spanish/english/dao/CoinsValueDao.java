package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.CoinsValue;

public interface CoinsValueDao {
	boolean addOrUpdateCoinsValue(CoinsValue coinsValue);
	Set<CoinsValue> getCoinsValueList();
	CoinsValue getCoinsValueById(long id);
	boolean deleteCoinsValue(long Id);
	CoinsValue getLastCoinsValue();
	Set<CoinsValue> getCoinsValueListByCoinsType(long ctid);
}
