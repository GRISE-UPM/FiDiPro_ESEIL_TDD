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
#include <list>
#include <utility>

using namespace std;

enum RoverDirection {
    BACKWARDS = -1,
    FORWARD = 1
};

enum GridStatus {
    CELL_FREE = 0,
    CELL_NON_FOUND_OBSTACLE,
    CELL_FOUND_OBSTACLE
};

class MarsRover {
public:
	MarsRover(int x, int y, string obstacles);
	virtual ~MarsRover();
	string executeCommand(string command);

private:
#ifdef UNIT_TEST
public:
#endif
	std::string buildPosition();
	void turnLeft();
	void turnRight();
	void move(RoverDirection where);

	uint32_t planet_x;
	uint32_t planet_y;
	uint32_t pos_x;
	uint32_t pos_y;
	uint32_t current_direction;

	std::vector<std::vector<GridStatus> > grid;
	std::list<std::pair<uint32_t, uint32_t> > found_obstacles;

	static const char *directions;
};

#endif  /*MARSROVER_H*/

