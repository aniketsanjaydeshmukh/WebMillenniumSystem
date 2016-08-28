package com.spanish.english.form;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Establishment")
@Proxy(lazy=false)
public class Establishment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 738660264056920949L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "establishmentName")
	private String establishmentName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "sector")
	private String Sector;
	
	@Column(name = "geolocation")
	private String geolocation;
	
	@Column(name = "dischargeDate")
	private String dischargeDate;
	
	@Column(name = "fund")
	private String fund;
	
	@Column(name = "percentage")
	private String percentage;
	
	@Column(name = "establishmentsType")
	private String establishmentsType;
	
	@Column(name = "status")
	private String status;	
	
	@Column(name = "prepayments")
	private String prepayments;
	
	@Column(name = "hours")
	private String hours;
	
	@Column(name = "loans")
	private String loans;
	
	@Column(name = "withdrawals")
	private String withdrawals;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "population")
	private String population;

	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	@ManyToOne(cascade=CascadeType.ALL)  
	private Admin admin;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstablishmentName() {
		return establishmentName;
	}

	public void setEstablishmentName(String establishmentName) {
		this.establishmentName = establishmentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSector() {
		return Sector;
	}

	public void setSector(String sector) {
		Sector = sector;
	}

	public String getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
	}

	public String getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getFund() {
		return fund;
	}

	public void setFund(String fund) {
		this.fund = fund;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getEstablishmentsType() {
		return establishmentsType;
	}

	public void setEstablishmentsType(String establishmentsType) {
		this.establishmentsType = establishmentsType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrepayments() {
		return prepayments;
	}

	public void setPrepayments(String prepayments) {
		this.prepayments = prepayments;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getLoans() {
		return loans;
	}

	public void setLoans(String loans) {
		this.loans = loans;
	}

	public String getWithdrawals() {
		return withdrawals;
	}

	public void setWithdrawals(String withdrawals) {
		this.withdrawals = withdrawals;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	
	
	
}