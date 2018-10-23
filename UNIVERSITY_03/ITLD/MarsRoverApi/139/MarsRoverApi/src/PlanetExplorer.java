




public class PlanetExplorer {
	private int gridX;
	private int gridY;
	private String obstacles;
	private char smer;
	private int pos_x;
	private int pos_y;

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" 
	 *  with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
	 *		this.gridX=x;
		this.gridY=y;
		this.obstacles=obstacles;

	}
	public PlanetExplorer(int x, int y, String obstacles,char smer,int pos_x,int pos_y){
		this.gridX=x;
		this.gridY=y;
		this.obstacles=obstacles;
		this.smer=smer;
		this.pos_x=pos_x;
		this.pos_y=pos_y;
	}

	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)
		 * ..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the
		 *  explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates
		 *  of the encountered obstacles. No white spaces.
		 *

		for (int i = 0; i < niz_prepreka.length; i++) {
			System.out.println(niz_prepreka[i]);
		}*
		char [] kretanja = command.toCharArray();

		for (int j = 0; j < kretanja.length; j++) {
			if(smer=='N'){
				switch(kretanja[j]){
				case 'f':
					this.pos_x++;
					break;
				case 'b':
					if(this.pos_x==0){
						this.pos_x=this.gridX-1;
						break;
					}
					this.pos_x--;
					break;
				}
			}else if(smer=='S'){
				switch(kretanja[j]){
				case 'b':
					this.pos_x++;
					break;
				case 'f':
					if(this.pos_x==0){
						this.pos_x=this.gridX-1;
						break;
					}
					this.pos_x--;
					break;
				}
			}else if(smer=='W'){
				switch(kretanja[j]){
				case 'b':
					this.pos_y++;
					break;
				case 'f':
					if(this.pos_y==0){
						this.pos_y=this.gridY-1;
						break;
					}
					this.pos_y--;
					break;
				}
			}else if(smer=='E'){
				switch(kretanja[j]){
				case 'f':
					this.pos_y++;
					break;
				case 'b':
					if(this.pos_y==0){
						this.pos_y=this.gridY-1;
						break;
					}
					this.pos_y--;
					break;
				}
			}

		}


		return this.getPosition();
	}

	public String getPosition(){

		return "("+this.pos_x+", "+this.pos_y+", "+this.smer+")";
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

	public String getObstacles() {
		return obstacles;
	}

	public void setObstacles(String obstacles) {
		this.obstacles = obstacles;
	}

	public char getSmer() {
		return smer;
	}

	public void setSmer(char smer) {
		this.smer = smer;
	}
	public int getPos_x() {
		return pos_x;
	}
	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}
	public int getPos_y() {
		return pos_y;
	}
	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}

}
