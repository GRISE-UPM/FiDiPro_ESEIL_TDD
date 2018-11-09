/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

Frame::Frame(int first, int second, int third, bool last) : first(first), second(second), bonusScore(0), third(third), isLast(last) {
	// TODO Auto-generated constructor stub

}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score(){
	return first + second + third + bonusScore;
}

//returns whether the frame is a strike or not
bool Frame::isStrike(){
	//to be implemented
	return first == 10;
}

//return whether a frame is a spare or not
bool Frame::isSpare(){
	//to be implemented
	return first != 10 && first+second == 10;
}

//return whether this is the last frame of the match
bool Frame::isLastFrame(){
	//to be implemented
	return isLast;
}

//bonus throws
int Frame::bonus(){
	//to be implemented
	return bonusScore;
}

//bonus throws
void Frame::setBonus(int i){
	//to be implemented
	bonusScore = i;
}
