import java.util.ArrayList;
import java.util.List;





public class PlanetExplorer {
	private int x = 0;
	private int y = 0;
	private String obstacles;
	private String direction = "n";
	private int roverX = 0;
	private int roverY = 0;
	private List<int[]> listaPrepreka = new ArrayList<int[]>();
	private List<int[]> listaKoriscenihPrepreka = new ArrayList<int[]>();

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		this.x = x;
		this.y = y;
		this.obstacles = obstacles;

	}

	public String executeCommand(String command) throws PlanetExplorerException{


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		if (obstacles != null){
			char[] nizPrepreka = obstacles.toCharArray();
			int counter = 0;
			int preprekaX = 0;
			int preprekaY = 0;
			int koriscena = 0;
			for (int i = 0; i < nizPrepreka.length; i++){
				char karakter = nizPrepreka[i];
				if (Character.isDigit(karakter)){
					if (counter == 0){
						preprekaX = Character.getNumericValue(karakter);
						counter = 1;
					} else if (counter == 1){
						counter = 0;
						preprekaY = Character.getNumericValue(karakter);
						int[] prepreka = {preprekaX, preprekaY, koriscena};
						listaPrepreka.add(prepreka);
					}
				}
			}
		}

		char[] niz = command.toCharArray();
		for (char i : niz){
			switch(i){
				case 'r': rotate(i); break; 
				case 'l': rotate(i); break;
				case 'f': moveForth(); break;
				case 'b': moveBack(); break;
				default: throw new PlanetExplorerException();
			}
		}

		String prepreke = "";

			for (int[] i : listaPrepreka){
				prepreke += "(" + i[0] + "," + i[1] + ")";
			}

			System.out.println(prepreke);

		return "(" + roverX + "," + roverY + "," + direction + ")" + prepreke;
	}

	public void rotate(char i){
		switch(i){
			case 'r': 
				if (direction.equals("n"))
					direction = "e";
				else if (direction.equals("e"))
					direction = "s";
				else if (direction.equals("s"))
					direction = "w";
				else 
					direction = "n";
				break;
			case 'l':
				if (direction.equals("n"))
					direction = "w";
				else if (direction.equals("w"))
					direction = "s";
				else if (direction.equals("s"))
					direction = "e";
				else 
					direction = "n";
				break;
		}
	}

	public void moveForth(){
		switch(direction){
			case "n":
				if (roverY == y - 1){
					if (obstacles != null){
						for (int[] i : listaPrepreka){
							if (i[0] == roverX && i[1] == 0){
								if (i[2] != 1){
									i[2] = 1;
									listaKoriscenihPrepreka.add(i);
								}
								return;
							}
						}
					}
					roverY = 0;
				}
				else {
					if (obstacles != null){
						for (int[] i : listaPrepreka){
							if (i[0] == roverX && i[1] == (y + 1)){
								if (i[2] != 1){
									i[2] = 1;
									listaKoriscenihPrepreka.add(i);
								}
								return;
							}
						}
					}
					roverY++; 
				}
				break;
			case "e": 
				if (roverX == x - 1){
					for (int[] i : listaPrepreka){
						if (i[0] == 0 && i[1] == roverY){
							if (i[2] != 1){
								i[2] = 1;
								listaKoriscenihPrepreka.add(i);
							}
							return;
						}
					}
					roverX = 0;
				}
				else {
					for (int[] i : listaPrepreka){
						if (i[0] == (x + 1) && i[1] == roverY){
							if (i[2] != 1){
								i[2] = 1;
								listaKoriscenihPrepreka.add(i);
							}
							return;
						}
					}
					roverX++; 
				}	
				break;
			case "s": 
				if (roverY == 0){
					for (int[] i : listaPrepreka){
						if (i[0] == roverX && i[1] == (y - 1)){
							if (i[2] != 1){
								i[2] = 1;
								listaKoriscenihPrepreka.add(i);
							}
							return;
						}
					}
					roverY = y - 1;
				}
				else {
					for (int[] i : listaPrepreka){
						if (i[0] == x && i[1] == (roverY - 1)){
							if (i[2] != 1){
								i[2] = 1;
								listaKoriscenihPrepreka.add(i);
							}
							return;
						}
					}
					roverY--; 
				}
				break;
			case "w": 
				if (roverX == 0) {
					for (int[] i : listaPrepreka){
						if (i[0] == (x - 1) && i[1] == roverY){
							if (i[2] != 1){
								i[2] = 1;
								listaKoriscenihPrepreka.add(i);
							}
							return;
						}
					}
					roverX = x - 1;
				}
				else {
					for (int[] i : listaPrepreka){
						if (i[0] == (roverX - 1) && i[1] == roverY){
							if (i[2] != 1){
								i[2] = 1;
								listaKoriscenihPrepreka.add(i);
							}
							return;
						}
					}
					roverX--;
				}
				break;
		}
	}

	public void moveBack(){
		switch(direction){
		case "n": 
			if (roverY == 0)
				roverY = y - 1;
			else
				roverY--; 
			break;
		case "e": 
			if (roverX == 0)
				roverX = x - 1;
			else
				roverX--; 
			break;
		case "s": 
			if (roverY == y - 1)
				roverY = 0;
			else
				roverY++; break;
		case "w": 
			if (roverX == x - 1)
				roverX = 0;
			else
				roverX++; 
			break;
	}
}
}
