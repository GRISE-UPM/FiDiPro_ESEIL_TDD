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
    BowlingGame(vector<Frame> passed_frames);
    virtual ~BowlingGame();
    void addFrame(Frame frame);
    void setBonus(int firstThrow, int secondThrow);
    int score();
    bool isNextFrameBonus();
    std::vector<Frame> getFrames();

private:

    //a bowling game is made of (at least) 10 frames
    std::vector<Frame> frames;
    Frame bonus;
};

#endif /* BOWLINGGAME_H_ */

