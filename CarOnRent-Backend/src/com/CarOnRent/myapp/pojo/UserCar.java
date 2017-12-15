package com.CarOnRent.myapp.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name="userCar")
public class UserCar implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "userCarID", unique=true)
	private int userCarID;
	
	@Column(name="carCompanyName")
	String carCompanyName;
	
	@Column(name="carModel")
	String carModel;
	
	@Column(name="carNumner")
	String carNumner;
	
	@Column(name="carimageName")
	String carimageName;
	
	@Column(name="carDescription")
	String carDescription;
	
	@Column(name="purchaseYear")
	String purchaseYear;
	
	@Column(name="autoGear")
	Boolean autoGear;
	
	@Column(name="carAverage")
	int carAverage;
	
	@Column(name="isDeleted")
	int isDeleted=1;
	
	@Column(name="isApproved")
	Boolean  isApproved=false;
	
	@OneToOne
	@JoinColumn(name = "userAccountID")
	@JsonBackReference
	private UserAccount userAccount;
	
	@OneToOne(mappedBy = "userCar")
	@JsonBackReference
	private CarInsurance carInsurance;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="userCar", cascade=CascadeType.ALL)
	@JsonManagedReference
	List<Availability> availabilities;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="userCar", cascade=CascadeType.ALL)
	@JsonManagedReference
	List<UsercarReservation> carReservationsList;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="userCar", cascade=CascadeType.ALL)
	@JsonManagedReference
	List<AllMasterAvailability> allMasterAvailabilities;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carDtailsID")
	@JsonBackReference
	private CarDetails carDetails;
	
	public List<UsercarReservation> getCarReservationsList() {
		return carReservationsList;
	}

	public void setCarReservationsList(List<UsercarReservation> carReservationsList) {
		this.carReservationsList = carReservationsList;
	}

	
	
	 
	public List<AllMasterAvailability> getAllMasterAvailabilities() {
		return allMasterAvailabilities;
	}

	public void setAllMasterAvailabilities(List<AllMasterAvailability> allMasterAvailabilities) {
		this.allMasterAvailabilities = allMasterAvailabilities;
	}



	public CarDetails getCarDetails() {
		return carDetails;
	}

	public void setCarDetails(CarDetails carDetails) {
		this.carDetails = carDetails;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public CarInsurance getCarInsurance() {
		return carInsurance;
	}

	public String getCarCompanyName() {
		return carCompanyName;
	}

	public void setCarCompanyName(String carCompanyName) {
		this.carCompanyName = carCompanyName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		carModel = carModel;
	}

	public String getCarNumner() {
		return carNumner;
	}

	public void setCarNumner(String carNumner) {
		this.carNumner = carNumner;
	}

	public String getCarimageName() {
		return carimageName;
	}

	public void setCarimageName(String carimageName) {
		this.carimageName = carimageName;
	}

	public String getCarDescription() {
		return carDescription;
	}

	public void setCarDescription(String carDescription) {
		this.carDescription = carDescription;
	}

	public String getPurchaseYear() {
		return purchaseYear;
	}

	public void setPurchaseYear(String purchaseYear) {
		this.purchaseYear = purchaseYear;
	}

	public Boolean getAutoGear() {
		return autoGear;
	}

	public void setAutoGear(Boolean autoGear) {
		this.autoGear = autoGear;
	}

	public int getCarAverage() {
		return carAverage;
	}

	public void setCarAverage(int carAverage) {
		this.carAverage = carAverage;
	}

	public List<Availability> getAvailabilities() {
		return availabilities;
	}

	public void setAvailabilities(List<Availability> availabilities) {
		this.availabilities = availabilities;
	}

	public int getUserCarID() {
		return userCarID;
	}

	public void setUserCarID(int userCarID) {
		this.userCarID = userCarID;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setCarInsurance(CarInsurance carInsurance) {
		
		this.carInsurance = carInsurance;
	}
	
	
	
}
