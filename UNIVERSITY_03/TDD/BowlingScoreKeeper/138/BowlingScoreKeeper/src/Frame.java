public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int bonusThrow;

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


	public int score() throws Exception{
		if((firstThrow + secondThrow) <= 10)
			return firstThrow + secondThrow;
		else
			throw new Exception("Max result per frame is 10");
	}


	public boolean isStrike(){

		return firstThrow == 10;
	}


	public boolean isSpare(){

		return firstThrow + secondThrow == 10;
	}
}
