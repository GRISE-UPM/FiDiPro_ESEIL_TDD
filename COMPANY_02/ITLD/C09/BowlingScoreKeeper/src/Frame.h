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
	Frame(int frame_index);
	virtual ~Frame();
	static bool checkThrows(int throw1, int throw2);
	void setThrows(int throw1, int throw2);
	int score();
	bool isStrike();
	bool isSpare();
	bool isLastFrame();
	void set_bonus(int roll1_pinsdown, int roll2_pinsdown);
	int bonus();
	bool bonus_set();
private:
	bool _strike;
	int index;
	int pins_down;
	int _bonus;
};

#endif /* FRAME_H_ */
