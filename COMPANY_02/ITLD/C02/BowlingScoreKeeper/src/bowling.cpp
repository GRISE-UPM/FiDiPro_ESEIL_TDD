#include <iostream>
using namespace std;

//First US, check number of frames
int number_of_frames(int nframes)
{
	if (nframes < 10)
	nframes ++;
	return nframes;
}
//second US, check the number of pins in each frame

int number_of_pins(int firstTry, int secondTry){
	int totalPins = firstTry + secondTry;
	return totalPins;
}

//Third US, check if has spare

bool spare(int firstTry, int secondTry){
	if (firstTry + secondTry == 10 );
	return true;
}

// Fourth US, check if Its strike

bool strike(int firstTry, int secondTry){
	if ((firstTry == 10) || (secondTry == 10))
		return true;
}

// totalscore ?

int totalScore(){

	if (nframes < 10){
	int totalScore += totalPins;
	return totalScore;
	}

}

