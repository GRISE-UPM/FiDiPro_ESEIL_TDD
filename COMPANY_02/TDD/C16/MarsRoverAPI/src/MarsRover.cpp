/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>

MarsRover::MarsRover(int x, int y, std::string obstacles) {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */
	planet_dimension_x = x;
	planet_dimension_y = y;

	// The way I am going to go forward is. Whenver the rover finds out it's next move,
	// it will compute the next co-ordinate to move, construct a string of the form (x,y) and make a string search
	// in the planet_obstacles. If the user specifies invalid obstacle, it doesn't matter for the rover :P.
	planet_obstacles = obstacles;
}

MarsRover::~MarsRover() {
	// TODO Auto-generated destructor stub
}

string MarsRover::executeCommand(std::string command) {

	/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
	 * Example:
	 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.

	 * The return string is in the format: (x,y,facing)(o1_x,o1_y)(o2_x,o2_y)..(on_x,on_y)
	 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
	 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
	 */

	if (command == "") {
		rover_position_x = 0;
		rover_position_y = 0;
		rover_facing_direction = "N";
	} else {
		for (std::string::iterator it = command.begin(); it != command.end(); it++) {
				char singleCommand = *it;
				executeIndividualCommand(singleCommand);
		}
	}

	string str = "";
	return str;
}

int MarsRover::getPlanetDimensionX() {
	return planet_dimension_x;
}

int MarsRover::getPlanetDimensionY() {
	return planet_dimension_y;
}

int MarsRover::getRoverPositionX() {
	return rover_position_x;
}

int MarsRover::getRoverPositionY() {
	return rover_position_y;
}

std::string MarsRover::getRoverFacingDirection() {
	return rover_facing_direction;
}

void MarsRover::executeIndividualCommand(char singleCommand) {
	if (singleCommand == 'r') {
		if (rover_facing_direction == "N")
			rover_facing_direction = "E";
		else if (rover_facing_direction == "E")
			rover_facing_direction = "S";
		else if (rover_facing_direction == "S")
			rover_facing_direction = "W";
		else
			rover_facing_direction = "N";
	} else if (singleCommand == 'l') {
		if (rover_facing_direction == "N")
			rover_facing_direction = "W";
		else if (rover_facing_direction == "W")
			rover_facing_direction = "S";
		else if (rover_facing_direction == "S")
			rover_facing_direction = "E";
		else
			rover_facing_direction = "N";
	} else if (singleCommand == 'f') {
		if (rover_facing_direction == "N") {
			rover_position_y++;
			if (rover_position_y == planet_dimension_y)
				rover_position_y = 0;
		}

		else if (rover_facing_direction == "S") {
			rover_position_y--;
			if (rover_position_y < 0)
				rover_position_y = planet_dimension_y - 1;
		}

		else if (rover_facing_direction == "E") {
			rover_position_x++;
			if (rover_position_x == planet_dimension_x)
				rover_position_x = 0;
		}

		else {
			rover_position_x--;
			if (rover_position_x < 0)
				rover_position_x = planet_dimension_x - 1;
		}


	} else if (singleCommand == 'b') {
		if (rover_facing_direction == "N") {
			rover_position_y--;
			if (rover_position_y < 0)
				rover_position_y = planet_dimension_y - 1;
		}

		else if (rover_facing_direction == "S") {
			rover_position_y++;
			if (rover_position_y == planet_dimension_y)
				rover_position_y = 0;
		}

		else if (rover_facing_direction == "E") {
			rover_position_x--;
			if (rover_position_x < 0)
				rover_position_x = planet_dimension_x - 1;
		} else {
			rover_position_x++;
			if (rover_position_x == planet_dimension_x)
				rover_position_x = 0;
		}

	}
}


bool MarsRover::isObstacle(int x, int y) {
   // How difficult is to convert a an interger to string in C++?
	//	std::string searchString = std::to_string(x) + "," + std::to_string(y);
	//	if (planet_obstacles.find(searchString) != std::string::npos)
	//		return true;
	//	else
	//		return false;
}
