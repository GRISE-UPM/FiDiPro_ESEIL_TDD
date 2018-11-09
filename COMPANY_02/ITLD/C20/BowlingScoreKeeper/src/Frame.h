/*
 * Frame.h
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#ifndef FRAME_H_
#define FRAME_H_

#include <array>

class Frame {
public:
    Frame(){};
    Frame(int first_throw, int second_throw);
    virtual ~Frame();
    int score();
    bool isStrike();
    bool isSpare();
    bool isLastFrame();
    int bonus();
    int getFirstThrow();
    int getSecondThrow();

    inline bool operator==(const Frame& f1, const Frame& f2)
    {
        return (f1.getFirstThrow() == f2.getFirstThrow()) && (f1.getSecondThrow() == f2.getSecondThrow());
    }
private:
    std::array<int, 2> m_throws;
};

#endif /* FRAME_H_ */
