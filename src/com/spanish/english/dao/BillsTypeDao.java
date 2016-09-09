package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.BillsType;

public interface BillsTypeDao {
	boolean addOrUpdateBillsType(BillsType billsType);
	Set<BillsType> getBillsTypeList();
	BillsType getBillsTypeById(long id);
	boolean deleteBillsType(long Id);
	BillsType getLastBillsType();
	BillsType getBillsTypeByBillValidatorType(long bvtId);
}
