public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int thirdThrow;
	private boolean proveraTreceg;

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

	public void setThirdThrow(int treci){
		this.thirdThrow = treci;
	}


	public int score(){
		if(proveraTreceg == true){
			return getFirstThrow() + getSecondThrow() + this.thirdThrow;
		}
		return getFirstThrow() + getSecondThrow();
	}

	public void setThird(boolean jeste){
		this.proveraTreceg = jeste;
	}


	public boolean isStrike(){
		if(getFirstThrow() == 10){
			return true;
		}
		return false;
	}


	public boolean isSpare(){
		if(getFirstThrow()<10 && (getFirstThrow() + getSecondThrow()) == 10){
			return true;
		}
		return false;
	}
}
