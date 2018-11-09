/*
 * Coordinate.h
 *
 *  Created on: 15 Apr 2015
 *      Author: user
 */

#ifndef COORDINATE_H_
#define COORDINATE_H_

class Coordinate {

public:
	Coordinate(int x, int y, bool obstacle): x(x), y(y), obstacle(obstacle){}
	int getX();
	int getY();
	int setX();
	int setY();
	bool hasObstacle();
	void setObstacle();

private:
	int x;
	int y;
	bool obstacle;
};




#endif /* COORDINATE_H_ */
