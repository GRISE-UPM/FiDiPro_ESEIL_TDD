import java.util.concurrent.ExecutionException;

import org.hamcrest.core.SubstringMatcher;





public class PlanetExplorer {

	public int granicaX;
	public int granicaY;
	public int koordinataX;
	public int koordinataY;
	public String smer = "n"; 
	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		this.granicaX=x;
		this.granicaY=y;
		this.koordinataX=0;
		this.koordinataY=0;

	}

	public String executeCommand(String command)throws PlanetExplorerException{

		char[] komanda = command.toCharArray();
		for(int i=0; i<command.length(); i++){
			String pomocni = command.substring(i, i+1);
			if(pomocni.equalsIgnoreCase("r")){
				if(smer.equalsIgnoreCase("n")){
					smer = "e";
				}
				else if(smer.equalsIgnoreCase("e")){
					smer = "s";
				}
				else if(smer.equalsIgnoreCase("s")){
					smer = "w";
				}
				else if(smer.equalsIgnoreCase("w")){
					smer="n";
				}
				else{
					throw new PlanetExplorerException();
				}
			}
			else if(pomocni.equalsIgnoreCase("l")){
				if(smer.equalsIgnoreCase("n")){
					smer = "w";
				}
				else if(smer.equalsIgnoreCase("e")){
					smer = "n";
				}
				else if(smer.equalsIgnoreCase("s")){
					smer = "e";
				}
				else if(smer.equalsIgnoreCase("w")){
					smer="s";
				}
				else{
					throw new PlanetExplorerException();
				}
			}
			else if(pomocni.equalsIgnoreCase("f")){
				if(smer.equalsIgnoreCase("n")){
					if(koordinataY == granicaY){
						koordinataY=0;
					}
					else{
						koordinataY++;
					}
				}
				else if(smer.equalsIgnoreCase("e")){
					if(koordinataX == granicaX){
						koordinataX=0;
					}
					else{
						koordinataX++;
					}
				}
				else if(smer.equalsIgnoreCase("s")){
					if(koordinataY == 0){
						koordinataY=granicaY;
					}
					else{
						koordinataY--;
					}
				}
				else if(smer.equalsIgnoreCase("w")){
					if(koordinataX == 0){
						koordinataX=granicaX;
					}
					else{
						koordinataX--;
					}
				}
				else{
					throw new PlanetExplorerException();
				}
			}
			else if(pomocni.equalsIgnoreCase("b")){
				if(smer.equalsIgnoreCase("n")){
					if(koordinataY == 0){
						koordinataY=granicaY;
					}
					else{
						koordinataY--;
					}
				}
				else if(smer.equalsIgnoreCase("e")){
					if(koordinataX == 0){
						koordinataX=granicaX;
					}
					else{
						koordinataX--;
					}
				}
				else if(smer.equalsIgnoreCase("s")){
					if(koordinataY == granicaY){
						koordinataY=0;
					}
					else{
						koordinataY--;
					}
				}
				else if(smer.equalsIgnoreCase("w")){
					if(koordinataX == 0){
						koordinataX=granicaX;
					}
					else{
						koordinataX--;
					}
				}
				else{
					throw new PlanetExplorerException();
				}
			}
		}


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		return "("+koordinataX + "," + koordinataY + "," + smer+")";
	}

	public int getGranicaX() {
		return granicaX;
	}

	public void setGranicaX(int granicaX) {
		this.granicaX = granicaX;
	}

	public int getGranicaY() {
		return granicaY;
	}

	public void setGranicaY(int granicaY) {
		this.granicaY = granicaY;
	}

	public int getKoordinataX() {
		return koordinataX;
	}

	public void setKoordinataX(int koordinataX) {
		this.koordinataX = koordinataX;
	}

	public int getKoordinataY() {
		return koordinataY;
	}

	public void setKoordinataY(int koordinataY) {
		this.koordinataY = koordinataY;
	}

	public String getSmer() {
		return smer;
	}

	public void setSmer(String smer) {
		this.smer = smer;
	}
}
