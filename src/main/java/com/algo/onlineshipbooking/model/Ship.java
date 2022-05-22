package com.algo.onlineshipbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ship 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shipId;
	private String shipName;
	private String source;
	private String destination;
	private String estimatedTravelDuration;
	private int seatingCapacity;
	private int reservationCapacityRegular;
	private int reservationCapacityWL;
	
	public Ship() {
		
	}
	public Ship(String shipName, String source, String destination, String estimatedTravelDuration, int seatingCapacity,
			int reservationCapacityRegular, int reservationCapacityWL) {
		super();
		this.shipName = shipName;
		this.source = source;
		this.destination = destination;
		this.estimatedTravelDuration = estimatedTravelDuration;
		this.seatingCapacity = seatingCapacity;
		this.reservationCapacityRegular = reservationCapacityRegular;
		this.reservationCapacityWL = reservationCapacityWL;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
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
	public String getEstimatedTravelDuration() {
		return estimatedTravelDuration;
	}
	public void setEstimatedTravelDuration(String estimatedTravelDuration) {
		this.estimatedTravelDuration = estimatedTravelDuration;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public int getReservationCapacityRegular() {
		return reservationCapacityRegular;
	}
	public void setReservationCapacityRegular(int reservationCapacityRegular) {
		this.reservationCapacityRegular = reservationCapacityRegular;
	}
	public int getReservationCapacityWL() {
		return reservationCapacityWL;
	}
	public void setReservationCapacityWL(int reservationCapacityWL) {
		this.reservationCapacityWL = reservationCapacityWL;
	}
		
}
