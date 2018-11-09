/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>
#include <stdlib.h>
#include <iostream>

string int2str(int a) {
	switch (a) {
	    case 0:
	      return "0";
	    case 1:
	    	      return "1";
	    case 2:
	    	      return "2";
	    case 3:
	    	      return "3";
	    case 4:
	    	      return "4";
	    case 5:
	    	      return "5";
	    case 6:
	    	      return "6";
	    case 7:
	    	      return "7";
	    case 8:
	    	      return "8";
	}
    return "";
}

MarsRover::MarsRover(int x, int y, string obstacles) {
	m_planetWidth = x;
	m_planetDepth = y;
	m_rover_pos_x = 0;
	m_rover_pos_y = 0;
	m_rover_dir = "N";
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

string MarsRover::executeCommand(string commands) {

	/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
	 * Example:
	 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.

	 * The return string is in the format: (x,y,facing)(o1_x,o1_y)(o2_x,o2_y)..(on_x,on_y)
	 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
	 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
	 */
    std::cout << commands << endl;
	for (unsigned int i = 0; i < commands.length(); i++)
	{
		char command = commands.at(i);

	if (command == 'l')
	{
		if (m_rover_dir == "N") {
			m_rover_dir = "W";
		}
		else if (m_rover_dir == "W") {
			m_rover_dir = "S";
		}
		else if (m_rover_dir == "S") {
			m_rover_dir = "E";
		}
		else if (m_rover_dir == "E") {
			m_rover_dir = "N";
		}
	}
	else if (command == 'r')
	{
		if (m_rover_dir == "N") {
			m_rover_dir = "E";
		}
		else if (m_rover_dir == "E") {
			m_rover_dir = "S";
		}
		else if (m_rover_dir == "S") {
			m_rover_dir = "W";
		}
		else if (m_rover_dir == "W") {
			m_rover_dir = "N";
		}
	}
	else if (command == 'f') {
		if (m_rover_dir == "N") {
			m_rover_pos_y++;
		} else if (m_rover_dir == "E") {
			m_rover_pos_x++;
		} else if (m_rover_dir == "S") {
			m_rover_pos_y--;
		} else if (m_rover_dir == "W") {
			m_rover_pos_x--;
		}
    }
	else if (command == 'b') {
		if (m_rover_dir == "N") {
			m_rover_pos_y--;
		} else if (m_rover_dir == "E") {
			m_rover_pos_x--;
		} else if (m_rover_dir == "S") {
			m_rover_pos_y++;
		} else if (m_rover_dir == "W") {
			m_rover_pos_x++;
		}
	}
	}
	string str = "(" + int2str(m_rover_pos_x) + "," + int2str(m_rover_pos_y) + "," + m_rover_dir + ")";

	return str;
}

int MarsRover::planetWidth()
{
	return m_planetWidth;
}

int MarsRover::planetDepth()
{
	return m_planetDepth;
}
