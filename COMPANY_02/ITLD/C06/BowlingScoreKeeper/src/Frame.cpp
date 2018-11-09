/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

Frame::Frame() {
	// TODO Auto-generated constructor stub
	firstThrow = 0;
	secondThrow = 0;
}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score(){
	//to be implemented
	int scoreSingle = 0;
	scoreSingle = firstThrow + secondThrow;
	return scoreSingle;
}

//returns whether the frame is a strike or not
bool Frame::isStrike(){
	//to be implemented
	return false;
}

//return whether a frame is a spare or not
bool Frame::isSpare(){
	//to be implemented
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
