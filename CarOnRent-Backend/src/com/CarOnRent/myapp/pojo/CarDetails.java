package com.CarOnRent.myapp.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name="carDetails")
public class CarDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "carDetailsID", unique=true)
	private int carDtailsID;
	
	@Column(name="carMaker")
	String carMaker;
	
	@Column(name="carModel")
	String carModel;
	
	@Column(name="carType")
	String carType;
	
	@Column(name="doors")
	String doors;
	
	@Column(name="passengers")
	int passengers;
	
	@Column(name="bags")
	int bags;
	
	@Column(name="autoGear")
	boolean autoGear;
	
	@Column(name="manualGear")
	boolean manualGear;
	
	@Column(name="backCamera")
	boolean backCamera;
	
	@Column(name="gpsDisplay")
	boolean gpsDisplay;
	
	@Column(name="remoteStart")
	boolean remoteStart;
	
	@Column(name="musicSystem")
	boolean musicSystem;

	@Column(name="chargingPoints")
	boolean chargingPoints;
	
	@Column(name="fuelTankCapacity")
	int fuelTankCapacity;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="carDetails", cascade=CascadeType.ALL)
	@JsonManagedReference
	List<UserCar> userCar;
	
	public int getCarDtailsID() {
		return carDtailsID;
	}

	public void setCarDtailsID(int carDtailsID) {
		this.carDtailsID = carDtailsID;
	}

	public String getCarMaker() {
		return carMaker;
	}

	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getDoors() {
		return doors;
	}

	public void setDoors(String doors) {
		this.doors = doors;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public int getBags() {
		return bags;
	}

	public void setBags(int bags) {
		this.bags = bags;
	}

	public boolean isAutoGear() {
		return autoGear;
	}

	public void setAutoGear(boolean autoGear) {
		this.autoGear = autoGear;
	}

	public boolean isManualGear() {
		return manualGear;
	}

	public void setManualGear(boolean manualGear) {
		this.manualGear = manualGear;
	}

	public boolean isBackCamera() {
		return backCamera;
	}

	public void setBackCamera(boolean backCamera) {
		this.backCamera = backCamera;
	}

	public boolean isGpsDisplay() {
		return gpsDisplay;
	}

	public void setGpsDisplay(boolean gpsDisplay) {
		this.gpsDisplay = gpsDisplay;
	}

	public boolean isRemoteStart() {
		return remoteStart;
	}

	public void setRemoteStart(boolean remoteStart) {
		this.remoteStart = remoteStart;
	}

	public boolean isMusicSystem() {
		return musicSystem;
	}

	public void setMusicSystem(boolean musicSystem) {
		this.musicSystem = musicSystem;
	}

	public boolean isChargingPoints() {
		return chargingPoints;
	}

	public void setChargingPoints(boolean chargingPoints) {
		this.chargingPoints = chargingPoints;
	}

	public int getFuelTankCapacity() {
		return fuelTankCapacity;
	}

	public void setFuelTankCapacity(int fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}

	public List<UserCar> getUserCar() {
		return userCar;
	}

	public void setUserCar(List<UserCar> userCar) {
		this.userCar = userCar;
	}
	
	
}
