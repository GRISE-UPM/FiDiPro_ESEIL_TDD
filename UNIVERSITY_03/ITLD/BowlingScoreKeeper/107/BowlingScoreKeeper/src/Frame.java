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

		return 0;
	}


	public boolean isStrike() throws BowlingException{
		if(firstThrow==10)
			return true;
		else if(firstThrow>10)
			throw new BowlingException("Nemoguce.");
		else
		return false;
	}


	public boolean isSpare() throws BowlingException{
		if((firstThrow+secondThrow)==10)
			return true;
		else if ((firstThrow+secondThrow)>10)
				throw new BowlingException("Nije moguc scenario.");
		else
		return false;
	}
}
