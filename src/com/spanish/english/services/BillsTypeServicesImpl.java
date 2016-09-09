package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.BillsTypeDao;
import com.spanish.english.form.BillsType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("billsTypeServices")
public class BillsTypeServicesImpl implements BillsTypeServices{

	@Autowired
	BillsTypeDao billsTypeDao;
	
	@Override
	public boolean addOrUpdateBillsType(BillsType billsType) {
		return billsTypeDao.addOrUpdateBillsType(billsType);
	}

	@Override
	public Set<BillsType> getBillsTypeList() {
		return billsTypeDao.getBillsTypeList();
	}

	@Override
	public BillsType getBillsTypeById(long id) {
		return billsTypeDao.getBillsTypeById(id);
	}

	@Override
	public boolean deleteBillsType(long Id) {
		return billsTypeDao.deleteBillsType(Id);
	}

	@Override
	public BillsType getLastBillsType() {
		return billsTypeDao.getLastBillsType();
	}

	@Override
	public BillsType getBillsTypeByBillValidatorType(long bvtId) {
		return billsTypeDao.getBillsTypeByBillValidatorType(bvtId);
	}

}
