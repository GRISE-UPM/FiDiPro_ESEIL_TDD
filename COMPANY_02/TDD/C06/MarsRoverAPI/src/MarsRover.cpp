/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>
#include <sstream>

MarsRover::MarsRover(int x, int y, string obstacles) :
     m_x(x),
     m_y(y),
     m_facing("N")
{
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */
}

MarsRover::~MarsRover() {
	// TODO Auto-generated destructor stub
}

string MarsRover::executeCommand(string command) {

	/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
	 * Example:
	 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.

	 * The return string is in the format: (x,y,facing)(o1_x,o1_y)(o2_x,o2_y)..(on_x,on_y)
	 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
	 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
	 */


	//string facing = "N";

	if (command == "b") {
    	if (m_facing == "N") {
    		m_y--;
    	}
    }
	if (command == "f") {
    	if (m_facing == "N") {
    		m_y++;
    		if (m_y == 3) {
    			m_y = 0;
    		}
    	}
    }

	if (command == "r") {
    	if (m_facing == "N") {
    		m_facing = "E";
    	}
    }

	if (command == "l") {
    	if (m_facing == "N") {
    		m_facing = "W";
    	}
    }

	stringstream ssx;
	ssx << m_x;
	string sx = ssx.str();
	stringstream ssy;
	ssy << m_y;
	string sy = ssy.str();

	string str = "(" + sx + "," + sy + "," + m_facing + ")";

	return str;
}
