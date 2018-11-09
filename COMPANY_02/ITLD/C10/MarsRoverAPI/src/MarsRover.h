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
	void setCurrentPosition(int x, int y, string facing);
	string getCurrentPostion(void);

private:
	string m_currentPostion;
	int m_xCoordinates;
	int m_yCoordinates;
	string m_obstacles;
	int m_posX;
	int m_posY;
	string m_facing;
};

#endif  /*MARSROVER_H*/

