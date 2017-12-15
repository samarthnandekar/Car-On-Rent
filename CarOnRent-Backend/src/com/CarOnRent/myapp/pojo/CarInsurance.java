package com.CarOnRent.myapp.pojo;

import java.util.Date;
import java.util.function.Predicate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="carInsurance")
public class CarInsurance {

	
	@Id
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "userCar"))
	@GeneratedValue(generator = "generator")
	@Column(name = "carInsuranceID",unique = true, nullable = false)
	private int carInsuranceID;
	
	@Column(name="carOwnerName")
	private String carOwnerName;
	
	@Column(name="insuranceCmpName")
	String insuranceCmpName;
	
	@Column(name="carOwnerLicenseNo")
	private String carOwnerLicenseNo;
		
	@Column(name="policyNumber")
	private String policyNumber;
	
	@Column(name="insuranceStartDate")
	private Date insuranceStartDate;
	
	@Column(name="insuranceEndDate")
	private Date insuranceEndDate;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonBackReference
	private UserCar userCar;
	
	
	public String getInsuranceCmpName() {
		return insuranceCmpName;
	}
	
	public UserCar getUserCar() {
		return userCar;
	}
	public void setUserCar(UserCar userCar) {
		this.userCar = userCar;
	}
	
	
	public int getCarInsuranceID() {
		return carInsuranceID;
	}
	public void setCarInsuranceID(int carInsuranceID) {
		this.carInsuranceID = carInsuranceID;
	}
	public String getCarOwnerName() {
		return carOwnerName;
	}
	public void setCarOwnerName(String carOwnerName) {
		this.carOwnerName = carOwnerName;
	}
	public String getCarOwnerLicenseNo() {
		return carOwnerLicenseNo;
	}
	public void setCarOwnerLicenseNo(String carOwnerLicenseNo) {
		this.carOwnerLicenseNo = carOwnerLicenseNo;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public Date getInsuranceStartDate() {
		return insuranceStartDate;
	}
	public void setInsuranceStartDate(Date insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}
	public Date getInsuranceEndDate() {
		return insuranceEndDate;
	}
	public void setInsuranceEndDate(Date insuranceEndDate) {
		this.insuranceEndDate = insuranceEndDate;
	}

	public void setInsuranceCmpName(String string) {
		this.insuranceCmpName = insuranceCmpName;
		
	}
	
	
	
	
}
