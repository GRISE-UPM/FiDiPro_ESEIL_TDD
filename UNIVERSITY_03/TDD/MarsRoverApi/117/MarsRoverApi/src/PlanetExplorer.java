




public class PlanetExplorer extends PlanetExplorerException {

	int x;
	int y;
	String obstacles;
	char [] positions = {'N','E', 'S','W'};


	int xExplorer = 0;
	int yExplorer = 0;

	String result;
	int counterForPosition=0;
	char position = positions[counterForPosition];

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		this.x=x;
		this.y=y;
		this.obstacles=obstacles;
	}
	public PlanetExplorer(int x, int y)
	{
		this.x=x;
		this.y=y;

	}

	public String executeCommand(String command) throws PlanetExplorerException{


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		for (int i = 0; i <command.length();i++)
		{
			if ( (command.charAt(i) != 'b') && (command.charAt(i) != 'f') && 
				 (command.charAt(i) != 'l') && (command.charAt(i) != 'r'))
				throw new PlanetExplorerException();

		}



		if (command.equals("f"))
		{
			if ((this.xExplorer == this.x - 1))
			{
				this.yExplorer=0;
				result = "(" + this.getxExplorer() + "," + this.getyExplorer()+ "," + position + ")";
				return result;

			}
			if ((this.yExplorer == this.y - 1) || this.position == 'E')
			{
				this.xExplorer=0;
				result = "(" + this.getxExplorer() + "," + this.getyExplorer()+ "," + position + ")";
				return result;

			}
			this.yExplorer++;
			result = "(" + this.getxExplorer() + "," + this.getyExplorer()+ "," + position + ")";
			return result;
		}

		if (command.equals("b"))
		{
			this.yExplorer--;
			result = "(" + this.getxExplorer() + "," + this.getyExplorer()+ "," + position + ")";
			return result;

		}
		if (command.equals("r"))
		{
			if (position == 'N')
			{
				result = "(" + this.getxExplorer() + "," + this.getyExplorer()+ ",E)";
				return result;
			}

		}
		if (command.equals("l"))
		{
			if (position == 'N')
			{
				result = "(" + this.getxExplorer() + "," + this.getyExplorer()+ ",W)";
				return result;
			}
		}



		return null;
	}
	public char getPosition(int number) {
		return positions[number];
	}
	public void setPosition(char[] position) {
		this.positions = position;
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
	public String getObstacles() {
		return obstacles;
	}
	public void setObstacles(String obstacles) {
		this.obstacles = obstacles;
	}
	public int getxExplorer() {
		return xExplorer;
	}
	public void setxExplorer(int xExplorer) {
		this.xExplorer = xExplorer;
	}
	public int getyExplorer() {
		return yExplorer;
	}
	public void setyExplorer(int yExplorer) {
		this.yExplorer = yExplorer;
	}
	public char[] getPositions() {
		return positions;
	}
	public void setPositions(char[] positions) {
		this.positions = positions;
	}
	public int getCounterForPosition() {
		return counterForPosition;
	}
	public void setCounterForPosition(int counterForPosition) {
		this.counterForPosition = counterForPosition;
	}
	public char getPosition() {
		return position;
	}
	public void setPosition(char position) {
		this.position = position;
	}
}
