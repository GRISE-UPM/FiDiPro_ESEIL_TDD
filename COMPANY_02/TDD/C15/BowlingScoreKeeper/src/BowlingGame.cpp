/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>

BowlingGame::BowlingGame() {
	max_rounds = 10;
	round=0;
}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(Frame frame){

	frames.push_back(frame);

}

void BowlingGame::setBonus(int firstThrow, int secondThrow, int thirdThrow) {
	Frame frame;
	int frameScore = firstThrow + secondThrow + thirdThrow;
	if(firstThrow < 10 && firstThrow + secondThrow == 10){
		frameScore = 10 + secondThrow + thirdThrow;
		frame.setScore(frameScore);
		frame.setSpare();
		addFrame(frame);
	} else if (firstThrow ==10){
		frameScore = 10 + secondThrow + thirdThrow;
		frame.setScore(frameScore);
		frame.setSpare();
		addFrame(frame);
	}

}

int BowlingGame::score(){
	int score = 0;

	for(std::vector<Frame>::iterator it = frames.begin(); it != frames.end(); ++it){
		Frame frame = *it;
		score += frame.score();
	}
	return score;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
