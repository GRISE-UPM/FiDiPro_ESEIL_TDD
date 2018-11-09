/*
 * MarsRover.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef MARSROVER_H_
#define MARSROVER_H_

#include <string>
#include <map>
#include <list>
#include <vector>

using namespace std;

class MarsRover {
	int posX, posY;
	int width, heigth;
	char facingTo;
	/* Map from <headingTo, turningTo> -> new heading */
	std::map<std::pair<char, char>, char> headings;
	std::list<std::string> obstacleCollisions;
	std::vector<std::pair<int, int> > obstaclesVector;
	std::vector<bool> obstacleFound;

	void move(char c);
	void turn(char c);

public:
	MarsRover(int x, int y, string obstacles);
	virtual ~MarsRover();
	string executeCommand(string command);

};

#endif  /*MARSROVER_H*/

