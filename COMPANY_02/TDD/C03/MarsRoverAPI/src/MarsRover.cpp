/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>
#include <sstream>
#include <stdexcept>

const char *MarsRover::directions = "NWSE"; // Counter-Clockwise

MarsRover::MarsRover(int x, int y, string obstacles) :
    planet_x(x), planet_y(y), pos_x(0), pos_y(0), current_direction(0),
    grid(planet_x, std::vector<GridStatus>(planet_y, CELL_FREE)) {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */
    std::stringstream ss(obstacles);
    ss.peek(); // Sets EOF
    while (!ss.eof()) {
        if (ss.get() != '(') {
            throw std::invalid_argument("Invalid format for obstacles: Obstacle does not start with (");
        }
        if (ss.peek() < '0' || ss.peek() > '9') {
            throw std::invalid_argument("Invalid format for obstacles: No number");
        }
        uint32_t coord_x;
        ss >> coord_x;
        if (ss.get() != ',') {
            throw std::invalid_argument("Invalid format for obstacles: No comma separating coordinates");
        }
        if (ss.peek() < '0' || ss.peek() > '9') {
            throw std::invalid_argument("Invalid format for obstacles: No number");
        }
        uint32_t coord_y;
        ss >> coord_y;
        if (ss.get() != ')') {
            throw std::invalid_argument("Invalid format for obstacles: Obstacle does not close with )");
        }
        grid[coord_x][coord_y] = CELL_NON_FOUND_OBSTACLE; // Vector will throw out_of_range if wrong
        ss.peek(); // Sets EOF
    }
}

MarsRover::~MarsRover() {
	// TODO Auto-generated destructor stub
}

std::string MarsRover::buildPosition() {
    std::stringstream ss;
    ss << "(" << pos_x << "," << pos_y << "," << directions[current_direction] << ")";
    for (auto it = found_obstacles.begin(); it != found_obstacles.end(); ++it) {
        ss << "(" << it->first << "," << it->second  << ")";
        grid[it->first][it->second] = CELL_NON_FOUND_OBSTACLE; // Reset for next execution
    }
    return ss.str();
}

inline void MarsRover::turnLeft() {
    current_direction = (current_direction + 1) & 0x3;
}

inline void MarsRover::turnRight() {
    current_direction = (current_direction - 1) & 0x3;
}

inline void MarsRover::move(RoverDirection where) {
    if (current_direction == 1 || current_direction == 2) {
        // South or west
        where = static_cast<RoverDirection>(-where);
    }

    uint32_t *pos_ptr;
    uint32_t *planet_ptr;
    if (current_direction % 2 == 0) {
        pos_ptr = &pos_y;
        planet_ptr = &planet_y;
    } else {
        pos_ptr = &pos_x;
        planet_ptr = &planet_x;
    }

    if (where == BACKWARDS && *pos_ptr == 0 ) {
        *pos_ptr = *planet_ptr - 1;
    } else if (where == FORWARD && *pos_ptr == (*planet_ptr - 1)) {
        *pos_ptr = 0;
    } else {
        *pos_ptr += where;
    }
}

string MarsRover::executeCommand(string command) {

	/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
	 * Example:
	 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.

	 * The return string is in the format: (x,y,facing)(o1_x,o1_y)(o2_x,o2_y)..(on_x,on_y)
	 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
	 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
	 */
    for (uint32_t i = 0; i < command.size(); ++i) {
        //Not a huge fan of this design...
        if (command[i] == 'l') {
            turnLeft();
        }
        if (command[i] == 'r') {
            turnRight();
        }
        if (command[i] == 'f') {
            move(FORWARD);
            if (grid[pos_x][pos_y] == CELL_NON_FOUND_OBSTACLE) {
                found_obstacles.push_back(make_pair(pos_x, pos_y));
                grid[pos_x][pos_y] = CELL_FOUND_OBSTACLE;
                move(BACKWARDS); // Undo!
            } else if (grid[pos_x][pos_y] == CELL_FOUND_OBSTACLE) {
                move(BACKWARDS); // Undo!
            }
        }
        if (command[i] == 'b') {
            move(BACKWARDS);
            if (grid[pos_x][pos_y] == CELL_NON_FOUND_OBSTACLE) {
                found_obstacles.push_back(make_pair(pos_x, pos_y));
                grid[pos_x][pos_y] = CELL_FOUND_OBSTACLE;
                move(FORWARD); // Undo!
            } else if (grid[pos_x][pos_y] == CELL_FOUND_OBSTACLE) {
                move(FORWARD); // Undo!
            }
        }
    }
	string str = buildPosition();
	found_obstacles.clear();
	return str;
}
