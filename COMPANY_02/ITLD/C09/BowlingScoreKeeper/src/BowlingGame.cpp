/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>

BowlingGame::BowlingGame() : bonus(11) {
	current_frame_index = 0;
}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(){
	// Check here that index of the frame is between 0 and 10
	if(current_frame_index > 10)
		return;

	current_frame_index++;
	Frame f(current_frame_index);
	frames.push_back(f);
}

void BowlingGame::throw2(int first, int second) {
	if(current_frame_index == 0)
		return;

	Frame* current_f = &frames[current_frame_index-1];
	current_f->setThrows(first, second);

	if(current_frame_index < 2)
		return;

	// Setting bonus for previous frame, if any
	Frame* prev_f = &frames[current_frame_index-2];
	if (prev_f->bonus_set())
		return;

	prev_f->set_bonus(first, second);
}

void BowlingGame::throw3(int first, int second, int third) {

	if(current_frame_index != 10)
		return;

	Frame* current_f = &frames[current_frame_index-1];
	current_f->setThrows(first, second);

	bonus.setThrows(third, 0);

	frames.push_back(bonus); // For the score
}

void BowlingGame::setBonus(int firstThrow, int secondThrow) {
	//to be implemented
		if((frames.size() >1) && (!frames.back().bonus_set()))
		{
			frames.back().set_bonus(firstThrow, secondThrow);
		}
	return;
}

int BowlingGame::getLastRoundScore() {
	return frames.back().score();
}

int BowlingGame::getScore(int round) {
	return frames[round-1].score();
}


int BowlingGame::score(){
	int currentscore = 0;
	for(unsigned int i=0; i<frames.size();i++){
		currentscore += frames[i].score();
	}
	return currentscore;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
