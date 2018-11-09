/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

Frame::Frame() {
	firstThrow = 0;
	secondThrow = 0;
	thirdThrow = 0;
	bonus = 0;
}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

void Frame::setFirstThrow(unsigned int pinsKnocked) {
	firstThrow = pinsKnocked;
}

void Frame::setSecondThrow(unsigned int pinsKnocked) {
	secondThrow = pinsKnocked;
}

void Frame::setThirdThrow(unsigned int pinsKnocked) {
	thirdThrow = pinsKnocked;
}

bool Frame::isStrike() {
	if (firstThrow == 10)
		return true;
	else
		return false;
}

bool Frame::isSpare() {
	if (firstThrow + secondThrow == 10)
		return true;
	else
		return false;
}

void Frame::updateFrameScore(){
	frameScore = firstThrow + secondThrow + thirdThrow + bonus;
}

unsigned int Frame::getFrameScore(){
	updateFrameScore();
	return frameScore;
}

unsigned int Frame::getFirstThrow(){
		return firstThrow;
}

unsigned int Frame::getSecondThrow(){
		return secondThrow;
}

