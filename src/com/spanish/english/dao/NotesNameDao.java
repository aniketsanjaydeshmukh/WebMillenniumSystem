package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.CoinsName;
import com.spanish.english.form.NotesName;

public interface NotesNameDao {
	boolean addOrUpdateNotesName(NotesName coinsName);
	Set<NotesName> getNotesNameList();
	NotesName getNotesNameById(long id);
	boolean deleteNotesName(long Id);
	Set<NotesName> getNotesNameByCountry(long cID);
}
