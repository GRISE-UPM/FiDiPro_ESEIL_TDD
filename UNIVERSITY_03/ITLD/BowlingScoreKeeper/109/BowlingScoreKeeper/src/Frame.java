public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int scoreBonus;

	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		this.scoreBonus = 0;

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

	public void addBonus(int bonus){
		scoreBonus = bonus;
	}

	public int scoreWithBonus(){

		return score() + scoreBonus;
	}


	public boolean isStrike(){
		if(firstThrow == 10){
			return true;
		}
		return false;
	}


	public boolean isSpare(){

		if(firstThrow != 10 && firstThrow+secondThrow == 10){
			return true;
		}
		return false;
	}
}
