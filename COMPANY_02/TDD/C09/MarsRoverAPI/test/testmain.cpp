#define BOOST_TEST_MODULE MR_tests
#include <boost/test/included/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

using namespace std;


BOOST_AUTO_TEST_CASE (smoke_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("", rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE (single_movements_test)
{
  // Using example in second page as template
  MarsRover rover(3,3,""); // Starts at 0,0
  BOOST_CHECK_EQUAL("(0, 1, north)", rover.executeCommand("f"));
  BOOST_CHECK_EQUAL("(0, 2, north)", rover.executeCommand("f"));
  BOOST_CHECK_EQUAL("(0, 2, east)", rover.executeCommand("r"));
  BOOST_CHECK_EQUAL("(1, 2, east)", rover.executeCommand("f"));

  // Check edges
  BOOST_CHECK_EQUAL("(2, 2, east)", rover.executeCommand("f"));
  BOOST_CHECK_EQUAL("(0, 2, east)", rover.executeCommand("f"));

  // Now for commands l and b:
  BOOST_CHECK_EQUAL("(0, 2, north)", rover.executeCommand("l"));
  BOOST_CHECK_EQUAL("(0, 2, west)", rover.executeCommand("l"));
  BOOST_CHECK_EQUAL("(0, 2, south)", rover.executeCommand("l"));
  BOOST_CHECK_EQUAL("(0, 1, south)", rover.executeCommand("f"));
  BOOST_CHECK_EQUAL("(0, 1, west)", rover.executeCommand("r"));
  BOOST_CHECK_EQUAL("(2, 1, west)", rover.executeCommand("f"));
  BOOST_CHECK_EQUAL("(2, 1, north)", rover.executeCommand("r"));
  BOOST_CHECK_EQUAL("(2, 0, north)", rover.executeCommand("b"));
}

BOOST_AUTO_TEST_CASE (composite_movements_test)
{
	// Doing variations of previous example
	MarsRover rover(3,3,""); // Starts at 0,0
	BOOST_CHECK_EQUAL("(0, 2, east)", rover.executeCommand("ffrfff"));

	BOOST_CHECK_EQUAL("(2, 0, north)", rover.executeCommand("lllfrfrb"));
}

// Now in order to test private methods readObstacle(s)
// a test double is needed

class RoverDouble : public MarsRover {
public:
	RoverDouble(int x, int y, string obstacles);

	position_t test_readObstacle(string obstacle) {
		position_t p;
		readObstacle(obstacle);
		return p;
	}

	int test_readObstacles(string obstacles) {
		readObstacles(obstacles);
		return 0;//obstaclesSize();
	}
};

RoverDouble::RoverDouble (int x, int y, string obstacles) :
				MarsRover( x,  y,  obstacles) {}


BOOST_AUTO_TEST_CASE (obstacles_test)
{
	// Using simple example provided
	RoverDouble rover_d(3,3,"(0,2)"); // Starts at 0,0

}

