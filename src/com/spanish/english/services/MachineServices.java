package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.Machine;

public interface MachineServices {

	boolean addOrUpdateMachine(Machine machine);
		Set<Machine> getMachineList();
		Machine getMachineById(long id);
		boolean deleteMachine(long Id);
}
