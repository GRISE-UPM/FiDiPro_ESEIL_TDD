#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/BowlingGame.h"
#include "../src/Frame.h"

BOOST_AUTO_TEST_CASE (test_score_1_4)
{
  BowlingGame game;
  Frame frame1(1,4);
  game.addFrame(frame1);
  BOOST_CHECK_EQUAL(game.score(), 5);
}

BOOST_AUTO_TEST_CASE (test_score_1_4__4_5)
{
  BowlingGame game;
  Frame frame1(1,4);
  game.addFrame(frame1);
  Frame frame2(4,5);
  game.addFrame(frame2);
  BOOST_CHECK_EQUAL(game.score(), 14);
}

BOOST_AUTO_TEST_CASE (test_score_1_4__4_5__6_s)
{
  BowlingGame game;
  Frame frame1(1,4);
  game.addFrame(frame1);
  Frame frame2(4,5);
  game.addFrame(frame2);
  Frame frame3(6,4);
  game.addFrame(frame3);
  BOOST_CHECK_EQUAL(game.score(), 24);
}

BOOST_AUTO_TEST_CASE (test_score_1_4__4_5__6_s__5_s)
{
  BowlingGame game;
  Frame frame1(1,4);
  game.addFrame(frame1);
  Frame frame2(4,5);
  game.addFrame(frame2);
  Frame frame3(6,4);
  game.addFrame(frame3);
  Frame frame4(5,5);
  game.addFrame(frame4);
  BOOST_CHECK_EQUAL(game.score(), 39);
}

BOOST_AUTO_TEST_CASE (test_score_1_4__4_5__6_s__5_s_S)
{
  BowlingGame game;
  Frame frame1(1,4);
  game.addFrame(frame1);
  Frame frame2(4,5);
  game.addFrame(frame2);
  Frame frame3(6,4);
  game.addFrame(frame3);
  Frame frame4(5,5);
  game.addFrame(frame4);
  Frame frame5(10,0);
  game.addFrame(frame5);
  BOOST_CHECK_EQUAL(game.score(), 59);
}

BOOST_AUTO_TEST_CASE (test_score_upto_frame_9)
{
  BowlingGame game;
  Frame frame1(1,4);
  game.addFrame(frame1);
  Frame frame2(4,5);
  game.addFrame(frame2);
  Frame frame3(6,4);
  game.addFrame(frame3);
  Frame frame4(5,5);
  game.addFrame(frame4);
  Frame frame5(10,0);
  game.addFrame(frame5);
  Frame frame6(0,1);
  game.addFrame(frame6);
  Frame frame7(7,3);
  game.addFrame(frame7);
  Frame frame8(6,4);
  game.addFrame(frame8);
  Frame frame9(10,0);
  game.addFrame(frame9);
  BOOST_CHECK_EQUAL(game.score(), 107);
}
