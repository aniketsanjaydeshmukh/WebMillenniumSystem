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
@Table(name = "CountryBillsValue")
@Proxy(lazy=false)
public class CountryBillsValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6161180311313837985L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private double value;
	
	@ManyToOne
	private BillsValue billsValue;
	
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

	public BillsValue getBillsValue() {
		return billsValue;
	}

	public void setBillsValue(BillsValue billsValue) {
		this.billsValue = billsValue;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
