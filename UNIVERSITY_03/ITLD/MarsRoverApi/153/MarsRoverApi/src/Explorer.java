
public class Explorer {

	private int x = 0;
	private int y = 0;
	private String direction = "N";
	private int[] grid = {0,0};

	public Explorer()
	{

	}

	public Explorer(int x, int y, String obstacles)
	{
		grid[0] = x;
		grid[1] = y;


	}

	public void moveForth() throws PlanetExplorerException
	{
		if(direction == "N" && y < grid[1])
			y++;
		else if(direction == "N" && y == grid[1])
			y = 0;
		if(direction == "E" && x < grid[0])
			x++;
		else if(direction == "E" && x == grid[0])
			x = 0;
		if(direction == "S" && y > 0)
			y--;
		else if(direction == "S" && y == 0)
			y = grid[1];
		if(direction == "W" && x > 0)
			x--;
		else if(direction == "W" && x == 0)
			x = grid[0];
	}

	public void moveBack() throws PlanetExplorerException
	{
		if(direction == "N" && y > 0)
			y--;
		else if(direction == "N" && y == 0)
			y = grid[1];
		if(direction == "E" && x > 0)
			x--;
		else if(direction == "E" && x == 0)
			x = grid[0];
		if(direction == "S" && y < grid[1])
			y++;
		else if(direction == "S" && y == grid[1])
			y = 0;
		if(direction == "W" && x < grid[0])
			x++;
		else if(direction == "W" && x == grid[0])
			x = 0;
	}

	public void turnRight() throws PlanetExplorerException
	{
		if(direction == "N")
			direction = "E";
		else if(direction == "E")
			direction = "S";
		else if(direction == "S")
			direction = "W";
		else if(direction == "W")
			direction = "N";
	}

	public void turnLeft() throws PlanetExplorerException
	{
		if(direction == "N")
			direction = "W";
		else if(direction == "E")
			direction = "N";
		else if(direction == "S")
			direction = "E";
		else if(direction == "W")
			direction = "S";
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

	public int[] getGrid() {
		return grid;
	}

	public void setGrid(int[] grid) {
		this.grid = grid;
	}
}
