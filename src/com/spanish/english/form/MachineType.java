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
@Table(name = "MachineType")
@Proxy(lazy=false)
public class MachineType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1632889406648099436L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private String machineTypeName;
	private String paymentDevices[];
	
	private boolean wirelessControl;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=HopperType.class,cascade=CascadeType.ALL, mappedBy="machineType")  
	private Set<HopperType> hopperType;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=CoinValidatorType.class,cascade=CascadeType.ALL, mappedBy="machineType")  
	private Set<CoinValidatorType> coinValidatorType;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=BillValidatorType.class,cascade=CascadeType.ALL, mappedBy="machineType")  
	private Set<BillValidatorType> billValidatorType;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMachineTypeName() {
		return machineTypeName;
	}
	public void setMachineTypeName(String machineTypeName) {
		this.machineTypeName = machineTypeName;
	}
	public String[] getPaymentDevices() {
		return paymentDevices;
	}
	public void setPaymentDevices(String[] paymentDevices) {
		this.paymentDevices = paymentDevices;
	}
	public Set<HopperType> getHopperType() {
		return hopperType;
	}
	public void setHopperType(Set<HopperType> hopperType) {
		this.hopperType = hopperType;
	}
	public Set<CoinValidatorType> getCoinValidatorType() {
		return coinValidatorType;
	}
	public void setCoinValidatorType(Set<CoinValidatorType> coinValidatorType) {
		this.coinValidatorType = coinValidatorType;
	}
	public Set<BillValidatorType> getBillValidatorType() {
		return billValidatorType;
	}
	public void setBillValidatorType(Set<BillValidatorType> billValidatorType) {
		this.billValidatorType = billValidatorType;
	}
	public boolean isWirelessControl() {
		return wirelessControl;
	}
	public void setWirelessControl(boolean wirelessControl) {
		this.wirelessControl = wirelessControl;
	}
	
}
