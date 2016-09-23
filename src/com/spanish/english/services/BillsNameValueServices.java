package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.BillsNameValue;

public interface BillsNameValueServices {
	boolean addOrUpdateBillsNameValue(BillsNameValue tokensName);
	Set<BillsNameValue> getBillsNameValueList();
	BillsNameValue getBillsNameValueById(long id);
	boolean deleteBillsNameValue(long Id);
	Set<BillsNameValue> getBillsNameValueByCountry(long cID);
	BillsNameValue getBillsNameValueByCountryAndBillsName(long countryID,long billsNameID);
}
