/*
 * MarsRover.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef MARSROVER_H_
#define MARSROVER_H_

#include <string>
#include <vector>

using namespace std;

enum direction{
	north = 0,
	east = 1,
	south = 2,
	west = 3
};

struct position
{
	int x_pos;
	int y_pos;
};

struct planet{
	int x_size;
	int y_size;
};

struct obstacle{
	position obstacle_pos;
	bool reported;
};

class MarsRover {
private:
	position roverPos;
	int facing;
	planet my_planet;
	std::vector<obstacle> obstacles;
	void moveTo(char);
public:
	MarsRover(int x, int y, string obstacles);
	virtual ~MarsRover();
	string executeCommand(string command);
};

#endif  /*MARSROVER_H*/

