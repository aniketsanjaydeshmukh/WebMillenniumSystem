package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.BillsName;

public interface BillsNameServices {
	boolean addOrUpdateBillsName(BillsName billsName);
	Set<BillsName> getBillsNameList();
	BillsName getBillsNameById(long id);
	boolean deleteBillsName(long Id);
}
