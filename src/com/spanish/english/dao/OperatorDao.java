package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.Operator;

public interface OperatorDao {
	boolean addOrUpdateOperator(Operator operator);
	Set<Operator> getOperatorList();
	Operator getOperatorById(long operatorId);
	boolean deleteOperator(long operatorId);
	Operator getOperatorByUsername(String username);
	
}
