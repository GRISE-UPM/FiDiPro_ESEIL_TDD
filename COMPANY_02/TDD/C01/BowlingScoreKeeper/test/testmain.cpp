#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/unit_test.hpp>

#include "../src/BowlingGame.h"

BOOST_AUTO_TEST_CASE (game_test_create_new_game)
{
  BowlingGame game;
  BOOST_CHECK_EQUAL(0, game.score());
}


BOOST_AUTO_TEST_CASE (frame_test__get_score_1)
{
  Frame frame(1,2);
  BOOST_CHECK_EQUAL(3, frame.score());
}


BOOST_AUTO_TEST_CASE (frame_test_get_score_2)
{
  Frame frame(4,5);
  BOOST_CHECK_EQUAL(9, frame.score());
}

BOOST_AUTO_TEST_CASE (game_add_ten_frames_calculate_score)
{
	BowlingGame game;
	game.addFrame(Frame(1,5));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(7,2));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(4,4));
	game.addFrame(Frame(5,3));
	game.addFrame(Frame(3,3));
	game.addFrame(Frame(4,5));
	game.addFrame(Frame(8,1));
	game.addFrame(Frame(2,6));

	BOOST_CHECK_EQUAL(game.score(), 81);
}


BOOST_AUTO_TEST_CASE (frame_is_strike)
{
  Frame frame(10,0);
  BOOST_CHECK(frame.isStrike());
}

BOOST_AUTO_TEST_CASE (frame_is_not_strike)
{
  Frame frame(5,5);
  BOOST_CHECK(!frame.isStrike());
}

BOOST_AUTO_TEST_CASE (game_add_ten_frames_calculate_score_with_a_strike_in_first_frame)
{
	BowlingGame game;
	game.addFrame(Frame(10,0));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(7,2));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(4,4));
	game.addFrame(Frame(5,3));
	game.addFrame(Frame(3,3));
	game.addFrame(Frame(4,5));
	game.addFrame(Frame(8,1));
	game.addFrame(Frame(2,6));

	BOOST_CHECK_EQUAL(game.score(), 94);
}


BOOST_AUTO_TEST_CASE (game_add_ten_frames_calculate_score_with_a_strike_in_last_frame)
{
	BowlingGame game;
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(7,2));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(4,4));
	game.addFrame(Frame(5,3));
	game.addFrame(Frame(3,3));
	game.addFrame(Frame(4,5));
	game.addFrame(Frame(8,1));
	game.addFrame(Frame(2,6));
	game.addFrame(Frame(10,0));

	BOOST_CHECK_EQUAL(game.score(), 85);
}



BOOST_AUTO_TEST_CASE (frame_is_spare)
{
  Frame frame(5,5);
  BOOST_CHECK(frame.isSpare());
}


BOOST_AUTO_TEST_CASE (frame_is_strike_but_not_spare)
{
  Frame frame(10,0);
  BOOST_CHECK(!frame.isSpare());
}

BOOST_AUTO_TEST_CASE (game_add_ten_frames_calculate_score_with_a_spare_as_first_frame)
{
	BowlingGame game;
	game.addFrame(Frame(1,9));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(7,2));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(4,4));
	game.addFrame(Frame(5,3));
	game.addFrame(Frame(3,3));
	game.addFrame(Frame(4,5));
	game.addFrame(Frame(8,1));
	game.addFrame(Frame(2,6));

	BOOST_CHECK_EQUAL(game.score(), 88);
}

/*BOOST_AUTO_TEST_CASE (game_add_ten_frames_calculate_score_with_a_spare_as_last_frame)
{
	BowlingGame game;
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(7,2));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(4,4));
	game.addFrame(Frame(5,3));
	game.addFrame(Frame(3,3));
	game.addFrame(Frame(4,5));
	game.addFrame(Frame(8,1));
	game.addFrame(Frame(2,6));
	game.addFrame(Frame(1,9));


	BOOST_CHECK_EQUAL(game.score(), 85);
}*/


BOOST_AUTO_TEST_CASE (game_add_ten_frames_calculate_score_with_strike_followed_by_spare)
{
	BowlingGame game;

	game.addFrame(Frame(10,0));
	game.addFrame(Frame(4,6));
	game.addFrame(Frame(7,2));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(4,4));
	game.addFrame(Frame(5,3));
	game.addFrame(Frame(3,3));
	game.addFrame(Frame(4,5));
	game.addFrame(Frame(8,1));
	game.addFrame(Frame(2,6));


	BOOST_CHECK_EQUAL(game.score(), 103);
}

BOOST_AUTO_TEST_CASE (game_add_ten_frames_calculate_score_with_spare_followed_by_a_strike)
{
	BowlingGame game;

	game.addFrame(Frame(4,6));
	game.addFrame(Frame(10,0));
	game.addFrame(Frame(7,2));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(4,4));
	game.addFrame(Frame(5,3));
	game.addFrame(Frame(3,3));
	game.addFrame(Frame(4,5));
	game.addFrame(Frame(8,1));
	game.addFrame(Frame(2,6));

	BOOST_CHECK_EQUAL(game.score(), 105);
}



BOOST_AUTO_TEST_CASE (game_add_ten_frames_calculate_score_with_two_strikes_in_a_row_as_first_throws)
{
	BowlingGame game;

	game.addFrame(Frame(10,0));
	game.addFrame(Frame(10,0));
	game.addFrame(Frame(7,2));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(4,4));
	game.addFrame(Frame(5,3));
	game.addFrame(Frame(3,3));
	game.addFrame(Frame(4,5));
	game.addFrame(Frame(8,1));
	game.addFrame(Frame(2,6));

	BOOST_CHECK_EQUAL(game.score(), 112);
}



BOOST_AUTO_TEST_CASE (game_add_ten_frames_calculate_score_with_two_spares_in_a_row_as_first_throws)
{
	BowlingGame game;

	game.addFrame(Frame(8,2));
	game.addFrame(Frame(5,5));
	game.addFrame(Frame(7,2));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(4,4));
	game.addFrame(Frame(5,3));
	game.addFrame(Frame(3,3));
	game.addFrame(Frame(4,5));
	game.addFrame(Frame(8,1));
	game.addFrame(Frame(2,6));

	BOOST_CHECK_EQUAL(game.score(), 98);
}


BOOST_AUTO_TEST_CASE (game_add_ten_frames_calculate_score_with_spare_as_last_throw)
{
	BowlingGame game;

	game.addFrame(Frame(1,5));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(7,2));
	game.addFrame(Frame(3,6));
	game.addFrame(Frame(4,4));
	game.addFrame(Frame(5,3));
	game.addFrame(Frame(3,3));
	game.addFrame(Frame(4,5));
	game.addFrame(Frame(8,1));
	game.addFrame(Frame(2,8));
	game.setBonus(7,0);


	BOOST_CHECK_EQUAL(game.score(), 90);
}



BOOST_AUTO_TEST_CASE (frame_is_last_frame) {
	Frame test(1,2,true);

	BOOST_CHECK(test.isLastFrame());


}


BOOST_AUTO_TEST_CASE (frame_bonus_set) {
	Frame test(1,2,true);

	BOOST_CHECK_EQUAL(test.bonus(),1);


}






