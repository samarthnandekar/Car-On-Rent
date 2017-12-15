package com.CarOnRent.myapp.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ReservationfeedbackSurvey")
public class ReservationfeedbackSurvey implements Serializable {

	public CarCondition car_condition=CarCondition.average;
	Boolean sufficientFuelAvailable;
	Boolean isDifficultToFindtheCarLocation;
	public CarCondition carCleanness;
	int overAllRating;
	
	String comments;

	public CarCondition getCar_condition() {
		return car_condition;
	}

	public void setCar_condition(CarCondition car_condition) {
		this.car_condition = car_condition;
	}

	public Boolean getSufficientFuelAvailable() {
		return sufficientFuelAvailable;
	}

	public void setSufficientFuelAvailable(Boolean sufficientFuelAvailable) {
		this.sufficientFuelAvailable = sufficientFuelAvailable;
	}

	public Boolean getIsDifficultToFindtheCarLocation() {
		return isDifficultToFindtheCarLocation;
	}

	public void setIsDifficultToFindtheCarLocation(Boolean isDifficultToFindtheCarLocation) {
		this.isDifficultToFindtheCarLocation = isDifficultToFindtheCarLocation;
	}

	public CarCondition getCarCleanness() {
		return carCleanness;
	}

	public void setCarCleanness(CarCondition carCleanness) {
		this.carCleanness = carCleanness;
	}

	public int getOverAllRating() {
		return overAllRating;
	}

	public void setOverAllRating(int overAllRating) {
		this.overAllRating = overAllRating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	
}
