#define BOOST_TEST_MODULE MR_tests
#include <boost/test/included/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE (turn_left_test)
{
  MarsRover rover(100,100,"");
  rover.executeCommand("l");
  BOOST_CHECK_EQUAL("(0,0,W)", rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE (turn_right_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,0,E)", rover.executeCommand("r"));
}

BOOST_AUTO_TEST_CASE (move_fwd_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,1,N)", rover.executeCommand("f"));
}

BOOST_AUTO_TEST_CASE (move_backward_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,99,N)", rover.executeCommand("b"));
}

BOOST_AUTO_TEST_CASE (move_twice_fwd_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,2,N)", rover.executeCommand("ff"));
}

BOOST_AUTO_TEST_CASE (turn_and_fwd_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand("rfrfrf"));
}
