/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

Frame::Frame() {
	first = -1;
	second = -1;
}

Frame::Frame(int throw1, int throw2) {
	// TODO Auto-generated constructor stub
	first = throw1;
	second = throw2;
}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score(){
	return ( first + second );
}

//returns whether the frame is a strike or not
bool Frame::isStrike(){
	if (first == 10)
		return true;
	return false;
}

//return whether a frame is a spare or not
bool Frame::isSpare(){
	if (!this->isStrike() && (first + second == 10))
		return true;
	return false;
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
