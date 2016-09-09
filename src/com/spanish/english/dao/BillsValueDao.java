package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.BillsValue;

public interface BillsValueDao {
	boolean addOrUpdateBillsValue(BillsValue billsValue);
	Set<BillsValue> getBillsValueList();
	BillsValue getBillsValueById(long id);
	boolean deleteBillsValue(long Id);
	BillsValue getLastBillsValue();
	Set<BillsValue> getBillsValueListByBillsType(long btid);
}