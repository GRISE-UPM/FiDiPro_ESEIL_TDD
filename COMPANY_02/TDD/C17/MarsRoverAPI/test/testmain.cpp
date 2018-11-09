
#define BOOST_TEST_MODULE MR_tests
#include <boost/test/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  MarsRover rover(100,100,"");
  //BOOST_CHECK_EQUAL("", rover.executeCommand(""));
  BOOST_CHECK_EQUAL("", rover.executeCommand("fflff"));
}






