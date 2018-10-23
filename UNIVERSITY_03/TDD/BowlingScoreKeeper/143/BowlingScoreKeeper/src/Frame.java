public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int thirdThrow;
	private int score = 0;
	private int bonus = 0;

	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	public Frame(int firstThrow, int secondThrow, int ThirdThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		this.thirdThrow = thirdThrow;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}
	public int getThirdThrow() {
		return thirdThrow;
	}


	public int score(){
		score = firstThrow + secondThrow;
		return score;
	}

	public int bonusScore(){
		if(isStrike()){

		}
		return 0;
	}


	public boolean isStrike(){
		if(firstThrow == 10)
			return true;
		return false;
	}


	public boolean isSpare(){
		if(firstThrow+secondThrow == 10)
			return true;
		return false;
	}
}
