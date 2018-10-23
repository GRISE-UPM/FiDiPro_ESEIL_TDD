
public class Explorer {
	private int x;
	private int y;
	private String direction;
	private String[] posibleDirRight = {"N", "E", "S", "W"};
	private String[] posibleDirLeft = {"N", "W", "S", "E"};

	public Explorer () {

	}

	public Explorer (int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}


		for (int i = 0; i < posibleDirRight.length; i++) {
			if (i < posibleDirRight.length - 1) {
				if (this.getDirection() == posibleDirRight[i]) {
					this.setDirection(posibleDirRight[i+1]);
				}
			}
			else {
				this.setDirection("N");
			}
		}
	}*
	public void changeDirectionRight(String dir) {
		if (dir == "N") {
			this.setDirection("E");
		}
		else if (dir == "E") {
			this.setDirection("S");
		}
		else if (dir == "S") {
			this.setDirection("W");
		}
		else if (dir == "W") {
			this.setDirection("N");
		}
	}

	public void changeDirectionLeft(String dir) {
		if (dir == "N") {
			this.setDirection("W");
		}
		else if (dir == "W") {
			this.setDirection("S");
		}
		else if (dir == "S") {
			this.setDirection("E");
		}
		else if (dir == "E") {
			this.setDirection("N");
		}
	}



	public void movingForward(String dir){
		int distance = 1;
		if (dir == "N"){
			y += distance;
		}
		if (dir == "S"){
			y -= distance;
		}
		if (dir == "E"){
			x += distance;
			this.changeDirectionRight(direction);
		}
		if (dir == "W"){
			x -= distance;
			this.changeDirectionLeft(direction);
		}
	}

	public void movingBack(String dir){
		int distance = 1;
		if (dir == "N"){
			y -= distance;
		}
		if (dir == "S"){
			y += distance;
		}
		if (dir == "E"){
			x -= distance;
			this.changeDirectionRight(direction);
		}
		if (dir == "W"){
			x += distance;
			this.changeDirectionLeft(direction);
		}
	}



	public String ispis() {
		return "(" + Integer.toString(this.x) + ", " + Integer.toString(this.y) + "), " + this.direction;
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

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}
