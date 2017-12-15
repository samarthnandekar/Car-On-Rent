package com.CarOnRent.myapp.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name="carmaker")
public class Carmaker implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "carMakerId", unique=true)
	int carMakerId;
	
	@Column(name="makerName")
	String makerName;
	
	@OneToMany(mappedBy="carmaker", cascade=CascadeType.ALL)
	@JsonManagedReference
	List<CarModel> carModels;

	public int getCarMakerId() {
		return carMakerId;
	}

	public void setCarMakerId(int carMakerId) {
		this.carMakerId = carMakerId;
	}

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public List<CarModel> getCarModels() {
		return carModels;
	}

	public void setCarModels(List<CarModel> carModels) {
		this.carModels = carModels;
	}
	
	
	
}
