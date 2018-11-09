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
	int m_planetWidth;
	int m_planetDepth;
	int m_rover_pos_x;
	int m_rover_pos_y;
	string m_rover_dir;
public:
	MarsRover(int x, int y, string obstacles);
	virtual ~MarsRover();
	string executeCommand(string command);
	void newPlanet(int width, int depth);
	int planetWidth();
	int planetDepth();
};

#endif  /*MARSROVER_H*/

