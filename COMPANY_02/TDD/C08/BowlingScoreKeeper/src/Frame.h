/*
 * Frame.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef FRAME_H_
#define FRAME_H_

using namespace std;

class Frame {
protected:
	int throw1;
	int throw2;
public:
	Frame();
	//void throw2 (int throw2);
	void save_throw1(int t1);
	int get_throw1();
	void save_throw2(int t1);
	virtual ~Frame();
	int score();
	bool isStrike();
	bool isSpare();
	bool isLastFrame();
	int bonus();
};

#endif /* FRAME_H_ */
