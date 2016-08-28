package com.spanish.english.services;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.MachineDao;
import com.spanish.english.form.Machine;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("machineServices")
public class MachineServicesImpl implements MachineServices{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Autowired
	MachineDao machineDao;
	
	@Override
	public boolean addOrUpdateMachine(Machine machine) {
		return machineDao.addOrUpdateMachine(machine);
	}

	@Override
	public Set<Machine> getMachineList() {
		return machineDao.getMachineList();
	}

	@Override
	public Machine getMachineById(long id) {
			return machineDao.getMachineById(id);
	}

	@Override
	public boolean deleteMachine(long Id) {
		return machineDao.deleteMachine(Id);
	}

}
