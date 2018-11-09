/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

Frame::Frame() {

}

Frame::Frame(int throw1, int throw2) {
	// TODO Auto-generated constructor stub
	setFirstThrow(throw1);
	setSecondThrow(throw2);
	m_strike = 0;
}


Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score(){
	//to be implemented
	return 0;
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

int Frame::getFirstthrow() {
	return m_throw1;
}

int Frame::getSecondthrow() {
	return m_throw2;
}

void Frame::setFirstThrow(int throw1) {
	 m_throw1 = throw1;
}

void Frame::setSecondThrow(int throw2) {
	m_throw2 = throw2;
}

int Frame::getFrameScore(void) {
	return m_throw1 + m_throw2;
}
