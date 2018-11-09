/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

Frame::Frame(int firstThrow, int secondThrow)  {
    m_firstThrow = firstThrow;
    m_secondThrow = secondThrow;
    m_additionalScore = 0;
}

Frame::Frame() {};

Frame::~Frame() {
    // TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score(){
    return m_firstThrow + m_secondThrow + m_additionalScore;
}

//returns whether the frame is a strike or not
bool Frame::isStrike(){
    if (m_firstThrow == 10) {
        return true;
    }
    return false;
}

//return whether a frame is a spare or not
bool Frame::isSpare(){
    return (m_firstThrow != 10 && m_firstThrow + m_secondThrow == 10);
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
int Frame::getFirstThrowScore() {
    return m_firstThrow;
}

int Frame::getSecondThrowScore() {
    return m_secondThrow;
}

void Frame::addScore(int additionalScore) {
    m_additionalScore += additionalScore;
}
