#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/unit_test.hpp>

#include "../src/BowlingGame.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
	BowlingGame game;
	BOOST_CHECK_EQUAL(0, game.score());
}

BOOST_AUTO_TEST_CASE( create_a_frame ) {
	Frame f(3,5);
	BOOST_CHECK_EQUAL(f.getFirst(), 3);
	BOOST_CHECK_EQUAL(f.getSecond(), 5);
}

BOOST_AUTO_TEST_CASE( compute_simple_frame_score ) {
	Frame f(1,3);
	BOOST_CHECK_EQUAL(f.score(), 4);
}

class BowlingGame_test_double : public BowlingGame {
public:
	BowlingGame_test_double() : BowlingGame() {};
	std::vector<Frame> getFrames() { return frames; }
};


BowlingGame_test_double createTestGame() {
	BowlingGame_test_double b;
	b.addFrame(Frame(1,5));
	b.addFrame(Frame(3,6));
	b.addFrame(Frame(7,2));
	b.addFrame(Frame(3,6));
	b.addFrame(Frame(4,4));
	b.addFrame(Frame(5,3));
	b.addFrame(Frame(3,3));
	b.addFrame(Frame(4,5));
	b.addFrame(Frame(8,1));
	b.addFrame(Frame(2,6));
	return b;
}



BOOST_AUTO_TEST_CASE( create_a_game_with_ten_frames ) {
	BowlingGame_test_double b = createTestGame();
	BOOST_CHECK_EQUAL(b.getFrames().size(), 10);
}

BOOST_AUTO_TEST_CASE( simple_game_score ) {
	BowlingGame_test_double b = createTestGame();
	BOOST_CHECK_EQUAL(b.score(), 81);
}

BowlingGame_test_double createTestGame2() {
	BowlingGame_test_double b;
	b.addFrame(Frame(10,0));
	b.addFrame(Frame(3,6));
	b.addFrame(Frame(7,2));
	b.addFrame(Frame(3,6));
	b.addFrame(Frame(4,4));
	b.addFrame(Frame(5,3));
	b.addFrame(Frame(3,3));
	b.addFrame(Frame(4,5));
	b.addFrame(Frame(8,1));
	b.addFrame(Frame(2,6));
	return b;
}

BOOST_AUTO_TEST_CASE( simple_strike ) {
	Frame f(10,0);
	BowlingGame_test_double b = createTestGame2();
	BOOST_CHECK(f.isStrike());
	BOOST_CHECK_EQUAL(f.score(), 10);
	BOOST_CHECK_EQUAL(b.score(), 94);
}

BowlingGame_test_double createTestGame3() {
	BowlingGame_test_double b;
	b.addFrame(Frame(1,9));
	b.addFrame(Frame(3,6));
	b.addFrame(Frame(7,2));
	b.addFrame(Frame(3,6));
	b.addFrame(Frame(4,4));
	b.addFrame(Frame(5,3));
	b.addFrame(Frame(3,3));
	b.addFrame(Frame(4,5));
	b.addFrame(Frame(8,1));
	b.addFrame(Frame(2,6));
	return b;
}

BOOST_AUTO_TEST_CASE (simple_spare ) {

	BOOST_CHECK(Frame(1,9).isSpare());
	BOOST_CHECK(Frame(4,6).isSpare());
	BOOST_CHECK(Frame(7,3).isSpare());

	BOOST_CHECK(!Frame(10,0).isSpare());

	BowlingGame_test_double b = createTestGame3();
	BOOST_CHECK_EQUAL( b.score(), 88);
}


BowlingGame_test_double createTestGame4() {
	BowlingGame_test_double b;
	b.addFrame(Frame(10,0));
	b.addFrame(Frame(4,6));
	b.addFrame(Frame(7,2));
	b.addFrame(Frame(3,6));
	b.addFrame(Frame(4,4));
	b.addFrame(Frame(5,3));
	b.addFrame(Frame(3,3));
	b.addFrame(Frame(4,5));
	b.addFrame(Frame(8,1));
	b.addFrame(Frame(2,6));
	return b;
}

BOOST_AUTO_TEST_CASE( strike_and_spare ) {
	BowlingGame_test_double b = createTestGame4();
	BOOST_CHECK_EQUAL(b.score(), 103);
}

BowlingGame_test_double createTestGame5() {
	BowlingGame_test_double b;
	b.addFrame(Frame(10,0));
	b.addFrame(Frame(10,0));
	b.addFrame(Frame(7,2));
	b.addFrame(Frame(3,6));
	b.addFrame(Frame(4,4));
	b.addFrame(Frame(5,3));
	b.addFrame(Frame(3,3));
	b.addFrame(Frame(4,5));
	b.addFrame(Frame(8,1));
	b.addFrame(Frame(2,6));
	return b;
}

BOOST_AUTO_TEST_CASE( consequent_strikes ) {
	BowlingGame_test_double b = createTestGame5();
	BOOST_CHECK_EQUAL(b.score(), 112);
}



