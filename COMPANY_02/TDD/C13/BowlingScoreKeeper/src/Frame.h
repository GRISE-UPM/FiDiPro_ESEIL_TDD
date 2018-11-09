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
	Frame(int first, int second, bool last);
	virtual ~Frame();
	int score();
	bool isStrike();
	bool isSpare();
	bool isLastFrame();
	void setBonus(int bonus);
	int bonus();
	int getFirst();
	int getSecond();
private:
	int score1, score2;
	int scorebonus;
	bool last;
};

#endif /* FRAME_H_ */
