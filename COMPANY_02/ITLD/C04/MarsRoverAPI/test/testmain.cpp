#define BOOST_TEST_MODULE MR_tests
#include <boost/test/included/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE (move_one_forward)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,1,N)", rover.executeCommand("f"));
}

BOOST_AUTO_TEST_CASE (move_one_forward_and_turn_right)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,1,E)", rover.executeCommand("fr"));
}

BOOST_AUTO_TEST_CASE (move_one_forward_and_turn_left)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,1,W)", rover.executeCommand("fl"));
}

BOOST_AUTO_TEST_CASE (move_one_forward_and_turn_three_left)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,1,E)", rover.executeCommand("flll"));
}

BOOST_AUTO_TEST_CASE (move_two_forward)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,2,N)", rover.executeCommand("ff"));
}

BOOST_AUTO_TEST_CASE (move_three_forward_and_one_back)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,2,N)", rover.executeCommand("fffb"));
}

BOOST_AUTO_TEST_CASE (move_three_forward_turn_right_two_forward)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(2,3,E)", rover.executeCommand("fffrff"));
}
