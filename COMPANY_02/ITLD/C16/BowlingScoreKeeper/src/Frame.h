# pragma once

class Frame {
public:
	Frame();
	virtual ~Frame();

	void setFirstThrow(unsigned int pinsKnocked);
	void setSecondThrow(unsigned int pinsKnocked);
	void setThirdThrow(unsigned int pinsKnocked);

	unsigned int getFirstThrow ();
	unsigned int getSecondThrow ();

	bool isStrike();
	bool isSpare();
	void updateFrameScore();
	unsigned int getFrameScore();

	unsigned int bonus;
private:
	unsigned int frameNumber;
	bool isTenthFrame;

	unsigned int firstThrow;
	unsigned int secondThrow;
	unsigned int thirdThrow;

	unsigned int frameScore;


};

