/*
 * BowlingGame.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef BOWLINGGAME_H_
#define BOWLINGGAME_H_

#include <vector>
#include "Frame.h"

using namespace std;

class BowlingGame {
public:

	BowlingGame();
	virtual ~BowlingGame();
	void addFrame(int firstThrow, int secondThrow);
	void setBonus(int firstThrow, int secondThrow);  // I have not used - the next frame is informed if the previous frame was a spare or strike (or neither). This next frame
	                                                 // will report the frame score including the bonus
	int score();
	bool isNextFrameBonus();

private:

	//a bowling game is made of (at least) 10 frames
	std::vector<Frame> frames;
	Frame bonus;
	int frameNumber;
};

#endif /* BOWLINGGAME_H_ */

