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

class MarsRover {
public:
	MarsRover(int x, int y, string obstacles){
		vector <int> height(y,0);
		planet(height,allocator);
	}
	virtual ~MarsRover();
	string executeCommand(string command);
	vector< vector<int> > planet;
	vector< vector<int> > getPlanet(){ return planet;};
};

#endif  /*MARSROVER_H*/

