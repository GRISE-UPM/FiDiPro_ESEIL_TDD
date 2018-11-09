#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/BowlingGame.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  BowlingGame game;
  BOOST_CHECK_EQUAL(0, game.score());
}

BOOST_AUTO_TEST_CASE (createframe_test)
{
  Frame test_frame(9,false, false, false);
  BOOST_CHECK_EQUAL(0, test_frame.isLastFrame());
}

BOOST_AUTO_TEST_CASE (isStrike_test)
{
  Frame test_frame(9,true, false, false);
  BOOST_CHECK_EQUAL(1, test_frame.isStrike());
}

BOOST_AUTO_TEST_CASE (isSpare_test)
{
  Frame test_frame(9,true, true, false);
  BOOST_CHECK_EQUAL(1, test_frame.isSpare());
}

BOOST_AUTO_TEST_CASE (isLast_test)
{
  Frame test_frame(9,true, true, true);
  BOOST_CHECK_EQUAL(1, test_frame.isLastFrame());
}

BOOST_AUTO_TEST_CASE (frameBonus_test)
{
  Frame test_frame(9,true, true, true);
  test_frame.addBonus(10);
  BOOST_CHECK_EQUAL(10, test_frame.bonus());
}


BOOST_AUTO_TEST_CASE (frameScore_test)
{
  Frame test_frame(9,true, true, true);
  BOOST_CHECK_EQUAL(9, test_frame.score());
}

BOOST_AUTO_TEST_CASE (gameScore_test)
{
  BowlingGame game;
  Frame test_frame(9,false, false, false);

  game.addFrame(test_frame);

  BOOST_CHECK_EQUAL(9, game.score());
}

BOOST_AUTO_TEST_CASE (gameScore_test2)
{
  BowlingGame game;
  Frame test_frame(9,false, false, false);
  Frame test_frame2(6,false, false, false);

  game.addFrame(test_frame);
  game.addFrame(test_frame2);

  BOOST_CHECK_EQUAL(15, game.score());
}
