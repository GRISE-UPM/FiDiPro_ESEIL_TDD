/*
 * MarsRover.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef MARSROVER_H_
#define MARSROVER_H_

#include <string>
#include <map>

using namespace std;

class MarsRover {
public:
    MarsRover(int x, int y, string obstacles);
    virtual ~MarsRover();
    string executeCommand(string command);
    // I know that this is not the correct way to test, but I am not familiar with c++ and the way which
    // was explained in the seminar is too complex for now.
    string getPlanetSize();
    string getPosition();

private:
    std::map<int,string> orientations;
    int m_planet[2];
    int m_rover_position[2];
    int m_rover_orientation;

    void turn(int direction); // 0: left, 1: right.
    void move(string direction);
};



#endif  /*MARSROVER_H*/

