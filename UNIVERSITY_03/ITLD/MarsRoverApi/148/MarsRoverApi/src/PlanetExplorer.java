




public class PlanetExplorer {
	private int gridX;
	private int gridY;
	private String prepreke;
	private Pozicija pozicija;


	public PlanetExplorer(int x, int y, String obstacles) throws PlanetExplorerException{

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		if(x < 1 || y < 1)
			throw new PlanetExplorerException("Neispravne dimenzije grida");

		gridX = x;
		gridY = y;
		prepreke = obstacles;

		pozicija = new Pozicija();

	}

	public String executeCommand(String command) throws PlanetExplorerException{


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		char[] nizKomandi = command.toCharArray();

		for(int i = 0; i < nizKomandi.length; i++){
			String komanda = String.valueOf(nizKomandi[i]);
			pozicija.pomeranje(komanda);
		}

		return null;
	}

	public String toString(){
		return "(" + gridX + ", " + gridY + ", " + prepreke + ")";
	}

	public int getGridX() {
		return gridX;
	}

	public int getGridY() {
		return gridY;
	}

	public Pozicija getPozicija() {
		return pozicija;
	}


}
