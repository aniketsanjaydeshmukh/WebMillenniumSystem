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
@Table(name = "CountryCoinsValue")
@Proxy(lazy=false)
public class CountryCoinsValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1041185206328633174L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private double value;
	
	@ManyToOne
	CoinsValue coinsValue;
	
	@ManyToOne
	Country country;

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

	public CoinsValue getCoinsValue() {
		return coinsValue;
	}

	public void setCoinsValue(CoinsValue coinsValue) {
		this.coinsValue = coinsValue;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	

}
