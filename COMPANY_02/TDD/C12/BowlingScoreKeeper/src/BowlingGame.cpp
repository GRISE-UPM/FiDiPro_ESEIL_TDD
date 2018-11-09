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
	//to be implemented
}

int BowlingGame::score(){
	int score = 0;
	for (std::vector<Frame>::iterator it = frames.begin(); it != frames.end(); ++it) {
		if (it->isStrike()) {
			score += (it->score() + (it+1)->score());
		} else if (it->isSpare()) {
			score += (10 + (it+1)->getFirst());
		} else {
			score += it->score();
		}
	}
	return score;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
