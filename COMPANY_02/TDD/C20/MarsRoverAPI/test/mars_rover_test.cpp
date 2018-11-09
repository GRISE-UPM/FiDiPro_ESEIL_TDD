#include "../src/MarsRover.h"

#define BOOST_TEST_MAIN
#define BOOST_TEST_DYN_LINK
#include <boost/test/unit_test.hpp>

// Default values
int planet_x_default = 100;
int planet_y_default = 100;
string obstacles_empty("");

BOOST_AUTO_TEST_CASE(planet_is_created_with_correct_size)
{
    MarsRover rover(planet_x_default, planet_y_default, obstacles_empty);
    BOOST_CHECK_EQUAL(rover.getPlanetSize(), std::to_string(planet_x_default) + "x" + std::to_string(planet_y_default));
}

BOOST_AUTO_TEST_CASE(rover_lands_at_0_0_N)
{
    MarsRover rover(planet_x_default, planet_y_default, obstacles_empty);
    BOOST_CHECK_EQUAL(rover.getPosition(), "0,0,N");
}

BOOST_AUTO_TEST_CASE(empty_command_returns_position) // This was not clear in the instructions
{
    MarsRover rover(planet_x_default, planet_y_default, obstacles_empty);
    BOOST_CHECK_EQUAL(rover.executeCommand(""), "0,0,N");
}

BOOST_AUTO_TEST_CASE(rover_turns_left)
{
    MarsRover rover(planet_x_default, planet_y_default, obstacles_empty);
    rover.executeCommand("l");

    BOOST_CHECK_EQUAL(rover.getPosition(), "0,0,W");
}

BOOST_AUTO_TEST_CASE(rover_turns_right)
{
    MarsRover rover(planet_x_default, planet_y_default, obstacles_empty);
    rover.executeCommand("r");

    BOOST_CHECK_EQUAL(rover.getPosition(), "0,0,E");
}

BOOST_AUTO_TEST_CASE(rover_moves_forward)
{
    MarsRover rover(planet_x_default, planet_y_default, obstacles_empty);
    rover.executeCommand("f");

    BOOST_CHECK_EQUAL(rover.getPosition(), "0,1,N");
}

BOOST_AUTO_TEST_CASE(rover_moves_backward)
{
    MarsRover rover(planet_x_default, planet_y_default, obstacles_empty);
    rover.executeCommand("f"); // If previous testcase passed this works
    rover.executeCommand("b");

    BOOST_CHECK_EQUAL(rover.getPosition(), "0,0,N");
}

BOOST_AUTO_TEST_CASE(rover_accepts_sequence_of_commands)
{
    MarsRover rover(planet_x_default, planet_y_default, obstacles_empty);
    rover.executeCommand("ffrff");

    BOOST_CHECK_EQUAL(rover.getPosition(), "2,2,E");
}

BOOST_AUTO_TEST_CASE(rover_wraps_around_planet)
{
    MarsRover rover(planet_x_default, planet_y_default, obstacles_empty);
    rover.executeCommand("blf");

    BOOST_CHECK_EQUAL(rover.getPosition(), "99,99,W");
}
