#define BOOST_TEST_MODULE MR_tests
#include <boost/test/included/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"


BOOST_AUTO_TEST_CASE (checkPlanetDimensions)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.planetWidth(), 100);
  BOOST_CHECK_EQUAL(rover.planetDepth(), 100);
}

BOOST_AUTO_TEST_CASE (checkInitialRoverPositionDirection)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand(""), "(0,0,N)");
}

BOOST_AUTO_TEST_CASE (Turning_Left)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand(""),  "(0,0,N)");
  BOOST_CHECK_EQUAL(rover.executeCommand("l"), "(0,0,W)");
  BOOST_CHECK_EQUAL(rover.executeCommand("l"), "(0,0,S)");
  BOOST_CHECK_EQUAL(rover.executeCommand("l"), "(0,0,E)");
  BOOST_CHECK_EQUAL(rover.executeCommand("l"), "(0,0,N)");
}

BOOST_AUTO_TEST_CASE (Turning_Right)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand(""),  "(0,0,N)");
  BOOST_CHECK_EQUAL(rover.executeCommand("r"), "(0,0,E)");
  BOOST_CHECK_EQUAL(rover.executeCommand("r"), "(0,0,S)");
  BOOST_CHECK_EQUAL(rover.executeCommand("r"), "(0,0,W)");
  BOOST_CHECK_EQUAL(rover.executeCommand("r"), "(0,0,N)");
}

BOOST_AUTO_TEST_CASE (Intial_Move_Forward)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand(""),  "(0,0,N)");
  BOOST_CHECK_EQUAL(rover.executeCommand("f"), "(0,1,N)");
}

BOOST_AUTO_TEST_CASE (Forward_allDirections)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand(""),  "(0,0,N)");
  BOOST_CHECK_EQUAL(rover.executeCommand("f"), "(0,1,N)");
  BOOST_CHECK_EQUAL(rover.executeCommand("r"), "(0,1,E)");
  BOOST_CHECK_EQUAL(rover.executeCommand("f"), "(1,1,E)");
  BOOST_CHECK_EQUAL(rover.executeCommand("r"), "(1,1,S)");
  BOOST_CHECK_EQUAL(rover.executeCommand("f"), "(1,0,S)");
  BOOST_CHECK_EQUAL(rover.executeCommand("r"), "(1,0,W)");
  BOOST_CHECK_EQUAL(rover.executeCommand("f"), "(0,0,W)");
}

BOOST_AUTO_TEST_CASE (Backward_allDirections)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand(""),  "(0,0,N)");
  BOOST_CHECK_EQUAL(rover.executeCommand("l"), "(0,0,W)");
  BOOST_CHECK_EQUAL(rover.executeCommand("b"), "(1,0,W)");
  BOOST_CHECK_EQUAL(rover.executeCommand("l"), "(1,0,S)");
  BOOST_CHECK_EQUAL(rover.executeCommand("b"), "(1,1,S)");
  BOOST_CHECK_EQUAL(rover.executeCommand("l"), "(1,1,E)");
  BOOST_CHECK_EQUAL(rover.executeCommand("b"), "(0,1,E)");
  BOOST_CHECK_EQUAL(rover.executeCommand("l"), "(0,1,N)");
  BOOST_CHECK_EQUAL(rover.executeCommand("b"), "(0,0,N)");
}

BOOST_AUTO_TEST_CASE (Complex_Directions)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.executeCommand(""),  "(0,0,N)");
  BOOST_CHECK_EQUAL(rover.executeCommand("ff"),  "(0,2,N)");
  BOOST_CHECK_EQUAL(rover.executeCommand("rr"),  "(0,0,S)");
  BOOST_CHECK_EQUAL(rover.executeCommand("fr"),  "(0,1,E)");
  BOOST_CHECK_EQUAL(rover.executeCommand("frfrbbrf"), "(0,3,W)");
}

