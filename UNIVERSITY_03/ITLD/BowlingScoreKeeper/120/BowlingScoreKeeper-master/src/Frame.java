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


	public int score(){
		return firstThrow + secondThrow;
	}


	public boolean isStrike(){
		if (firstThrow == 10)
			return true;
		return false;
	}


	public boolean isSpare(){
		if (firstThrow != 10 && (10 - (firstThrow + secondThrow)) == 0)
			return true;
		return false;
	}
}
