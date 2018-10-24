public class Frame {
	private int firstThrow;
	private int secondThrow;

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
		if (this.firstThrow + this.secondThrow > 10) {
			throw new BowlingException();
		}
		else {
			return this.firstThrow + this.secondThrow;
		}
	}


	public boolean isStrike() throws BowlingException {
		if (this.firstThrow > 10) {
			throw new BowlingException();
		}
		else if (this.firstThrow == 10) {
			return true;
		}
		else {
			return false;
		}
	}


	public boolean isSpare() throws BowlingException{
		if (this.firstThrow + this.secondThrow > 10) {
			throw new BowlingException();
		}
		else if (this.firstThrow + this.secondThrow == 10) {
			return true;
		}
		else
			return false;
	}
}
