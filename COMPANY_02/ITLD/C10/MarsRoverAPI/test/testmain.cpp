#define BOOST_TEST_MODULE MR_tests
#include <boost/test/included/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

BOOST_AUTO_TEST_CASE (test_get_current_postion)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL(rover.getCurrentPostion(), "(0,0,N)");
}

BOOST_AUTO_TEST_CASE (stepping_north)
{
  MarsRover rover(100,100,"N");
  rover.setCurrentPosition(0,1,"N");
  BOOST_CHECK_EQUAL("(0,2,N)", rover.executeCommand("f"));
}

BOOST_AUTO_TEST_CASE (tipping_from_the_top)
{
  MarsRover rover(100,100,"N");
  rover.setCurrentPosition(0,100,"N");
  BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand("f"));
}

BOOST_AUTO_TEST_CASE (stepping_east)
{
  MarsRover rover(100,100,"N");
  rover.setCurrentPosition(0,1,"E");
  BOOST_CHECK_EQUAL("(2,1,E)", rover.executeCommand("ff"));
}

BOOST_AUTO_TEST_CASE (tipping_from_the_east)
{
  MarsRover rover(100,100,"N");
  rover.setCurrentPosition(100,1,"E");
  BOOST_CHECK_EQUAL("(0,1,E)", rover.executeCommand("f"));
}

BOOST_AUTO_TEST_CASE (going_back_east)
{
  MarsRover rover(100,100,"N");
  rover.setCurrentPosition(100,1,"E");
  BOOST_CHECK_EQUAL("(99,1,E)", rover.executeCommand("b"));
}

BOOST_AUTO_TEST_CASE (longer_strives)
{
  MarsRover rover(100,100,"N");
  rover.setCurrentPosition(0,0,"N");
  BOOST_CHECK_EQUAL("(1,2,E)", rover.executeCommand("ffrf"));
}
