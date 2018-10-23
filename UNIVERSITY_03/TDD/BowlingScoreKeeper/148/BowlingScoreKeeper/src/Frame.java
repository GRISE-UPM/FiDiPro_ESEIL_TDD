public class Frame {
	private int firstThrow;
	private int secondThrow;

	public Frame(){

	}

	public Frame(int firstThrow, int secondThrow) throws BowlingException{
		if(firstThrow > 10 || firstThrow < 0)
			throw new BowlingException("Vise od mogucih 10 oborenih u prvom bacanju");
		this.firstThrow = firstThrow;
		if(secondThrow > 10 - firstThrow || secondThrow < 0)
			throw new BowlingException("Vise od mogucih 10 oborenih cunjeva iz dva bacanja");
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
		return false;
	}


	public boolean isSpare(){
		if(getFirstThrow() + getSecondThrow() == 10 && getFirstThrow() != 10)
			return true;
		return false;
	}

	public String getScore(){
		return score() + "";
	}
}
