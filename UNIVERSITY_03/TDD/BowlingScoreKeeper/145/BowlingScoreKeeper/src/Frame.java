public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int bonus;

	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		bonus=0;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}


	public int score(){

		return firstThrow+secondThrow;
	}


	public boolean isStrike(){
		if(firstThrow==10){
			return true;
		}else{
			return false;
		}
	}


	public boolean isSpare(){
		if(firstThrow+secondThrow==10 && !isStrike()){
			return true;
		}else{
			return false;
		}
	}

	public int scoreWithBonus() {

		return score()+bonus;
	}

	public void setBonus(int i) {

		bonus=i;
	}
}
