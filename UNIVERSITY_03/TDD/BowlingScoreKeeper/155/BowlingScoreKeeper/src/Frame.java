public class Frame {
	private int firstThrow;
	private int secondThrow;


	public Frame() {}

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
		int score = getFirstThrow() + getSecondThrow();

		return score;
	}


	public boolean isStrike(){

		if(getFirstThrow() == 10)
			return true;
		else
			return false;
	}


	public boolean isSpare(){

		if (getFirstThrow() + getSecondThrow() == 10 && getFirstThrow() != 10)
			return true;
		else
			return false;
	}
}
