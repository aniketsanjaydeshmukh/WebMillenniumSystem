package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.BillsName;

public interface BillsNameDao {
	boolean addOrUpdateBillsName(BillsName billsName);
	Set<BillsName> getBillsNameList();
	BillsName getBillsNameById(long id);
	boolean deleteBillsName(long Id);
}
