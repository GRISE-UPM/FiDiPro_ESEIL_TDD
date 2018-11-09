/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>
#include "Frame.h"

BowlingGame::BowlingGame(): activeFrameId(0) {
}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(Frame frame){
	frames.insert(frames.end(),frame); // iterator insert (iterator position, const value_type& val);
	activeFrameId++;
}

void BowlingGame::setBonus(int firstThrow, int seconThrow) {
	//to be implemented
}

int BowlingGame::score(){
	scorePoints = 0; // Init
	for (int i=0;i<activeFrameId;++i)
		scorePoints += frames.at(i).score();

	if (activeFrameId > 0)
		for (int i=1;i<activeFrameId;++i) {
			int bonusThrows = 0; // Init

			if (frames.at(i-1).isSpare()) bonusThrows = 1;
			if (frames.at(i-1).isStrike()) bonusThrows = 2;
			if (bonusThrows > 0) scorePoints += frames.at(i).bonus(bonusThrows);
		}

	return scorePoints;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
