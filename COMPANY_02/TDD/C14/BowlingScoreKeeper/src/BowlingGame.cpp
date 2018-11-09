/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>

BowlingGame::BowlingGame() {

}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(Frame frame){
	frames.push_back(frame);
}

void BowlingGame::setBonus(int firstThrow, int secondThrow) {
	if(frames.back().isStrike()) {
		frames.back().setBonus(firstThrow+secondThrow);
	} else if(frames.back().isSpare()) {
		frames.back().setBonus(firstThrow);
	}
}

int BowlingGame::score(){
	int score = 0;
	for(std::vector<Frame>::iterator it = frames.begin(); it != frames.end(); it++) {
		score += it->score();
	}

	return score;
}

bool BowlingGame::isNextFrameBonus(){
	return frames.back().isStrike() || frames.back().isSpare();
}
