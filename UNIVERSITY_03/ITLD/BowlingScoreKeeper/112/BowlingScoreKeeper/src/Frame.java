public class Frame {
	private int firstThrow;
	private int secondThrow;

	public Frame(){

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

		if(isSpare()){
			return 10+secondThrow;
		}
		else if(isStrike()){
			return 10+(firstThrow+secondThrow);
		}
		else{
			return firstThrow+secondThrow;
		}

	}


	public boolean isStrike(){

		if(firstThrow==10){
			return true;
		}
		else
		return false;
	}


	public boolean isSpare(){

		if((firstThrow+secondThrow)==10){
			return true;
		}
		else
		return false;
	}
}
