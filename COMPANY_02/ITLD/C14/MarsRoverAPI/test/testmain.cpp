#define BOOST_TEST_MODULE MR_tests
#include <boost/test/unit_test.hpp>

#include <string>
#include "../src/MarsRover.h"

BOOST_AUTO_TEST_CASE (smoke_test_move_forward)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,2,N)", rover.executeCommand("ff"));
}

BOOST_AUTO_TEST_CASE (smoke_test_move_forward_and_backward)
{
  MarsRover rover(100,100,"");
  BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand("fb"));
}

BOOST_AUTO_TEST_CASE(smoke_test_wrap_around) {
	MarsRover rover(5,5,"");
	BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand("fffff"));
}

BOOST_AUTO_TEST_CASE(smoke_test_wrap_around_backwards) {
	MarsRover rover(5,5,"");
	BOOST_CHECK_EQUAL("(0,4,N)", rover.executeCommand("b"));
}

BOOST_AUTO_TEST_CASE(smoke_test_turn_right_test) {
	MarsRover rover(5,5,"");
	BOOST_CHECK_EQUAL("(0,0,E)", rover.executeCommand("r"));
}

BOOST_AUTO_TEST_CASE(smoke_test_turn_right_turn_right_test) {
	MarsRover rover(5,5,"");
	BOOST_CHECK_EQUAL("(0,0,S)", rover.executeCommand("rr"));
}

BOOST_AUTO_TEST_CASE(smoke_test_turn_left_turn_right_test) {
	MarsRover rover(5,5,"");
	BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand("lr"));
}

BOOST_AUTO_TEST_CASE(smoke_test_turn_around_from_right) {
	MarsRover rover(5,5,"");
	BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand("rrrr"));
}

BOOST_AUTO_TEST_CASE(smoke_test_turn_around_from_left) {
	MarsRover rover(5,5,"");
	BOOST_CHECK_EQUAL("(0,0,N)", rover.executeCommand("llll"));
}

BOOST_AUTO_TEST_CASE(smoke_test_turn_right_then_move_forward) {
	MarsRover rover(5,5,"");
	BOOST_CHECK_EQUAL("(1,0,E)", rover.executeCommand("rf"));
}

BOOST_AUTO_TEST_CASE(smoke_test_turn_left_then_move_forward_wrap) {
	MarsRover rover(5,5,"");
	BOOST_CHECK_EQUAL("(4,0,W)", rover.executeCommand("lf"));
}

BOOST_AUTO_TEST_CASE(smoke_test_turn_rigth_then_move_forward_until_wrap) {
	MarsRover rover(5,5,"");
	BOOST_CHECK_EQUAL("(0,0,E)", rover.executeCommand("rfffff"));
}

BOOST_AUTO_TEST_CASE(smoke_test_check_collision) {
	MarsRover rover(5,5,"(0,1)");
	BOOST_CHECK_EQUAL("(0,0,N)(0,1)", rover.executeCommand("f"));
}

BOOST_AUTO_TEST_CASE(smoke_test_check_collision_twice_report_once) {
	MarsRover rover(5,5,"(0,1)");
	BOOST_CHECK_EQUAL("(0,0,N)(0,1)", rover.executeCommand("ff"));
}

BOOST_AUTO_TEST_CASE(smoke_test_check_collision_and_moving) {
	MarsRover rover(3,3,"(0,2)");
	BOOST_CHECK_EQUAL("(1,1,E)(0,2)", rover.executeCommand("ffrf"));
}
