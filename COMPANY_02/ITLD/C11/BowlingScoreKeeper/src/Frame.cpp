/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"
#include <string>
using namespace std;

Frame::Frame() {
	// TODO Auto-generated constructor stub
	frameScore = 0;
	strike = false;
	spare = false;
	lastFrame = false;
	frameBonus = 0;
}

Frame::Frame(int score, bool Strike, bool Spare, bool LastFrame){

	if (score < 0)
		throw string("Frame score has to be positive");

	if(!(lastFrame) && score > 10)
		throw string("too much is too much");

	frameScore = score;
	strike = Strike;
	spare = Spare;
	lastFrame = LastFrame;
	frameBonus = 0;
}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score(){
	//to be implemented
	return frameScore;
}

//returns whether the frame is a strike or not
bool Frame::isStrike(){
	//to be implemented
	return strike;
}

//return whether a frame is a spare or not
bool Frame::isSpare(){
	//to be implemented
	return spare;
}

//return whether this is the last frame of the match
bool Frame::isLastFrame(){
	//to be implemented
	return lastFrame;
}

//bonus throws
int Frame::bonus(){
	//to be implemented
	return 0;
}

//add bonus to a frame
void Frame::addBonus(int value){
	frameBonus += value;
	return;
}
