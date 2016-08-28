package com.spanish.english.form;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "Role")
@Proxy(lazy=false)
public class Role implements GrantedAuthority{
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	 private String name;

	 @ManyToOne(cascade=CascadeType.ALL)  
	private Admin admin;
	 
	public Admin getAdmin() {
		return admin;
	}



	public void setAdmin(Admin admin) {
		this.admin = admin;
	}



	@Override
	public String getAuthority() {
		return this.name;
	}
	
	
	
	public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}
