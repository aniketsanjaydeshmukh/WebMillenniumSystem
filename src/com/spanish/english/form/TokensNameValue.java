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
@Table(name = "TokensNameValue")
@Proxy(lazy=false)
public class TokensNameValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1909366336157149978L;
	
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
	TokensName tokensName;

	@OneToMany(fetch = FetchType.EAGER,targetEntity=CountryTokensValue.class,cascade=CascadeType.ALL, mappedBy="tokensNameValue")  
	private Set<CountryTokensValue> countryTokensValue;
	
	public TokensName getTokensName() {
		return tokensName;
	}

	public void setTokensName(TokensName tokensName) {
		this.tokensName = tokensName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

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

	public Set<CountryTokensValue> getCountryTokensValue() {
		return countryTokensValue;
	}

	public void setCountryTokensValue(Set<CountryTokensValue> countryTokensValue) {
		this.countryTokensValue = countryTokensValue;
	}

}
