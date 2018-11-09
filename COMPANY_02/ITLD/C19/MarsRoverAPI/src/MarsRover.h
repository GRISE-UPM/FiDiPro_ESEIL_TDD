/*
 * MarsRover.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef MARSROVER_H_
#define MARSROVER_H_

#include <string>

using namespace std;

class MarsRover {
public:
	MarsRover(int x, int y, string obstacles);
	virtual ~MarsRover();
	string executeCommand(string command);
private:
	int xGeo, yGeo;
	string obstacles;
	int xCord, yCord;
	string dir;

	void doWrapping(void);
	void obstacleParser(string obstacles);
};

#endif  /*MARSROVER_H*/

