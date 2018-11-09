/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

const int Frame::NUM_PINS = 10;

Frame::Frame():
		m_throw1(0),
		m_throw2(0) {
	// TODO Auto-generated constructor stub

}

bool Frame::setThrow(const int throwId, const int pins) {
	if (throwId == 1) {
		m_throw1 = pins;
	} else if (throwId == 2) {
		m_throw2 = pins;
	}
	return true;
}

int Frame::getThrow(const int throwId) const {
	if (throwId == 1) {
		return m_throw1;
	} else if (throwId == 2) {
		return m_throw2;
	}
}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score() const {
	if ((m_throw1 + m_throw2) > Frame::NUM_PINS) {
		return -1;
	} else {
		return m_throw1 + m_throw2;
	}
}

//returns whether the frame is a strike or not
bool Frame::isStrike() const{
	if (m_throw1 == 10 && m_throw2 == 0) {
		return true;
	}
	return false;
}

//return whether a frame is a spare or not
bool Frame::isSpare() const {
	return (m_throw1 + m_throw2 == Frame::NUM_PINS)? true : false;
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
