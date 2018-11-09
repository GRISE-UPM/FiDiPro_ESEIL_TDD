/*
 * BowlingGame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "BowlingGame.h"
#include <string>

BowlingGame::BowlingGame() {
	frames.reserve(10);
	frames_filled = -1;
}

BowlingGame::~BowlingGame() {
	// TODO Auto-generated destructor stub
}

void BowlingGame::addFrame(int p1, int p2){
	frames_filled++;
	frames[frames_filled].save_throw1(p1);
	frames[frames_filled].save_throw2(p2);


	//to be implemented
}

void BowlingGame::setBonus(int firstThrow, int secondThrow) {
	bonus.save_throw1(firstThrow);//to be implemented
	bonus.save_throw2(secondThrow);
}

int BowlingGame::score(){
	int score=0;
	for (int i=0;i <= frames_filled;i++){
		if (frames[i].isStrike()){
            if (i==9){
            	score += (10 + bonus.score());
            }
            else{


			if (frames[i+1].isStrike()){

              if (i < 8){

                  score += (20 + frames[i+2].get_throw1());
              }
              else{
            	  score += (20 + bonus.get_throw1());
              }

			  }
              else{
                  score += (10 + frames[i+1].score());
              }
            }
		}
		else if(frames[i].isSpare()){
            if (i<9){
               score += (10 + frames[i+1].get_throw1());
            }
            else{
            	score += (10 + bonus.get_throw1());
            }
		}

		else{
		    score += frames[i].score();
		}
	}
	//to be implemented
	return score;
}

bool BowlingGame::isNextFrameBonus(){
	//to be implemented
	return false;
}
