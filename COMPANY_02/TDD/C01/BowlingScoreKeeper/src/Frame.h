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
	Frame(int throwOne, int throwTwo, bool isLast = false);
	virtual ~Frame();
	int score();
	bool isStrike();
	bool isSpare();
	bool isLastFrame();
	int firstThrowScore();
	int bonus();

private:
	int firstThrow;
	int secondThrow;
	bool isLast;
};

#endif /* FRAME_H_ */
