package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.CoinsType;

public interface CoinsTypeServices {
	boolean addOrUpdateCoinsType(CoinsType machineType);
	Set<CoinsType> getCoinsTypeList();
	CoinsType getCoinsTypeById(long id);
	boolean deleteCoinsType(long Id);
	CoinsType getLastCoinsType();
	CoinsType getCoinsTypeByCoinValidatorType(long cvtId);
}
