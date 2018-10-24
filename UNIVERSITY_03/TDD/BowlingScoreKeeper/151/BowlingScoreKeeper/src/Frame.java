public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int bonus;
	public Frame(int firstThrow, int secondThrow) throws BowlingException{
		if (firstThrow + secondThrow > 10)
			throw new BowlingException();
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}


	public int score(){

		return firstThrow + secondThrow + bonus;
	}


	public boolean isStrike(){

		return firstThrow == 10 || secondThrow == 10;
	}


	public boolean isSpare(){

		return firstThrow + secondThrow == 10;
	}

	public void addBonus(int firstThrow2, int secondThrow2) {
		this.bonus += firstThrow2 + secondThrow2;
	}
}
