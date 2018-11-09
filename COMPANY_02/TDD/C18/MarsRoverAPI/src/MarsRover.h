/*
 * MarsRover.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef MARSROVER_H_
#define MARSROVER_H_

#include <string>
#include <sstream>
#include <iostream>
#include <stdio.h>



using namespace std;

class MarsRover {
public:
	MarsRover(int x, int y, string obstacles);
	virtual ~MarsRover();
	string executeCommand(string command);
	int pos_x, pos_y, direction, table_x, table_y;
	char directionResult;


};

#endif  /*MARSROVER_H*/

