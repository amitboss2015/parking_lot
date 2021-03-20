package com.amit.model;

public class Vehicle_parkingSlot_Association {
	private long vehicleAssID;
	private int fkSlotID;
	private int fkVehicleID;
	private long elapsedTime;
	private double chargesApplied;

	public long getVehicleAssID() {
		return vehicleAssID;
	}

	public void setVehicleAssID(long vehicleAssID) {
		this.vehicleAssID = vehicleAssID;
	}

	public int getFkSlotID() {
		return fkSlotID;
	}

	public void setFkSlotID(int fkSlotID) {
		this.fkSlotID = fkSlotID;
	}

	public int getFkVehicleID() {
		return fkVehicleID;
	}

	public void setFkVehicleID(int fkVehicleID) {
		this.fkVehicleID = fkVehicleID;
	}

	public long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public double getChargesApplied() {
		return chargesApplied;
	}

	public void setChargesApplied(double chargesApplied) {
		this.chargesApplied = chargesApplied;
	}

}
