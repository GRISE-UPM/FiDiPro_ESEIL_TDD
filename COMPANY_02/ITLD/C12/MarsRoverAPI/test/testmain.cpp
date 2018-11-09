#define BOOST_TEST_MODULE MR_tests
#include <boost/test/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

BOOST_AUTO_TEST_CASE(init)
{
	MarsRover rover(100, 10, "");
	BOOST_CHECK_EQUAL(rover.get_limit_x(), 100);
	BOOST_CHECK_EQUAL(rover.get_limit_y(), 10);
}

BOOST_AUTO_TEST_CASE(rover_init)
{
	MarsRover rover(100,100,"");
	BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE(single_turn_left)
{
	MarsRover rover(10,10,"");
	BOOST_CHECK_EQUAL("(0,0,W)", rover.executeCommand("l"));
}

BOOST_AUTO_TEST_CASE(single_turn_right)
{
	MarsRover rover(10,10,"");
	BOOST_CHECK_EQUAL("(0,0,E)", rover.executeCommand("r"));
}

BOOST_AUTO_TEST_CASE(single_forward)
{
	MarsRover rover(10,10,"");
	rover.set_location(7,6,'N');
	BOOST_CHECK_EQUAL("(7,7,N)", rover.executeCommand("f"));
}

BOOST_AUTO_TEST_CASE(single_reverse)
{
	MarsRover rover(10,10,"");
	rover.set_location(5,8,'E');
	BOOST_CHECK_EQUAL("(4,8,E)", rover.executeCommand("b"));
}

BOOST_AUTO_TEST_CASE(combined_moves)
{
	MarsRover rover(10,10,"");
	BOOST_CHECK_EQUAL("(2,2,E)", rover.executeCommand("ffrff"));
}

BOOST_AUTO_TEST_CASE(wrap_planet)
{
	MarsRover rover(100,100,"");
	BOOST_CHECK_EQUAL("(0,99,N)", rover.executeCommand("b"));
}
