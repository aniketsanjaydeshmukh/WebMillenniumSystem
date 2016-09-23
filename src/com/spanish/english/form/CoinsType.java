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
@Table(name = "CoinsType")
@Proxy(lazy=false)
public class CoinsType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2713769913688043913L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	/*@ManyToOne  
	HopperType hopperType;*/
	
	/*@ManyToOne
	CoinValidatorType coinValidatorType;*/
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=CoinsValue.class,cascade=CascadeType.ALL, mappedBy="coinsType")  
	private Set<CoinsValue> coinsValue;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*public HopperType getHopperType() {
		return hopperType;
	}

	public void setHopperType(HopperType hopperType) {
		this.hopperType = hopperType;
	}*/

	/*public CoinValidatorType getCoinValidatorType() {
		return coinValidatorType;
	}

	public void setCoinValidatorType(CoinValidatorType coinValidatorType) {
		this.coinValidatorType = coinValidatorType;
	}*/

}
