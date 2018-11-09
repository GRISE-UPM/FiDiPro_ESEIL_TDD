/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

using namespace std;

Frame::Frame() {
// TODO Auto-generated constructor stub

	this->throw1 = 0;
	this->throw2 = 0;
}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

void Frame::save_throw1(int t1) {
	this->throw1 = t1;
}

int Frame::get_throw1() {
	return this->throw1;
}


void Frame::save_throw2(int t1) {
	this->throw2 = t1;
}

//the score of a single frame
int Frame::score(){
	//to be implemented
	return throw1+throw2;
}

//returns whether the frame is a strike or not
bool Frame::isStrike(){
    bool result = false;
	if (throw1 == 10){
		result = true;
	}
	return result;
}

//return whether a frame is a spare or not
bool Frame::isSpare(){
	bool result = false;
	if ((throw1 < 10 ) && (throw1 + throw2) == 10){
		result = true;
	}

    return result;
}

//return whether this is the last frame of the match
bool Frame::isLastFrame(){
	//to be implemented
	return false;
}

//bonus throws
int Frame::bonus(){
	//to be implemented
	return 0;
}
