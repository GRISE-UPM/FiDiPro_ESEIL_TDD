#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/BowlingGame.h"
#include "../src/Frame.h"

#include <vector>


BOOST_AUTO_TEST_CASE (smoke_test)
{
  BowlingGame game;
  BOOST_CHECK_EQUAL(0, game.score());
}

BOOST_AUTO_TEST_CASE(test_frame) {
	Frame frame;
	frame.setThrow(1, 2);
	frame.setThrow(2, 4);
	BOOST_CHECK_EQUAL(frame.getThrow(1), 2);
	BOOST_CHECK_EQUAL(frame.getThrow(2), 4);
}

BOOST_AUTO_TEST_CASE(test_frame_score) {
	Frame frame1;
	frame1.setThrow(1, 2);
	frame1.setThrow(2, 6);
	BOOST_CHECK_EQUAL(frame1.score(), 8);

	Frame frame2;
	frame2.setThrow(1, 0);
	frame2.setThrow(2, 9);
	BOOST_CHECK_EQUAL(frame2.score(), 9);
}

BOOST_AUTO_TEST_CASE(game_frames_test) {
	BowlingGame game;

	for (int x = 0; x < 10; ++x) {
		Frame frame;
		frame.setThrow(1, x);
		frame.setThrow(2, 10 - x);
		game.addFrame(frame);
	}

	const std::vector<Frame>& frames = game.getFrames();
	BOOST_CHECK(frames.size() == 10);
	BOOST_CHECK_EQUAL(frames.at(2).getThrow(2), 8);
}

BOOST_AUTO_TEST_CASE(game_score_test) {
	BowlingGame game1;

	for (int x = 0; x < 10; ++x) {
		Frame frame;
		frame.setThrow(1, 3);
		frame.setThrow(2, 6);
		game1.addFrame(frame);
	}

	BOOST_CHECK_EQUAL(game1.score(), 90);

	BowlingGame game2;

	for (int x = 0; x < 10; ++x) {
		Frame frame;
		frame.setThrow(1, 2);
		frame.setThrow(2, 3);
		game2.addFrame(frame);
	}

	BOOST_CHECK_EQUAL(game2.score(), 50);


	// test with some variance in the frame scores
	BowlingGame game3;

	for (int x = 0; x < 7; ++x) {
		Frame frame;
		frame.setThrow(1, 2);
		frame.setThrow(2, 3);
		game3.addFrame(frame);
	}

	Frame frameTwos;
	frameTwos.setThrow(1, 0);
	frameTwos.setThrow(2, 2);
	for (int x = 0; x < 3; ++x) {
		game3.addFrame(frameTwos);
	}

	BOOST_CHECK_EQUAL(game3.score(), (7 * 5) + (3 * 2));
}

BOOST_AUTO_TEST_CASE(game_strike_test) {
	BowlingGame game;

	Frame frame1;
	frame1.setThrow(1, 2);
	frame1.setThrow(2, 3);
	game.addFrame(frame1);

	Frame frameStrike;
	frameStrike.setThrow(1, 10);
	frameStrike.setThrow(2, 0);
	game.addFrame(frameStrike);

	for (int x = 0; x < 8; ++x) {
		Frame frame;
		frame.setThrow(1, 2);
		frame.setThrow(2, 2);
		game.addFrame(frame);
	}

	BOOST_CHECK_EQUAL(game.score(), (5 + 10 + (9*4 /* strike bonus + 8 frames */)));
}

BOOST_AUTO_TEST_CASE(game_spare_test) {
	BowlingGame game;

	Frame frame1;
	frame1.setThrow(1, 2);
	frame1.setThrow(2, 3);
	game.addFrame(frame1);

	Frame frameSpare;
	frameSpare.setThrow(1, 6);
	frameSpare.setThrow(2, 4);
	game.addFrame(frameSpare);

	for (int x = 0; x < 8; ++x) {
		Frame frame;
		frame.setThrow(1, 2);
		frame.setThrow(2, 2);
		game.addFrame(frame);
	}

	BOOST_CHECK_EQUAL(game.score(), (5 + 10 + 2 + 8*4));
}

BOOST_AUTO_TEST_CASE(game_strike_and_spare) {
	BowlingGame game;

	std::vector<std::vector<int>> throwsVec {
		{10, 0},
		{4, 6},
		{7, 2},
		{3, 6},
		{4, 4},
		{5, 3},
		{3, 3},
		{4, 5},
		{8, 1},
		{2, 6}
	};

	for (const auto& throws : throwsVec) {
		Frame frame;
		frame.setThrow(1, throws[0]);
		frame.setThrow(2, throws[1]);
		game.addFrame(frame);
	}

	BOOST_CHECK_EQUAL(game.score(), 103);
}

BOOST_AUTO_TEST_CASE(game_double_strike) {
	BowlingGame game;

	std::vector<std::vector<int>> throwsVec {
		{10, 0},
		{10, 0},
		{7, 2},
		{3, 6},
		{4, 4},
		{5, 3},
		{3, 3},
		{4, 5},
		{8, 1},
		{2, 6}
	};

	for (const auto& throws : throwsVec) {
		Frame frame;
		frame.setThrow(1, throws[0]);
		frame.setThrow(2, throws[1]);
		game.addFrame(frame);
	}

	BOOST_CHECK_EQUAL(game.score(), 112);
}
