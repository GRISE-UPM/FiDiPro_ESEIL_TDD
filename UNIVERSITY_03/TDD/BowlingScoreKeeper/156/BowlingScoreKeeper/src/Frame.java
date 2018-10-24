public class Frame {
	private int firstThrow;
	private int secondThrow;

	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		int score=0;
	}

	public Frame(double d) {

	}


	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}


	public int score(){

		if(firstThrow<=10)
		{
			return firstThrow + secondThrow;
		}
		return 0;
	}


	public boolean isStrike(){

		if (firstThrow==10)
		{
			return true;
		}
		return false;
	}


	public boolean isSpare(){

		if(firstThrow ==10)
		{
			return true;
		}
		return false;
	}

	public int size() {

		return 0;
	}


}
