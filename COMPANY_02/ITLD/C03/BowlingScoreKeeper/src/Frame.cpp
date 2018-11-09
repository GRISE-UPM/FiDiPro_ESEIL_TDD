/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

static const uint32_t MAX_SCORE = 10;

Frame::Frame(uint32_t _first_score, uint32_t _second_score) :
    score_first(_first_score), score_second(_second_score), bonus_score(0) {
    if ((score_first + score_second) > MAX_SCORE) {
        throw std::logic_error("Frame constructed with illegal score");
    }
}

Frame::~Frame() {}

//the score of a single frame
uint32_t Frame::score() const {
	return score_first + score_second + bonus_score;
}

//returns whether the frame is a strike or not
bool Frame::isStrike() const {
	return (score_first == 10);
}

//return whether a frame is a spare or not
bool Frame::isSpare() const {
	return (((score_first + score_second) == 10) && score_first != 10);
}

//bonus throws
uint32_t Frame::bonusSpare() const {
	return score_first;
}

uint32_t Frame::bonusStrike() const {
    return score_first + score_second;
}

void Frame::setBonus(uint32_t bonus) {
    if (bonus > MAX_SCORE) {
        throw std::logic_error("Requested illegal bonus amount");
    } else if (bonus_score > 0) {
        throw std::logic_error("Bonus already initialized");
    }
    bonus_score = bonus;
}
