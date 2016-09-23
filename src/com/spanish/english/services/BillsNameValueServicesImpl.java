package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.BillsNameValueDao;
import com.spanish.english.form.BillsNameValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("billsNameValueServices")
public class BillsNameValueServicesImpl implements BillsNameValueServices{
	
	@Autowired
	BillsNameValueDao billsNameValueDao;

	@Override
	public boolean addOrUpdateBillsNameValue(BillsNameValue tokensName) {
		return billsNameValueDao.addOrUpdateBillsNameValue(tokensName);
	}

	@Override
	public Set<BillsNameValue> getBillsNameValueList() {
		return billsNameValueDao.getBillsNameValueList();
	}

	@Override
	public BillsNameValue getBillsNameValueById(long id) {
		return billsNameValueDao.getBillsNameValueById(id);
	}

	@Override
	public boolean deleteBillsNameValue(long Id) {
		return billsNameValueDao.deleteBillsNameValue(Id);
	}

	@Override
	public Set<BillsNameValue> getBillsNameValueByCountry(long cID) {
		return billsNameValueDao.getBillsNameValueByCountry(cID);
	}

	@Override
	public BillsNameValue getBillsNameValueByCountryAndBillsName(
			long countryID, long billsNameID) {
		return billsNameValueDao.getBillsNameValueByCountryAndBillsName(countryID, billsNameID);
	}

}
