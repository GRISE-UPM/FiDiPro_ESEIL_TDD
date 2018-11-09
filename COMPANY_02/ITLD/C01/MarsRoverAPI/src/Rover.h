/*
 * Rover.h
 *
 *  Created on: 15 Apr 2015
 *      Author: user
 */

#ifndef ROVER_H_
#define ROVER_H_

#include "Direction.h"
#include "Coordinate.h"


class Rover {
public:
	Rover();
	bool moveForwards();
	bool moveBackwards();
	Direction getDirection();

private:
	Coordinate locationCoordinate;
	Direction direction;

};

#endif /* ROVER_H_ */
