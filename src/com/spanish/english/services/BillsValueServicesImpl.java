package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.BillsValueDao;
import com.spanish.english.form.BillsValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("billsValueServices")
public class BillsValueServicesImpl implements BillsValueServices{

	@Autowired
	BillsValueDao billsValueDao;
	
	@Override
	public boolean addOrUpdateBillsValue(BillsValue billsValue) {
		return billsValueDao.addOrUpdateBillsValue(billsValue);
	}

	@Override
	public Set<BillsValue> getBillsValueList() {
		return billsValueDao.getBillsValueList();
	}

	@Override
	public BillsValue getBillsValueById(long id) {
		return billsValueDao.getBillsValueById(id);
	}

	@Override
	public boolean deleteBillsValue(long Id) {
		return billsValueDao.deleteBillsValue(Id);
	}

	@Override
	public BillsValue getLastBillsValue() {
		return billsValueDao.getLastBillsValue();
	}

	@Override
	public Set<BillsValue> getBillsValueListByBillsType(long btid) {
		return billsValueDao.getBillsValueListByBillsType(btid);
	}

}
