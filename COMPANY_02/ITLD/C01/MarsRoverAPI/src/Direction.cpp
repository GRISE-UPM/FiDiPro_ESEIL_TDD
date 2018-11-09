/*
 * Direction.cpp
 *
 *  Created on: 15 Apr 2015
 *      Author: user
 */

#include "Direction.h"

void Direction::rotateClockwise() {
	roverIsFacing = N;
}

void Direction::rotateCouterClockwise() {

	if (roverIsFacing == 0) {
		roverIsFacing = N;
	} else{
		roverIsFacing = N;

	}
}

int Direction::roverFacing() {
	return roverIsFacing;
}







