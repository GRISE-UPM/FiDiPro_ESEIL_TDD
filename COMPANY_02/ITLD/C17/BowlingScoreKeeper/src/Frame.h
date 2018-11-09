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
	int _first;
	int _second;
public:
	Frame();
	Frame(int a[2]);
	Frame(int a, int b);
	virtual ~Frame();
	int score();
	bool isStrike();
	bool isSpare();
	bool isLastFrame();
	int bonus();
	int first() { return _first; }
};

#endif /* FRAME_H_ */
