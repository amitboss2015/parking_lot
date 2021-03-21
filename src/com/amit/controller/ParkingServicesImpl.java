package com.amit.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import com.amit.model.CommandType;
import com.amit.model.ParkingSlot;
import com.amit.model.VehicleMaster;
import com.amit.model.Vehicle_parkingSlot_Association;
import com.amit.services.IParkingServices;

public class ParkingServicesImpl implements IParkingServices{
	  ParkingSlot[] parkingSlotList = null;
	  List<VehicleMaster> vehicleMasterList = new ArrayList<>();
	  List<Vehicle_parkingSlot_Association> vehicleParkingSlotAssList = new ArrayList<>();
	  Map<Integer, Vehicle_parkingSlot_Association> parkingSlotAndVehicleDetailsMap = new HashMap<>();
	static int vehicleCounter = 1;
	static int vehicleParkingAsscnCounter = 1;

	
	
	@Override
	public int getFinalParkingFee(int noOfHours) {
		int totalBill = 10;
		if (noOfHours > 2) {
			totalBill += (noOfHours - 2) * 10;
		}

		return totalBill;
	}

	@Override
	public ParkingSlot getNearestAvailableSlot() {
		Optional<ParkingSlot> nearestSlot = Arrays.stream(parkingSlotList).filter(slot -> slot.isAvailable())
				.findFirst();
		if (nearestSlot.isPresent()) {
			return nearestSlot.get();
		} else
			return null;
	}

	@Override
	public VehicleMaster getVehicleMasterByRegistrationNumber(String registrationNo) {
		Optional<VehicleMaster> vehicleMasterObj = vehicleMasterList.stream()
				.filter(vehicle -> vehicle.getRegistrationNumber().equals(registrationNo)).findFirst();
		if (vehicleMasterObj.isPresent()) {
			return vehicleMasterObj.get();
		} else {
			return null;
		}
	}

	@Override
	public void executeCommand(String command) {
		String[] commandTxt = command.split("\\s+");
		switch (CommandType.valueOf(commandTxt[0].toUpperCase())) {
		case CREATE_PARKING_LOT:
			// PARKING SLOT CREATION LOGIC
			int noOfSlotsToCreate = Integer.valueOf(commandTxt[1]);
			parkingSlotList = new ParkingSlot[noOfSlotsToCreate];
			ParkingSlot slot = null;
			for (int i = 0; i < noOfSlotsToCreate; i++) {
				slot = new ParkingSlot(i, true);
				parkingSlotList[i] = slot;
			}
			System.out.println("Created parking lot with " + noOfSlotsToCreate + " slots");

			break;
		case PARK:

			VehicleMaster vehicleMaster = null;
			// perform allocation of slots
			Vehicle_parkingSlot_Association vpAssObj = new Vehicle_parkingSlot_Association();
			vpAssObj.setVehicleAssID(vehicleParkingAsscnCounter++);
			ParkingSlot nearestSlot = getNearestAvailableSlot();
			if (nearestSlot != null) {
				vpAssObj.setFkSlotID(nearestSlot.getSlotNumber());
				vehicleMaster = new VehicleMaster(vehicleCounter++, commandTxt[1]);
				vehicleMasterList.add(vehicleMaster);
				vpAssObj.setFkVehicleID(vehicleMaster.getVehicleID());
			} else {
				System.out.println("Sorry, parking lot is full");
				break;
			}
			vpAssObj.setVehicleMaster(vehicleMaster);

			vehicleParkingSlotAssList.add(vpAssObj);
			parkingSlotAndVehicleDetailsMap.put(vpAssObj.getFkSlotID(), vpAssObj);
			// after association update the slot occupied.
			nearestSlot.setAvailable(false);
			// parking slot list will be updated
			parkingSlotList[nearestSlot.getSlotNumber()] = nearestSlot;
			System.out.println("Allocated slot number: " + (vpAssObj.getFkSlotID() + 1));

			break;
		case LEAVE:
			// final billing to be generated
			String registrationNo = commandTxt[1];
			// find vehicle master by registration number
			VehicleMaster vehicleMasterObj = getVehicleMasterByRegistrationNumber(registrationNo);

			if(vehicleMasterObj==null) {
				System.out.println("Registration number "+registrationNo+" not found");
				break;
			}
			// find vehle and slot association by vehicle id
			Vehicle_parkingSlot_Association vpaObj = vehicleParkingSlotAssList.stream().filter(vpa -> vpa.getFkVehicleID() == vehicleMasterObj.getVehicleID()).findFirst().get();
			// generate invoice
			int hours = Integer.valueOf(commandTxt[2]);
			vpaObj.setElapsedTime(hours);
			vpaObj.setChargesApplied(getFinalParkingFee(hours));
			// update vehicle slot associaiton list with total bill
			vehicleParkingSlotAssList.add(vpaObj);
			// update the map of slot and vehicleslot association.
			parkingSlotAndVehicleDetailsMap.remove(vpaObj.getFkSlotID());

			// update paring slot status to available
			ParkingSlot psObj = parkingSlotList[vpaObj.getFkSlotID()];
			psObj.setAvailable(true);
			parkingSlotList[vpaObj.getFkSlotID()] = psObj;
			System.out.println("Registration number " + registrationNo + " with Slot Number "+ (vpaObj.getFkSlotID() + 1) + " is free with Charge " + getFinalParkingFee(hours));

			break;
		case STATUS:
			// System.out.println("Status command is called");
			System.out.println("Slot No. Registration No.");

			for (Entry<Integer, Vehicle_parkingSlot_Association> entry: parkingSlotAndVehicleDetailsMap.entrySet()) {
				System.out.println((entry.getKey() + 1) + "	" + entry.getValue().getVehicleMaster().getRegistrationNumber());

			}

			break;

		default:
			System.out.println("");
			break;
		}
	}

}
