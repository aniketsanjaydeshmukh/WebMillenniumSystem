package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.NotesName;

public interface NotesNameServices {
	boolean addOrUpdateNotesName(NotesName coinsName);
	Set<NotesName> getNotesNameList();
	NotesName getNotesNameById(long id);
	boolean deleteNotesName(long Id);
	Set<NotesName> getNotesNameByCountry(long cID);
}
