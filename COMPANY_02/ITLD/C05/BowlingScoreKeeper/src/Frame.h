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
	int score() const;
	bool isStrike() const;
	bool isSpare() const;
	bool isLastFrame();
	int bonus();

	static const int NUM_PINS;

	bool setThrow(const int throwId, const int pins);
	int getThrow(const int throwId) const;

private:
	int m_throw1;
	int m_throw2;
};

#endif /* FRAME_H_ */
