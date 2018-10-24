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
		if(firstThrow+secondThrow==10){
			bonus = secondThrow;
			return firstThrow+secondThrow+bonus;
		}else if(firstThrow + secondThrow<10){
			return firstThrow+secondThrow;
		}else if(firstThrow == 10){
			return firstThrow;
		}

		return 0;
	}


	public boolean isStrike(){
		if(firstThrow == 10 && secondThrow == 0){
			return true;
		}else
			return false;
	}


	public boolean isSpare(){
		if(firstThrow + secondThrow == 10){
			return true;
		}else 
			return false;
	}
}
