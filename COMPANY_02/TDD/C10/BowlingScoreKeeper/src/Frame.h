/*
 * Frame.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef FRAME_H_
#define FRAME_H_

class Frame {
public:
	Frame();
	Frame(int throw1, int throw2);
	virtual ~Frame();
	int score();
	bool isStrike();
	bool isSpare();
	bool isLastFrame();
	int bonus();
	int getFirstthrow();
	int getSecondthrow();
	void setFirstThrow(int throw1);
	void setSecondThrow(int throw2);
	int getFrameScore(void);

private:
	int m_throw1;
	int m_throw2;
	int m_strike;
//	int totalPins = 10;
};

#endif /* FRAME_H_ */
