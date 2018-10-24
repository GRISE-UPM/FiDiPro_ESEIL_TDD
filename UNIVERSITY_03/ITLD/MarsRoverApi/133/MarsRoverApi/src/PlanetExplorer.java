import java.util.List;





public class PlanetExplorer {

	private int x;
	private int y;
	private String obstacles;
	private String direction;
	List<String> list;
	private int[] coordinates = new int[2];

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		this.x = x;
		this.y = y;
		this.obstacles = obstacles;
		direction = "N";
		coordinates[0] = 0;			coordinates[1] = 0;		}

	public PlanetExplorer(int x, int y)
	{
		this.x = x;
		this.y = y;
		direction = "N";
		coordinates[0] = 0;
		coordinates[1] = 0;
	}

	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *

		values = obstacles.split(")(");
		for(int i = 0 ; i < values.length ; i++)
		{
			list.add(values[i]);
		}


		String obst = values[1];*		switch(command)
		{
		case "f":
			if(direction == "N")
			{
					if(coordinates[1] < y - 1)
						coordinates[1]++;
					else
						coordinates[1] = 0;
			}
			else if(direction == "S")
			{
				if(coordinates[1] == 0)
					coordinates[1] = y - 1;
				else
					coordinates[1]--;
			}
			else if(direction == "E")
			{
				if(coordinates[0] == x - 1)
					coordinates[0] = 0;
				else coordinates[0]++;
			}
			else if(direction == "W")
			{
				if(coordinates[0] == 0)
					coordinates[0] = x - 1;
				else coordinates[0]--;
			}
			break;
		case "b":
			break;
		case "l":
			if(direction == "N")
				direction = "W";
			else if(direction == "S")
				direction = "E";
			else if(direction == "E")
				direction = "N";
			else if(direction == "W")
				direction = "S";
			break;
		case "r":
			if(direction == "N")
				direction = "E";
			else if(direction == "E")
				direction = "S";
			else if(direction == "S")
				direction = "W";
			else if(direction == "W")
				direction = "N";
			break;
		}

		return "(pos_" + coordinates[0] + ",pos_" + coordinates[1] +"," + direction + ")";
	}


		return coordinates;
	}*}
