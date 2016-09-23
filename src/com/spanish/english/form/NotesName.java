package com.spanish.english.form;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "NotesName")
@Proxy(lazy=false)
public class NotesName implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6882518640228882529L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "value")
	private double value;
	
	@Column(name = "code")
	private String code;
	
	@ManyToOne
	Country country;
	
	/*@OneToMany(fetch = FetchType.EAGER,targetEntity=CountryCoinsValue.class,cascade=CascadeType.ALL, mappedBy="notesName")  
	private Set<CountryNotesValue> countryNotesValue;*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	/*public Set<CountryNotesValue> getCountryNotesValue() {
		return countryNotesValue;
	}

	public void setCountryNotesValue(Set<CountryNotesValue> countryNotesValue) {
		this.countryNotesValue = countryNotesValue;
	}*/

}
