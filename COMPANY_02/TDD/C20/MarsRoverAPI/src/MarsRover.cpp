/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include "iostream"

MarsRover::MarsRover(int x, int y, string obstacles) {
    /*    x and y represent the size of the grid.
     *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
     *
     Example use:
     MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
     */
    m_planet[0] = x;
    m_planet[1] = y;
    m_rover_position[0] = 0;
    m_rover_position[1] = 0;
    m_rover_orientation = 0;

    // Nasty nasty
    orientations[0] = "N";
    orientations[1] = "E";
    orientations[2] = "S";
    orientations[3] = "W";
}

MarsRover::~MarsRover() {
    // TODO Auto-generated destructor stub
}

string MarsRover::executeCommand(string passed_sequence) {

    /* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
     * Example:
     * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.

     * The return string is in the format: (x,y,facing)(o1_x,o1_y)(o2_x,o2_y)..(on_x,on_y)
     * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
     * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
     */
    string str = "";
    string command = "";

    if (passed_sequence == "")
    {
        str =  MarsRover::getPosition();
    }

    for (unsigned i = 0; i < passed_sequence.length(); ++i)
    {
        command = passed_sequence.at(i);

        if (command == "l")
        {
            MarsRover::turn(0);
        }
        else if (command == "r")
        {
            MarsRover::turn(1);
        }
        else if (command == "f")
        {
            MarsRover::move("f");
        }
        else if (command == "b")
        {
            MarsRover::move("b");
        }
    }

    return str;
}

string MarsRover::getPlanetSize()
{
    return std::to_string(this->m_planet[0]) + string("x") + std::to_string(this->m_planet[1]);
}

string MarsRover::getPosition()
{
    return std::to_string(this->m_rover_position[0]) + string(",") + std::to_string(this->m_rover_position[1]) + string(",") + orientations[m_rover_orientation];
}

void MarsRover::turn(int direction)
{
    if (direction == 1)
    {
        m_rover_orientation = (m_rover_orientation + 1) % 4;
    }
    else
    {
        if (m_rover_orientation == 0)
        {
            m_rover_orientation = 3;
        }
        else
        {
            m_rover_orientation -= m_rover_orientation;
        }
    }

}

void MarsRover::move(string direction)
{
    switch (m_rover_orientation)
    {
        case 0:
            if (direction == "f")
                m_rover_position[1] += 1;
            else
                m_rover_position[1] -= 1;
            break;
        case 1:
            if (direction == "f")
                m_rover_position[0] += 1;
            else
                m_rover_position[0] -= 1;
            break;
        case 2:
            if (direction == "f")
                m_rover_position[1] -= 1;
            else
                m_rover_position[1] += 1;
            break;
        case 3:
            if (direction == "f")
                m_rover_position[0] -= 1;
            else
                m_rover_position[0] += 1;
            break;
    }

    if (m_rover_position[0] >= m_planet[0])
        m_rover_position[0] = 0;
    else if (m_rover_position[0] < 0)
        m_rover_position[0] = m_planet[0] - 1;

    if (m_rover_position[1] >= m_planet[1])
        m_rover_position[1] = 0;
    else if (m_rover_position[1] < 0)
        m_rover_position[1] = m_planet[1] - 1;
}

