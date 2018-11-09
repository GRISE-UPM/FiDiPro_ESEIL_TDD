/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>

MarsRover::MarsRover(int x, int y, string obstacles) {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */

	table_x = x;
	table_y = y;



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
	pos_x = 0;
	pos_y = 0;
	direction = 0; // 0=N, 1=S, 2=E, 3=W

	string result = "";
	char direction_result;

	const int north = 0;
	const int south = 1;
	const int east = 2;
	const int west = 3;

	if (command.size() > 0){
		for (int i=0; i<command.size(); i++){
			switch (command.at(i)){
			case 'f':
				if (direction == north){
					if (pos_y < table_y)
						pos_y += 1;
					else
						pos_y = 0;
				}
				if (direction == south){
					if (pos_y > 0)
						pos_y -= 1;
					else
						pos_y = table_y;
				}
				if (direction == east){		pos_x += 1;		}
				if (direction == west){		pos_x -= 1;		}
				break;
			case 'b':
				if (direction == north){	pos_y -= 1;		}
				if (direction == south){	pos_y += 1;		}
				if (direction == east){		pos_x -= 1;		}
				if (direction == west){		pos_x += 1;		}
				break;
			case 'r':
				switch (direction){
				case north:
					direction = east;
					break;
				case east:
					direction = south;
					break;
				case south:
					direction = west;
					break;
				case west:
					direction = north;
					break;
				}
				break;

			case 'l':
					switch (direction){
					case north:
						direction = west;
						break;
					case east:
						direction = north;
						break;
					case south:
						direction = west;
						break;
					case west:
						direction = north;
						break;
					}
					break;
			}
		}
	}


	switch (direction)
	{
	case 0:
		direction_result = 'N';
		break;
	case 1:
		direction_result = 'S';
		break;
	case 2:
		direction_result = 'E';
		break;
	case 3:
		direction_result = 'W';
		break;
	default:
		direction_result = 'N';
	}

	if (command.size() > 0){
		char buffer[20];
		sprintf(buffer, "(%u,%u,%u)", pos_x, pos_y, direction);
		return buffer;
		//return direction as integer...
	}
	else
		return "";

/*
	if (command == "f")
		return "0,1";
	else{
		return result;
	}*/

}
