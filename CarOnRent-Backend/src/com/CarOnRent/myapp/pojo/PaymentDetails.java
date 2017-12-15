package com.CarOnRent.myapp.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="paymentDetails")
public class PaymentDetails implements Serializable{
	
	
	@Id
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "usercarReservation"))
	@GeneratedValue(generator = "generator")
	@Column(name = "paymentDetailsID",unique = true, nullable = false)
	private int paymentDetailsID;
	
	@Column(name = "cardNumber")
	String cardNumber;
	
	@Column(name = "bankName")
	String bankName;
	
	@Column(name = "expDate")
	String expDate;
	
	@Column(name = "cardHolderName")
	String cardHolderName;
	
	@Column(name = "amount")
	int amount;
	
	@Column(name = "emailID")
	String emailID;
	 
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonBackReference
	private UsercarReservation usercarReservation;

	public int getPaymentDetailsID() {
		return paymentDetailsID;
	}

	public void setPaymentDetailsID(int paymentDetailsID) {
		this.paymentDetailsID = paymentDetailsID;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public UsercarReservation getUsercarReservation() {
		return usercarReservation;
	}

	public void setUsercarReservation(UsercarReservation usercarReservation) {
		this.usercarReservation = usercarReservation;
	}

	
}
