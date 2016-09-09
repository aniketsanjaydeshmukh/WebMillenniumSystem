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
@Table(name = "TokensType")
@Proxy(lazy=false)
public class TokensType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 240447595345415929L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@ManyToOne  
	HopperType hopperType;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=TokensValue.class,cascade=CascadeType.ALL, mappedBy="tokensType")  
	private Set<TokensValue> tokensValue;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public HopperType getHopperType() {
		return hopperType;
	}

	public void setHopperType(HopperType hopperType) {
		this.hopperType = hopperType;
	}
}
