public class Frame {
	private int firstThrow;
	private int secondThrow;

	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}

	public Frame(){};

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}


	public int score(){
		int skor = firstThrow + secondThrow;
		return skor;
	}


	public boolean isStrike(){
		if(firstThrow == 10){
			return true;
		}
		return false;
	}


	public boolean isSpare(){
		if(isStrike() == false && (10 - (firstThrow + secondThrow)) == 0){
			return true;
		}
		return false;
	}
}
