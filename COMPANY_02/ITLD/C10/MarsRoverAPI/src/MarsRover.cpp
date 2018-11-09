/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>
#include <string.h>
#include <stdio.h>

using namespace std;

MarsRover::MarsRover(int x, int y, string obstacles) {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */
	m_xCoordinates = x;
	m_yCoordinates = y;
	m_obstacles = obstacles;
	setCurrentPosition(0,0,"N");
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
	for(string::iterator it = command.begin(); it != command.end(); ++it) {
		if (*it == 'f') {
			if (m_facing == "N") {
				if (m_posY == m_yCoordinates) {
					setCurrentPosition(m_posX,0,m_facing);
				}
				else {
					setCurrentPosition(m_posX, m_posY + 1, m_facing);
				}
			}
			if (m_facing == "E") {
				if (m_posX == m_xCoordinates) {
					setCurrentPosition(0, m_posY, m_facing);
				}
				else {
					setCurrentPosition(m_posX + 1, m_posY, m_facing);
				}
			}
			if (m_facing == "W") {
				if (m_posX == 0) {
					setCurrentPosition(m_xCoordinates, m_posY, m_facing);
				}
				else {
					setCurrentPosition(m_posX - 1, m_posY, m_facing);
				}
			}
			if (m_facing == "S") {
				if (m_posY == 0) {
					setCurrentPosition(m_yCoordinates, m_posY, m_facing);
				}
				else {
					setCurrentPosition(m_posY - 1, m_posY, m_facing);
				}
			}
		} else if (*it == 'b'){
			if (m_facing == "N") {
				if (m_posY == 0) {
					setCurrentPosition(m_posX, m_yCoordinates, m_facing);
				}
				else {
					setCurrentPosition(m_posX, m_posY - 1, m_facing);
				}
			}
			if (m_facing == "W") {
				if (m_posX == m_xCoordinates) {
					setCurrentPosition(0, m_posY, m_facing);
				}
				else {
					setCurrentPosition(m_posX + 1, m_posY, m_facing);
				}
			}
			if (m_facing == "E") {
				if (m_posX == 0) {
					setCurrentPosition(m_xCoordinates, m_posY, m_facing);
				}
				else {
					setCurrentPosition(m_posX - 1, m_posY, m_facing);
				}
			}
			if (m_facing == "S") {
				if (m_posY == m_yCoordinates) {
					setCurrentPosition(m_yCoordinates, 0, m_facing);
				}
				else {
					setCurrentPosition(m_posX, m_posY + 1, m_facing);
				}
			}
		}
		else if (*it == 'r') {
			if (m_facing == "N") {
				setCurrentPosition(m_posX, m_posY, "E");
			} else if (m_facing == "E") {
				setCurrentPosition(m_posX, m_posY, "S");
			} else if (m_facing == "S") {
				setCurrentPosition(m_posX, m_posY, "W");
			} else if (m_facing == "W") {
				setCurrentPosition(m_posX, m_posY, "N");
			}
		} else if (*it == 'l') {
			if (m_facing == "N") {
				setCurrentPosition(m_posX, m_posY, "W");
			} else if (m_facing == "E") {
				setCurrentPosition(m_posX, m_posY, "N");
			} else if (m_facing == "S") {
				setCurrentPosition(m_posX, m_posY, "E");
			} else if (m_facing == "W") {
				setCurrentPosition(m_posX, m_posY, "S");
			}
		}

	}

	string str = getCurrentPostion();
	return str;
}

string MarsRover::getCurrentPostion() {
	return m_currentPostion;
}

void MarsRover::setCurrentPosition(int x, int y, string facing) {
	m_posX = x;
	m_posY = y;
	m_facing = facing;

	//TODO: I would probably check here if the current position set matches with any of the forbidden points on the grid
	//and would not move there and keep the current position as it is

	char str[50];
	int len = 0;
	len = sprintf(str, "%d,", x);
	sprintf(str+len, "%d,", y);
	string s = string("(");
	s.append(string(str));
	s.append(facing);
	s.append(")");
	m_currentPostion = s;
}
