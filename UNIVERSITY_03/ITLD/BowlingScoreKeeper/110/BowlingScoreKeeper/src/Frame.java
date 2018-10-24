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
		int rez = this.getFirstThrow()+this.getSecondThrow();
		return rez;
	}


	public boolean isStrike(){
		if(this.firstThrow==10){
			return true;
		}
		else
			return false;
	}


	public boolean isSpare(){
		if(this.firstThrow<10){
			if(this.firstThrow+this.secondThrow==10){
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
}
