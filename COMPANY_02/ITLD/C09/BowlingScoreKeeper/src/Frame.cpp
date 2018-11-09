/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

Frame::Frame(int frame_index) {
	// TODO Auto-generated constructor stub
	index = frame_index;
	pins_down = 0;
	_strike = false;
	_bonus = 0;
}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

// Checks whether the validity of the input throws
bool Frame::checkThrows(int throw1, int throw2) {
	if((throw1 + throw2) > 10)
		return false;
	if((throw1 < 0) || (throw2 < 0))
		return false;
	return true;
}

// Inputs the two throws corresponding to this frame
void Frame::setThrows(int throw1, int throw2) {
	if (checkThrows(throw1, throw2)){
		pins_down = throw1 + throw2;
	}
	if (throw1 == 10)
		_strike = true;
}

//the score of a single frame
int Frame::score(){
	return pins_down+_bonus;
}

//returns whether the frame is a strike or not
bool Frame::isStrike(){
	return _strike;
}

//return whether a frame is a spare or not
bool Frame::isSpare(){
	return (pins_down == 10);
}

//return whether this is the last frame of the match
bool Frame::isLastFrame(){
	return (index == 10);
}

void Frame::set_bonus(int roll1_pinsdown, int roll2_pinsdown) {
	if(isSpare()) {
		_bonus = roll1_pinsdown;
	}
	if(isStrike()) {
		_bonus = roll1_pinsdown+roll2_pinsdown;
	}
}

//bonus throws
int Frame::bonus(){
	//If it is a spare: bonus is pins_down by the next roll
	return _bonus;
}

bool Frame::bonus_set() {
	return (_bonus != 0);
}
