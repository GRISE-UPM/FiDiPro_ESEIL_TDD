/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>
#include <sstream>



using namespace std;
string itos(int i) // convert int to string
{
    stringstream s;
    s << i;
    return s.str();
}

string dir2string(int i) // convert int to string
{
    switch (i){
    case 0:
    	return "N";
    case 1:
    	return "E";
    case 2:
    	return "S";
    case 3:
    	return "W";
    default:
    	return "N";
    }
}

MarsRover::MarsRover(int x, int y, string obstacles) {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */

	my_planet.x_size = x;
	my_planet.y_size = y;

	roverPos.x_pos = 0;
	roverPos.y_pos = 0;

	facing = north;

}

MarsRover::~MarsRover() {
	// TODO Auto-generated destructor stub
}

void MarsRover::moveTo(char direction) {
	/*moving forward*/
	if (facing == north){
		if(direction == 'f')
			roverPos.y_pos++;
		else
			roverPos.y_pos--;
	}
	else if (facing == east){
		if(direction == 'f')
			roverPos.x_pos++;
		else
			roverPos.x_pos--;
	}
	else if(facing == south){
		if(direction == 'f')
			roverPos.y_pos--;
		else
			roverPos.y_pos++;
	}
	else if (facing == west){
		if(direction == 'f')
			roverPos.x_pos--;
		else
			roverPos.x_pos++;
	}
	else
		return;

/*check that we have not reached the grid limit*/
	if(roverPos.x_pos < 0)
		roverPos.x_pos = my_planet.x_size - 1;
	if(roverPos.y_pos < 0)
		roverPos.y_pos = my_planet.y_size - 1;
	if(roverPos.x_pos == my_planet.x_size)
		roverPos.x_pos = 0;
	if(roverPos.y_pos == my_planet.y_size)
			roverPos.y_pos = 0;

}

string MarsRover::executeCommand(string command) {

	/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
	 * Example:
	 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.

	 * The return string is in the format: (x,y,facing)(o1_x,o1_y)(o2_x,o2_y)..(on_x,on_y)
	 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
	 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
	 */
	//string str = "";
	//return str;
	std::string ret("");
	char command_char;
//mystring[mystring.length()-1] .at( myString.length() - 1 );
	/*empty command should return only rover position*/
	while (command.length() > 0) {
			command_char = command.at(command.length() - 1);
			/*turn left*/
			if (command_char == 'l') {
				if (facing == north)
					facing = west;
				else
					facing -= 1;
				/*turn right*/
			} else if (command_char == 'r') {
				if (facing == west)
					facing = north;
				else
					facing += 1;
			}
			/*move forward*/
			else if (command_char  == 'f') {
				moveTo(command_char );
			}
			/*move backward*/
			else if (command_char  == 'b') {
				moveTo(command_char );
			}
			/*remove last char = command*/
			command.erase(command.size() - 1);
		}

	/*first rover current position and facing*/
	ret += "(";
	ret += itos(roverPos.x_pos);
	ret += ",";
	ret += itos(roverPos.y_pos);
	ret += ",";
	ret += dir2string(facing);
	ret += ")";

	return ret;
}
