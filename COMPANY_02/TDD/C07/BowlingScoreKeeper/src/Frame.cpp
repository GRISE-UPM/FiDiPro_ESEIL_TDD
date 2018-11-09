/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"
#include "iostream"


Frame::Frame() {
	m_frameNumber = -1;
	m_firstRoll   = -1;
	m_secondRoll  = -1;
	m_prevSpare   = false;
	m_prevStrike  = false;

}

Frame::Frame(int frameNumber, int firstRoll, int secondRoll, bool prevSpare, bool prevStrike) {
	m_frameNumber = frameNumber;
	m_firstRoll   = firstRoll;
	m_secondRoll  = secondRoll;
	m_prevSpare   = prevSpare;
	m_prevStrike  = prevStrike;


}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score(){
	if (m_frameNumber != 11) {
	  if (m_prevSpare)
	    return m_firstRoll + m_secondRoll + m_firstRoll;
	  else if (m_prevStrike)
	    return 2*(m_firstRoll + m_secondRoll);
	  return (m_firstRoll + m_secondRoll);
	} else {
		if (m_prevStrike) {
			return (m_firstRoll + m_secondRoll);
		} else {  // Must be spare
			// Even if the second roll is cast (i.e. cheating) the roll is not counted
			return (m_firstRoll);
		}
	}
}

//returns whether the frame is a strike or not
bool Frame::isStrike(){
	//to be implemented
	if (m_firstRoll == 10 && m_secondRoll == 0) {
		return true;
	}
	return false;
}

//return whether a frame is a spare or not
bool Frame::isSpare(){
	if (isStrike())
		return false;
	if (m_firstRoll + m_secondRoll == 10)
			return true;
	return false;
}

//return whether this is the last frame of the match
bool Frame::isLastFrame(){
	if (m_frameNumber == 11) {
		return true;
	} else if (m_frameNumber == 10) {
		if (m_firstRoll + m_secondRoll < 10)
			return true;

	}
	return false;
}

//bonus throws
int Frame::bonus(){
	//to be implemented
	return 0;
}
