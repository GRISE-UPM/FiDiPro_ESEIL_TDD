/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

Frame::Frame() {

}

Frame::Frame(int firstThrow, int secondThrow): firstThrow(firstThrow), secondThrow(secondThrow), bonusPoints(0) {

}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score(){
	//to be implemented
	return firstThrow + secondThrow;
}

//returns whether the frame is a strike or not
bool Frame::isStrike(){
	if (firstThrow == 10) return true;
	return false;
}

//return whether a frame is a spare or not
bool Frame::isSpare(){
	if (firstThrow < 10 && (firstThrow + secondThrow == 10)) return true;
	return false;
}

//return whether this is the last frame of the match
bool Frame::isLastFrame(){
	//to be implemented
	return false;
}

//bonus throws
int Frame::bonus(int throws){
	return throws==1?firstThrow:firstThrow+secondThrow;
}

void setScore(int score) {
	// scorePoints = score;
}


