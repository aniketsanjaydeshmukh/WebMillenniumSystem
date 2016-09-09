package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.Technician;

public interface TechnicianServices {
	boolean addOrUpdateTechnician(Technician establishment);
	Set<Technician> getTechnicianList();
	Technician getTechnicianById(long id);
	boolean deleteTechnician(long Id);
}
