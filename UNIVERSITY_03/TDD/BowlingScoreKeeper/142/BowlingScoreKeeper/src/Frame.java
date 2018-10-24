public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int frameScore;


	public Frame(int firstThrow, int secondThrow) throws BowlingException {
		if (firstThrow + secondThrow > 10)
			throw new BowlingException("Frame score ne moze biti veci od 10");

		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		frameScore = this.firstThrow + this.secondThrow;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}


	public int score(){

		frameScore = this.firstThrow + this.secondThrow;
		return frameScore;

	}


	public boolean isStrike(){

		if(firstThrow==10)
		{
			return true;
		}
		return false;
	}


	public boolean isSpare(){

		if(firstThrow+secondThrow==10)
		{
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
