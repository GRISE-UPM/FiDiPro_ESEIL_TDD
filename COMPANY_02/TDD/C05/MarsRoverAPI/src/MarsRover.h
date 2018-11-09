/*
 * MarsRover.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef MARSROVER_H_
#define MARSROVER_H_

#include <string>
#include <utility>
#include <map>
#include <vector>

using namespace std;

class MarsRover {
public:
	enum class Heading {
		NORTH,
		EAST,
		SOUTH,
		WEST
	};


	MarsRover(int x, int y, string obstacles);
	virtual ~MarsRover();
	string executeCommand(string command);

	std::pair<int, int> getGridSize() const;
	std::pair<int, int> getRoverPos() const;
	Heading getRoverHeading() const;

	void placeObstacles(const std::string& obstacles);

	bool isObstacle(int x, int y) const;

private:
	int m_gridSizeX;
	int m_gridSizeY;

	Heading m_roverHeading;
	int m_roverX;
	int m_roverY;

	std::vector<bool> m_planet;

	//std::map<char, std::function<void()>> m_commands;

	void roverTurn(bool right);
	void roverMove(bool fwd);

};

#endif  /*MARSROVER_H*/

