public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int frameScore = 0;

	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}


	public int score() throws BowlingException{
		frameScore = firstThrow + secondThrow;
		if (frameScore > 10) {
			throw new BowlingException("Error. Score can not be more than 10 for one frame.");
		}

		return frameScore;
	}


	public boolean isStrike(){
		if(firstThrow == 10) {
			return true;
		}
		return false;
	}


	public boolean isSpare(){
		if(firstThrow + secondThrow == 10 && !isStrike()){
			return true;
		}
		return false;
	}

	public int getFrameScore() {
		return frameScore;
	}

	public void setFrameScore(int frameScore) {
		this.frameScore = frameScore;
	}
}
