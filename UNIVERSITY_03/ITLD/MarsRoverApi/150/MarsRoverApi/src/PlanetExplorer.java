




public class PlanetExplorer {

	private int x;
	private int y;
	private String obstacles;
	private String side;
	private Vozilo vozilo;



	public PlanetExplorer(int x, int y, String obstacles){

		this.x=x;
		this.y=y;
		this.obstacles=obstacles;
		vozilo = new Vozilo(0,0);



		 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
		 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

		 *	}


	public PlanetExplorer(int x, int y){

		this.x=x;
		this.y=y;
		vozilo = new Vozilo(0,0);

	}


	public String executeCommand(String command){



		if(command=="f"){

				int a = vozilo.getY();
				a++;
				vozilo.setY(a);
				return toString(vozilo.getX(),vozilo.getY());


		} else if(command == "b"){

			int a = vozilo.getY();
			a--;
			vozilo.setY(a);
			return toString(vozilo.getX(),vozilo.getY());

		} else if(command == "l"){

			int a = vozilo.getX();
			a--;
			vozilo.setX(a);
			return toString(vozilo.getX(),vozilo.getY());


		} else if(command == "r"){

			int a = vozilo.getX();
			a++;
			vozilo.setX(a);
			return toString(vozilo.getX(),vozilo.getY());



		}





		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		return null;
	}


	public String toString(int x, int y){

		return "(" + x + "," + y + ")";
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


	public String getSide() {
		return side;
	}


	public void setSide(String side) {
		this.side = side;
	}


	public Vozilo getVozilo() {
		return vozilo;
	}


	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}


}
