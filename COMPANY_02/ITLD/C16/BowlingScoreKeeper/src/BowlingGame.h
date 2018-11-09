/*
 * BowlingGame.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */
#include <iostream>
#include "Frame.h"

class BowlingGame {
public:

	BowlingGame();
	virtual ~BowlingGame();
	void playGame();
	unsigned int getGameScore (int numberOfFramesPlayed);
	void updateGameScore(int frameNumber);
	Frame frames[10];
private:
	unsigned int gameScore;

};


