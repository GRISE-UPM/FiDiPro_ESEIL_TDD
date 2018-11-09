/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>

BowlingGame::BowlingGame(): _bonus(0) {
}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(Frame frame){
	frames.push_back(frame);
}

int BowlingGame::nrFrames() {
	return frames.size();
}

void BowlingGame::addBonus(int f, int s) {
    _bonus=new Frame(f, s);
}

int BowlingGame::score(){
	int total=0;
	bool previsstrike=false;
	bool previsspare=false;
	bool prev2isstrike=false;
	for(unsigned int i=0;i<frames.size();i++) {
		int sf;
		if((sf=frames[i].score())<0) {
			return -1;
		}
		if(previsstrike) {
			sf=2*sf;
			if(prev2isstrike) {
				sf+=frames[i].first();
			}
		} else if(previsspare) {
			sf+=frames[i].first();
		}
		total+=sf;
		prev2isstrike=previsstrike;
		previsstrike=frames[i].isStrike();
		previsspare=frames[i].isSpare();
    }
	if(_bonus) {
		total+=_bonus->score();
	}
	return total;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
