public class Frame {
	private int firstThrow;
	private int secondThrow;
	public int bonus;

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

		return getFirstThrow() + getSecondThrow();
	}


	public boolean isStrike(){

		if(getFirstThrow() == 10)
			return true;
		else
			return false;
	}


	public boolean isSpare(){

		if(getFirstThrow() != 10 && getSecondThrow() + getFirstThrow() == 10)
			return true;
		else
			return false;
	}
}
