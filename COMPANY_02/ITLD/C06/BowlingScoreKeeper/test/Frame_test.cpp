
#include <boost/test/unit_test.hpp>

#include "../src/Frame.h"

BOOST_AUTO_TEST_CASE (frame)
{
  Frame testFrame;
  testFrame.firstThrow = 1;
  testFrame.secondThrow = 8;
  BOOST_CHECK_EQUAL(testFrame.firstThrow, 1 );
  BOOST_CHECK_EQUAL(testFrame.secondThrow, 8 );
}

BOOST_AUTO_TEST_CASE (score_singleFrame)
{
	  Frame testFrame;
	  BOOST_CHECK_EQUAL(testFrame.score(), 0 );
}
