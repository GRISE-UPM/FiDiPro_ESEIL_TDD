/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>
#include "iostream"

BowlingGame::BowlingGame() {
	frameNumber = 1;
}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(int firstThrow, int secondThrow){
	if ((firstThrow + secondThrow) > 10)
		throw string("There are not that many skittles used in a game of bowling");

	cout << "Frame" << frameNumber << endl;
	if (frameNumber == 1) {
	    frames.push_back(Frame(frameNumber, firstThrow, secondThrow));
    } else {
    	cout << "BOOL: " << frames.at(frameNumber - 2).isSpare() << endl;
    	frames.push_back(Frame(frameNumber, firstThrow, secondThrow, frames.at(frameNumber - 2).isSpare(), frames.at(frameNumber - 2).isStrike()));
    	//frames.push_back(Frame(frameNumber, firstThrow, secondThrow));
    }
	cout << "OK" << endl;
	frameNumber++;
}

void BowlingGame::setBonus(int firstThrow, int secondThrow) {
	//to be implemented
}

int BowlingGame::score(){
	//to be implemented
	cout << frameNumber << endl;
	int gameScore = 0;
    for (int i = 1; i < frameNumber; i++) {
    	gameScore += frames.at(i - 1).score();
    }
	return gameScore;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
