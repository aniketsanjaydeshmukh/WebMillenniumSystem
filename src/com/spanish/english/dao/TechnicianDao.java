package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.Technician;

public interface TechnicianDao {
	boolean addOrUpdateTechnician(Technician establishment);
	Set<Technician> getTechnicianList();
	Technician getTechnicianById(long id);
	boolean deleteTechnician(long Id);
}
