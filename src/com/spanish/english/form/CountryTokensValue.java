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
@Table(name = "CountryTokensValue")
@Proxy(lazy=false)
public class CountryTokensValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8771759765449973042L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	/*private double value;
	
	@ManyToOne
	TokensValue tokensValue;
	
	@ManyToOne
	Country country;*/
	
	@ManyToOne
	TokensNameValue tokensNameValue;
	
	@ManyToOne
	HopperType hopperType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TokensNameValue getTokensNameValue() {
		return tokensNameValue;
	}

	public void setTokensNameValue(TokensNameValue tokensNameValue) {
		this.tokensNameValue = tokensNameValue;
	}

	public HopperType getHopperType() {
		return hopperType;
	}

	public void setHopperType(HopperType hopperType) {
		this.hopperType = hopperType;
	}

	/*public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public TokensValue getTokensValue() {
		return tokensValue;
	}

	public void setTokensValue(TokensValue tokensValue) {
		this.tokensValue = tokensValue;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}*/

}
