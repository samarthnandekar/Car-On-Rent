package com.CarOnRent.myapp.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="carParkingaddress")
public class CarParkingaddress implements Serializable{

//	@Id
//	@GenericGenerator(name = "generator", strategy = "foreign",
//	parameters = {@Parameter(name = "property", value = "availability"),
//			      @Parameter(name = "property", value = "usercarReservation"),
//			      @Parameter(name = "property", value = "allMasterAvailability")})
//	@GeneratedValue(generator = "generator")
//	@Column(name = "carParkingaddressID",unique = true, nullable = false)
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "carParkingaddressID", unique=true)
	private int carParkingaddressID;
	
	@Column(name="streetName")
	String streetName;
	
	@Column(name="city")
	String city;
	
	@Column(name="state")
	String state;
	
	@Column(name="country")
	String country;
	
	@Column(name="zipcode")
	int zipcode;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@PrimaryKeyJoinColumn
//	private Availability availability;
//	
//	@OneToOne(fetch = FetchType.LAZY)
//	@PrimaryKeyJoinColumn
//	private UsercarReservation usercarReservation;
//
//	@OneToOne(fetch = FetchType.LAZY)
//	@PrimaryKeyJoinColumn
//	private AllMasterAvailability allMasterAvailability;
	
	
	public int getCarParkingaddressID() {
		return carParkingaddressID;
	}

	public void setCarParkingaddressID(int carParkingaddressID) {
		this.carParkingaddressID = carParkingaddressID;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

//	public Availability getAvailability() {
//		return availability;
//	}
//
//	public void setAvailability(Availability availability) {
//		this.availability = availability;
//	}
//
//	public UsercarReservation getUsercarReservation() {
//		return usercarReservation;
//	}
//
//	public void setUsercarReservation(UsercarReservation usercarReservation) {
//		this.usercarReservation = usercarReservation;
//	}
//
//	public AllMasterAvailability getAllMasterAvailability() {
//		return allMasterAvailability;
//	}
//
//	public void setAllMasterAvailability(AllMasterAvailability allMasterAvailability) {
//		this.allMasterAvailability = allMasterAvailability;
//	}



	
	
}
