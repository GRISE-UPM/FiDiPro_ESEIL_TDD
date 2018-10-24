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
		if(firstThrow+secondThrow<=10)
		return firstThrow+secondThrow;

		else throw new BowlingException();
	}


	public boolean isStrike(){
		if(firstThrow == 10 && secondThrow == 0) return true;
		else return false;
	}


	public boolean isSpare(){
		if(firstThrow + secondThrow == 10) return true;
		else return false;
	}

	public void setFirstThrow(int first) {
		this.firstThrow = first;
	}

	public void setSecondThrow(int second) {
		this.secondThrow = second;
	}
}
