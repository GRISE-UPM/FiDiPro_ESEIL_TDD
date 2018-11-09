/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>
#include <boost/foreach.hpp>

BowlingGame::BowlingGame() {
}

BowlingGame::~BowlingGame() {
    // TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(Frame frame){
    frames.push_back(frame);
}

void BowlingGame::setBonus(int firstThrow, int secondThrow) {
    //to be implemented
}

int BowlingGame::score(){
    //to be implemented
    bool strikeInPrevious = false;
    bool spareInPrevious = false;
    bool doubleStrikeHappened = false;
    int totalScore = 0;
    for(int i = 0; i < frames.size(); i++) {
        if (strikeInPrevious) {
            frames[i-1].addScore(frames[i].score());
            if (frames[i].isStrike()) {
                doubleStrikeHappened = true;
            } else {
                strikeInPrevious = false;
        }
        } else if (spareInPrevious) {
            frames[i-1].addScore(frames[i].getFirstThrowScore());
            spareInPrevious = false;
        }

        if (frames[i].isStrike()) {
            strikeInPrevious = true;
        }
        if (frames[i].isSpare()) {
            spareInPrevious = true;
        }
    }

    Frame frame;
    BOOST_FOREACH(frame, frames) {
        totalScore += frame.score();
    }
    return totalScore;
}

bool BowlingGame::isNextFrameBonus(){
    //to be implemented
    return false;
}
