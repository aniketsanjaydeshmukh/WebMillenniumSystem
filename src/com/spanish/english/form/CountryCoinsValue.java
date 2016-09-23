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
	
	
	@ManyToOne
	CoinsName coinsName;
	
	@ManyToOne
	HopperType hopperType;
	
	@ManyToOne
	CoinValidatorType coinValidatorType;
	
	/*@ManyToOne
	Country country;*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
*/
	public CoinsName getCoinsName() {
		return coinsName;
	}

	public void setCoinsName(CoinsName coinsName) {
		this.coinsName = coinsName;
	}

	public HopperType getHopperType() {
		return hopperType;
	}

	public void setHopperType(HopperType hopperType) {
		this.hopperType = hopperType;
	}

	public CoinValidatorType getCoinValidatorType() {
		return coinValidatorType;
	}

	public void setCoinValidatorType(CoinValidatorType coinValidatorType) {
		this.coinValidatorType = coinValidatorType;
	}

	

	/*public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}*/
	

}
