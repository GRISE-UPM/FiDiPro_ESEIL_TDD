public class Frame {

	private int firstThrow;
	private int secondThrow;
	boolean frameDodavanje = false;

	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}

	public Frame(){

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
		if(firstThrow == 10){
			return true;
		} else
			return false;
	}


	public boolean isSpare(){
		if(firstThrow + secondThrow == 10){
			return true;
		} else
			return false;
	}
}
