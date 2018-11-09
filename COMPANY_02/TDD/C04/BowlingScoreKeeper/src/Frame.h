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
    Frame(int firstThrow, int secondThrow);
    virtual ~Frame();
    int score();
    bool isStrike();
    bool isSpare();
    bool isLastFrame();
    int bonus();
    int getFirstThrowScore();
    int getSecondThrowScore();
    void addScore(int additionalScore);
protected:
    int m_firstThrow;
    int m_secondThrow;
    int m_additionalScore;
};

#endif /* FRAME_H_ */
