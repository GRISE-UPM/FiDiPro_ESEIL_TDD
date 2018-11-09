#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/BowlingGame.h"
#include "../src/Frame.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  BowlingGame game;
  BOOST_CHECK_EQUAL(0, game.score());
}

BOOST_AUTO_TEST_CASE (test_knockdown_1)
{
  BowlingGame game;
  Frame frame;
  frame.setScore(1);
  game.addFrame(frame);
  BOOST_CHECK_EQUAL(1, game.score());
}

BOOST_AUTO_TEST_CASE (test_knockdown_spare_bonus_2)
{
  BowlingGame game;
  game.setBonus(8, 2, 0);
  BOOST_CHECK_EQUAL(12, game.score());
}

BOOST_AUTO_TEST_CASE (test_knockdown_strike_bonus_4)
{
  BowlingGame game;
  game.setBonus(10, 4, 0);
  BOOST_CHECK_EQUAL(14, game.score());
}

BOOST_AUTO_TEST_CASE (test_knockdown_spare_tenth_frame_no_extra_throw_1)
{
  BowlingGame game;
  game.setBonus(8, 2, 2);
  BOOST_CHECK_EQUAL(14, game.score());
}

