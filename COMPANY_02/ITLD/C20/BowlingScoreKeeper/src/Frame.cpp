/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"

Frame::Frame(int first_throw, int second_throw) {
    m_throws[0] = first_throw;
    m_throws[1] = second_throw;
}

Frame::~Frame() {
    // TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score(){
    return this->m_throws[0] + this->m_throws[1];
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

int Frame::getFirstThrow()
{
    return this->m_throws[0];
}

int Frame::getSecondThrow()
{
    return this->m_throws[1];
}

