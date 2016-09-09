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
@Table(name = "BillsValue")
@Proxy(lazy=false)
public class BillsValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3629571633327935271L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private double value;
	
	private boolean isDone; 
	
	@ManyToOne
	BillsType billsType;

	@OneToMany(fetch = FetchType.EAGER,targetEntity=CountryBillsValue.class,cascade=CascadeType.ALL, mappedBy="billsValue")  
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

	public BillsType getBillsType() {
		return billsType;
	}

	public void setBillsType(BillsType billsType) {
		this.billsType = billsType;
	}

	public Set<CountryBillsValue> getCountryBillsValue() {
		return countryBillsValue;
	}

	public void setCountryBillsValue(Set<CountryBillsValue> countryBillsValue) {
		this.countryBillsValue = countryBillsValue;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

}
