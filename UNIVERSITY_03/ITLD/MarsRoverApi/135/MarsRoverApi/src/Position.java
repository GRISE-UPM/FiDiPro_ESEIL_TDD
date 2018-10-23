
public class Position {
	private int x;
	private int y;

	public Position(){
		this.x = 0;
		this.y = 0;
	}

	public Position(int x,int y){
		this.x = x;
		this.y = y;
	}

	public void moveForward(String dir){
		int distance = 1;
		if (dir.equals("N")){
			y += distance;
		}
		if (dir.equals("S")){
			y -= distance;
		}
		if (dir.equals("E")){
			x += distance;
		}
		if (dir.equals("W")){
			x -= distance;
		}
	}

	public void moveBackwards(String dir){
		int distance = -1;
		if (dir.equals("N")){
			y += distance;
		}
		if (dir.equals("S")){
			y -= distance;
		}
		if (dir.equals("E")){
			x += distance;
		}
		if (dir.equals("W")){
			x -= distance;
		}
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Position){
			Position tmp = new Position(((Position) obj).getX(),((Position) obj).getY());
			if(tmp.getX() == this.x  && tmp.getY() == this.y)
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


}
