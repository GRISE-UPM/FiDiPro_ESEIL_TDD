public class Frame {
	private int firstThrow;
	private int secondThrow;

	public Frame(int firstThrow, int secondThrow) throws BowlingException{
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;

		if(firstThrow + secondThrow > 10)
			throw new BowlingException();
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	public void setFirstThrow(int first){
		firstThrow = first;
	}

	public void setSecondThrow(int second){
		secondThrow = second;
	}


	public int score() throws BowlingException{
		int score = 0;

		if(firstThrow + secondThrow <= 10)
			score = firstThrow + secondThrow;
		else throw new BowlingException();

		return score;
	}


	public boolean isStrike() throws BowlingException{
		if(firstThrow + secondThrow > 10)
			throw new BowlingException();

		if(firstThrow == 10 && secondThrow == 0)
			return true;
		return false;
	}


	public boolean isSpare() throws BowlingException{
		if(firstThrow + secondThrow > 10)
			throw new BowlingException();

		if(firstThrow + secondThrow == 10)
			return true;

		return false;
	}
}
