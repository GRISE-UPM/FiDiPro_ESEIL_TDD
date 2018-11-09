/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>

BowlingGame::BowlingGame() {
	gameScore = 0;
}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::playGame() {
	for (int frameNumber = 0; frameNumber <10; frameNumber++) {
		unsigned int firstThrow;
		std::cin>>firstThrow;
		frames[frameNumber].setFirstThrow(firstThrow);

		if (!frames[frameNumber].isStrike()) {
			unsigned int secondThrow;
			std::cin>>secondThrow;
			frames[frameNumber].setSecondThrow(secondThrow);
		}

		if (frameNumber == 10) {
			unsigned int thirdThrow;
			std::cin>>thirdThrow;
			frames[frameNumber].setThirdThrow(thirdThrow);
		}

		updateGameScore(frameNumber);

	}

}

void BowlingGame::updateGameScore(int frame_number) {
	// Just update the frame score accordingly.
	if (frame_number > 0) {
		if (frames[frame_number-1].isStrike()) {
			frames[frame_number-1].bonus += frames[frame_number].getFirstThrow() + frames[frame_number].getSecondThrow();
			if (frame_number-2 >=0 && frames[frame_number-2].isStrike())
				frames[frame_number-2].bonus += frames[frame_number].getFirstThrow();
		}
		if (frames[frame_number-1].isSpare())
			frames[frame_number-1].bonus += frames[frame_number].getFirstThrow();
	}

}

unsigned int BowlingGame::getGameScore(int numberOfFramesPlayed) {
	for (int frameNumber = 1; frameNumber <= numberOfFramesPlayed; frameNumber++) {
		gameScore += frames[frameNumber-1].getFrameScore();
	}
	return gameScore;
}
