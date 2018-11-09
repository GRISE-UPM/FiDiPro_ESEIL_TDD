/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>
#include <sstream>
#include <iostream>
#include <string.h>

MarsRover::MarsRover(int x, int y, string obstacles) {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */
	int obs_x, obs_y;
	enum { PARSE_SKIP, PARSE_X, PARSE_Y } parser_state = PARSE_SKIP;

	xpos = 0;
	ypos = 0;
	xsize = x;
	ysize = y;
	facing = 'N';
	obs_map = new int[x * y];
	memset(obs_map, 0, x * y * sizeof(*obs_map));
	for (string::iterator it = obstacles.begin(); it != obstacles.end(); it++) {
		switch (*it) {
		case '(':
			parser_state = PARSE_X;
			break;
		case ')':
			parser_state = PARSE_SKIP;
			break;
		case ',':
			parser_state = PARSE_Y;
			break;
		default:
			stringstream ss(&(*it));
			if (parser_state == PARSE_X) {
				ss >> obs_x;
				parser_state = PARSE_SKIP;
			}
			if (parser_state == PARSE_Y) {
				ss >> obs_y;
				obs_map[obs_y * xsize + obs_x] = 1;
				parser_state = PARSE_SKIP;
			}
			break;
		}
	}
}

MarsRover::~MarsRover() {
	delete obs_map;
	// TODO Auto-generated destructor stub
}

string MarsRover::move_forward() {
	int dest_x = xpos, dest_y = ypos;
	stringstream reply;

	switch (facing) {
	case 'N':
		dest_y++;
		if (dest_y == ysize)
			dest_y = 0;
		break;
	case 'E':
		dest_x++;
		if (dest_x == xsize)
			dest_x = 0;
		break;
	case 'S':
		if (dest_y == 0)
			dest_y = ysize;
		dest_y--;
		break;
	case 'W':
		if (dest_x == 0)
			dest_x = xsize;
		dest_x--;
		break;
	}

	if (obs_map[xsize * dest_y + dest_x]) {
		reply << "(" << dest_x << "," << dest_y << ")";
	} else {
		xpos = dest_x;
		ypos = dest_y;
	}
	return reply.str();
}

string MarsRover::move_backward() {
	int dest_x = xpos, dest_y = ypos;
	stringstream reply;

	switch (facing) {
	case 'N':
		if (dest_y == 0)
			dest_y = ysize;
		dest_y--;
		break;
	case 'E':
		if (dest_x == 0)
			dest_x = xsize;
		dest_x--;
		break;
	case 'S':
		dest_y++;
		if (dest_y == ysize)
			dest_y = 0;
		break;
	case 'W':
		dest_x++;
		if (dest_x == xsize)
			dest_x = 0;
		break;
	}

	if (obs_map[xsize * dest_y + dest_x]) {
		reply << "(" << dest_x << "," << dest_y << ")";
	} else {
		xpos = dest_x;
		ypos = dest_y;
	}
	return reply.str();
}

void MarsRover::turn_left() {
	switch (facing) {
	case 'N':
		facing = 'W';
		break;
	case 'E':
		facing = 'N';
		break;
	case 'S':
		facing = 'E';
		break;
	case 'W':
		facing = 'S';
		break;
	}
}

void MarsRover::turn_right() {
	switch (facing) {
	case 'N':
		facing = 'E';
		break;
	case 'E':
		facing = 'S';
		break;
	case 'S':
		facing = 'W';
		break;
	case 'W':
		facing = 'N';
		break;
	}
}

string MarsRover::executeCommand(string command) {
	bool empty_cmd = true;
	stringstream obsstr;

	/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
	 * Example:
	 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.

	 * The return string is in the format: (x,y,facing)(o1_x,o1_y)(o2_x,o2_y)..(on_x,on_y)
	 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
	 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
	 */
	for (string::iterator it = command.begin(); it != command.end(); it++) {
		empty_cmd = false;
		switch (*it) {
			case 'f':
				obsstr << move_forward();
				break;
			case 'b':
				obsstr << move_backward();
				break;
			case 'l':
				turn_left();
				break;
			case 'r':
				turn_right();
				break;
		}
	}

	if (empty_cmd)
		return "";

	string str("");
	ostringstream ostr;
	ostr << "(" << xpos << "," << ypos << "," << facing << ")" << obsstr.str();
	str = ostr.str();
	return str;
}
