package com.amit.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.amit.services.IParkingServices;

public class ParkingOfficer {

	 static IParkingServices parkingServices = new ParkingServicesImpl();
	
	public static void main(String[] args) {
		// system should accept a filename as a parameter at the command prompt and read the commands from that file.
		String fileName = args[0];
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(x -> parkingServices.executeCommand(x));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
