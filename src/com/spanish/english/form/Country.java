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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Country")
@Proxy(lazy=false)
public class Country implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7826987608446327673L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private String country;
	private String currency;
	
	private boolean done;
	
	/*@OneToOne( mappedBy = "country",cascade = CascadeType.ALL)
	private DummyCountry dummyCountry;*/
	
	/*@OneToMany(fetch = FetchType.EAGER,targetEntity=CountryCoinsValue.class,cascade=CascadeType.ALL, mappedBy="country")  
	private Set<CountryCoinsValue> countryCoinsValue;*/

	/*@OneToMany(fetch = FetchType.EAGER,targetEntity=CountryTokensValue.class,cascade=CascadeType.ALL, mappedBy="country")  
	private Set<CountryTokensValue> countryTokensValue;*/
	
	/*@OneToMany(fetch = FetchType.EAGER,targetEntity=CountryBillsValue.class,cascade=CascadeType.ALL, mappedBy="country")  
	private Set<CountryBillsValue> countryBillsValue;*/

	@OneToMany(fetch = FetchType.EAGER,targetEntity=CoinsName.class,cascade=CascadeType.ALL, mappedBy="country")  
	private Set<CoinsName> coinsName;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=NotesName.class,cascade=CascadeType.ALL, mappedBy="country")  
	private Set<NotesName> notesName;

	@OneToMany(fetch = FetchType.EAGER,targetEntity=TokensNameValue.class,cascade=CascadeType.ALL, mappedBy="country")  
	private Set<TokensNameValue> tokensNameValue;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=BillsNameValue.class,cascade=CascadeType.ALL, mappedBy="country")  
	private Set<BillsNameValue> billsNameValue;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/*public Set<CountryCoinsValue> getCountryCoinsValue() {
		return countryCoinsValue;
	}
	public void setCountryCoinsValue(Set<CountryCoinsValue> countryCoinsValue) {
		this.countryCoinsValue = countryCoinsValue;
	}*/
	/*public Set<CountryTokensValue> getCountryTokensValue() {
		return countryTokensValue;
	}
	public void setCountryTokensValue(Set<CountryTokensValue> countryTokensValue) {
		this.countryTokensValue = countryTokensValue;
	}*/
	/*public Set<CountryBillsValue> getCountryBillsValue() {
		return countryBillsValue;
	}
	public void setCountryBillsValue(Set<CountryBillsValue> countryBillsValue) {
		this.countryBillsValue = countryBillsValue;
	}*/
	public Set<CoinsName> getCoinsName() {
		return coinsName;
	}
	public void setCoinsName(Set<CoinsName> coinsName) {
		this.coinsName = coinsName;
	}
	public Set<NotesName> getNotesName() {
		return notesName;
	}
	public void setNotesName(Set<NotesName> notesName) {
		this.notesName = notesName;
	}
	public Set<TokensNameValue> getTokensNameValue() {
		return tokensNameValue;
	}
	public void setTokensNameValue(Set<TokensNameValue> tokensNameValue) {
		this.tokensNameValue = tokensNameValue;
	}
	public Set<BillsNameValue> getBillsNameValue() {
		return billsNameValue;
	}
	public void setBillsNameValue(Set<BillsNameValue> billsNameValue) {
		this.billsNameValue = billsNameValue;
	}
	/*public DummyCountry getDummyCountry() {
		return dummyCountry;
	}
	public void setDummyCountry(DummyCountry dummyCountry) {
		this.dummyCountry = dummyCountry;
	}*/
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
}
