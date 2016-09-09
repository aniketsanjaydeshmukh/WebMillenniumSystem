package com.spanish.english.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Machine")
@Proxy(lazy=false)
public class Machine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5250536209481159189L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private String machineNumber;
	private String manufacturingDate;
	private String machineIMEI;
	private String machineEntries;
	private String machineStatus;
	private String machineOutput;
	private String machineType;
	private String machineHopper;
	private String machineControl;
	private String machinelock;
	private String repairHistory;
	
	@ManyToOne 
	private Admin admin;
	
	@ManyToOne 
	private Operator operator;
	
	@ManyToOne
	private Establishment establishment;
	
	@ManyToOne
	private Technician technician;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMachineNumber() {
		return machineNumber;
	}
	public void setMachineNumber(String machineNumber) {
		this.machineNumber = machineNumber;
	}
	public String getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public String getMachineIMEI() {
		return machineIMEI;
	}
	public void setMachineIMEI(String machineIMEI) {
		this.machineIMEI = machineIMEI;
	}
	public String getMachineEntries() {
		return machineEntries;
	}
	public void setMachineEntries(String machineEntries) {
		this.machineEntries = machineEntries;
	}
	public String getMachineStatus() {
		return machineStatus;
	}
	public void setMachineStatus(String machineStatus) {
		this.machineStatus = machineStatus;
	}
	public String getMachineOutput() {
		return machineOutput;
	}
	public void setMachineOutput(String machineOutput) {
		this.machineOutput = machineOutput;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public String getMachineHopper() {
		return machineHopper;
	}
	public void setMachineHopper(String machineHopper) {
		this.machineHopper = machineHopper;
	}
	public String getMachineControl() {
		return machineControl;
	}
	public void setMachineControl(String machineControl) {
		this.machineControl = machineControl;
	}
	public String getMachinelock() {
		return machinelock;
	}
	public void setMachinelock(String machinelock) {
		this.machinelock = machinelock;
	}
	public String getRepairHistory() {
		return repairHistory;
	}
	public void setRepairHistory(String repairHistory) {
		this.repairHistory = repairHistory;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Establishment getEstablishment() {
		return establishment;
	}
	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
	public Technician getTechnician() {
		return technician;
	}
	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

}
