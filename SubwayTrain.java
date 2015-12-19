//FILE:SubwayTrain.java
//PROGRAMMER: Alexis Williams
//PURPOSE: Manages and manipulates the data to be used in MainClass.java

package stu.williams.program4;

import java.util.Random;

public class SubwayTrain 
{
	private int passengers; 
	private int maxCapacity;
	private int numStation;
	private int currentStation;
	private int startingStation;
	private int targetStation;
	private Random ranNumGenerator;
	
	public SubwayTrain(int numStat, int maxPersons, int starStatNum)
	{
		numStation = numStat;
		maxCapacity = maxPersons;
		startingStation = starStatNum;
		passengers = 0;
		currentStation = startingStation;
		targetStation = currentStation;
		ranNumGenerator = new Random();
		
	}
	
	public int getCurrentStation()
	{
		return currentStation;
	}
	
	public int getStartingStation()
	{
		return startingStation;
	}
	
	public int getPassengers()
	{
		return passengers;
	}
	
	public int genRanNumber(int maxNum)
	{
		return ranNumGenerator.nextInt(maxNum + 1);
	}
	
	public void loadPassengers(int numWaiting)
	{
		if(maxCapacity < (passengers + numWaiting))
		{
			System.out.println("Number of Passengers wanting to get on board: " + numWaiting);
			System.out.println("Max capacity has been reached. Not every one can board, sorry!");
			int openPositions = maxCapacity - passengers;
			int numWhoCanBoard = 0;
			
				if (numWaiting > openPositions)
				{
					numWhoCanBoard = openPositions;
				}
				else
					numWhoCanBoard = numWaiting;
			
			passengers += numWhoCanBoard;
			
			System.out.println("Number of passengers capable of boarding: " + numWhoCanBoard);
			System.out.println("Now boarding...");
			System.out.println("Current number of passengers on board: " + passengers);
		}
		else if(maxCapacity > (passengers + numWaiting))
		{
			passengers += numWaiting;
			
			System.out.println("Number of passengers wanting to board: " + numWaiting);
			System.out.println("Now boarding...");
			System.out.println("Current number of passengers on board: " + passengers);
		}
	}
	
	public void unloadPassengers(int numLeaving)
	{
		if(numLeaving > passengers)
		{
			passengers = 0;
		}
		else
			passengers -= numLeaving;
		
		System.out.println("Number of passengers wishing to unboard: " + numLeaving);
		System.out.println("Now unboarding passengers!");
		System.out.println("Current number of passengers on board: " + passengers);
	}
	
	public void moveToStation(int destination)
	{
		//testing to see if destination station number is valid
		if(destination > numStation || destination < 1)
		{
			System.out.println("This station number is not inside our subway line.");
		}
		else
			targetStation = destination;
		
		System.out.println("Now leaving Station " + currentStation + " for Station " + targetStation + " with " + passengers +" on board.");	
		//update currentStation
		currentStation = targetStation;
		
	}
}
