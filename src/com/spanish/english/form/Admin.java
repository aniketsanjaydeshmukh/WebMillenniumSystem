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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Admin")
@Proxy(lazy=false)
public class Admin implements Serializable, UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5685868652637033632L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private String adminUsername;
	
	private String adminPassword;
	
	private String adminRole;
	
	 
	@OneToMany(targetEntity=Operator.class,cascade=CascadeType.ALL, mappedBy="admin")  
	private Set<Operator> operators;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=Establishment.class,cascade=CascadeType.ALL, mappedBy="admin")  
	private Set<Establishment> establishment;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=Machine.class,cascade=CascadeType.ALL, mappedBy="admin")  
	private Set<Machine> machine;
	
	/* Spring Security related fields*/
	@OneToMany(targetEntity=Role.class,cascade=CascadeType.ALL, mappedBy="admin")  
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
	
	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	 
	public Set<Operator> getOperators() {
		return operators;
	}

	public Set<Establishment> getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Set<Establishment> establishment) {
		this.establishment = establishment;
	}

	public void setOperators(Set<Operator> operators) {
		this.operators = operators;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
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
			return this.adminPassword;
		}

		@Override
		public String getUsername() {
			return this.adminUsername;
		}
	
}
