import java.awt.List;
import java.util.ListIterator;





public class PlanetExplorer {
	private int x, y;
	private String facing;
	private List obstacles;
	public PlanetExplorer(int x, int y, String obstacles){
		this.x=x;
		this.y = y;
		this.facing = "N";



	}

	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		for (char c : command.toCharArray()) 
		{
			int curr_x = this.x;
			int curr_y= this.y;
		switch(c)
		{
		case 'f':
		{
			if(facing == "N" ) this.y++;
			else if (facing == "S" ) this.y--;
			else if (facing == "E" ) this.x++;
			else if ( facing == "W") this.x--;
		}break;
		case 'b':
		{
			if(facing == "N" ) this.y--;
			else if (facing == "S" ) this.y++;
			else if (facing == "E" ) this.x--;
			else if ( facing == "W") this.x++;
		}break;
		case 'r':
		{
			if(facing == "N" ) this.facing = "E";
			else if (facing == "S" ) this.facing = "W";
			else if (facing == "E" ) this.facing = "S";
			else if ( facing == "W") this.facing = "N";
		}break;
		case 'l':
		{
			if(facing == "N" ) this.facing = "W";
			else if (facing == "S" ) this.facing = "E";
			else if (facing == "E" ) this.facing = "N";
			else if ( facing == "W") this.facing = "S";
		}break;
		}

		}

		return "("+this.x+","+this.y+","+this.facing+")";
	}
	}
