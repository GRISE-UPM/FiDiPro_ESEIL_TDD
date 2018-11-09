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

typedef enum orientation {
	MR_NORTH,
	MR_SOUTH,
	MR_WEST,
	MR_EAST
}orientation_t;

typedef struct position {
public:
	position () : x(0), y(0) {}
	position (int ix, int iy) { x = ix; y = iy;}
	int x;
	int y;
}position_t;

class MarsRover {
public:
	MarsRover(int x, int y, string obstacles);
	virtual ~MarsRover();
	string executeCommand(string command);

protected:
	void moveForward();
	void moveBackwards();
	void turnRight();
	void turnLeft();

	void readObstacle(string obstacle);
	void readObstacles(string obstacles);

	unsigned int obstaclesSize();

	vector<position_t> _obstacles;
	orientation_t _orientation;
	position_t _position;
	position_t _gridsize;
};

#endif  /*MARSROVER_H*/

