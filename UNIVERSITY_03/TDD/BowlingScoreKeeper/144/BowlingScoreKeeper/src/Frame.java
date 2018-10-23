public class Frame {
	private int firstThrow;
	private int secondThrow;

	public Frame(int firstThrow, int secondThrow) {

		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;

	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}


	public int score() throws Exception{

		if (firstThrow+secondThrow>10) {

			throw new BowlingException("Incorrect score");
		}

		return firstThrow+secondThrow;
	}


	public boolean isStrike(){

		if (firstThrow==10 && secondThrow==0) {

			return true;
		}
		else {

		return false;
		}
	}


	public boolean isSpare() throws Exception{

		if (firstThrow!=10 && score()==10) {

			return true;
		} 
		else {

			return false;
		}
	}
}
