/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>
using namespace std;

BowlingGame::BowlingGame() {
}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(Frame frame){
	//to be implemented
	if ((frames.size() < 9) && (frame.isLastFrame() == true))
		throw string("Only frame 10 can be the last frame!");

	/*check if there is a need to add bonus to previous frame*/
	if (frames.size() > 0){
		//previous frame currently at the end of vector
		if (frames.end()->isSpare()){
			frames.end()->addBonus(frame.score());
		}
	}

	frames.insert(frames.end(), frame);
}

void BowlingGame::setBonus(int firstThrow, int secondThrow) {
	//to be implemented
}

int BowlingGame::score(){
	int totalScore = 0;
	//to be implemented
	for (std::vector<Frame>::iterator it = frames.begin() ; it != frames.end(); ++it){
		totalScore += it->score() + it->bonus();
	}
	return totalScore;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
