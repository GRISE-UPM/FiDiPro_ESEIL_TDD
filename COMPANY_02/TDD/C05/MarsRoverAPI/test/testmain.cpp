#define BOOST_TEST_MODULE MR_tests
#include <boost/test/included/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("", rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE(planet_grid_test) {
	MarsRover rover(100, 100, "");
	const auto gridSize = rover.getGridSize();

	BOOST_CHECK_EQUAL(gridSize.first, 100);
	BOOST_CHECK_EQUAL(gridSize.second, 100);
}

BOOST_AUTO_TEST_CASE(rover_landing_test) {
	MarsRover rover(100, 100, "");

	const auto pos = rover.getRoverPos();
	BOOST_CHECK_EQUAL(pos.first, 0);
	BOOST_CHECK_EQUAL(pos.second, 0);

	const auto heading = rover.getRoverHeading();
	BOOST_CHECK(heading == MarsRover::Heading::NORTH);
}

BOOST_AUTO_TEST_CASE(rover_turning_test) {
	MarsRover rover(100, 100, "");


	rover.executeCommand("L");
	BOOST_CHECK(rover.getRoverHeading() == MarsRover::Heading::WEST);

	rover.executeCommand("L");
	BOOST_CHECK(rover.getRoverHeading() == MarsRover::Heading::SOUTH);

	rover.executeCommand("L");
	BOOST_CHECK(rover.getRoverHeading() == MarsRover::Heading::EAST);

	rover.executeCommand("R");
	BOOST_CHECK(rover.getRoverHeading() == MarsRover::Heading::SOUTH);
}

BOOST_AUTO_TEST_CASE(rover_moving_test) {
	MarsRover rover(100, 100, "");

	rover.executeCommand("F");
	BOOST_CHECK_EQUAL(rover.getRoverPos().second, 1);

	rover.executeCommand("F");
	rover.executeCommand("F");
	BOOST_CHECK_EQUAL(rover.getRoverPos().second, 3);

	rover.executeCommand("R");
	rover.executeCommand("F");
	auto pos = rover.getRoverPos();
	BOOST_CHECK(pos.first == 1 && pos.second == 3);

	rover.executeCommand("L");
	pos = rover.getRoverPos();
	BOOST_CHECK(pos.first == 1 && pos.second == 3);

	rover.executeCommand("F");
	pos = rover.getRoverPos();
	BOOST_CHECK(pos.first == 1 && pos.second == 4);

}

BOOST_AUTO_TEST_CASE(rover_combined_commands) {
	MarsRover rover(100, 100, "");

	rover.executeCommand("FFFRFLF");

	const auto pos = rover.getRoverPos();
	BOOST_CHECK(pos.first == 1 && pos.second == 4);

}

BOOST_AUTO_TEST_CASE(rover_wrapping_test) {
	MarsRover rover(100, 100, "");

	rover.executeCommand("B");
	auto pos = rover.getRoverPos();
	BOOST_CHECK(pos.first == 0 && pos.second == 99);

	rover.executeCommand("FLF");
	pos = rover.getRoverPos();
	BOOST_CHECK(pos.first == 99 && pos.second == 0);

	rover.executeCommand("LF");
	pos = rover.getRoverPos();
	BOOST_CHECK(pos.first == 99 && pos.second == 99);

	rover.executeCommand("LF");
	pos = rover.getRoverPos();
	BOOST_CHECK(pos.first == 0 && pos.second == 99);
}

BOOST_AUTO_TEST_CASE(rover_obstacle_placement) {
	/*
	 *  -----
	 *  -x---
	 *  -xx--
	 *  -x---
	 *
	 * */
	std::string obstacles = "(1,0)(1,1)(2,1)(1,2)";
	MarsRover rover(5, 5, obstacles);

	BOOST_CHECK(rover.isObstacle(1, 0));
	BOOST_CHECK(rover.isObstacle(1, 1));
	BOOST_CHECK(rover.isObstacle(2, 1));
	BOOST_CHECK(rover.isObstacle(1, 2));
}

BOOST_AUTO_TEST_CASE(rover_obstacle_report) {
	/*
	 *  -----
	 *  -x---
	 *  -xx--
	 *  -x---
	 *
	 * */
	std::string obstacles = "(1,0)(1,1)(2,1)(1,2)";
	MarsRover rover(5, 5, obstacles);

	BOOST_CHECK_EQUAL(rover.executeCommand("FR"), "(0,1,E)");
	BOOST_CHECK_EQUAL(rover.executeCommand("F"), "(0,1,E)(1,1)");
}
