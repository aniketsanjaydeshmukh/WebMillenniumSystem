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
@Table(name = "CoinsName")
@Proxy(lazy=false)
public class CoinsName implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8851058192802202364L;

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
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=CountryCoinsValue.class,cascade=CascadeType.ALL, mappedBy="coinsName")  
	private Set<CountryCoinsValue> countryCoinsValue;
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

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

	public Set<CountryCoinsValue> getCountryCoinsValue() {
		return countryCoinsValue;
	}

	public void setCountryCoinsValue(Set<CountryCoinsValue> countryCoinsValue) {
		this.countryCoinsValue = countryCoinsValue;
	}
	

	
}