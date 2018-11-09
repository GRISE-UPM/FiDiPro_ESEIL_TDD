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
	int first, second, third, bonusScore;
	bool isLast;

public:
	Frame(int first = 0, int second = 0, int third=0, bool isLast = false);
	virtual ~Frame();
	int score();
	bool isStrike();
	bool isSpare();
	bool isLastFrame();
	void setBonus(int bonus);
	int bonus();
};

#endif /* FRAME_H_ */
