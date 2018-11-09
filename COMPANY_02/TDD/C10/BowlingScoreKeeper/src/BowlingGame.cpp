/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

BowlingGame::BowlingGame(string sequenceOfFrames){
	//	if (gameSize < 10) {
	//		frames.resize(10);
	//	} else {
	//		frames.resize(gameSize);
	//	}
	//	for (int i = 0; i< gameSize; i++) {
	//		addFrame()
	//	}
	int throw1, throw2;
	for (size_t i = 0; i < sequenceOfFrames.length(); i++) {
		if (sequenceOfFrames.c_str()[i] == '[') {
			throw1 = atoi(sequenceOfFrames.c_str() + (i + 1));
			continue;
		}
		if (sequenceOfFrames.c_str()[i] == ',') {
			throw2 = atoi(sequenceOfFrames.c_str() + (i + 1));
			Frame frame(throw1, throw2);
			addFrame(frame);
			continue;
		}
	}
}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(Frame frame){
	//to be implemented
	frames.push_back(frame);
}

void BowlingGame::setBonus(int firstThrow, int secondThrow) {
	//to be implemented
}

int BowlingGame::score(){
	//to be implemented
	return 0;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}

int BowlingGame::getGameSize() {
	return frames.size();
}

int BowlingGame::getScore() {
	int sum = 0;

	for (size_t i = 0; i < frames.size(); i++) {
		if (frames[i].getFirstthrow() == 10 && ((i + 1) < frames.size())) {
			if (frames.at(i + 1).getFirstthrow() == 10 &&((i + 2) < frames.size())) {
				sum += frames.at(i + 2).getFrameScore();
			}
			sum += frames.at(i + 1).getFrameScore();
		}
		if (frames[i].getFrameScore() == 10 && frames[i].getFirstthrow() != 10 && ((i + 1) < frames.size())) {
			sum += frames.at(i + 1).getFirstthrow();
		}
		sum += frames[i].getFrameScore();
	}
	return sum;
}
