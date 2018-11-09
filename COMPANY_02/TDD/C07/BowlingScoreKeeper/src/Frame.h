/*
 * Frame.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef FRAME_H_
#define FRAME_H_

class Frame {

private:
	int  m_frameNumber;
	int  m_firstRoll;
	int  m_secondRoll;
	bool m_prevSpare;
	bool m_prevStrike;

public:
	Frame();
	Frame(int frameNumber, int firstRoll, int secondRoll, bool prevSpare = false, bool prevStrike = false);
	virtual ~Frame();
	int score();
	bool isStrike();
	bool isSpare();
	bool isLastFrame();
	int bonus();
};

#endif /* FRAME_H_ */
