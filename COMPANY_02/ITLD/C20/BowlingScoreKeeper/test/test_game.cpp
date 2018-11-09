#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/Frame.h"
#include "../src/BowlingGame.h"

int first_throw_default = 3;
int second_throw_default = 2;

//vector<Frame> frames = {frame0,frame1,frame2,frame3,frame4,frame5,frame6,frame7,frame8,framer9};
vector<Frame> frames = {Frame(1,5), Frame(3,6), Frame(7,2), Frame(3,6), Frame(4,4), Frame(5,3), Frame(3,3), Frame(4,5), Frame(8,1), Frame(2,6)};


BOOST_AUTO_TEST_CASE (game_is_defined)
{
    BowlingGame game(frames);
    BOOST_CHECK_EQUAL_COLLECTIONS(frames.begin(), frames.end(), game.getFrames().begin(), game.getFrames().end());
}
