/*
 * MarsRover.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef MARSROVER_H_
#define MARSROVER_H_

#include "Coordinate.h"
#include "Rover.h"
#include "Direction.h"
#include <string>
#include <vector>
#include <fstream>
#include <iostream>
#include <sstream>


class MarsRover {
public:
	MarsRover(int x, int y, std::string obstacles);
	virtual ~MarsRover();
	std::string executeCommand(std::string command);

private:
	std::vector<Coordinate> obstacles;
	std::vector<std::vector<Coordinate>> planet;
	Rover marsRover;
};

#endif  /*MARSROVER_H*/

