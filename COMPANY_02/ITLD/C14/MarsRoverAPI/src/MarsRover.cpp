/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>
#include <iostream>
#include <sstream>
#include <cstdio>

MarsRover::MarsRover(int x, int y, string obstacles) {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */
	heigth = y;
	width = x;
	posX = 0;
	posY = 0;
	facingTo = 'N';

	std::pair<char, char> NL = std::make_pair('N', 'l');
	std::pair<char, char> NR = std::make_pair('N', 'r');

	std::pair<char, char> WL = std::make_pair('W', 'l');
	std::pair<char, char> WR = std::make_pair('W', 'r');

	std::pair<char, char> EL = std::make_pair('E', 'l');
	std::pair<char, char> ER = std::make_pair('E', 'r');

	std::pair<char, char> SL = std::make_pair('S', 'l');
	std::pair<char, char> SR = std::make_pair('S', 'r');

	headings[NL] = 'W';
	headings[NR] = 'E';
	headings[WR] = 'N';
	headings[WL] = 'S';
	headings[EL] = 'N';
	headings[ER] = 'S';
	headings[SL] = 'E';
	headings[SR] = 'W';

	std::string obstaclesLeft = obstacles;

	while(obstaclesLeft.find("(") != std::string::npos) {
		std::string obstacleString = obstaclesLeft.substr(obstaclesLeft.find("(")+1, obstaclesLeft.find(")")-1);
		std::cout << obstacleString << std::endl;

		std::size_t nextComma = obstacleString.find(",");
		std::string obsXs = obstacleString.substr(0, nextComma);
		std::string obsYs = obstacleString.substr(nextComma+1);
		int obsX, obsY;
		sscanf(obsXs.c_str(), "%d", &obsX);
		sscanf(obsYs.c_str(), "%d", &obsY);

		std::pair<int, int> obs = std::make_pair(obsX, obsY);
		obstaclesVector.push_back(obs);
		obstacleFound.push_back(false);
		obstaclesLeft = obstaclesLeft.substr(obstaclesLeft.find(")")+1);
	}
}

MarsRover::~MarsRover() {
	// TODO Auto-generated destructor stub
}

void MarsRover::turn(char c) {
	facingTo = headings[std::make_pair(facingTo, c)];
}

void MarsRover::move(char c) {
	int* var;

	int curX = posX;
	int curY = posY;

	if(facingTo == 'N' || facingTo == 'S') {
		var = &posY;
	} else {
		var = &posX;
	}

	if(c == 'f') {
		if(facingTo == 'N' || facingTo == 'E') {
			(*var)++;
		} else {
			(*var)--;
		}
	} else {
		if(facingTo == 'N' || facingTo == 'E') {
			(*var)--;
		} else {
			(*var)++;
		}
	}

	for(size_t i = 0; i  < obstaclesVector.size(); i++) {
		std::pair<int, int> p = obstaclesVector.at(i);
		if(p.first == posX && p.second == posY) {
			if(obstacleFound[i] == false) {
				obstacleFound[i] = true;
				std::stringstream ss;
				ss << "(" << p.first << "," << p.second << ")";
				obstacleCollisions.push_back(ss.str());
			}
			posX = curX;
			posY = curY;
		}
	}


	if(posY == heigth) {
		posY = 0;
	} else if(posY < 0) {
		posY = heigth-1;
	}

	if(posX == width) {
		posX = 0;
	} else if(posX < 0) {
		posX = width - 1;
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
	for(size_t i = 0; i < command.length(); i++) {
		char c = command.at(i);

		if(c == 'f' || c == 'b') {
			move(c);
		} else {
			turn(c);
		}
	}

	std::stringstream ss;

	ss << "(" << posX << "," << posY << "," << facingTo << ")";
	for(std::list<std::string>::iterator it = obstacleCollisions.begin(); it != obstacleCollisions.end(); it++) {
		ss << *it;
	}

	string str = ss.str();
	return str;
}
