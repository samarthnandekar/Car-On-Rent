package com.CarOnRent.myapp.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name="allMasterAvailability")
public class AllMasterAvailability implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "masterAvailabilityID", unique=true,nullable=false)
	long masterAvailabilityID;
	
	@OneToOne
	@JoinColumn(name = "userCar")
	@JsonBackReference
	UserCar userCar;
	
	@Column(name="availableDateFrom")
	Date availableDateFrom;
	
	@Column(name="availableTimeFrom")
	String availableTimeFrom;
	
	@Column(name="availableDateTo")
	Date availableDateTo;
	
	@Column(name="availableTimeTo")
	String availableTimeTo;
	
	@Column(name="isAvailable")
	Boolean isAvailable=false;
	
	@Column(name="isBooked")
	Boolean isBooked=false;
	
	@Column(name="isActive")
	Boolean isActive=false;
	
	@Column(name="totalAvailableTime")
	int totalAvailableTime;
	
	@Column(name="hoursRate")
	int hoursRate;
	
	@Column(name="dayRates")
	int dayRates;

	@OneToOne
    @JoinColumn(name="carParkingAddressID")
	@JsonBackReference
	private CarParkingaddress carParkingaddress;
	

	public CarParkingaddress getCarParkingaddress() {
		return carParkingaddress;
	}

	public void setCarParkingaddress(CarParkingaddress carParkingaddress) {
		this.carParkingaddress = carParkingaddress;
	}

	public long getMasterAvailabilityID() {
		return masterAvailabilityID;
	}

	public void setMasterAvailabilityID(long masterAvailabilityID) {
		this.masterAvailabilityID = masterAvailabilityID;
	}




	public UserCar getUserCar() {
		return userCar;
	}

	public void setUserCar(UserCar userCar) {
		this.userCar = userCar;
	}

	public Date getAvailableDateFrom() {
		return availableDateFrom;
	}

	public void setAvailableDateFrom(Date availableDateFrom) {
		this.availableDateFrom = availableDateFrom;
	}

	public String getAvailableTimeFrom() {
		return availableTimeFrom;
	}
	

	public void setAvailableTimeFrom(String availableTimeFrom) {
		this.availableTimeFrom = availableTimeFrom;
	}

	public Date getAvailableDateTo() {
		return availableDateTo;
	}

	public void setAvailableDateTo(Date availableDateTo) {
		this.availableDateTo = availableDateTo;
	}

	public String getAvailableTimeTo() {
		return availableTimeTo;
	}

	public void setAvailableTimeTo(String availableTimeTo) {
		this.availableTimeTo = availableTimeTo;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public int getTotalAvailableTime() {
		return totalAvailableTime;
	}

	public void setTotalAvailableTime(int totalAvailableTime) {
		this.totalAvailableTime = totalAvailableTime;
	}

	public int getHoursRate() {
		return hoursRate;
	}

	public void setHoursRate(int hoursRate) {
		this.hoursRate = hoursRate;
	}

	public int getDayRates() {
		return dayRates;
	}

	public void setDayRates(int dayRates) {
		this.dayRates = dayRates;
	}
	
	
	
}
