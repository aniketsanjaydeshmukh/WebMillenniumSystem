package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.Machine;

public interface MachineDao {

	boolean addOrUpdateMachine(Machine machine);
		Set<Machine> getMachineList();
		Machine getMachineById(long id);
		boolean deleteMachine(long Id);
	
}
