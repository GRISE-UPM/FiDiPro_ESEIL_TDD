#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/BowlingGame.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
	BowlingGame game;
	BOOST_CHECK_EQUAL(0, game.score());
}

BOOST_AUTO_TEST_CASE (check_throws_test)
{
	Frame f1(1);
	f1.setThrows(7, 7);
	BOOST_CHECK_EQUAL(0, f1.score());
}

BOOST_AUTO_TEST_CASE (frame_bool_funcs_test)
{
	Frame f1(10);
	f1.setThrows(7, 3);
	BOOST_CHECK(f1.isLastFrame());
	f1.setThrows(10, 0);
	BOOST_CHECK(f1.isStrike());
	f1.setThrows(7, 3);
	BOOST_CHECK(f1.isSpare());
}

BOOST_AUTO_TEST_CASE (frame_score_func_test)
{
	Frame f1(10);
	f1.setThrows(7, 3); // Strike
	f1.set_bonus(5, 3);
	BOOST_CHECK_EQUAL(15, f1.score());

	f1.setThrows(10, 0);
	f1.set_bonus(5, 3);
	BOOST_CHECK_EQUAL(18, f1.score());
}

BOOST_AUTO_TEST_CASE (Game_score_func_test)
{
	// Based on the provided example
	BowlingGame game;
	// Round (frame) 1: 1 [4]
	// --------------
	// Score	5
	game.addFrame(); game.throw2(1, 4);
	BOOST_CHECK_EQUAL(5, game.score());

	// Round 2: 4 [5]
	// --------------
	// Score	14
	game.addFrame(); game.throw2(4, 5);
	BOOST_CHECK_EQUAL(14, game.score());

	// Round 3: 6 [4-spare]
	// --------------
	// Score	29 incl bonus (5)
	game.addFrame(); game.throw2(6, 4);
	game.setBonus(5, 5); // see next throw
	BOOST_CHECK_EQUAL(10+5, game.getLastRoundScore());
	BOOST_CHECK_EQUAL(29, game.score());

	// Round 4: 5 [5-spare]
	// --------------
	// Score	49 incl bonus
	game.addFrame(); game.throw2(5, 5);
	game.setBonus(10, 0);
	BOOST_CHECK_EQUAL(49, game.score());

	// Round 5: 10 [0-strike]
	// --------------
	// Score	60 incl bonus
	game.addFrame(); game.throw2(10, 0);
	game.setBonus(0, 1);
	BOOST_CHECK_EQUAL(60, game.score());

	// Round 6: 0 [1]
	// --------------
	// Score	61
	game.addFrame(); game.throw2(0, 1);
	BOOST_CHECK_EQUAL(61, game.score());

	// Round 7: 7 [3]
	// --------------
	// Score	77
	game.addFrame(); game.throw2(7, 3);
	game.setBonus(6, 4);
	BOOST_CHECK_EQUAL(77, game.score());

	// Round 8: 6 [4]
	// --------------
	// Score	97
	game.addFrame(); game.throw2(6, 4);
	game.setBonus(10, 0);
	BOOST_CHECK_EQUAL(97, game.score());

	// Round 9: 10 [0]
	// --------------
	// Score	117
	game.addFrame(); game.throw2(10, 0);
	game.setBonus(2, 8);
	BOOST_CHECK_EQUAL(117, game.score());

	// Round 10: 2 [8] 6
	// --------------
	// Score	133
	game.addFrame(); game.throw3(2, 8, 6);
	BOOST_CHECK_EQUAL(6, game.getLastRoundScore());
	BOOST_CHECK_EQUAL(2+8, game.getScore(10)); // Score of round 10 without the bonus round
	BOOST_CHECK_EQUAL(133, game.score());
}
