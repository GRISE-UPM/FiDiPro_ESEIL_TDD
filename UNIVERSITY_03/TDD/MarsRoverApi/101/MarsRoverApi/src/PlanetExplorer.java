




public class PlanetExplorer {
	private int xKo=0;
	private int yKo=0;

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
		 *
		 String stranaSveta="N";

		String rezultat="";
		String [] nizKomandi = command.split(",");

		for(int i=0; i<nizKomandi.length; i++)
		{
			if (nizKomandi[i]=="f")
			{
				yKo++;

				stranaSveta="N";

			} else if(nizKomandi[i]=="b")
			{
				yKo--;
				stranaSveta="S";
			} else if (nizKomandi[i]=="r")
			{
				xKo++;
				if (xKo > 2)
				{
					throw new PlanetExplorerException("Ne moze da ode na 3,0 poziciju!!");
				}
				stranaSveta="E";
			} else if (nizKomandi[i]=="l")
			{

				xKo--;

				if (xKo < 0 ) 
				{
					throw new PlanetExplorerException("Ne moze da ode na -1,0 poziciju!!");
				}

				stranaSveta="W";
			}
		}


		return pozicijaNaMapi(xKo, yKo,stranaSveta);
	}

	public String pozicijaNaMapi(int x1, int y1, String stranaSveta)
	{
		return "(" + x1 + "," + y1 + "," + stranaSveta + ")";
	}


	public int getxKo() {
		return xKo;
	}

	public void setxKo(int xKo) {
		this.xKo = xKo;
	}

	public int getyKo() {
		return yKo;
	}

	public void setyKo(int yKo) {
		this.yKo = yKo;
	}


}
