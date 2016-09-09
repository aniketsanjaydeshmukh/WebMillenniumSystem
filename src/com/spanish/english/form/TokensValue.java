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
@Table(name = "TokensValue")
@Proxy(lazy=false)
public class TokensValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2702188397896783670L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private double value;

	private boolean isDone; 
	
	@ManyToOne
	TokensType tokensType;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=CountryTokensValue.class,cascade=CascadeType.ALL, mappedBy="tokensValue")  
	private Set<CountryTokensValue> countryTokensValue;

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

	public TokensType getTokensType() {
		return tokensType;
	}

	public void setTokensType(TokensType tokensType) {
		this.tokensType = tokensType;
	}

	public Set<CountryTokensValue> getCountryTokensValue() {
		return countryTokensValue;
	}

	public void setCountryTokensValue(Set<CountryTokensValue> countryTokensValue) {
		this.countryTokensValue = countryTokensValue;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

}
