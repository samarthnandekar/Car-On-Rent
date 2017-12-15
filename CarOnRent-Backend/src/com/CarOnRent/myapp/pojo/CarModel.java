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
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name="carmodel")
public class CarModel implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "carModelID", unique=true)
	int carModelID;
	
	@Column(name="modelName")
	String modelName;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "makerID")
	@JsonBackReference
	Carmaker carmaker;

	public int getCarModelID() {
		return carModelID;
	}

	public void setCarModelID(int carModelID) {
		this.carModelID = carModelID;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Carmaker getCarmaker() {
		return carmaker;
	}

	public void setCarmaker(Carmaker carmaker) {
		this.carmaker = carmaker;
	}
	
	
}
