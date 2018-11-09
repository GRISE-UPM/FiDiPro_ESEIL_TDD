#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/unit_test.hpp>

#include "../src/BowlingGame.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  BowlingGame game;
  BOOST_CHECK_EQUAL(0, game.score());
}
