#define BOOST_TEST_MODULE MR_tests
#include <boost/test/included/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

BOOST_AUTO_TEST_CASE (Landing)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand(""), "(0,0,N)");
}

BOOST_AUTO_TEST_SUITE(Turning)
BOOST_AUTO_TEST_CASE (TurnRight)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand("r"), "(0,0,E)");
}
BOOST_AUTO_TEST_CASE (TurnRight_2x)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand("rr"), "(0,0,S)");
}
BOOST_AUTO_TEST_CASE (TurnLeft)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand("l"), "(0,0,W)");
}
BOOST_AUTO_TEST_SUITE_END()

BOOST_AUTO_TEST_SUITE(Moving)
BOOST_AUTO_TEST_CASE (MoveFwd)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand("f"), "(0,1,N)");
}
BOOST_AUTO_TEST_CASE (MoveFwd_2x)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand("ff"), "(0,2,N)");
}
BOOST_AUTO_TEST_CASE (MoveFwd_MoveBwd)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand("f"), "(0,1,N)");
  BOOST_CHECK_EQUAL(rover.executeCommand("b"), "(0,0,N)");
}
BOOST_AUTO_TEST_SUITE_END()

BOOST_AUTO_TEST_SUITE(Turning_and_moving_combo)
BOOST_AUTO_TEST_CASE (MoveFwd_2x_TurnRight_MoveFwd_2x)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand("ffrff"), "(2,2,E)");
}
BOOST_AUTO_TEST_SUITE_END()

BOOST_AUTO_TEST_SUITE(Wrapping)
BOOST_AUTO_TEST_CASE (Turning_and_moving_and_wrapping_combo)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand("lf"), "(99,0,W)");
  BOOST_CHECK_EQUAL(rover.executeCommand("lf"), "(99,99,S)");
  BOOST_CHECK_EQUAL(rover.executeCommand("b"), "(99,0,S)");
  BOOST_CHECK_EQUAL(rover.executeCommand("rb"), "(0,0,W)");
}
BOOST_AUTO_TEST_SUITE_END()

BOOST_AUTO_TEST_SUITE(Obstacles)
BOOST_AUTO_TEST_CASE (Turning_and_moving_and_wrapping_combo_xxx)
{
  MarsRover rover(6,6,"(1,1)(4,5)");
  BOOST_CHECK_EQUAL(rover.executeCommand("f"), "(0,1,N)");
}
BOOST_AUTO_TEST_SUITE_END()
