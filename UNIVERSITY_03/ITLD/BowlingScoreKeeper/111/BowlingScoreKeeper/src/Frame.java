public class Frame {
	private int firstThrow;
	private int secondThrow;
	public int bonus = 0;

	public Frame(int firstThrow, int secondThrow) throws BowlingException {
		if(firstThrow > 10 || secondThrow > 10){
			throw new BowlingException();
		} else {
			this.firstThrow = firstThrow;
			this.secondThrow = secondThrow;
		}
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}


	public int score(){

		int prvi = getFirstThrow();
		int drugi = getSecondThrow();
		return prvi + drugi + bonus;
	}


	public boolean isStrike(){

		if(firstThrow == 10) {
			return true;
		} else {
			return false;
		}

	}


	public boolean isSpare(){

		if(firstThrow + secondThrow == 10) {
			return true;
		} else {
			return false;
		}
	}
}
