#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/BowlingGame.h"

struct ExceptionChecker {
    ExceptionChecker(const std::string &_str) : str(_str) {}
    bool operator()(const std::exception &ex) {
        return (str == ex.what());
    }
private:
    std::string str;
};

BOOST_AUTO_TEST_SUITE(frame_tests)

BOOST_AUTO_TEST_CASE( frame_can_be_constructed_with_correct_values ) {
    BOOST_CHECK_NO_THROW(Frame(3, 5));
}

BOOST_AUTO_TEST_CASE( frame_cannot_be_constructed_with_wrong_values ) {
    BOOST_CHECK_EXCEPTION(Frame(8, 9), std::logic_error, ExceptionChecker("Frame constructed with illegal score"));
}

BOOST_AUTO_TEST_CASE( frame_with_spare_score_should_detect_it_and_not_be_strike ) {
    Frame frame(1, 9);
    BOOST_CHECK(frame.isSpare());
    BOOST_CHECK(!frame.isStrike());
}

BOOST_AUTO_TEST_CASE( frame_with_strike_score_should_detect_it_and_not_be_spare ) {
    Frame frame(10, 0);
    BOOST_CHECK(frame.isStrike());
    BOOST_CHECK(!frame.isSpare());
}

BOOST_AUTO_TEST_CASE( adding_a_bonus_effectively_increases_score ) {
    Frame frame(1, 1);
    frame.setBonus(5);

    BOOST_CHECK_EQUAL(frame.score(), 1 + 1 + 5);
}

BOOST_AUTO_TEST_CASE( adding_a_new_bonus_should_trigger_a_exception ) {
    Frame frame(1, 1);
    frame.setBonus(5);

    BOOST_CHECK_EXCEPTION(frame.setBonus(4), std::logic_error, ExceptionChecker("Bonus already initialized"));
}

BOOST_AUTO_TEST_CASE( adding_a_wrong_should_trigger_a_exception ) {
    Frame frame(1, 1);

    BOOST_CHECK_EXCEPTION(frame.setBonus(11), std::logic_error, ExceptionChecker("Requested illegal bonus amount"));
}

BOOST_AUTO_TEST_SUITE_END()

struct BowlingGameTestFixture {
    void add_frame(uint32_t first_score, uint32_t second_score) {
        Frame frame(first_score, second_score);
        game.addFrame(frame);
    }
    BowlingGame game;
};

BOOST_FIXTURE_TEST_SUITE(bowling_game_tests, BowlingGameTestFixture)

BOOST_AUTO_TEST_CASE ( empty_game_gives_total_zero_score ) {
    BOOST_CHECK_EQUAL(0, game.score());
}

BOOST_AUTO_TEST_CASE( game_allows_input_frame_and_returns_correct_score ) {
    add_frame(3, 4);
    BOOST_CHECK_EQUAL(game.score(), 3 + 4);
}

BOOST_AUTO_TEST_CASE( game_does_not_allow_excessive_amount_of_frames ) {
    const uint32_t MAX_FRAMES = 10;
    for (uint32_t i = 0; i < MAX_FRAMES; ++i) {
        add_frame(0, 0);
    }
    BOOST_CHECK_EXCEPTION(add_frame(0, 0), std::out_of_range, ExceptionChecker("Too many frames for a game"));
}

BOOST_AUTO_TEST_CASE( game_handles_bonus_accordingly ) {
    add_frame(1, 9); // Spare
    add_frame(3, 5);

    const uint32_t score_up_to_here =  1 + 9 + 3 + 3 + 5;
    BOOST_CHECK_EQUAL(game.score(), score_up_to_here);

    add_frame(10,0); // Strike
    add_frame(1, 1);
    BOOST_CHECK_EQUAL(game.score(), score_up_to_here + 10 + 1 + 1 + 1 + 1);
}

BOOST_AUTO_TEST_CASE( game_allows_one_extra_frame_if_last_was_spare_or_strike ) {
    const uint32_t MAX_FRAMES = 10;
    for (uint32_t i = 0; i < MAX_FRAMES; ++i) {
        add_frame(10, 0);
    }
    BOOST_CHECK_NO_THROW(add_frame(1, 0));
}

BOOST_AUTO_TEST_CASE( extra_frame_should_have_only_one_throw ) {
    const uint32_t MAX_FRAMES = 10;
    for (uint32_t i = 0; i < MAX_FRAMES; ++i) {
        add_frame(10, 0);
    }
    BOOST_CHECK_EXCEPTION(add_frame(1, 1), std::logic_error, ExceptionChecker("Bonus frame has two throws"));
}

BOOST_AUTO_TEST_CASE( complete_bowling_game ) {
    add_frame(1, 4);
    BOOST_CHECK_EQUAL(game.score(), 5);

    add_frame(4, 5);
    BOOST_CHECK_EQUAL(game.score(), 14);

    add_frame(6, 4);
    BOOST_CHECK_EQUAL(game.score(), 24);

    add_frame(5, 5);
    BOOST_CHECK_EQUAL(game.score(), 39);

    add_frame(10, 0);
    BOOST_CHECK_EQUAL(game.score(), 59);

    add_frame(0, 1);
    BOOST_CHECK_EQUAL(game.score(), 61);

    add_frame(7, 3);
    BOOST_CHECK_EQUAL(game.score(), 71);

    add_frame(6, 4);
    BOOST_CHECK_EQUAL(game.score(), 87);

    add_frame(10, 0);
    BOOST_CHECK_EQUAL(game.score(), 107);

    add_frame(2, 8);
    BOOST_CHECK_EQUAL(game.score(), 127);

    add_frame(6, 0);
    BOOST_CHECK_EQUAL(game.score(), 133);

}

BOOST_AUTO_TEST_SUITE_END()
