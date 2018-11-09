/*
 * Frame.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef FRAME_H_
#define FRAME_H_

class Frame {
	int first;
	int second;
public:
	Frame();
	Frame(int, int);
	virtual ~Frame();
	int score();
	bool isStrike();
	bool isSpare();
	bool isLastFrame();
	int bonus();

	// test helpers
	int getFirst() { return first; }
	int getSecond() { return second; }
};

#endif /* FRAME_H_ */
