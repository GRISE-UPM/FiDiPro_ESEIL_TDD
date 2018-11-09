/*
 * MarsRover.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef MARSROVER_H_
#define MARSROVER_H_

#include <iostream>
#include <sstream>

using namespace std;

class MarsRover {
public:
	MarsRover(int x, int y, string obstacles);
	virtual ~MarsRover();
	string executeCommand(std::string command);
	int getPlanetDimensionX();
	int getPlanetDimensionY();

	int getRoverPositionX();
	int getRoverPositionY();
	std::string getRoverFacingDirection();

private:
	int planet_dimension_x;
	int planet_dimension_y;

	int rover_position_x;
	int rover_position_y;
	std::string rover_facing_direction;
	std::string planet_obstacles;
	void executeIndividualCommand(char singleCommand);
	bool isObstacle(int x, int y);
};

#endif  /*MARSROVER_H*/

