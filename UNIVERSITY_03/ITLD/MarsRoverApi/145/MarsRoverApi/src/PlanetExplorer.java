import java.util.ArrayList;





public class PlanetExplorer {
	private int gridX;
	private int gridY;
	private char strana = 'N';
	private char smer = 'f';

	private ArrayList<String> pre = new ArrayList<String>();
	private int kordinataX=0;
	private int kordinataY=0;
	String[] prepreke;
	ArrayList<Integer> preprekaX= new ArrayList<Integer>();
	ArrayList<Integer> preprekaY= new ArrayList<Integer>();
	public PlanetExplorer(int x, int y){

		 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
		 *  
			Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
			PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 *			gridX=x;
			gridY=y;



		}
	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
	 *		gridX=x;
		gridY=y;
		prepreke =obstacles.split(",");
		for(int i=0;i<prepreke.length;i++){
			preprekaX.add(Integer.parseInt(prepreke[i]));
		}
		for(int i=0;i<prepreke.length;i++){
			preprekaY.add(Integer.parseInt(prepreke[i]));
		}



	}

	public String executeCommand(String command) throws PlanetExplorerException{


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		char[] komande = command.toCharArray();
		for(int i=0;i<komande.length;i++){
			if(komande[i]=='f'){
			switch(strana){
			case 'N':
				if(kordinataY==gridY){
					kordinataY=0;
				}else{
					for(int j=0;j<preprekaY.size()-1;j++){
						if(preprekaY.get(i)==getKordinataY()){
							throw new PlanetExplorerException();
						}	
					}
				kordinataY++;
				}
				break;
			case 'S':
				if(kordinataY==0){
				kordinataY=gridY;
			}else{
			kordinataY--;
			}
				break;
			case 'E':
				if(kordinataX==gridX){
					kordinataY=0;
				}else{
				kordinataX++;
				}
				break;
			case 'W':
				if(kordinataY==0){
					kordinataX=gridX;
				}else{
				kordinataX--;
				}
				break;

			}
			}
			if(komande[i]=='b'){
				switch(strana){
				case 'N':
					if(kordinataY==0){
						kordinataY=gridY;
					}else{
					kordinataY--;
					}
					break;
				case 'S':
					if(kordinataY==gridY){
						kordinataY=0;
					}else{
					kordinataY++;
					}
					break;
				case 'E':
					if(kordinataY==0){
						kordinataX=gridX;
					}else{
					kordinataX--;
					}
					break;
				case 'W':
					if(kordinataX==gridX){
						kordinataY=0;
					}else{
					kordinataX++;
					}
					break;

				}		
		}
			if(komande[i]=='l'){
				switch(strana){
				case 'N':
					strana='W';
					break;
				case 'S':
					strana='E';
					break;
				case 'E':
					strana='N';
					break;
				case 'W':
					strana='S';
					break;
				}


		}
			if(komande[i]=='r'){
				switch(strana){
				case 'N':
					strana='E';
					break;
				case 'S':
					strana='W';
					break;
				case 'E':
					strana='S';
					break;
				case 'W':
					strana='N';
					break;
				}
	}
		}
		return getCoordinates();



	}
	public String getCoordinates(){
		return "("+kordinataX+", "+kordinataY+", "+ strana +")";
	}

	public int getGridX() {
		return gridX;
	}

	public void setGridX(int gridX) {
		this.gridX = gridX;
	}

	public int getGridY() {
		return gridY;
	}

	public void setGridY(int gridY) {
		this.gridY = gridY;
	}



	public ArrayList<String> getPre() {
		return pre;
	}

	public void setPre(ArrayList<String> pre) {
		this.pre = pre;
	}

	public int getKordinataX() {
		return kordinataX;
	}

	public void setKordinataX(int kordinataX) {
		this.kordinataX = kordinataX;
	}

	public int getKordinataY() {
		return kordinataY;
	}

	public void setKordinataY(int kordinataY) {
		this.kordinataY = kordinataY;
	}




}
