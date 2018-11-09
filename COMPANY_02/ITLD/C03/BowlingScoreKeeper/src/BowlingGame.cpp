/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>
#include <numeric>

static const uint32_t MAX_GAMES_NORMAL = 10;

BowlingGame::BowlingGame() {
    frames.reserve(MAX_GAMES_NORMAL + 1);
}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(const Frame &frame){
    if (frames.size() >= MAX_GAMES_NORMAL) {
	    Frame &prev_frame = frames[frames.size() - 1];
	    if ( frames.size() > MAX_GAMES_NORMAL || (!prev_frame.isStrike() && !prev_frame.isSpare()) ) {
	        throw std::out_of_range("Too many frames for a game");
	    } else if (frame.bonusStrike() != frame.bonusSpare()) {
	        throw std::logic_error("Bonus frame has two throws");
	    }
	}
    bool apply_bonus = frames.size() < MAX_GAMES_NORMAL;
	if (frames.size() > 0) {
	    Frame &prev_frame = frames[frames.size() - 1];
	    if (prev_frame.isSpare() && apply_bonus) {
	        prev_frame.setBonus(frame.bonusSpare());
	    }
	    if (prev_frame.isStrike() && apply_bonus) {
	        prev_frame.setBonus(frame.bonusStrike());
	    }
	}

	frames.push_back(frame);
}

void BowlingGame::setBonus(int firstThrow, int secondThrow) {
	//to be implemented
}

int BowlingGame::score(){
    struct SumFrames {
        uint32_t operator()(uint32_t &lhs, const Frame &rhs) {
            return lhs + rhs.score();
        }
    };
    if (frames.size() > 0) {
        return std::accumulate(frames.begin(), frames.end(), 0U, SumFrames());
    } else {
        return 0;
    }
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
