#define BOOST_TEST_MODULE MR_tests
#include <boost/test/included/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("", rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE(forward)
{
	MarsRover rover(100, 100, "");
	BOOST_CHECK_EQUAL("(0,1,N)", rover.executeCommand("f"));
}

BOOST_AUTO_TEST_CASE(backward)
{
	MarsRover rover(100, 100, "");
	BOOST_CHECK_EQUAL("(0,99,N)", rover.executeCommand("b"));
}

BOOST_AUTO_TEST_CASE(forward_and_backward)
{
	MarsRover rover(100, 100, "");
	BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand("fb"));
}

BOOST_AUTO_TEST_CASE(turn_right)
{
	MarsRover rover(100, 100, "");
	BOOST_CHECK_EQUAL("(0,0,E)", rover.executeCommand("r"));
}

BOOST_AUTO_TEST_CASE(turn_left)
{
	MarsRover rover(100, 100, "");
	BOOST_CHECK_EQUAL("(0,0,W)", rover.executeCommand("l"));
}

BOOST_AUTO_TEST_CASE(full_circle_right)
{
	MarsRover rover(100, 100, "");
	BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand("frfrfrfr"));
}

BOOST_AUTO_TEST_CASE(test_obstacle)
{
	MarsRover rover(100, 100, "(0,1)");
	BOOST_CHECK_EQUAL("(0,0,N)(0,1)", rover.executeCommand("f"));
}
