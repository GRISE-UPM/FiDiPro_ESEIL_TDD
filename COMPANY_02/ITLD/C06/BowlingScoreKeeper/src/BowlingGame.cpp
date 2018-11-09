/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include "Frame.h"
#include <string>

BowlingGame::BowlingGame() {

}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(Frame frame){
	Frame frame1[10] = frame;
}

void BowlingGame::setBonus(int firstThrow, int secondThrow) {
	//to be implemented
}

int BowlingGame::score(){
	//to be implemented
	int score = 0;
	//score = frame1.firstThrow + frame1.secondThrow;
	return score;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
