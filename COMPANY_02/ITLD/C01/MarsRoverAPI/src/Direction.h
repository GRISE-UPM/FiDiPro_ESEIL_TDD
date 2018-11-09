/*
 * Direction.h
 *
 *  Created on: 15 Apr 2015
 *      Author: user
 */

#ifndef DIRECTION_H_
#define DIRECTION_H_

class Direction {

private:
	enum directionEnum { N = 0, E = 1, S = 2, W = 3 } roverIsFacing;

public:
	void rotateClockwise();
	void rotateCouterClockwise();
	int roverFacing();
};

#endif /* DIRECTION_H_ */
