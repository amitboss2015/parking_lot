package com.amit.model;

// Assumption is that we are going to make a car parking allotment as per problem statement.
public class ParkingSlot {
	private int slotNumber;
	private boolean isAvailable;

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	

	public ParkingSlot(int slotNumber, boolean isAvailable) {
		super();
		this.slotNumber = slotNumber;
		this.isAvailable = isAvailable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isAvailable ? 1231 : 1237);
		result = prime * result + slotNumber;
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
		ParkingSlot other = (ParkingSlot) obj;
		if (isAvailable != other.isAvailable)
			return false;
		if (slotNumber != other.slotNumber)
			return false;
		return true;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

}
