/*
 * Frame.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "Frame.h"
#include <iostream>

Frame::Frame(int a[2]): _first(a[0]), _second(a[1]){
}

Frame::Frame(int a, int b): _first(a), _second(b){
}

Frame::~Frame() {
	// TODO Auto-generated destructor stub
}

//the score of a single frame
int Frame::score(){
	if(_first+_second>10)
	    return -1;
	return _first+_second;
}

//returns whether the frame is a strike or not
bool Frame::isStrike(){
	if(score()==10 && _first==10) {
		std::cout<<"GOT STRIKE\n";
		return true;
	}
	return false;
}

//return whether a frame is a spare or not
bool Frame::isSpare() {
	if(score()==10 && _first!=10) {
		return true;
	}
	return false;
}

//return whether this is the last frame of the match
bool Frame::isLastFrame(){
	//to be implemented
	return false;
}

//bonus throws
int Frame::bonus(){
	//to be implemented
	return 0;
}
