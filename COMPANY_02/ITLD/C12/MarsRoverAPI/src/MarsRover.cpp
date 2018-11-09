/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>
#include <sstream>

MarsRover::MarsRover(int x, int y, string obstacles) {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */
	lim_x = x;
	lim_y = y;
	loc_x = 0;
	loc_y = 0;
	heading = 'N';
}

MarsRover::~MarsRover() {
	// TODO Auto-generated destructor stub
}

void MarsRover::turn_left() {
	switch (heading) {
	case 'N':
		heading = 'W';
		break;
	case 'W':
		heading = 'S';
		break;
	case 'S':
		heading = 'E';
		break;
	case 'E':
		heading = 'N';
		break;
	}
}

void MarsRover::turn_right() {
	switch (heading) {
	case 'N':
		heading = 'E';
		break;
	case 'E':
		heading = 'S';
		break;
	case 'S':
		heading = 'W';
		break;
	case 'W':
		heading = 'N';
		break;
	}
}

void MarsRover::forward() {
	switch (heading) {
	case 'N':
		loc_y += 1;
		break;
	case 'E':
		loc_x += 1;
		break;
	case 'S':
		loc_y -= 1;
		break;
	case 'W':
		loc_x -= 1;
		break;
	}
	if (loc_x < 0) {
		loc_x += 100;
		return;
	}
	if (loc_x > 99) {
		loc_x -= 100;
		return;
	}
	if (loc_y < 0) {
		loc_y += 100;
		return;
	}
	if (loc_y > 99) {
		loc_y -= 100;
		return;
	}
}

void MarsRover::reverse() {
	switch (heading) {
	case 'N':
		loc_y -= 1;
		break;
	case 'E':
		loc_x -= 1;
		break;
	case 'S':
		loc_y += 1;
		break;
	case 'W':
		loc_x += 1;
		break;
	}
	if (loc_x < 0) {
		loc_x += 100;
		return;
	}
	if (loc_x > 99) {
		loc_x -= 100;
		return;
	}
	if (loc_y < 0) {
		loc_y += 100;
		return;
	}
	if (loc_y > 99) {
		loc_y -= 100;
		return;
	}

}

string MarsRover::executeCommand(string command) {

	/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
	 * Example:
	 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.

	 * The return string is in the format: (x,y,facing)(o1_x,o1_y)(o2_x,o2_y)..(on_x,on_y)
	 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
	 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
	 */
	if ( !command.compare("") ) {
		loc_x = 0;
		loc_y = 0;
		heading = 'N';
	}
	else {
		for (string::iterator it = command.begin(); it != command.end(); ++it) {
			if (*it == 'l') {
				turn_left();
			} else if (*it == 'r') {
				turn_right();
			} else if (*it == 'f') {
				forward();
			} else if (*it == 'b') {
				reverse();
			}
		}
	}

	stringstream ss;
	ss << "(" << loc_x << + "," << loc_y << "," << heading <<  ")";
	return ss.str();
}
