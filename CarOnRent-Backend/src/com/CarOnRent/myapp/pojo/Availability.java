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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="availability")
public class Availability implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "availabilityID", unique=true)
	private int availabilityID;
	
	@Column(name="availableFrom")
	Date availableFrom;
	
	@Column(name="availableFromTime")
	String availableFromTime;
	
	@Column(name="availableTo")
	Date availableTo;
	
	@Column(name="availableToTime")
	String availableToTime;
	
	@Column(name="hoursRate")
	int hoursRate;
	
	@Column(name="dayRates")
	int dayRates;
	
	@Column(name="locationlatitude")
	double locationlatitude;
	
	@Column(name="locationlongitude")
	double locationlongitude;
	
	@Column(name="availabilityStatus")
	String availabilityStatus;
	
	@Column(name="aVailpostedDate")
	Date aVailpostedDate;
	
	@Column(name="cancellationDate")
	Date cancellationDate;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userCarID")
	@JsonBackReference
	private UserCar userCar;
	
	
//	@OneToOne(fetch=FetchType.LAZY,mappedBy = "availability",cascade=CascadeType.ALL)
//	private CarParkingaddress carParkingaddress;
	
	// one to one unidirectional
	@OneToOne
    @JoinColumn(name="carParkingAddressID")
	@JsonBackReference
	private CarParkingaddress carParkingaddress;
	
	
	public int getAvailabilityID() {
		return availabilityID;
	}
	public void setAvailabilityID(int availabilityID) {
		this.availabilityID = availabilityID;
	}
	public Date getAvailableFrom() {
		return availableFrom;
	}
	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}
	public Date getAvailableTo() {
		return availableTo;
	}
	public void setAvailableTo(Date availableTo) {
		this.availableTo = availableTo;
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
	
	public UserCar getUserCar() {
		return userCar;
	}
	public void setUserCar(UserCar userCar) {
		this.userCar = userCar;
	}
	public String getAvailableFromTime() {
		return availableFromTime;
	}
	public void setAvailableFromTime(String availableFromTime) {
		this.availableFromTime = availableFromTime;
	}
	public String getAvailableToTime() {
		return availableToTime;
	}
	public void setAvailableToTime(String availableToTime) {
		this.availableToTime = availableToTime;
	}
	public double getLocationlatitude() {
		return locationlatitude;
	}
	public void setLocationlatitude(double locationlatitude) {
		this.locationlatitude = locationlatitude;
	}
	public double getLocationlongitude() {
		return locationlongitude;
	}
	public void setLocationlongitude(double locationlongitude) {
		this.locationlongitude = locationlongitude;
	}
	public CarParkingaddress getCarParkingaddress() {
		return carParkingaddress;
	}
	public void setCarParkingaddress(CarParkingaddress carParkingaddress) {
		this.carParkingaddress = carParkingaddress;
	}
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	public Date getaVailpostedDate() {
		return aVailpostedDate;
	}
	public void setaVailpostedDate(Date aVailpostedDate) {
		this.aVailpostedDate = aVailpostedDate;
	}
	public Date getCancellationDate() {
		return cancellationDate;
	}
	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	
}
