/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

Frame::Frame(int firstThrow, int secondThrow, bool isLast):firstThrow(firstThrow), secondThrow(secondThrow), isLast(isLast) {

}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score(){
	return firstThrow + secondThrow;
}

//returns whether the frame is a strike or not
bool Frame::isStrike(){
	if (firstThrow == 10)
		return true;
	else
		return false;
}

//return first throws score
int Frame::firstThrowScore(){
	return firstThrow;
}

//return whether a frame is a spare or not
bool Frame::isSpare(){

	if (firstThrow == 10)
		return false;

	if ((firstThrow + secondThrow) == 10)
		return true;

	return false;
}

//return whether this is the last frame of the match
bool Frame::isLastFrame(){
	return isLast;
}

//bonus throws
int Frame::bonus(){
	//to be implemented
	return 0;
}
