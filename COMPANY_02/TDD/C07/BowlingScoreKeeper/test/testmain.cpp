#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/unit_test.hpp>

#include "../src/BowlingGame.h"

BOOST_AUTO_TEST_CASE (smoke_test)
{
  BowlingGame game;
  BOOST_CHECK_EQUAL(0, game.score());
}

BOOST_AUTO_TEST_CASE (check_frameScrore)
{
  Frame  frame(1,2,5);
  BOOST_CHECK_EQUAL(7, frame.score());
}

BOOST_AUTO_TEST_CASE (check_frameStrike)
{
  Frame  frame1(1,2,5);
  BOOST_CHECK(!frame1.isStrike());
  Frame  frame2(1,10,0);
  BOOST_CHECK(frame2.isStrike());
}

BOOST_AUTO_TEST_CASE (check_frameSpare)
{
  Frame  frame1(1,2,5);
  BOOST_CHECK(!frame1.isSpare());
  Frame  frame2(1,10,0);
  BOOST_CHECK(!frame2.isSpare());
  Frame  frame3(1,7,3);
  BOOST_CHECK(frame3.isSpare());
}

BOOST_AUTO_TEST_CASE (check_frameIsLast)
{
  Frame  frame1(9,2,5);
  BOOST_CHECK(!frame1.isLastFrame());
  Frame  frame2(10,2,5);
  BOOST_CHECK(frame2.isLastFrame());
  Frame  frame3(10,7,3);
  BOOST_CHECK(!frame3.isLastFrame());
  Frame  frame4(10,10,0);
  BOOST_CHECK(!frame4.isLastFrame());

  // Bonus frame
  Frame  frame5(11,0,0);
  BOOST_CHECK(frame5.isLastFrame());
  Frame  frame6(11,5,5);
  BOOST_CHECK(frame6.isLastFrame());
  Frame  frame7(11,10,0);
  BOOST_CHECK(frame7.isLastFrame());
}

// First testing a game or someone thaat is not very good i.e. no spares/strikes/bonus
BOOST_AUTO_TEST_CASE (Game_Start)
{
  BowlingGame game;
  BOOST_CHECK_EQUAL(0, game.score());
}

BOOST_AUTO_TEST_CASE (Game_FirstFrame)
{
  BowlingGame game;
  game.addFrame(2,5);
  BOOST_CHECK_EQUAL(7, game.score());
}

BOOST_AUTO_TEST_CASE (Game_SecondFrame)
{
  BowlingGame game;
  game.addFrame(2,5);
  game.addFrame(6,3);
  BOOST_CHECK_EQUAL(16, game.score());
}

BOOST_AUTO_TEST_CASE (Game_Finished_without_Bonus)
{
  BowlingGame game;
  game.addFrame(2,5);
  game.addFrame(6,3);
  game.addFrame(2,5);
  game.addFrame(6,3);
  game.addFrame(2,5);
  game.addFrame(6,3);
  game.addFrame(2,5);
  game.addFrame(6,3);
  game.addFrame(2,5);
  game.addFrame(6,3);
  BOOST_CHECK_EQUAL(80, game.score());
}

// Now to add some spares and strikes
BOOST_AUTO_TEST_CASE (Game_FirstSpare)
{
  BowlingGame game;
  game.addFrame(2,5);
  game.addFrame(6,4); // spare - this score would need to be updated after the next frame
  BOOST_CHECK_EQUAL(17, game.score());
  game.addFrame(3,2); // Bonus of 3 should be added for previous spare
  BOOST_CHECK_EQUAL(25, game.score());
}

BOOST_AUTO_TEST_CASE (Game_FirstStrike)
{
  BowlingGame game;
  game.addFrame(2,5);
  game.addFrame(10,0); // STRIKE - this score would need to be updated after the next frame
  BOOST_CHECK_EQUAL(17, game.score());
  game.addFrame(3,2); // Bonus of 3 should be added for previous spare
  BOOST_CHECK_EQUAL(27, game.score());
}

BOOST_AUTO_TEST_CASE (Game_MultipleStrikes)
{
  BowlingGame game;
  game.addFrame(2,5);
  game.addFrame(10,0); // STRIKE - this score would need to be updated after the next frame
  BOOST_CHECK_EQUAL(17, game.score());
  game.addFrame(3,2); // Bonus of 3 should be added for previous spare
  BOOST_CHECK_EQUAL(27, game.score());
  game.addFrame(10,0); // STRIKE - this score would need to be updated after the next frame
  BOOST_CHECK_EQUAL(37, game.score());
  game.addFrame(10,0); // STRIKE - this score would need to be updated after the next frame plus bonus from before
  BOOST_CHECK_EQUAL(57, game.score());
  game.addFrame(7,2); // Bonus of this throw
  BOOST_CHECK_EQUAL(75, game.score());
}


BOOST_AUTO_TEST_CASE (Game_MultipleSpares)
{
  BowlingGame game;
  game.addFrame(2,5);
  game.addFrame(10,0); // STRIKE - this score would need to be updated after the next frame
  BOOST_CHECK_EQUAL(17, game.score());
  game.addFrame(3,2); // Bonus of 3 should be added for previous spare
  BOOST_CHECK_EQUAL(27, game.score());
  game.addFrame(7,3); // SPARE - this score would need to be updated after the next frame
  BOOST_CHECK_EQUAL(37, game.score());
  game.addFrame(2,8); // SPARE - this score would need to be updated after the next frame plus bonus from before
  BOOST_CHECK_EQUAL(49, game.score());
  game.addFrame(7,2); // Bonus of this throw
  BOOST_CHECK_EQUAL(65, game.score());
}

// BONUS throw at end of game
// If the 10 frame is a spare or a strike then one or two extra balls may be rolled.

BOOST_AUTO_TEST_CASE (Game_extraRollDueToFinalSpare)
{
  BowlingGame game;
  game.addFrame(2,5);
  game.addFrame(6,3);
  game.addFrame(2,5);
  game.addFrame(6,3);
  game.addFrame(2,5);
  game.addFrame(6,3);
  game.addFrame(2,5);
  game.addFrame(6,3);
  game.addFrame(2,5);
  game.addFrame(6,4);
  BOOST_CHECK_EQUAL(81, game.score());
  game.addFrame(7,0);
  BOOST_CHECK_EQUAL(88, game.score());
}

BOOST_AUTO_TEST_CASE (Game_extraRollDueToFinalStrike)
{
  BowlingGame game;
  game.addFrame(2,5);
  game.addFrame(6,3);
  game.addFrame(2,5);
  game.addFrame(6,3);
  game.addFrame(2,5);
  game.addFrame(6,3);
  game.addFrame(2,5);
  game.addFrame(6,3);
  game.addFrame(2,5);
  game.addFrame(10,0);
  BOOST_CHECK_EQUAL(81, game.score());
  game.addFrame(7,2);
  BOOST_CHECK_EQUAL(90, game.score());
}

// The basic game is now tested
// Negative test cases would now be required

BOOST_AUTO_TEST_CASE (Game_Negative_MoreThan10Skittles)
{
  BowlingGame game;
  BOOST_CHECK_THROW(game.addFrame(2,9), std::string );
}

// Infinite more test cases to go - but it is time to stop

// THE END

