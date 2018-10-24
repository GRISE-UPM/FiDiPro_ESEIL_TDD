import java.util.ArrayList;





public class PlanetExplorer {

	private int x, y;
	private String direction = "N";
	private ArrayList<Tacka> lista;
	private Tacka explorerPosition = new Tacka(0, 0);

	public PlanetExplorer() {
		this.x = 0;
		this.y = 0;
	}

	public PlanetExplorer(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public PlanetExplorer(int x, int y, String obstacles) {

		 * x and y represent the size of the grid. Obstacles is a String
		 * formatted as follows:
		 * "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white
		 * spaces.
		 * 
		 * Example use: For a 100x100 grid with two obstacles at coordinates
		 * (5,5) and (7,8) PlanetExplorer explorer = new
		 * PlanetExplorer(100,100,"(5,5)(7,8)")
		 * 
		 *
		this.x = x;
		this.y = y;

		String[] niz = obstacles.split(":");
		for (int i = 0; i < niz.length; i++) {
			niz[i].replace("(", "");
			niz[i].replace(")", "");
			String[] tacka = niz[i].split(",");
			lista.add(new Tacka(Integer.parseInt(tacka[0]), Integer.parseInt(tacka[1])));
		}
	}

	public String executeCommand(String command) {

		 * The command string is composed of "f" (forward), "b" (backward), "l"
		 * (left) and "r" (right) Example: The explorer is on a 100x100 grid at
		 * location (0, 0) and facing NORTH. The explorer is given the commands
		 * "ffrff" and should end up at (2, 2) facing East.
		 * 
		 * The return string is in the format:
		 * "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)"
		 * Where pos_x and pos_y are the final coordinates, facing is the
		 * current direction the explorer is pointing to (N,S,W,E). The return
		 * string should also contain a list of coordinates of the encountered
		 * obstacles. No white spaces.
		 *
		char[] commands = command.toCharArray();

		for (int i = 0; i < commands.length; i++) {
			if (direction.equals("N")) {
				if (commands[i] == 'f'){
					explorerPosition.setY(explorerPosition.getY() + 1);
					if (explorerPosition.getY() == this.y) {
						explorerPosition.setY(0);
					}
				}
				else if(commands[i] == 'b'){
					explorerPosition.setY(explorerPosition.getY() - 1);
					if (explorerPosition.getY() < 0) {
						explorerPosition.setY(this.y);
					}
				}
				else if(commands[i] == 'r')
					direction = "E";
				else if(commands[i] == 'l')
					direction = "W";

			} else if (direction.equals("E")) {
				if(commands[i] == 'f'){
					explorerPosition.setY(explorerPosition.getX() + 1);
					if (explorerPosition.getX() == this.x) {
						explorerPosition.setX(0);
					}
				}
				else if(commands[i] == 'b'){
					explorerPosition.setY(explorerPosition.getX() - 1);
					if (explorerPosition.getX() < 0) {
						explorerPosition.setX(this.x);
					}
				}
				else if(commands[i] == 'r')
					direction = "S";
				else if(commands[i] == 'l')
					direction = "N";

			} else if (direction.equals("S")) {
				if(commands[i] == 'f'){
					explorerPosition.setY(explorerPosition.getY() - 1);
					if (explorerPosition.getY() < 0) {
						explorerPosition.setY(this.y);
					}
				}
				else if(commands[i] == 'b'){
					explorerPosition.setY(explorerPosition.getY() + 1);
					if (explorerPosition.getY() == this.y) {
						explorerPosition.setY(0);
					}
				}
				else if(commands[i] == 'r')
					direction = "W";
				else if(commands[i] == 'l')
					direction = "E";

			} else if (direction.equals("W")) {
				if(commands[i] == 'f'){
					explorerPosition.setY(explorerPosition.getX() - 1);
					if (explorerPosition.getX() < 0) {
						explorerPosition.setX(this.x);
					}
				}
				else if(commands[i] == 'b'){
					explorerPosition.setY(explorerPosition.getX() + 1);
					if (explorerPosition.getX() == this.x) {
						explorerPosition.setX(0);
					}
				}
				else if(commands[i] == 'r')
					direction = "N";
				else if(commands[i] == 'l')
					direction = "S";

			} else {

			}
		}
		return "(" + Integer.toString(explorerPosition.getX()) + "," + Integer.toString(explorerPosition.getY()) + ","
				+ direction + ")";
	}
}
