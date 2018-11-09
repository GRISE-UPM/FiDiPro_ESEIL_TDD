/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>

#include <iostream>

BowlingGame::BowlingGame() {
	bonus = 0;
}

BowlingGame::~BowlingGame() {
	if (bonus)
		delete bonus;
}

void BowlingGame::addFrame(Frame frame) {
	frames.push_back(frame);
}

void BowlingGame::setBonus(int firstThrow, int secondThrow) {
	bonus = new Frame(firstThrow, secondThrow, false);
	//bonus.set(firstThrow, secondThrow);
}

int BowlingGame::score(){
	int score = 0;
	std::vector<Frame>::iterator i;
	int bonus_rolls = 0;

	for (i = frames.begin(); i != frames.end(); i++) {
		if (bonus_rolls >= 2) {
			score += i->score();
			if (i->isStrike())
				bonus_rolls--;
			else
				bonus_rolls -= 2;
		}
		else if (bonus_rolls == 1) {
			score += i->getFirst();
			bonus_rolls--;
		}
		score += i->score();
		if (i->isSpare())
			bonus_rolls++;
		else if (i->isStrike())
			bonus_rolls += 2;
	}
	if (bonus) {
		score += bonus->score();
		if (bonus_rolls >= 2) {
			score += bonus->score();
			if (bonus->isStrike()) {
				score += bonus->getSecond();
			}
		} else if (bonus_rolls == 1) {
			score += bonus->getFirst();
		}
	}
	return score;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
