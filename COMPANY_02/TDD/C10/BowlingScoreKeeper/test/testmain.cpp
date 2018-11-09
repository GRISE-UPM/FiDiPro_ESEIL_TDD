#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/BowlingGame.h"

BOOST_AUTO_TEST_CASE (create_frame_with_two_throws_and_check_first_throw)
{
  Frame frame(2,4);
  BOOST_CHECK_EQUAL(frame.getFirstthrow(), 2);
}

BOOST_AUTO_TEST_CASE (create_frame_with_two_throws_and_check_second_throw)
{
  Frame frame(2,4);
  BOOST_CHECK_EQUAL(frame.getSecondthrow(), 4);
}

BOOST_AUTO_TEST_CASE (sum_of_frame_with_two_throws)
{
  Frame frame(2,4);
  BOOST_CHECK_EQUAL(frame.getFrameScore(), 6);
}

BOOST_AUTO_TEST_CASE (game_with_2_frames)
{
	BowlingGame game("[1,2][2,4]");
  BOOST_CHECK_EQUAL(game.getScore(), 9);
}

BOOST_AUTO_TEST_CASE (game_with_10_frames)
{
	BowlingGame game("[1,2][2,4][1,2][2,4][1,2][2,4][1,2][2,4][1,2][2,4]");
  BOOST_CHECK_EQUAL(game.getScore(), 45);
}

BOOST_AUTO_TEST_CASE (game_with_4_frames_and_a_strike)
{
	BowlingGame game("[1,2][2,4][10,0][2,4]");
  BOOST_CHECK_EQUAL(game.getScore(), 31);
}

BOOST_AUTO_TEST_CASE (game_with_4_frames_and_a_spare_frame)
{
	BowlingGame game("[1,2][2,4][3,7][2,4]");
  BOOST_CHECK_EQUAL(game.getScore(), 27);
}

BOOST_AUTO_TEST_CASE (game_with_5_frames_and_strike_followed_by_a_spare_frame)
{
	BowlingGame game("[1,2][10,0][3,7][2,4]");
  BOOST_CHECK_EQUAL(game.getScore(), 41);
}

BOOST_AUTO_TEST_CASE (game_with_5_frames_and_two_strikes_in_a_row)
{
	BowlingGame game("[1,2][10,0][10,0][2,4]");
  BOOST_CHECK_EQUAL(game.getScore(), 51);
}
