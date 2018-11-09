/*
 * Frame.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef FRAME_H_
#define FRAME_H_

#include <cstdint>
#include <stdexcept>

class Frame {
public:
	Frame(uint32_t _first_score, uint32_t _second_score);
	virtual ~Frame();
	uint32_t score() const;
	bool isStrike() const;
	bool isSpare() const;
	void setBonus(uint32_t bonus);
	uint32_t bonusSpare() const;
	uint32_t bonusStrike() const;

private:
	uint32_t score_first;
	uint32_t score_second;
	uint32_t bonus_score;
};

#endif /* FRAME_H_ */
