package com.amit.model;

public class Vehicle_parkingSlot_Association {
	private long vehicleAssID;
	private int fkSlotID;
	private int fkVehicleID;
	private long elapsedTime;
	private int chargesApplied;
	private VehicleMaster vehicleMaster;
	
	

	public VehicleMaster getVehicleMaster() {
		return vehicleMaster;
	}

	public void setVehicleMaster(VehicleMaster vehicleMaster) {
		this.vehicleMaster = vehicleMaster;
	}

	public long getVehicleAssID() {
		return vehicleAssID;
	}

	public void setVehicleAssID(long vehicleAssID) {
		this.vehicleAssID = vehicleAssID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fkSlotID;
		result = prime * result + fkVehicleID;
		result = prime * result + (int) (vehicleAssID ^ (vehicleAssID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle_parkingSlot_Association other = (Vehicle_parkingSlot_Association) obj;
		if (fkSlotID != other.fkSlotID)
			return false;
		if (fkVehicleID != other.fkVehicleID)
			return false;
		if (vehicleAssID != other.vehicleAssID)
			return false;
		return true;
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

	public int getChargesApplied() {
		return chargesApplied;
	}

	public void setChargesApplied(int chargesApplied) {
		this.chargesApplied = chargesApplied;
	}

	

}
