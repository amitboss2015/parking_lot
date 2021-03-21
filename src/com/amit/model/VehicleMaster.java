package com.amit.model;

public class VehicleMaster {
	private int vehicleID;
	private String registrationNumber;
	private String color;

	

	public VehicleMaster(int vehicleID, String registrationNumber) {
		super();
		this.vehicleID = vehicleID;
		this.registrationNumber = registrationNumber;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
