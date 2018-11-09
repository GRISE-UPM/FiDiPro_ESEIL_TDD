#define BOOST_TEST_MODULE MR_tests
#include <boost/test/unit_test.hpp>


#include <string>
#include "../src/MarsRover.h"

/*BOOST_AUTO_TEST_CASE (smoke_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("", rover.executeCommand(""));
}*/

BOOST_AUTO_TEST_CASE (rover_initial_position)
{
  MarsRover rover(0,0,"");
  BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE (forward_north)
{
  MarsRover rover(0,0,"");
  BOOST_CHECK_EQUAL("(0,1,N)", rover.executeCommand("f"));
}

BOOST_AUTO_TEST_CASE (turn_rigth)
{
  MarsRover rover(0,0,"");
  BOOST_CHECK_EQUAL("(0,0,E)", rover.executeCommand("r"));
}

BOOST_AUTO_TEST_CASE (turn_left)
{
  MarsRover rover(2,2,"");
  BOOST_CHECK_EQUAL("(2,2,W)", rover.executeCommand("l"));
}

BOOST_AUTO_TEST_CASE (back_south)
{
  MarsRover rover(2,2,"");
  BOOST_CHECK_EQUAL("(2,1,N)", rover.executeCommand("b"));
}

BOOST_AUTO_TEST_CASE (spawn_opposite_side_north_out)
{
  MarsRover rover(2,2,"");
  BOOST_CHECK_EQUAL("(2,0,N)", rover.executeCommand("f"));
}
