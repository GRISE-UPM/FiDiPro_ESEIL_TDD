import javax.swing.plaf.synth.SynthSpinnerUI;





public class PlanetExplorer {

	public PlanetExplorer(int x, int y){

	}

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *
	}
	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		char[] komande = command.toCharArray();

		String side = "N";
		String route = "(0,0)";
		for (int i = 0; i < komande.length; i++) {
			String[] ruta =route.split(",");

			char[] iks = ruta[0].toCharArray();
			char[] ipsilon = ruta[1].toCharArray();

			int novoX = Integer.parseInt(String.valueOf(iks[1]));
			int novoY = Integer.parseInt(String.valueOf(ipsilon[0]));

			if(komande[i] == 'f' && side == "N"){
				route = GoUp(novoX, novoY);
				side = "N";
			}
			else if(komande[i] == 'b' && side == "N"){
				route = GoDown(novoX, novoY);
				side = "N";
			}
			else if(komande[i] == 'r' && side == "N"){
				side = "E";
			}
			else if(komande[i] == 'l' && side == "N"){
				side = "W";
			}

			else if(komande[i] == 'f' && side == "E"){
				route = GoRight(novoX, novoY);
				side = "E";
			}
			else if(komande[i] == 'b' && side == "E"){
				route = GoLeft(novoX, novoY);
				side = "E";
			}
			else if(komande[i] == 'r' && side == "E"){
				side = "S";
			}
			else if(komande[i] == 'l' && side == "E"){
				side = "N";
			}

			else if(komande[i] == 'f' && side == "S"){
				route = GoDown(novoX, novoY);
				side = "S";
			}
			else if(komande[i] == 'b' && side == "S"){
				route = GoUp(novoX, novoY);
				side = "S";
			}
			else if(komande[i] == 'r' && side == "S"){
				side = "W";
			}
			else if(komande[i] == 'l' && side == "S"){
				side = "E";
			}

			else if(komande[i] == 'f' && side == "W"){
				route = GoLeft(novoX, novoY);
				side = "W";
			}
			else if(komande[i] == 'b' && side == "W"){
				route = GoRight(novoX, novoY);
				side = "W";
			}
			else if(komande[i] == 'r' && side == "W"){
				side = "N";
			}
			else if(komande[i] == 'l' && side == "W"){
				side = "S";
			}		
		}

		return route;
	}

	public String GoUp(int x, int y){
		y++;
		return("("+x+","+y+")");
	}
	public String GoDown(int x, int y){
		y--;
		return("("+x+","+y+")");
	}
	public String GoRight(int x, int y){
		x++;
		return("("+x+","+y+")");
	}
	public String GoLeft(int x, int y){
		x--;
		return("("+x+","+y+")");
	}


}
