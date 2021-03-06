package com.spanish.english.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "CountryNotesValue")
@Proxy(lazy=false)
public class CountryNotesValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2857638744773885820L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	NotesName notesName;
	
	@ManyToOne
	HopperType hopperType;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public NotesName getNotesName() {
		return notesName;
	}

	public void setNotesName(NotesName notesName) {
		this.notesName = notesName;
	}

	public HopperType getHopperType() {
		return hopperType;
	}

	public void setHopperType(HopperType hopperType) {
		this.hopperType = hopperType;
	}

}
