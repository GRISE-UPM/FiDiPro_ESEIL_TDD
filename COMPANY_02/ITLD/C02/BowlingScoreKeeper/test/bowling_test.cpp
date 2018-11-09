/*
 * bowling_test.cpp
 *
 *  Created on: 15 Apr 2015
 *      Author: user
 */

#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "bowling.cpp"

BOOST_AUTO_TEST_CASE (number_frames)
{
 BOOST_CHECK(spare(5,5), true);
}


