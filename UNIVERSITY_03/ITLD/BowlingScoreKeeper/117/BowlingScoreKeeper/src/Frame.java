public class Frame {
	private int firstThrow;
	private int secondThrow;

	public Frame (){

	}
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

		if ( firstThrow != 10 && (firstThrow + secondThrow) != 10)
			return firstThrow + secondThrow;
		if (isSpare())
			return 0;
		if (isStrike())
			return 0;


		return 0;
	}


	public boolean isStrike(){
		if (firstThrow == 10)
			return true;
		else
			return false;		
	}


	public boolean isSpare(){
		if ((firstThrow + secondThrow)==10)
			return true;
		else
		return false;
	}
}
