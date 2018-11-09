#define BOOST_TEST_MODULE MR_tests
#include <boost/test/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"
#include <vector>

BOOST_AUTO_TEST_CASE (smoke_test)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("", rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE (initialize_planet)
{
  MarsRover rover(100,100,"");
  vector < vector<int> > roverPlanet = rover.getPlanet();
  size_t h = roverPlanet.max_size();
  BOOST_CHECK(h=1);
}

