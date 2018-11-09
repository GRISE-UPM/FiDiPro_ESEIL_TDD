#define BOOST_TEST_MODULE MR_tests
#include <boost/test/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("", rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE (test_fw)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,1,0)", rover.executeCommand("f"));
}

BOOST_AUTO_TEST_CASE (test_fb)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,0,0)", rover.executeCommand("fb"));
}

BOOST_AUTO_TEST_CASE (test_r)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,0,2)", rover.executeCommand("r"));
}

BOOST_AUTO_TEST_CASE (test_l)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,0,3)", rover.executeCommand("l"));
}

BOOST_AUTO_TEST_CASE (test_rf)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(1,0,2)", rover.executeCommand("rf"));
}

BOOST_AUTO_TEST_CASE (test_rffflf)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(3,1,0)", rover.executeCommand("rffflf"));
}

BOOST_AUTO_TEST_CASE (test_goOut)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(3,1,0)", rover.executeCommand("lff"));
}
