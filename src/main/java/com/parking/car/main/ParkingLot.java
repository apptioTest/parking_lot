package com.parking.car.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.parking.car.service.ServiceClass;

public class ParkingLot {
	@SuppressWarnings("resource")
	public static void main(String[] args) {		
		String fileName = args[0];
		if(null==fileName || fileName.trim().equals(""))
		{
			System.out.println("Please enter correct file name");
			return;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("../bin/"+fileName+".txt"));
			ServiceClass service = new ServiceClass();
			String line = br.readLine();
			while(line!=null)
			{
				String[] commands = line.split(" ");
				
				if(null!=commands[0])
				{
					switch(commands[0])
					{
					case "create_parking_lot":
							service.createParkingLot(commands[1]!=null ? Integer.parseInt(commands[1]):0);
						break;
						
					case "park":
							service.parkCar(commands[1]);
						break;
						
					case "leave":
							service.removeCar(commands[1], commands[2]!=null ? Integer.parseInt(commands[2]):0);
						break;
						
					case "status":
							service.status();
						break;
						
						default:
							System.out.println("Command is not proper");
					}
				}
				//System.out.println(line);
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Please enter correct file Name");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
