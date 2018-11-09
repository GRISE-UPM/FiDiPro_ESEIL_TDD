/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>

BowlingGame::BowlingGame(vector<Frame> passed_frames)
{
    frames = passed_frames;
}

BowlingGame::~BowlingGame() {
    // TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(Frame frame){
    //to be implemented
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

std::vector<Frame> BowlingGame::getFrames()
{
    return this->frames;
}
