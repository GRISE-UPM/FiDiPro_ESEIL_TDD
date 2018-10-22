package tdd.training.paf;

import java.util.ArrayList;
import java.util.List;

public class Temp {
	public static void main(String []args) {
		
		MarsRover rover = new MarsRover(3,3,"(1,2)(2,2)");
		System.out.println(rover.executeCommand("brfrb"));
		/*
		Temp t = new Temp();
		List<String> obsList = t.extractObstacles("(2,8)(3,9)");
		for(String obs : obsList){f
			System.out.println(obs);
		}
		*/
	}
	
	List<String> extractObstacles(String obstacles){
		int numberOfObstacles = obstacles.length() - obstacles.replace("(", "").length();
		List<String> obstacleCoordinates = new ArrayList<String>();
				
		while(numberOfObstacles > 0){
			String requiredString = obstacles.substring(obstacles.indexOf("(") + 1, obstacles.indexOf(")"));
			obstacleCoordinates.add(requiredString);
			obstacles = obstacles.substring(obstacles.indexOf(")") + 1, obstacles.length());
			numberOfObstacles--;
		}
		return obstacleCoordinates;
	}
}
