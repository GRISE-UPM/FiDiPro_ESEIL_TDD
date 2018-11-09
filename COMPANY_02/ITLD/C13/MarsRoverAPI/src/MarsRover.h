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
	string move_forward();
	string move_backward();
	void turn_left();
	void turn_right();
	int xsize, ysize;
	int xpos, ypos;
	char facing;
	int *obs_map;
};

#endif  /*MARSROVER_H*/

