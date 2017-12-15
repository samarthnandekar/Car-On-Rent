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
@Table(name="userAccount")
public class UserAccount implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "userAccountID", unique=true)
	private int userAccountID;
	
	@Column(name="firstName")
	String firstName;
	
	@Column(name="lastName")
	String lastName;
	
	@Column(name="contactNumber")
	String contactNumber;
	
	@Column(name="emailID")
	String emailID;
	
	@Column(name="userpassword")
	String password;	

	@Column(name="userLicenseNo")
	String userLicenseNo;
	
	@Column(name="isAccLocked")
	Boolean isAccLock=false;
	
	@Column(name="isDeleted")
	Boolean isDeleted=false;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy = "userAccount",cascade=CascadeType.ALL)
	@JsonBackReference
	AccountDetails accountDetails;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="userAccount", cascade=CascadeType.ALL)
	@JsonManagedReference
	List<Address> addresses;
	
	@OneToMany(mappedBy="userAccount", cascade=CascadeType.ALL)
	@JsonManagedReference
	List<UserCar> userCar;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="userAccount", cascade=CascadeType.ALL)
	@JsonManagedReference
	List<UsercarReservation> usercarReservations;
	
	

	public List<UsercarReservation> getUsercarReservations() {
		return usercarReservations;
	}

	public void setUsercarReservations(List<UsercarReservation> usercarReservations) {
		this.usercarReservations = usercarReservations;
	}

	public int getUserAccountID() {
		return userAccountID;
	}

	public void setUserAccountID(int userAccountID) {
		this.userAccountID = userAccountID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<UserCar> getUserCar() {
		return userCar;
	}

	public void setUserCar(List<UserCar> userCar) {
		this.userCar = userCar;
	}

//	public void setUserLicenseNo(String userLicense) {
//		// TODO Auto-generated method stub
//		
//	}
	public String getUserLicenseNo() {
		return userLicenseNo;
	}

	public void setUserLicenseNo(String userLicenseNo) {
		this.userLicenseNo = userLicenseNo;
	}

	public Boolean getIsAccLock() {
		return isAccLock;
	}

	public void setIsAccLock(Boolean isAccLock) {
		this.isAccLock = isAccLock;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	
	
	
}
