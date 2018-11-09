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
private:
	int _width;
	int _height;
public:
	MarsRover(int x, int y, string obstacles);
	virtual ~MarsRover();
	string executeCommand(string command);
};

#endif  /*MARSROVER_H*/

