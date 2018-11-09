#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/unit_test.hpp>

#include "../src/BowlingGame.h"
#include "../src/Frame.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  BowlingGame game;
  BOOST_CHECK_EQUAL(0, game.score());
}


BOOST_AUTO_TEST_CASE (score_for_one_frame)
{
	BowlingGame game;
	Frame frame(4,0);

	game.addFrame(frame);
	BOOST_CHECK_EQUAL(4, game.score());
}

BOOST_AUTO_TEST_CASE (score_for_one_frame_two_hits)
{
	BowlingGame game;
	Frame frame(4,3);

	game.addFrame(frame);
	BOOST_CHECK_EQUAL(7, game.score());
}

BOOST_AUTO_TEST_CASE (score_for_two_frames)
{
	BowlingGame game;
	Frame frame(4,3);
	Frame frame2(2,2);

	game.addFrame(frame);
	game.addFrame(frame2);
	BOOST_CHECK_EQUAL(11, game.score());
}

BOOST_AUTO_TEST_CASE (check_frame_is_spare)
{
	Frame frame(4,6);
	BOOST_CHECK(frame.isSpare());
}

BOOST_AUTO_TEST_CASE (check_frame_is_strike)
{
	Frame frame(10,0);
	BOOST_CHECK(frame.isStrike());
}

BOOST_AUTO_TEST_CASE (check_frame_bonus)
{
	Frame frame(5,4);
	frame.setBonus(5);
	BOOST_CHECK_EQUAL(frame.score(), 14);
}

BOOST_AUTO_TEST_CASE (check_game_score_with_spares)
{
	BowlingGame game;
	Frame frame(5,5);
	game.addFrame(frame);

	if(game.isNextFrameBonus()) {
		game.setBonus(4,3);
	}
	Frame frame2(4,3);
	game.addFrame(frame2);

	BOOST_CHECK_EQUAL(game.score(), 21);
}

BOOST_AUTO_TEST_CASE (check_game_score_with_strike)
{
	BowlingGame game;
	Frame frame(10,0);
	game.addFrame(frame);

	if(game.isNextFrameBonus()) {
		game.setBonus(4,3);
	}
	Frame frame2(4,3);
	game.addFrame(frame2);

	BOOST_CHECK_EQUAL(game.score(), 24);
}

BOOST_AUTO_TEST_CASE (check_last_frame)
{
	Frame frame(10,0,0, true);

	BOOST_CHECK(frame.isLastFrame());
}

BOOST_AUTO_TEST_CASE (check_last_frame_score) {
	Frame frame(10,10,10, true);
	BOOST_CHECK_EQUAL(frame.score(), 30);
}

void game_add_score(BowlingGame &game, int f, int s) {
	Frame frame = Frame(f,s);
	if(game.isNextFrameBonus()) {
		game.setBonus(f,s);
	}
	game.addFrame(frame);
}


BOOST_AUTO_TEST_CASE (check_total_game_score) {
	BowlingGame game;

	Frame f = Frame(1,4);
	game.addFrame(f);

	game_add_score(game, 4,5);
	game_add_score(game, 6,4);
	game_add_score(game, 5,5);
	game_add_score(game, 10,0);
	game_add_score(game, 0,1);
	game_add_score(game, 7,3);
	game_add_score(game, 6,4);
	game_add_score(game, 10,0);

	f = Frame(2,8,6,true);

	if(game.isNextFrameBonus()) {
		game.setBonus(2,8);
	}
	game.addFrame(f);

	BOOST_CHECK_EQUAL(game.score(), 133);
}

