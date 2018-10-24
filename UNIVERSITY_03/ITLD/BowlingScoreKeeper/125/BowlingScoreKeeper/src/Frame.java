public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int bonus = 0;

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
		return firstThrow + secondThrow + bonus;
	}


	public boolean isStrike(){

		if(firstThrow + secondThrow == 10)
			return true;

		return false;
	}


	public boolean isSpare(){

		if(firstThrow == 10)
			return true;

		return false;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
