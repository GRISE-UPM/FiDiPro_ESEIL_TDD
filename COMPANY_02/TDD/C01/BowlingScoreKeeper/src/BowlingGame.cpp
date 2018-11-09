/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"

#include <string>

BowlingGame::BowlingGame(): bonus(Frame(0,0)) {

}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(Frame frame){
	frames.push_back(frame);
}

void BowlingGame::setBonus(int firstThrow, int secondThrow) {
	bonus = Frame(firstThrow,secondThrow);
}

int BowlingGame::score(){
	int sum = 0;


	for	(unsigned int i = 0; i < frames.size(); i++){

		if (frames[i].isStrike()){

			if (frames[i].isStrike() && frames[i+1].isStrike()){
				sum += (frames[i].score() + frames[i+1].score() +frames[i+2].firstThrowScore());
			}else if (frames[i].isStrike() && frames[i-1].isStrike()){
				sum += frames[i].score() + frames[i+1].score();
			}
			else
			{
				sum += (frames[i].score() + frames[i+1].score());
			}
		}

		else if(frames[i].isSpare())
		{
			if (i < frames.size()-1) {
				sum += frames[i].score()+ frames[i+1].firstThrowScore();
			}
			if(i == frames.size()-1){
				//sum+= 10 + bonus.score();
			}
		}
		else {
			sum += frames[i].score();
		}
	}
	return sum;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
