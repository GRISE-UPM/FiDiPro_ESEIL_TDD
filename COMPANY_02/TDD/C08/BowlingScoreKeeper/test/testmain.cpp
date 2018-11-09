#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/BowlingGame.h"
#include "../src/Frame.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  BowlingGame game;
  BOOST_CHECK_EQUAL(0, game.score());
}

BOOST_AUTO_TEST_CASE (frame_and_set_score)
{
  Frame frame1;
  frame1.save_throw1(2);
  frame1.save_throw2(4);
}


BOOST_AUTO_TEST_CASE (frame_and_set_score_and_read)
{
  Frame frame1;
  frame1.save_throw1(2);
  frame1.save_throw2(4);
  BOOST_CHECK_EQUAL(6, frame1.score());
}

BOOST_AUTO_TEST_CASE (game_with_ten_frames)
{
  BowlingGame game;
  game.addFrame(1,5); // 1
  game.addFrame(3,6); // 2
  game.addFrame(7,2); // 3
  game.addFrame(3,6); // 4
  game.addFrame(4,4); // 5
  game.addFrame(5,3); // 6
  game.addFrame(3,3); // 7
  game.addFrame(4,5); // 8
  game.addFrame(8,1); // 9
  game.addFrame(2,6); // 10
}

BOOST_AUTO_TEST_CASE (game_with_ten_frames_and_check_total)
{
  BowlingGame game;
  game.addFrame(1,5); // 1
  game.addFrame(3,6); // 2
  game.addFrame(7,2); // 3
  game.addFrame(3,6); // 4
  game.addFrame(4,4); // 5
  game.addFrame(5,3); // 6
  game.addFrame(3,3); // 7
  game.addFrame(4,5); // 8
  game.addFrame(8,1); // 9
  game.addFrame(2,6); // 10
  BOOST_CHECK_EQUAL(81, game.score());

}

BOOST_AUTO_TEST_CASE (game_with_ten_frames_with_strike_and_check_total)
{
  BowlingGame game;
  game.addFrame(10,0); // 1
  game.addFrame(3,6); // 2
  game.addFrame(7,2); // 3
  game.addFrame(3,6); // 4
  game.addFrame(4,4); // 5
  game.addFrame(5,3); // 6
  game.addFrame(3,3); // 7
  game.addFrame(4,5); // 8
  game.addFrame(8,1); // 9
  game.addFrame(2,6); // 10
  BOOST_CHECK_EQUAL(94, game.score());

}

BOOST_AUTO_TEST_CASE (game_with_ten_frames_with_spare)
{
  BowlingGame game;
  game.addFrame(1,9); // 1 spare
  game.addFrame(3,6); // 2
  game.addFrame(7,2); // 3
  game.addFrame(3,6); // 4
  game.addFrame(4,4); // 5
  game.addFrame(5,3); // 6
  game.addFrame(3,3); // 7
  game.addFrame(4,5); // 8
  game.addFrame(8,1); // 9
  game.addFrame(2,6); // 10
  BOOST_CHECK_EQUAL(88, game.score());

}

BOOST_AUTO_TEST_CASE (game_with_ten_frames_with_strike_and_spare)
{
  BowlingGame game;
  game.addFrame(10,0); // 1 strike
  game.addFrame(4,6); // 2 spare
  game.addFrame(7,2); // 3
  game.addFrame(3,6); // 4
  game.addFrame(4,4); // 5
  game.addFrame(5,3); // 6
  game.addFrame(3,3); // 7
  game.addFrame(4,5); // 8
  game.addFrame(8,1); // 9
  game.addFrame(2,6); // 10
  BOOST_CHECK_EQUAL(103, game.score());
}

BOOST_AUTO_TEST_CASE (game_with_two_strikes_in_a_row)
{
  BowlingGame game;
  game.addFrame(10,0); // 1 strike
  game.addFrame(10,0); // 2 strike
  game.addFrame(7,2); // 3
  game.addFrame(3,6); // 4
  game.addFrame(4,4); // 5
  game.addFrame(5,3); // 6
  game.addFrame(3,3); // 7
  game.addFrame(4,5); // 8
  game.addFrame(8,1); // 9
  game.addFrame(2,6); // 10
  BOOST_CHECK_EQUAL(112, game.score());
}

BOOST_AUTO_TEST_CASE (game_with_multiple_spares)
{
  BowlingGame game;
  game.addFrame(8,2); // 1 spare
  game.addFrame(5,5); // 2 spare
  game.addFrame(7,2); // 3
  game.addFrame(3,6); // 4
  game.addFrame(4,4); // 5
  game.addFrame(5,3); // 6
  game.addFrame(3,3); // 7
  game.addFrame(4,5); // 8
  game.addFrame(8,1); // 9
  game.addFrame(2,6); // 10
  BOOST_CHECK_EQUAL(98, game.score());
}

BOOST_AUTO_TEST_CASE (game_spare_as_the_last_frame)
{
  BowlingGame game;
  game.addFrame(1,5); // 1
  game.addFrame(3,6); // 2
  game.addFrame(7,2); // 3
  game.addFrame(3,6); // 4
  game.addFrame(4,4); // 5
  game.addFrame(5,3); // 6
  game.addFrame(3,3); // 7
  game.addFrame(4,5); // 8
  game.addFrame(8,1); // 9
  game.addFrame(2,8); // 10
  game.setBonus(7,0); // bonus
  BOOST_CHECK_EQUAL(90, game.score());
}

BOOST_AUTO_TEST_CASE (game_strike_as_the_last_frame)
{
  BowlingGame game;
  game.addFrame(1,5); // 1
  game.addFrame(3,6); // 2
  game.addFrame(7,2); // 3
  game.addFrame(3,6); // 4
  game.addFrame(4,4); // 5
  game.addFrame(5,3); // 6
  game.addFrame(3,3); // 7
  game.addFrame(4,5); // 8
  game.addFrame(8,1); // 9
  game.addFrame(10,0); // 10
  game.setBonus(7,2); // bonus
  BOOST_CHECK_EQUAL(92, game.score());
}

BOOST_AUTO_TEST_CASE (game_bonus_is_a_strike)
{
  BowlingGame game;
  game.addFrame(1,5); // 1
  game.addFrame(3,6); // 2
  game.addFrame(7,2); // 3
  game.addFrame(3,6); // 4
  game.addFrame(4,4); // 5
  game.addFrame(5,3); // 6
  game.addFrame(3,3); // 7
  game.addFrame(4,5); // 8
  game.addFrame(8,1); // 9
  game.addFrame(2,8); // 10
  game.setBonus(10,0); // bonus
  BOOST_CHECK_EQUAL(93, game.score());
}

BOOST_AUTO_TEST_CASE (game_best_score)
{
  BowlingGame game;
  game.addFrame(10,0); // 1
  game.addFrame(10,0); // 1
  game.addFrame(10,0); // 1
  game.addFrame(10,0); // 1
  game.addFrame(10,0); // 1
  game.addFrame(10,0); // 1
  game.addFrame(10,0); // 1
  game.addFrame(10,0); // 1
  game.addFrame(10,0); // 1
  game.addFrame(10,0); // 1
  game.setBonus(10,10); // bonus
  BOOST_CHECK_EQUAL(300, game.score());
}

BOOST_AUTO_TEST_CASE (real_game)
{
  BowlingGame game;
  game.addFrame(6,3); // 1
  game.addFrame(7,1); // 1
  game.addFrame(8,2); // 1
  game.addFrame(7,2); // 1
  game.addFrame(10,0); // 1
  game.addFrame(6,2); // 1
  game.addFrame(7,3); // 1
  game.addFrame(10,0); // 1
  game.addFrame(8,0); // 1
  game.addFrame(7,3); // 1
  game.setBonus(10,0); // bonus
  BOOST_CHECK_EQUAL(135, game.score());
}





