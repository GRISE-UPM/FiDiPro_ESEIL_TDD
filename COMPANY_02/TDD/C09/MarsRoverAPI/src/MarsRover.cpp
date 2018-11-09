/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>
#include <vector>

using namespace std;

MarsRover::MarsRover(int x, int y, string obstacles) {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */
	readObstacles(obstacles);
	_gridsize = position_t (x, y);
	_orientation = MR_NORTH;
}

void MarsRover::readObstacles(string obstacles) {

}

void MarsRover::readObstacle (string obstacle) {

}

unsigned int MarsRover::obstaclesSize () {
	return _obstacles.size();
}

MarsRover::~MarsRover() {
	// TODO Auto-generated destructor stub
}

string format_command(position_t p, orientation_t o) {
	string s = "(";

	s += ('0'+p.x);
	s += ", ";

	s += ('0'+p.y);
	s+= ", ";

	switch(o) {
	case MR_NORTH:
		s += "north";
		break;
	case MR_EAST:
		s += "east";
		break;
	case MR_SOUTH:
		s += "south";
		break;
	case MR_WEST:
		s += "west";
		break;
	default:
		break;
	}

	s += ")";
	return s;
}

void MarsRover::turnRight() {
	switch(_orientation) {
	case MR_NORTH:
		_orientation = MR_EAST;
		break;
	case MR_EAST:
		_orientation = MR_SOUTH;
		break;
	case MR_SOUTH:
		_orientation = MR_WEST;
		break;
	case MR_WEST:
		_orientation = MR_NORTH;
		break;
	default:
		break;
	}
}

void MarsRover::turnLeft() {
	switch(_orientation) {
	case MR_NORTH:
		_orientation = MR_WEST;
		break;
	case MR_WEST:
		_orientation = MR_SOUTH;
		break;
	case MR_SOUTH:
		_orientation = MR_EAST;
		break;
	case MR_EAST:
		_orientation = MR_NORTH;
		break;
	default:
		break;
	}

}

void MarsRover::moveForward() {
	switch(_orientation) {
	case MR_NORTH:
		if(_position.y == _gridsize.y-1) // Apply grid limits
			_position.y = 0;
		else
			_position.y++;
		break;
	case MR_EAST:
		if(_position.x == _gridsize.x-1) // Apply grid limits
			_position.x = 0;
		else
			_position.x++;
		break;
	case MR_SOUTH:
		if( _position.y == 0) // Apply grid limits
			_position.y = _gridsize.y-1;
		else
			_position.y--;
		break;
	case MR_WEST:
		if( _position.x == 0) // Apply grid limits
			_position.x = _gridsize.x-1;
		else
			_position.x--;
		break;
	default:
		break;
	}
}

void MarsRover::moveBackwards() {
	switch(_orientation) {
	case MR_SOUTH:
		if(_position.y == _gridsize.y -1) // Apply grid limits
			_position.y = 0;
		else
			_position.y++;
		break;
	case MR_WEST:
		if(_position.x == _gridsize.x -1) // Apply grid limits
			_position.x = 0;
		else
			_position.x++;
		break;
	case MR_NORTH:
		if( _position.y == 0) // Apply grid limits
			_position.y = _gridsize.y-1;
		else
			_position.y--;
		break;
	case MR_EAST:
		if( _position.x == 0) // Apply grid limits
			_position.x = _gridsize.x-1;
		else
			_position.x--;
		break;
	default:
		break;
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

	if(command.size() == 0)
		return "";

	for (unsigned int i = 0; i<command.size(); i++) {
		char c = command.at(i);
		switch(c){
		case 'f':
			moveForward();
			break;
		case 'b':
			moveBackwards();
			break;
		case 'r':
			turnRight();
			break;
		case 'l':
			turnLeft();
			break;
		default:
			// Not a valid command
			break;
		}
	}

	return format_command(_position, _orientation);
}
