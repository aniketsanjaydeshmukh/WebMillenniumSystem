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
@Table(name = "CoinsValue")
@Proxy(lazy=false)
public class CoinsValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4923638771395789165L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private double value;
	
	private boolean isDone; 
	
	@ManyToOne
	CoinsType coinsType;

	@OneToMany(fetch = FetchType.EAGER,targetEntity=CountryCoinsValue.class,cascade=CascadeType.ALL, mappedBy="coinsValue")  
	private Set<CountryCoinsValue> countryCoinsValue;
	
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

	public CoinsType getCoinsType() {
		return coinsType;
	}

	public void setCoinsType(CoinsType coinsType) {
		this.coinsType = coinsType;
	}

	public Set<CountryCoinsValue> getCountryCoinsValue() {
		return countryCoinsValue;
	}

	public void setCountryCoinsValue(Set<CountryCoinsValue> countryCoinsValue) {
		this.countryCoinsValue = countryCoinsValue;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

}
