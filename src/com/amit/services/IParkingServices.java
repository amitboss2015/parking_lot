package com.amit.services;

import com.amit.model.ParkingSlot;
import com.amit.model.VehicleMaster;

public interface IParkingServices {
	int getFinalParkingFee(int noOfHours);

	ParkingSlot getNearestAvailableSlot();

	VehicleMaster getVehicleMasterByRegistrationNumber(String registrationNo);

	void executeCommand(String command);
}
