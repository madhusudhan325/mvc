package com.mindtree.traveltourism.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Travel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int travelId;
	private String source;
	private String destination;
	private Date dateOfJourney;
	private int distance;
	private String foodType;
	private String travelType;
	private int travelFare;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Customer customer;

	public Travel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Travel(int travelId, String source, String destination, Date dateOfJourney, int distance, String foodType,
			String travelType, int travelFare, Customer customer) {
		super();
		this.travelId = travelId;
		this.source = source;
		this.destination = destination;
		this.dateOfJourney = dateOfJourney;
		this.distance = distance;
		this.foodType = foodType;
		this.travelType = travelType;
		this.travelFare = travelFare;
		this.customer = customer;
	}

	public int getTravelId() {
		return travelId;
	}

	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getTravelType() {
		return travelType;
	}

	public void setTravelType(String travelType) {
		this.travelType = travelType;
	}

	public int getTravelFare() {
		return travelFare;
	}

	public void setTravelFare(int travelFare) {
		this.travelFare = travelFare;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
