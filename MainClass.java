//FILE: MainClass.java
//PROGRAMMER: Alexis Williams
//PUPROSE: Simulates a subway train going down the station line

package stu.williams.program4;

public class MainClass                 
{

	public static void main(String[] args) 
	{
		final int PAX_BOARD_LIMIT = 300;
		//instiate constructor
		SubwayTrain expressLane = new SubwayTrain(30, 200, 1);
		
		System.out.println("All aboard the Empire Express Subway!");		
		//cannot have subway empty before departing
		//the value passed in the ranNumGenerator will be based on the max number of passengers who can board the train
		expressLane.loadPassengers(expressLane.genRanNumber(PAX_BOARD_LIMIT));						
			for(int count = 0; count < 31; ++count)
			{
				expressLane.moveToStation(expressLane.getCurrentStation() + 1);
				expressLane.unloadPassengers(expressLane.genRanNumber(expressLane.getPassengers()));
				expressLane.loadPassengers(expressLane.genRanNumber(PAX_BOARD_LIMIT));	
			
			}//end for loop					
		expressLane.moveToStation(expressLane.getStartingStation());	
		expressLane.unloadPassengers(expressLane.genRanNumber(expressLane.getPassengers()));
	}//end Main

}//end MainClass
