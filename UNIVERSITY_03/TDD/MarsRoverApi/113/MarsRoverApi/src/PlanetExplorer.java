




public class PlanetExplorer {
	private int x;
	private int y;
	private String direction;
	private String prepreke;

	public PlanetExplorer(int x, int y, String obstacles){
		this.x =x;
		this.y =y;
		this.direction = "N";
		this.prepreke = obstacles;
	}

	public String getFormatedCoorditates()
	{
		String ispis = null;
		ispis = "(" + Integer.toString(x) + ", " + Integer.toString(y) + ", " + direction + ")";

		return ispis;
	}

	public void moveForth() throws PlanetExplorerException
	{
		if(this.direction == "N" || this.direction == "S")
			this.y++;
		else if(this.direction == "E" || this.direction == "W")
			this.x++;
		else
			throw new PlanetExplorerException("Nesto nevalja");
	}

	public void moveBack() throws PlanetExplorerException
	{
		if(this.direction == "N" || this.direction == "S")
			this.y--;
		else if(this.direction == "E" || this.direction == "W")
			this.x--;
		else
			throw new PlanetExplorerException("Nesto nevalja");
	}

	public void moveLeft() throws PlanetExplorerException
	{
		if(this.direction == "N")
			this.direction = "W";
		else if(this.direction == "W")
			this.direction = "S";
		else if(this.direction == "S")
			this.direction = "E";
		else if(this.direction == "E")
			this.direction = "N";
		else
			throw new PlanetExplorerException("Vozilo je pokvareno, ne moze se poimeriti u levo!");

	}

	public void moveRight() throws PlanetExplorerException
	{
		if(this.direction == "N")
			this.direction = "E";
		else if(this.direction == "E")
			this.direction = "S";
		else if(this.direction == "S")
			this.direction = "W";
		else if (this.direction == "W")
			this.direction = "N";
		else
			throw new PlanetExplorerException("Vozilo je pokvareno, ne moze se poimeriti u desno!");
	}


	public String executeCommand(String command){

		return null;
	}
}
