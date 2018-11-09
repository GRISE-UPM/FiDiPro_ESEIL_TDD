/*
 * MarsRover.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef MARSROVER_H_
#define MARSROVER_H_

#include <string>
#include <boost/lexical_cast.hpp>

using namespace std;

enum RoverDirection {
    NORTH = 0,
    EAST,
    SOUTH,
    WEST
};

enum {
    X_COORD = 0,
    Y_COORD = 1
};

class MarsRover {
public:
    MarsRover(int x, int y, string obstacles);
    virtual ~MarsRover();
    string executeCommand(string command);
private:
    string getDirectionAsString(RoverDirection);
    RoverDirection changeDirectionRight(RoverDirection currentDirection);
    RoverDirection changeDirectionLeft(RoverDirection currentDirection);

};

#endif  /*MARSROVER_H*/

