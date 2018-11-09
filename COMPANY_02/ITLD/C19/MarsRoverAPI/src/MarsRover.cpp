/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>
#include <cstdio>

MarsRover::MarsRover(int x, int y, string obstacles): xGeo(x), yGeo(y), xCord(0), yCord(0), dir("N") {
	obstacleParser(obstacles);
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

	if (command.empty()) { // Case 2: Landing
		char buffer [10];
		sprintf (buffer, "(%u,%u,%s)", xCord,yCord,dir.c_str() );
		return buffer;
	}

	string str = "";
    // Status: going to case 7...
	// Planning...

	for (unsigned i=0; i<command.length(); ++i)  // Case 5: Combo
	{
		switch (command.at(i)) {
	    case 'r': // Case 3: Turning Right
	    	if (dir == "N") dir = "E"; else
	    	if (dir == "E") dir = "S"; else
	    	if (dir == "S") dir = "W"; else
	    	if (dir == "W") dir = "N";
	    	break;
	    case 'l': // Case 3: Turning Left
	    	if (dir == "N") dir = "W"; else
	    	if (dir == "W") dir = "S"; else
	    	if (dir == "S") dir = "E"; else
	    	if (dir == "E") dir = "N";
	    	break;
	    case 'f': // Case 4: Moving Fwd
	    	if (dir == "N") ++yCord; else
	    	if (dir == "W") --xCord; else
	    	if (dir == "S") --yCord; else
	    	if (dir == "E") ++xCord;
	    	doWrapping();
	    	break;
	    case 'b': // Case 4: Moving Bwd
	    	if (dir == "N") --yCord; else
	    	if (dir == "W") ++xCord; else
	    	if (dir == "S") ++yCord; else
	    	if (dir == "E") --xCord;
	    	doWrapping();
	    	break;
		}
	}

	char buffer [10];
	sprintf (buffer, "(%u,%u,%s)", xCord,yCord,dir.c_str() );
	return buffer;
}

void MarsRover::doWrapping(void) { // Case 6: Wrapping
	if (xCord > xGeo-1) xCord = 0; else
	if (xCord < 0) xCord = xGeo-1; else
	if (yCord > yGeo-1) yCord = 0; else
	if (yCord < 0) yCord = yGeo-1;
}

void MarsRover::obstacleParser(string obstacles) { // Case 7: Placing obstacles
	std::string delimiter = "(";
	size_t pos = 0;
	string token;

	while ((pos = obstacles.find(delimiter)) != std::string::npos) {
		token = obstacles.substr(0, pos-1);
		// token: "x,y" "x,y"
printf("***%s***\n",token.c_str() );
// continue from here...
		obstacles.erase(0, pos + delimiter.length());
		}
}

