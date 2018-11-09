#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/BowlingGame.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  BowlingGame game;
  BOOST_CHECK_EQUAL(0, game.score());
}

BOOST_AUTO_TEST_CASE (frame_creation) {
  Frame frame(5,2);
  BOOST_CHECK_EQUAL(frame.getFirstThrowScore(), 5);
  BOOST_CHECK_EQUAL(frame.getSecondThrowScore(), 2);
}

BOOST_AUTO_TEST_CASE( score_of_an_ordinary_frame ) {
    Frame frame(2,8);
    BOOST_CHECK_EQUAL(frame.score(), 10);
}

BOOST_AUTO_TEST_CASE(game_creation) {
    BowlingGame game;
    Frame frame1(1,5);
    Frame frame2(3,6);
    Frame frame3(7,2);
    Frame frame4(3,6);
    Frame frame5(4,4);
    Frame frame6(5,3);
    Frame frame7(3,3);
    Frame frame8(4,5);
    Frame frame9(8,1);
    Frame frame10(2,6);

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
    //what to test here..
}

BOOST_AUTO_TEST_CASE( calculate_game_score_ordinary_frames ) {
    BowlingGame game;
    Frame frame1(1,5);
    Frame frame2(3,6);
    Frame frame3(7,2);
    Frame frame4(3,6);
    Frame frame5(4,4);
    Frame frame6(5,3);
    Frame frame7(3,3);
    Frame frame8(4,5);
    Frame frame9(8,1);
    Frame frame10(2,6);

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

    BOOST_CHECK_EQUAL(game.score(), 81);
}

BOOST_AUTO_TEST_CASE(strike_recognition) {
    Frame frame1(10,0);
    Frame frame2(3,6);

    BOOST_CHECK_EQUAL(frame1.isStrike(), true);
    BOOST_CHECK_EQUAL(frame2.isStrike(), false);

}

BOOST_AUTO_TEST_CASE(strike_scoring) {
    BowlingGame game;
    Frame frame1(10,0);
    Frame frame2(3,6);
    Frame frame3(7,2);
    Frame frame4(3,6);
    Frame frame5(4,4);
    Frame frame6(5,3);
    Frame frame7(3,3);
    Frame frame8(4,5);
    Frame frame9(8,1);
    Frame frame10(2,6);

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

    BOOST_CHECK_EQUAL(game.score(), 94);
}

BOOST_AUTO_TEST_CASE(recognize_spare) {
    Frame frame1(8,2);
    Frame frame2(3,6);

    BOOST_CHECK_EQUAL(frame1.isSpare(), true);
    BOOST_CHECK_EQUAL(frame2.isSpare(), false);

}

BOOST_AUTO_TEST_CASE(spare_scoring) {
    BowlingGame game;
    Frame frame1(1,9);
    Frame frame2(3,6);
    Frame frame3(7,2);
    Frame frame4(3,6);
    Frame frame5(4,4);
    Frame frame6(5,3);
    Frame frame7(3,3);
    Frame frame8(4,5);
    Frame frame9(8,1);
    Frame frame10(2,6);

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

    BOOST_CHECK_EQUAL(game.score(), 88);
}

BOOST_AUTO_TEST_CASE(strike_followed_by_spare_scoring) {
    BowlingGame game;
    Frame frame1(10,0);
    Frame frame2(4,6);
    Frame frame3(7,2);
    Frame frame4(3,6);
    Frame frame5(4,4);
    Frame frame6(5,3);
    Frame frame7(3,3);
    Frame frame8(4,5);
    Frame frame9(8,1);
    Frame frame10(2,6);

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

    BOOST_CHECK_EQUAL(game.score(), 103);
}

BOOST_AUTO_TEST_CASE(double_strikes) {
    BowlingGame game;
    Frame frame1(10,0);
    Frame frame2(10,0);
    Frame frame3(7,2);
    Frame frame4(3,6);
    Frame frame5(4,4);
    Frame frame6(5,3);
    Frame frame7(3,3);
    Frame frame8(4,5);
    Frame frame9(8,1);
    Frame frame10(2,6);

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

    BOOST_CHECK_EQUAL(game.score(), 112);
}
