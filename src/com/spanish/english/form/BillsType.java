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
@Table(name = "BillsType")
@Proxy(lazy=false)
public class BillsType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2846823353095486354L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	/*@ManyToOne  
	BillValidatorType billValidatorType;*/
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=BillsValue.class,cascade=CascadeType.ALL, mappedBy="billsType")  
	private Set<BillsValue> billsValue;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*public BillValidatorType getBillValidatorType() {
		return billValidatorType;
	}

	public void setBillValidatorType(BillValidatorType billValidatorType) {
		this.billValidatorType = billValidatorType;
	}*/

	public Set<BillsValue> getBillsValue() {
		return billsValue;
	}

	public void setBillsValue(Set<BillsValue> billsValue) {
		this.billsValue = billsValue;
	}

}
