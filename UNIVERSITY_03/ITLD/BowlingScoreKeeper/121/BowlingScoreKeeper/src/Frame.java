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

		return firstThrow + secondThrow;

	}


	public boolean isStrike(){

		if(firstThrow == 10){
			return true;
		}else{
			return false;
		}
	}


	public boolean isSpare(){

		if((firstThrow + secondThrow) == 10){
			return true;
		}else{
			return false;
		}
	}

	public void setFirstThrow(int firstThrow) {
		this.firstThrow = firstThrow;
	}

	public void setSecondThrow(int secondThrow) {
		this.secondThrow = secondThrow;
	}
}
