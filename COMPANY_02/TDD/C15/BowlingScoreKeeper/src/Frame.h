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
	virtual ~Frame();
	int score();
	void setScore(int score);
	bool isStrike();
	void setStrike(void);
	bool isSpare();
	void setSpare(void);
	bool isLastFrame();
	int bonus();
private:
	int totalScore;
	bool spare;
	bool strike;
};

#endif /* FRAME_H_ */
