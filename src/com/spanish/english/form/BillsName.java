package com.spanish.english.form;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "BillsName")
@Proxy(lazy=false)
public class BillsName implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8996773598808512613L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER,targetEntity=BillsNameValue.class,cascade=CascadeType.ALL, mappedBy="billsName")  
	private Set<BillsNameValue> billsNameValue;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BillsNameValue> getBillsNameValue() {
		return billsNameValue;
	}

	public void setBillsNameValue(Set<BillsNameValue> billsNameValue) {
		this.billsNameValue = billsNameValue;
	}

}
