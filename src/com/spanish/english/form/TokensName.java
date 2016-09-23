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
@Table(name = "TokensName")
@Proxy(lazy=false)
public class TokensName implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4381754015281981789L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER,targetEntity=TokensNameValue.class,cascade=CascadeType.ALL, mappedBy="tokensName")  
	private Set<TokensNameValue> tokensNameValue;
	
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

	public Set<TokensNameValue> getTokensNameValue() {
		return tokensNameValue;
	}

	public void setTokensNameValue(Set<TokensNameValue> tokensNameValue) {
		this.tokensNameValue = tokensNameValue;
	}
	
}
