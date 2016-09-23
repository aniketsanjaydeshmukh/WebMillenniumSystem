package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.BillsNameDao;
import com.spanish.english.form.BillsName;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("billsNameServices")
public class BillsNameServicesImpl implements BillsNameServices{

	@Autowired
	BillsNameDao billsNameDao;
	
	@Override
	public boolean addOrUpdateBillsName(BillsName billsName) {
		return billsNameDao.addOrUpdateBillsName(billsName);
	}

	@Override
	public Set<BillsName> getBillsNameList() {
		return billsNameDao.getBillsNameList();
	}

	@Override
	public BillsName getBillsNameById(long id) {
		return billsNameDao.getBillsNameById(id);
	}

	@Override
	public boolean deleteBillsName(long Id) {
		return billsNameDao.deleteBillsName(Id);
	}

}
