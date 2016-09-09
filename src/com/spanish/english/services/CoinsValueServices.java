package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.CoinsValue;

public interface CoinsValueServices {
	boolean addOrUpdateCoinsValue(CoinsValue coinsValue);
	Set<CoinsValue> getCoinsValueList();
	CoinsValue getCoinsValueById(long id);
	boolean deleteCoinsValue(long Id);
	CoinsValue getLastCoinsValue();
	Set<CoinsValue> getCoinsValueListByCoinsType(long ctid);
}
