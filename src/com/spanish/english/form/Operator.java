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
@Table(name = "Operator")
@Proxy(lazy=false)
public class Operator implements Serializable, UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5250536209481159189L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private String business;
	private String name;
	private String sector;
	private String population;
	private String province;
	private String identity_card;
	private String email;
	private String telephone;
	private String operatorUsername;
	private String operatorPassword;
	private String address;
	private String operatorRole;
	
	@ManyToOne(cascade=CascadeType.ALL)  
	private Admin admin;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=Machine.class,cascade=CascadeType.ALL, mappedBy="operator")  
	private Set<Machine> machine;
	
	/* Spring Security related fields*/
	@OneToMany(targetEntity=Role.class,cascade=CascadeType.ALL, mappedBy="operator")  
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
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getIdentity_card() {
		return identity_card;
	}
	public void setIdentity_card(String identity_card) {
		this.identity_card = identity_card;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getOperatorUsername() {
		return operatorUsername;
	}
	public void setOperatorUsername(String username) {
		this.operatorUsername = username;
	}
	public String getOperatorPassword() {
		return operatorPassword;
	}
	public void setOperatorPassword(String password) {
		this.operatorPassword = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
			return this.operatorPassword;
		}

		@Override
		public String getUsername() {
			return this.operatorUsername;
		}
		public String getOperatorRole() {
			return operatorRole;
		}
		public void setOperatorRole(String operatorRole) {
			this.operatorRole = operatorRole;
		}

}
