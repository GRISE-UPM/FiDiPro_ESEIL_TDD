#define BOOST_TEST_MODULE MR_tests
#include <boost/test/included/unit_test.hpp>

#include <string>
#include <cstdint>
#include <sstream>
#include "../src/MarsRover.h"

static const uint32_t INIT_X = 0;
static const uint32_t INIT_Y = 0;
static const uint32_t MAP_X_MAX = 100;
static const uint32_t MAP_Y_MAX = 100;

struct MarsRoverTestFixtureBase {
    MarsRoverTestFixtureBase(const std::string &obstacles) : rover(MAP_X_MAX, MAP_Y_MAX, obstacles) {}

    MarsRover rover;
};

std::string buildPosition(int x, int y, char direction) {
    std::stringstream ss;
    ss << "(" << x << "," << y << "," << direction << ")";
    return ss.str();
}

struct MarsRoverTestFixtureNoObstacles : MarsRoverTestFixtureBase {
    MarsRoverTestFixtureNoObstacles() : MarsRoverTestFixtureBase("") {}
};

BOOST_FIXTURE_TEST_SUITE(MarsRoverNoObstaclesTests, MarsRoverTestFixtureNoObstacles)

BOOST_AUTO_TEST_CASE (empty_command_returns_current_position)
{
  BOOST_CHECK_EQUAL(buildPosition(INIT_X, INIT_Y, 'N'), rover.executeCommand(""));
}

BOOST_AUTO_TEST_CASE( mars_rover_is_able_to_turn_left ) {
    BOOST_CHECK_EQUAL(buildPosition(INIT_X, INIT_Y, 'W'), rover.executeCommand("l"));
    BOOST_CHECK_EQUAL(buildPosition(INIT_X, INIT_Y, 'S'), rover.executeCommand("l"));
    BOOST_CHECK_EQUAL(buildPosition(INIT_X, INIT_Y, 'E'), rover.executeCommand("l"));
    BOOST_CHECK_EQUAL(buildPosition(INIT_X, INIT_Y, 'N'), rover.executeCommand("l"));
}

BOOST_AUTO_TEST_CASE( mars_rover_is_able_to_turn_right ) {
    BOOST_CHECK_EQUAL(buildPosition(INIT_X, INIT_Y, 'E'), rover.executeCommand("r"));
    BOOST_CHECK_EQUAL(buildPosition(INIT_X, INIT_Y, 'S'), rover.executeCommand("r"));
    BOOST_CHECK_EQUAL(buildPosition(INIT_X, INIT_Y, 'W'), rover.executeCommand("r"));
    BOOST_CHECK_EQUAL(buildPosition(INIT_X, INIT_Y, 'N'), rover.executeCommand("r"));
}

BOOST_AUTO_TEST_CASE( mars_rover_is_able_to_move_forward_and_backward ) {
    BOOST_CHECK_EQUAL(buildPosition(INIT_X, INIT_Y + 1, 'N'), rover.executeCommand("f"));
    BOOST_CHECK_EQUAL(buildPosition(INIT_X, INIT_Y, 'N'), rover.executeCommand("b"));
    rover.executeCommand("r");
    BOOST_CHECK_EQUAL(buildPosition(INIT_X + 1, INIT_Y, 'E'), rover.executeCommand("f"));
}

BOOST_AUTO_TEST_CASE( mars_rover_executes_arbitrary_sequence_of_commands ) {
    BOOST_CHECK_EQUAL(buildPosition(INIT_X + 1, INIT_Y, 'E'), rover.executeCommand("fbrf"));
}

BOOST_AUTO_TEST_CASE( mars_rover_wraps_position_in_the_world_map ) {
    BOOST_CHECK_EQUAL(buildPosition(INIT_X, 99, 'N'), rover.executeCommand("b"));
    BOOST_CHECK_EQUAL(buildPosition(99, 99, 'W'), rover.executeCommand("lf"));
}

BOOST_AUTO_TEST_SUITE_END()

const std::string obstacles_default = "(2,2)(0,5)(5,0)";

struct MarsRoverTestFixtureObstacles : MarsRoverTestFixtureBase {
    MarsRoverTestFixtureObstacles() : MarsRoverTestFixtureBase("(2,2)(0,5)(5,0)") {}
};

BOOST_FIXTURE_TEST_SUITE(MarsRoverObstaclesTests, MarsRoverTestFixtureObstacles)

BOOST_AUTO_TEST_CASE( location_of_obstacles_is_correct ) {
    BOOST_CHECK_EQUAL(rover.grid[0][0], CELL_FREE);
    BOOST_CHECK_EQUAL(rover.grid[2][2], CELL_NON_FOUND_OBSTACLE);
    BOOST_CHECK_EQUAL(rover.grid[0][5], CELL_NON_FOUND_OBSTACLE);
    BOOST_CHECK_EQUAL(rover.grid[5][0], CELL_NON_FOUND_OBSTACLE);
}

BOOST_AUTO_TEST_CASE( rover_reports_obstacle ) {
    BOOST_CHECK_EQUAL(buildPosition(1, 2, 'E') + "(2,2)", rover.executeCommand("ffrfff"));
}

BOOST_AUTO_TEST_CASE( tour_around_the_planet ) {
    MarsRover another_rover(6,6,obstacles_default);
    BOOST_CHECK_EQUAL(std::string("(0,0,N)(2,2)(0,5)(5,0)"), another_rover.executeCommand("ffrfffrbbblllfrfrbbl"));
}

BOOST_AUTO_TEST_SUITE_END()
