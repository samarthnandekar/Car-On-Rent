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
@Table(name="usercarReservation")
public class UsercarReservation implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "usercarReservationID", unique=true)
	int usercarReservationID;

	@OneToOne
	@JoinColumn(name="userAccountID")
	UserAccount userAccount;
	
	@Column(name="driverName")
	String driverName;
	
	@Column(name="reservationStartDate")
	Date reservationStartDate;
	
	@Column(name="reservationStartTime")
	String reservationStartTime;
	
	@Column(name="reservationEndDate")
	Date reservationEndDate;
	
	@Column(name="reservationEndTime")
	String reservationEndTime;
	
	@OneToOne
	@JoinColumn(name = "userCar")
	@JsonBackReference
	UserCar userCar;
	
	@Column(name="rate")
	int rate;
	
	// rate can be perhours and perDay , how will store them
	
	@Column(name="totalreverVationTime")
	int totalTimereverVationTime;
	
	@Column(name="totalReservationCost")
	int totalReservationCost;
	
	@Column(name="bookingDate")
	Date bookingDate;
	
	@Column(name="bookingStatus")
	String bookingStatus;
	
	@Column(name="reservationMemo")
	String reservationMemo;

	@OneToOne(fetch=FetchType.LAZY,mappedBy = "usercarReservation",cascade=CascadeType.ALL)
	@JsonBackReference
	private PaymentDetails paymentDetails;	
	
	@OneToOne
    @JoinColumn(name="carParkingAddressID")
	@JsonBackReference
	private CarParkingaddress carParkingaddress;
	
	
	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}


	public int getTotalReservationCost() {
		return totalReservationCost;
	}
	
	

	public int getUsercarReservationID() {
		return usercarReservationID;
	}

	public void setUsercarReservationID(int usercarReservationID) {
		this.usercarReservationID = usercarReservationID;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}



	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Date getReservationStartDate() {
		return reservationStartDate;
	}

	public void setReservationStartDate(Date reservationStartDate) {
		this.reservationStartDate = reservationStartDate;
	}

	public String getReservationStartTime() {
		return reservationStartTime;
	}

	public void setReservationStartTime(String reservationStartTime) {
		this.reservationStartTime = reservationStartTime;
	}

	public Date getReservationEndDate() {
		return reservationEndDate;
	}

	public void setReservationEndDate(Date reservationEndDate) {
		this.reservationEndDate = reservationEndDate;
	}

	public String getReservationEndTime() {
		return reservationEndTime;
	}

	public void setReservationEndTime(String reservationEndTime) {
		this.reservationEndTime = reservationEndTime;
	}



	public UserCar getUserCar() {
		return userCar;
	}



	public void setUserCar(UserCar userCar) {
		this.userCar = userCar;
	}



	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getTotalTimereverVationTime() {
		return totalTimereverVationTime;
	}

	public void setTotalTimereverVationTime(int totalTimereverVationTime) {
		this.totalTimereverVationTime = totalTimereverVationTime;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getReservationMemo() {
		return reservationMemo;
	}

	public void setReservationMemo(String reservationMemo) {
		this.reservationMemo = reservationMemo;
	}

	public void setTotalReservationCost(int i) {
		this.totalReservationCost=i;
		
	}

	public CarParkingaddress getCarParkingaddress() {
		return carParkingaddress;
	}

	public void setCarParkingaddress(CarParkingaddress carParkingaddress) {
		this.carParkingaddress = carParkingaddress;
	}
	
	
	
}
