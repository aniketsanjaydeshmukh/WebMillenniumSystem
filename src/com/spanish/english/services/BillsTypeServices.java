package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.BillsType;

public interface BillsTypeServices {
	boolean addOrUpdateBillsType(BillsType billsType);
	Set<BillsType> getBillsTypeList();
	BillsType getBillsTypeById(long id);
	boolean deleteBillsType(long Id);
	BillsType getLastBillsType();
	BillsType getBillsTypeByBillValidatorType(long bvtId);
}
