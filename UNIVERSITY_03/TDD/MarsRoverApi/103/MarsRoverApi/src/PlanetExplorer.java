




public class PlanetExplorer {
	int x_vozila=0;
	int y_vozila=0;
	String facing = " ";




	public PlanetExplorer(int x, int y, String obstacles){


	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *	}


	public String executeCommand(String command) throws PlanetExplorerException{


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		String rez = " ";

		String komande [] = command.split(",");

		for(int i=0;i<komande.length;i++)
		{
			if(komande[i]=="f")
			{
				y_vozila++;
				facing="N";
			}
			else if(komande[i]=="r")
			{
				x_vozila++;
				facing="E";
			}
			else if(komande[i]=="b")
			{
				y_vozila--;
				facing="S";
			}
			else if(komande[i]=="l")
			{
				x_vozila--;

				if(x_vozila<0)
				{
					throw new PlanetExplorerException("ne moze proci levo");
				}
				facing="W";
			}



		}

		return pozicija(x_vozila,y_vozila,facing);
	}

	public String pozicija(int x_vozila, int y_vozila, String facing)
	{
		return "("+x_vozila + "," + y_vozila + "," + facing + ")";
	}

	public int getX_vozila() {
		return x_vozila;
	}

	public void setX_vozila(int x_vozila) {
		this.x_vozila = x_vozila;
	}

	public int getY_vozila() {
		return y_vozila;
	}

	public void setY_vozila(int y_vozila) {
		this.y_vozila = y_vozila;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}




}
