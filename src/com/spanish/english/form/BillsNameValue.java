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
@Table(name = "BillsNameValue")
@Proxy(lazy=false)
public class BillsNameValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3486835649307811290L;

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
	
	@ManyToOne
	BillsName billsName;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=CountryBillsValue.class,cascade=CascadeType.ALL, mappedBy="billsNameValue")  
	private Set<CountryBillsValue> countryBillsValue;

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

	public BillsName getBillsName() {
		return billsName;
	}

	public void setBillsName(BillsName billsName) {
		this.billsName = billsName;
	}

	public Set<CountryBillsValue> getCountryBillsValue() {
		return countryBillsValue;
	}

	public void setCountryBillsValue(Set<CountryBillsValue> countryBillsValue) {
		this.countryBillsValue = countryBillsValue;
	}
}
