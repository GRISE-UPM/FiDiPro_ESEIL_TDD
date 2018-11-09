#define BOOST_TEST_MODULE MR_tests
#include <boost/test/included/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

BOOST_AUTO_TEST_CASE (the_planet_intialization_test)
{
  MarsRover rover(10, 10, "");
  BOOST_CHECK_EQUAL(rover.getPlanetDimensionX(), 10);
  BOOST_CHECK_EQUAL(rover.getPlanetDimensionY(), 10);
}

BOOST_AUTO_TEST_CASE (rover_landing_test)
{
  MarsRover rover(10, 10, "");
  rover.executeCommand("");
  BOOST_CHECK_EQUAL(rover.getRoverPositionX(), 0);
  BOOST_CHECK_EQUAL(rover.getRoverPositionY(), 0);
  BOOST_CHECK_EQUAL(rover.getRoverFacingDirection(), "N");
}

BOOST_AUTO_TEST_CASE (rover_right_turn_test)
{
  MarsRover rover(10, 10, "");
  rover.executeCommand("");
  rover.executeCommand("r");
  rover.executeCommand("r");
  rover.executeCommand("r");

  BOOST_CHECK_EQUAL(rover.getRoverPositionX(), 0);
  BOOST_CHECK_EQUAL(rover.getRoverPositionY(), 0);
  BOOST_CHECK_EQUAL(rover.getRoverFacingDirection(), "W");
}

BOOST_AUTO_TEST_CASE (rover_left_turn_test)
{
  MarsRover rover(10, 10, "");
  rover.executeCommand("");
  rover.executeCommand("l");
  rover.executeCommand("l");

  BOOST_CHECK_EQUAL(rover.getRoverPositionX(), 0);
  BOOST_CHECK_EQUAL(rover.getRoverPositionY(), 0);
  BOOST_CHECK_EQUAL(rover.getRoverFacingDirection(), "S");
}

BOOST_AUTO_TEST_CASE (rover_forward_move_test)
{
  MarsRover rover(10, 10, "");
  rover.executeCommand("");
  rover.executeCommand("r");
  rover.executeCommand("f");

  BOOST_CHECK_EQUAL(rover.getRoverPositionX(), 1);
  BOOST_CHECK_EQUAL(rover.getRoverPositionY(), 0);
  BOOST_CHECK_EQUAL(rover.getRoverFacingDirection(), "E");
}

BOOST_AUTO_TEST_CASE (rover_backward_move_test)
{
  MarsRover rover(10, 10, "");
  rover.executeCommand("");
  rover.executeCommand("l");
  rover.executeCommand("b");

  BOOST_CHECK_EQUAL(rover.getRoverPositionX(), 1);
  BOOST_CHECK_EQUAL(rover.getRoverPositionY(), 0);
  BOOST_CHECK_EQUAL(rover.getRoverFacingDirection(), "W");
}

BOOST_AUTO_TEST_CASE (rover_moving_and_turning_test)
{
  MarsRover rover(10, 10, "");
  rover.executeCommand("");
  rover.executeCommand("ffrff");

  BOOST_CHECK_EQUAL(rover.getRoverPositionX(), 2);
  BOOST_CHECK_EQUAL(rover.getRoverPositionY(), 2);
  BOOST_CHECK_EQUAL(rover.getRoverFacingDirection(), "E");
}

BOOST_AUTO_TEST_CASE (wrapping_planet)
{
  MarsRover rover(10, 10, "");
  rover.executeCommand("");
  rover.executeCommand("rblbf");

  BOOST_CHECK_EQUAL(rover.getRoverPositionX(), 9);
  BOOST_CHECK_EQUAL(rover.getRoverPositionY(), 0);
  BOOST_CHECK_EQUAL(rover.getRoverFacingDirection(), "N");
}

BOOST_AUTO_TEST_CASE (planet_single_obstacles)
{
  MarsRover rover(10, 10, "(1,1)");
  rover.executeCommand("");
  BOOST_CHECK_EQUAL(rover.executeCommand("frf"), "(0,1,E)(1,1)");

}
