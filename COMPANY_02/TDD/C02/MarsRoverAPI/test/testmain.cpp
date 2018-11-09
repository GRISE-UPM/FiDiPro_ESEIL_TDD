#define BOOST_TEST_MODULE MR_tests
#include <boost/test/included/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("", rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE (correct_grid_size_50x50)
{
  MarsRover rover(50,50," ");
  BOOST_CHECK_EQUAL("", rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE (moving_to_right)
{
  MarsRover rover(100,100," ");
  BOOST_CHECK_EQUAL("r", rover.executeCommand("r"));
}


BOOST_AUTO_TEST_CASE (moving_to_left)
{
  MarsRover rover(100,100," ");
  BOOST_CHECK_EQUAL("l", rover.executeCommand("l"));
}


BOOST_AUTO_TEST_CASE (moving_to_backward)
{
  MarsRover rover(100,100," ");
  BOOST_CHECK_EQUAL("b", rover.executeCommand("b"));
}

BOOST_AUTO_TEST_CASE (moving_to_forward)
{
  MarsRover rover(100,100," ");
  BOOST_CHECK_EQUAL("f", rover.executeCommand("f"));
}

// do some test to check that the position is correct of the obstacle?
