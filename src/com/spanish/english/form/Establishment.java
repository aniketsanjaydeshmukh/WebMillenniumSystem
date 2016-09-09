package com.spanish.english.form;

import java.io.Serializable;
import java.util.List;
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
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Establishment")
@Proxy(lazy=false)
public class Establishment implements Serializable, UserDetails{

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

	
	@Column(name = "establishmentUsername")
	private String establishmentUsername;
	
	@Column(name = "establishmentPassword")
	private String establishmentPassword;
	
	@Column(name = "establishmentRole")
	private String establishmentRole;
	
	@ManyToOne  
	private Admin admin;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=Machine.class, mappedBy="establishment")  
	private Set<Machine> machine;
	
	@OneToMany(targetEntity=Technician.class,cascade=CascadeType.ALL, mappedBy="establishment")  
	private Set<Technician> technicians;
	
	/* Spring Security related fields*/
	@OneToMany(targetEntity=Role.class,cascade=CascadeType.ALL, mappedBy="establishment")  
    private List<Role> authorities;
	
	 private boolean accountNonExpired = true;
	    private boolean accountNonLocked = true;
	    private boolean credentialsNonExpired = true;
	    private boolean enabled = true;
	    
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Set<Machine> getMachine() {
		return machine;
	}

	public void setMachine(Set<Machine> machine) {
		this.machine = machine;
	}

	public String getEstablishmentUsername() {
		return establishmentUsername;
	}

	public void setEstablishmentUsername(String establishmentUsername) {
		this.establishmentUsername = establishmentUsername;
	}

	public String getEstablishmentPassword() {
		return establishmentPassword;
	}

	public void setEstablishmentPassword(String establishmentPassword) {
		this.establishmentPassword = establishmentPassword;
	}

	public String getEstablishmentRole() {
		return establishmentRole;
	}

	public void setEstablishmentRole(String establishmentRole) {
		this.establishmentRole = establishmentRole;
	}

	public List<Role> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String getPassword() {
		return this.establishmentPassword;
	}

	@Override
	public String getUsername() {
		return this.establishmentUsername;
	}

	public Set<Technician> getTechnicians() {
		return technicians;
	}

	public void setTechnicians(Set<Technician> technicians) {
		this.technicians = technicians;
	}

	
	
	
}