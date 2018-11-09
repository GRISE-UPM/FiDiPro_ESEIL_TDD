/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>
#include <iostream>
using namespace std;

MarsRover::MarsRover(int x, int y, string obstacles) {

	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */
	int **p_p_grid;
	p_p_grid = new int*[x];

	for (int i=0; i < x; i++){
		p_p_grid[i] = new int[x];
	}

	for (int i=0; i < x; i++){
		for (int j=0; j< x; j++){
			p_p_grid[i][j]=0;
		}
	}

	// some implementation

	for (int i=0; i< x; i++){
		delete[] p_p_grid[i];
	}

	delete[] p_p_grid;
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
	string str = command;
	return str;

	if (command == 'r'){
		return p_p_grid[x][j+1];
	}

	if (command == 'l'){
		return p_p_grid[x][j-1];
	}

	if (command == 'b'){
			return p_p_grid[x-1][j];
		}

	if (command == 'f'){
			return p_p_grid[x+1][j];
		}

}
