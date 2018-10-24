




public class PlanetExplorer {

	int x, y;
	int pozX, pozY;
	String smer;
	String obstacles;
	boolean osaX;

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *
		if(x<0 || y<0){

		}
		else{
		this.x=x;
		this.y=y;
		this.obstacles=obstacles;
		pozX=0;
		pozY=0;
		smer="N";
		osaX=false;
		}



	}

	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		for(int i=0; i<command.length();i++){
			char cmnd=command.charAt(i);
			switch(cmnd){
			case 'f':
				if(pozY==y && !osaX){
					pozY=0;
				}
				else if(pozX==x && osaX){
					pozX=0;
				}
				else if(osaX && pozX==0 && smer=="W"){
					pozX=x;
				}
				else{
					if (!osaX)
						pozY++;
					else
						pozX++;
				}
				break;

			case 'b':
				if(pozY==0 && !osaX){
					pozY=y;
				}
				else if(pozX==0 && osaX){
					pozX=x;
				}
				else if(pozY==0 && !osaX && smer=="S"){
					pozY=y;
				}
				else {
					if(!osaX)
						pozY--;
					else
						pozX++;
				}
				break;

			case 'r':
				if(smer=="N"){
					smer="E";
					osaX=true;
				}
				else if(smer=="E"){
					smer="S";
					osaX=false;
				}
				else if(smer=="S"){
					smer="W";
					osaX=true;
				}
				else if(smer=="W"){
					smer="N";
					osaX=false;
				}
				break;

			case 'l':
				if(smer=="N"){
					smer="W";
					osaX=true;
				}
				else if(smer=="W"){
					smer="S";
					osaX=false;
				}
				else if(smer=="S"){
					smer="E";
					osaX=true;
				}
				else if(smer=="E"){
					smer="N";
					osaX=false;
				}
				break;
			}
		}

		return "("+pozX+","+pozY+","+smer+")";
	}
}
