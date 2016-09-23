package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.BillsNameValue;

public interface BillsNameValueDao {
	boolean addOrUpdateBillsNameValue(BillsNameValue tokensName);
	Set<BillsNameValue> getBillsNameValueList();
	BillsNameValue getBillsNameValueById(long id);
	boolean deleteBillsNameValue(long Id);
	Set<BillsNameValue> getBillsNameValueByCountry(long cID);
	BillsNameValue getBillsNameValueByCountryAndBillsName(long countryID,long billsNameID);
}
