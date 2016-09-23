package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.NotesNameDao;
import com.spanish.english.form.NotesName;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("notesNameServices")
public class NotesNameServicesImpl implements NotesNameServices{
	
	@Autowired
	NotesNameDao notesNameDao;

	@Override
	public boolean addOrUpdateNotesName(NotesName coinsName) {
		return notesNameDao.addOrUpdateNotesName(coinsName);
	}

	@Override
	public Set<NotesName> getNotesNameList() {
		return notesNameDao.getNotesNameList();
	}

	@Override
	public NotesName getNotesNameById(long id) {
		return notesNameDao.getNotesNameById(id);
	}

	@Override
	public boolean deleteNotesName(long Id) {
		return notesNameDao.deleteNotesName(Id);
	}

	@Override
	public Set<NotesName> getNotesNameByCountry(long cID) {
		return notesNameDao.getNotesNameByCountry(cID);
	}

}
