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
	int frameScore;
	bool strike;
	bool spare;
	bool lastFrame;
	int frameBonus;
public:
	Frame();
	Frame(int score, bool Strike, bool Spare, bool LastFrame);
	virtual ~Frame();
	int score();
	bool isStrike();
	bool isSpare();
	bool isLastFrame();
	int bonus();
	void addBonus(int);
};

#endif /* FRAME_H_ */
