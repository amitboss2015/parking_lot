package com.amit.services;

import java.util.Comparator;

import com.amit.model.ParkingSlot;

public class ParkingSlotComparator implements Comparator<ParkingSlot>{

	@Override
	public int compare(ParkingSlot arg0, ParkingSlot arg1) {
		// TODO Auto-generated method stub
		return Boolean.compare(arg0.isAvailable(),arg1.isAvailable());
	}

}
