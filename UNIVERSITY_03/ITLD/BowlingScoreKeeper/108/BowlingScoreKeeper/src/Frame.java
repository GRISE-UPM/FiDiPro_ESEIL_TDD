
public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int score;

	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		int score = 0;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}


	public int score() throws BowlingException { 		if(score <= 10) {
			return firstThrow + secondThrow;
		}else{
			throw new BowlingException();
		}
	}


	public boolean isStrike(){
		if(firstThrow == 10){
			return true;
		} else {
			return false;
		}
	}


	public boolean isSpare(){
		if(this.firstThrow+this.secondThrow == 10){
			return true;
		} else{
			return false;
		}

	}
}
