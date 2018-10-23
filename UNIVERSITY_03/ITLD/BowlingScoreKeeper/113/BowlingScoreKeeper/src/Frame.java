public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int score;
	private boolean strike = false;
	private boolean spare = false;

	public Frame(int firstThrow, int secondThrow){
		if(firstThrow > 10 || firstThrow < 0)


		{
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
		this.score = firstThrow + secondThrow;
		return score;
	}


	public boolean isStrike(){
		if(firstThrow == 10)
			strike = true;
		return strike;
	}


	public boolean isSpare(){
		if(firstThrow + secondThrow == 10)
			spare = true;
		return spare;
	}
}
