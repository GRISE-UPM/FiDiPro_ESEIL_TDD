/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>

BowlingGame::BowlingGame() {
}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(Frame frame) {
	frames.push_back(frame);
}

const std::vector<Frame>& BowlingGame::getFrames() const {
	return frames;
}

void BowlingGame::setBonus(int firstThrow, int secondThrow) {
	//to be implemented
}

int BowlingGame::score() {
	int score = 0;
	for (int i = 0; i < frames.size(); ++i) {
		score += getFrameScore(i, false);
	}
	return score;
}

int BowlingGame::getFrameScore(decltype(frames)::size_type frameIdx, bool strike) const {
	if (frameIdx >= frames.size()) {
		return 0;
	}

	const Frame& frame = frames.at(frameIdx);
	int score = frame.score();

	if (frame.isStrike()) {
		if (strike) {
			// we're already calculating the score of a strike, don't recurse
			if (frameIdx + 1 >= frames.size()) {
				const Frame& frameNext = frames.at(frameIdx + 1);

				score += frames.at(frameIdx + 1).getThrow(1);
				if (frameNext.isSpare()) {
					score += frames.at(frameIdx + 1).getThrow(2);
				}
			}
		} else {
			score += getFrameScore(frameIdx + 1, true);
		}
	} else if (frame.isSpare() && (frameIdx + 1) < frames.size()) {
		score += frames.at(frameIdx + 1).getThrow(1);
	}

	return score;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
