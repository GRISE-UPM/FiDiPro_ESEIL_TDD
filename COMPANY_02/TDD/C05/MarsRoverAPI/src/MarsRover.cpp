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

MarsRover::MarsRover(int x, int y, string obstacles):
		m_gridSizeX(x),
		m_gridSizeY(y),
		m_roverHeading(Heading::NORTH),
		m_roverX(0),
		m_roverY(0),
		m_planet(x * y, false) {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */
	/*
	m_commands.insert(std::make_pair('L', [this]() {
		this->roverTurn(false);
	}));

	m_commands.insert(std::make_pair('R', [this]() {
		this->roverTurn(true);
	}));*/
	this->placeObstacles(obstacles);
}

void MarsRover::placeObstacles(const std::string& obstacles) {
	if (obstacles.length() == 0) return;

	std::istringstream stream(obstacles);

	while (!stream.eof()) {
		char delim1 = 0, delim2 = 0, comma = 0;
		int x = 0, y = 0;
		stream.get(delim1);
		stream >> x;
		stream.get(comma);
		stream >> y;
		stream.get(delim2);

		/*
		if (delim1 != '(' || comma != ',' || delim2 != ')') {
			throw std::runtime_error("invalid obstacle string");
		}*/

		m_planet[y * m_gridSizeX + x] = true;
	}
}

MarsRover::~MarsRover() {
	// TODO Auto-generated destructor stub
}
void MarsRover::roverTurn(bool right) {
	switch (m_roverHeading) {
	case Heading::NORTH:
		m_roverHeading = (right)? Heading::EAST : Heading::WEST;
		break;
	case Heading::EAST:
		m_roverHeading = (right)? Heading::SOUTH : Heading::NORTH;
		break;
	case Heading::SOUTH:
		m_roverHeading = (right)? Heading::WEST : Heading::EAST;
		break;
	case Heading::WEST:
		m_roverHeading = (right)? Heading::NORTH : Heading::SOUTH;
		break;
	default:
		break;
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

	if (command.length() == 0) return "";

	std::vector<std::pair<int, int>> obstaclesSeen;

	for (const auto ch : command) {
		//m_commands.at(commandId)();

		std::pair<int, int> obstacleSeen;

		switch (ch) {
		case 'L':
			this->roverTurn(false);
			break;
		case 'R':
			this->roverTurn(true);
			break;
		case 'F':
			this->roverMove(true);
			break;
		case 'B':
			this->roverMove(false);
			break;
		default:
			break;
		}
	}

	std::string str("(");
	const auto pos = this->getRoverPos();
	str += std::to_string(pos.first);
	str += ",";
	str += std::to_string(pos.second);
	str += ",";

	switch (m_roverHeading) {
	case Heading::NORTH:
		str += "N"; break;
	case Heading::SOUTH:
		str += "S"; break;
	case Heading::WEST:
		str += "W"; break;
	case Heading::EAST:
		str += "E"; break;
	}
	str += ")";

	return str;
}

void MarsRover::roverMove(bool fwd) {
	switch (m_roverHeading) {
	case Heading::NORTH:
		if (fwd)
			++m_roverY;
		else
			--m_roverY;
		break;
	case Heading::EAST:
		if (fwd)
			++m_roverX;
		else
			--m_roverX;
		break;
	case Heading::SOUTH:
		if (fwd)
			--m_roverY;
		else
			++m_roverY;
		break;
	case Heading::WEST:
		if (fwd)
			--m_roverX;
		else
			++m_roverX;
		break;
	default:
		break;
	}

	if (m_roverX < 0) {
		m_roverX = m_gridSizeX - 1;
	} else if (m_roverX == m_gridSizeX) {
		m_roverX = 0;
	}

	if (m_roverY < 0) {
		m_roverY = m_gridSizeY - 1;
	} else if (m_roverY == m_gridSizeY) {
		m_roverY = 0;
	}
}

std::pair<int, int> MarsRover::getGridSize() const {
	return std::make_pair(m_gridSizeX, m_gridSizeY);
}

std::pair<int, int> MarsRover::getRoverPos() const {
	return std::make_pair(m_roverX, m_roverY);
}

MarsRover::Heading MarsRover::getRoverHeading() const {
	return m_roverHeading;
}

bool MarsRover::isObstacle(int x, int y) const {
	return m_planet[y * m_gridSizeX + x];
}
