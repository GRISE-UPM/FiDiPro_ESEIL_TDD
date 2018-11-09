#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/BowlingGame.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  BowlingGame game;
  BOOST_CHECK_EQUAL(0, game.score());
}

BOOST_AUTO_TEST_CASE(frame_score)
{
	Frame frame(2, 3, true);
	BOOST_CHECK_EQUAL(5, frame.score());
}

BOOST_AUTO_TEST_CASE(frame_strike_positive)
{
	Frame frame(10, 0, true);
	BOOST_CHECK_EQUAL(true, frame.isStrike());
}

BOOST_AUTO_TEST_CASE(frame_strike_negative)
{
	Frame frame(0, 0, true);
	BOOST_CHECK_EQUAL(false, frame.isStrike());
}

BOOST_AUTO_TEST_CASE(frame_spare_positive)
{
	Frame frame(5, 5, true);
	BOOST_CHECK_EQUAL(true, frame.isSpare());
}

BOOST_AUTO_TEST_CASE(frame_spare_negative)
{
	Frame frame(0, 0, true);
	BOOST_CHECK_EQUAL(false, frame.isSpare());
}

BOOST_AUTO_TEST_CASE(frame_spare_is_really_strike)
{
	Frame frame(10, 0, true);
	BOOST_CHECK_EQUAL(false, frame.isSpare());
}

BOOST_AUTO_TEST_CASE(frame_bonus)
{
	Frame frame(0, 0, true);
	frame.setBonus(1);
	BOOST_CHECK_EQUAL(1, frame.bonus());
}

BOOST_AUTO_TEST_CASE(frame_score_with_bonus)
{
	Frame frame(5, 5, true);
	frame.setBonus(5);
	BOOST_CHECK_EQUAL(15, frame.score());
}

BOOST_AUTO_TEST_CASE(game_score_for_one_frame)
{
	BowlingGame game;
	Frame frame(2, 3, true);

	game.addFrame(frame);
	BOOST_CHECK_EQUAL(5, game.score());
}

BOOST_AUTO_TEST_CASE(game_score_for_two_frames)
{
	BowlingGame game;
	Frame frame1(1, 2, false);
	Frame frame2(2, 3, true);

	game.addFrame(frame1);
	game.addFrame(frame2);
	BOOST_CHECK_EQUAL(8, game.score());
}

BOOST_AUTO_TEST_CASE(game_score_with_strike)
{
	BowlingGame game;
	Frame frame1(10, 0, false);
	Frame frame2(2, 3, true);

	game.addFrame(frame1);
	game.addFrame(frame2);
	// 10 + 0 (first frame) + 2 + 3 (second frame) + 2 + 3 (bonus due to strike)
	BOOST_CHECK_EQUAL(20, game.score());
}

BOOST_AUTO_TEST_CASE(game_score_with_spare)
{
	BowlingGame game;
	Frame frame1(6, 4, false);
	Frame frame2(2, 3, true);

	game.addFrame(frame1);
	game.addFrame(frame2);
	// 6 + 4 (first frame) + 2 + 3 (second frame) + 2 (bonus due to spare)
	BOOST_CHECK_EQUAL(17, game.score());
}

BOOST_AUTO_TEST_CASE(game_score_assignment_example)
{
	BowlingGame game;
	Frame frame1(1, 4, false);
	Frame frame2(4, 5, false);
	Frame frame3(6, 4, false);
	Frame frame4(5, 5, false);
	Frame frame5(10, 0, false);
	Frame frame6(0, 1, false);
	Frame frame7(7, 3, false);
	Frame frame8(6, 4, false);
	Frame frame9(10, 0, false);
	Frame frame10(2, 8, true);

	game.addFrame(frame1);
	game.addFrame(frame2);
	game.addFrame(frame3);
	game.addFrame(frame4);
	game.addFrame(frame5);
	game.addFrame(frame6);
	game.addFrame(frame7);
	game.addFrame(frame8);
	game.addFrame(frame9);
	game.addFrame(frame10);
	game.setBonus(6, 0);
	BOOST_CHECK_EQUAL(133, game.score());
}

BOOST_AUTO_TEST_CASE(game_score_perfect)
{
	BowlingGame game;
	Frame frame1(10, 0, false);
	Frame frame2(10, 0, false);
	Frame frame3(10, 0, false);
	Frame frame4(10, 0, false);
	Frame frame5(10, 0, false);
	Frame frame6(10, 0, false);
	Frame frame7(10, 0, false);
	Frame frame8(10, 0, false);
	Frame frame9(10, 0, false);
	Frame frame10(10, 0, true);

	game.addFrame(frame1);
	game.addFrame(frame2);
	game.addFrame(frame3);
	game.addFrame(frame4);
	game.addFrame(frame5);
	game.addFrame(frame6);
	game.addFrame(frame7);
	game.addFrame(frame8);
	game.addFrame(frame9);
	game.addFrame(frame10);
	game.setBonus(10, 10);
	BOOST_CHECK_EQUAL(300, game.score());
}
