#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/BowlingGame.h"


BOOST_AUTO_TEST_CASE (frame_strike_test)
{
  Frame first;
  first.setFirstThrow(10);
  BOOST_CHECK_EQUAL(first.isStrike(), true);

  first.setFirstThrow(9);
  BOOST_CHECK_EQUAL(first.isStrike(), false);
}

BOOST_AUTO_TEST_CASE (frame_spare_test)
{
  Frame first;
  first.setFirstThrow(5);
  first.setSecondThrow(5);
  BOOST_CHECK_EQUAL(first.isSpare(), true);

  first.setFirstThrow(0);
  first.setSecondThrow(1);
  BOOST_CHECK_EQUAL(first.isSpare(), false);
}

BOOST_AUTO_TEST_CASE (frame_score__test)
{
  Frame first;
  first.setFirstThrow(0);
  first.setSecondThrow(5);
  BOOST_CHECK_EQUAL(first.getFrameScore(), 5);

  Frame tenth;
  tenth.setFirstThrow(10);
  tenth.setSecondThrow(10);
  tenth.setThirdThrow(10);
  BOOST_CHECK_EQUAL(tenth.getFrameScore(), 30);


}

BOOST_AUTO_TEST_CASE (game_first_frame_score)
{
  BowlingGame game;
  game.frames[0].setFirstThrow(5);
  game.frames[0].setSecondThrow(5);
  game.updateGameScore(0);
  BOOST_CHECK_EQUAL(game.getGameScore(1), 10);

}

BOOST_AUTO_TEST_CASE (game_spare_frame_score)
{
  BowlingGame game;
  game.frames[0].setFirstThrow(5);
  game.frames[0].setSecondThrow(5);
  game.updateGameScore(0);

  game.frames[1].setFirstThrow(8);
  game.frames[1].setSecondThrow(1);
  game.updateGameScore(1);

  BOOST_CHECK_EQUAL(game.getGameScore(2), 27);

}

BOOST_AUTO_TEST_CASE (game_strike_frame_score)
{
  BowlingGame game;
  game.frames[0].setFirstThrow(5);
  game.frames[0].setSecondThrow(5);
  game.updateGameScore(0);

  game.frames[1].setFirstThrow(10);
  game.updateGameScore(1);

  game.frames[2].setFirstThrow(10);
  game.updateGameScore(2);

  game.frames[3].setFirstThrow(10);
  game.updateGameScore(3);

  game.frames[4].setFirstThrow(8);
  game.frames[4].setSecondThrow(1);
  game.updateGameScore(4);

  BOOST_CHECK_EQUAL(game.getGameScore(5), 106);

}

