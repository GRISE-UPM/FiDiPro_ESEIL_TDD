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

		int rez = firstThrow + secondThrow;
		return rez;
	}


	public boolean isStrike(){

		if(firstThrow == 10){
			return true;
		}
		else{
		return false;}
	}


	public boolean isSpare(){

		if(firstThrow != 10 && (firstThrow + secondThrow) == 10)
		{
			return true;
		}
		else {
		return false;}
	}
}
