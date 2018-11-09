/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

Frame::Frame() {
	score1 = 0;
	score2 = 0;
	scorebonus = 0;
	last = 0;
}

Frame::Frame(int first, int second, bool isLast)
{
	score1 = first;
	score2 = second;
	scorebonus = 0;
	last = isLast;
}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score(){
	return score1 + score2 + scorebonus;
}

//returns whether the frame is a strike or not
bool Frame::isStrike(){
	return score1 == 10;
}

//return whether a frame is a spare or not
bool Frame::isSpare(){
	return (score1 != 10) && (score1 + score2 == 10);
}

//return whether this is the last frame of the match
bool Frame::isLastFrame(){
	return last;
}

void Frame::setBonus(int bonus)
{
	scorebonus = bonus;
}

//bonus throws
int Frame::bonus(){
	return scorebonus;
}

int Frame::getFirst() {
	return score1;
}

int Frame::getSecond() {
	return score2;
}
