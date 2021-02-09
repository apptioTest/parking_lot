package com.parking.car.service;

public class ServiceClass
{
	private int capacity;
	private String[] parkingLot;
	private int availableCars = 0;
	
	public void createParkingLot(int capacity)
	{
		this.capacity = capacity;
		this.parkingLot = new String[capacity];
	}
	
	public void parkCar(String carNumber)
	{
		if(carNumber==null || carNumber.trim().length()<13)
		{
			System.out.println("Please Enter correct car number");
			return;
		}
		if(availableCars<capacity)
		{
			for(int i = 0;i<capacity;i++) {
				if(parkingLot[i]=="0" || parkingLot[i]==null)
				{
					parkingLot[i] = carNumber;
					System.out.println("Allocated slot number: "+(i+1));
					availableCars++;
					break;
				}
			}
		}
		else
		{
			System.out.println("Sorry, parking lot is full");
		}
	}
	
	public void removeCar(String carNumber, int hours)
	{
		if(carNumber==null || carNumber.trim().length()<13)
		{
			System.out.println("Please Enter correct car number");
			return;
		}
		if(availableCars==0)
		{
			System.out.println("Registration number "+carNumber+" not found");
			return;
		}
		if(parkingLot!=null)
		{
			int i = 0;
			for(;i<capacity;i++)
			{
				if(carNumber.equals(parkingLot[i]))
				{
					int charge = hours>1?(10*(hours-1)):10;
					System.out.println("Registration number "+carNumber+" with Slot Number "+(i+1)+" is free with Charge "+charge);
					availableCars--;
					parkingLot[i] = "0";
					break;
				}
			}
			if(i==capacity)
			{
				System.out.println("Registration number "+carNumber+" not found");
				return;
			}
		}
	}
	
	public void status()
	{
		if(availableCars==0)
		{
			return;
		}
		System.out.println("Slot No.\tRegistration No.");
		for(int i = 0;i<capacity;i++)
		{
			if(parkingLot[i]=="0"||parkingLot[i]==null)
			{
				System.out.println(i+1);
			}
			else
			{
				System.out.println((i+1)+"\t"+parkingLot[i]);
			}
			
		}
	}
}
