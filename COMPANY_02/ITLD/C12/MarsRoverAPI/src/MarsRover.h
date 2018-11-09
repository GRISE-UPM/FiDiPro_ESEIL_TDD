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
	int lim_x, lim_y;
	int loc_x, loc_y;
	char heading;
	void turn_left();
	void turn_right();

	void forward();
	void reverse();

public:
	MarsRover(int x, int y, string obstacles);
	virtual ~MarsRover();
	string executeCommand(string command);

	// unit test helper
	void set_location(int x, int y, char head) {loc_x = x; loc_y = y; heading = head;};
	int get_limit_x() { return lim_x; };
	int get_limit_y() { return lim_y; };

};

#endif  /*MARSROVER_H*/

