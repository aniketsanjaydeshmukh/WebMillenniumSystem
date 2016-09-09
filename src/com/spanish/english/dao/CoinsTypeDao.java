package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.CoinsType;


public interface CoinsTypeDao {
	boolean addOrUpdateCoinsType(CoinsType machineType);
	Set<CoinsType> getCoinsTypeList();
	CoinsType getCoinsTypeById(long id);
	boolean deleteCoinsType(long Id);
	CoinsType getLastCoinsType();
	CoinsType getCoinsTypeByCoinValidatorType(long cvtId);
}
