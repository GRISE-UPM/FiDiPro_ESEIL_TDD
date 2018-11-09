#define BOOST_TEST_MODULE BSK_tests
#include <boost/test/included/unit_test.hpp>

#include "../src/Frame.h"

int first_throw_default = 3;
int second_throw_default = 2;

BOOST_AUTO_TEST_CASE (first_and_second_throws_are_correctly_stored_and_distinguishable)
{
  Frame frame(first_throw_default, second_throw_default);

  BOOST_CHECK_EQUAL(first_throw_default, frame.getFirstThrow());
  BOOST_CHECK_EQUAL(second_throw_default, frame.getSecondThrow());
}

BOOST_AUTO_TEST_CASE (score_is_calculated_correctly_as_sum_of_throws)
{
  Frame frame(first_throw_default, second_throw_default);

  BOOST_CHECK_EQUAL(first_throw_default + second_throw_default, frame.score());
}
