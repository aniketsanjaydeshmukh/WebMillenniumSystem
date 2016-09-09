package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.Establishment;

public interface EstablishmentServices {
	boolean addOrUpdateEstablishment(Establishment establishment);
	Set<Establishment> getEstablishmentList();
	Establishment getEstablishmentById(long id);
	boolean deleteEstablishment(long Id);
	Establishment getEstablishmentByUsername(String username);
}
