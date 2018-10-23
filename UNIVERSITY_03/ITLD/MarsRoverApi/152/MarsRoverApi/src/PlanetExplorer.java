




public class PlanetExplorer {
	private int x ;
	private int y ;
	String obstacles = "";

	private String smerS = "S";
	private String smerE = "E";
	private String smerW = "W";*
	private String smer = "N";
	int prvaKordinata = 0 ;
	int drugaKordinata = 0;
	private int[] vozilo = {prvaKordinata,drugaKordinata};

	public PlanetExplorer(int x, int y, String obstacles){

		this.x = x;
		this.y = y;
		this.obstacles = obstacles;


	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *	}

	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		String prviSplit = this.obstacles.replace("(","");
		String drugiSplit = prviSplit.replace(")","");
		String treciSplit = drugiSplit.replace(",","");
		char[] nizCarovaKoordinataOBST = treciSplit.toCharArray();
		int [] niz = new int [nizCarovaKoordinataOBST.length];
		for(int i = 0;i<niz.length;i++){
			niz[i] = Integer.parseInt(String.valueOf(nizCarovaKoordinataOBST[i]));
		}
		int prvaKor = niz[0];
		int drugaKor = niz[1];

		char[] nizKomandi = command.toCharArray();
		int n = nizKomandi.length;
		if(x>=0 && y>=0){
			for(int i = 0; i<nizKomandi.length;i++){
				if(nizKomandi[i] == 'f'){
					if(smer == "N"){

						drugaKordinata++;

					}else if(smer == "E"){
						this.prvaKordinata++;

					}else if(smer == "S"){
						drugaKordinata--;

					}else if(smer == "W"){
						prvaKordinata--;

					}

				}else if(nizKomandi[i] == 'r'){
					if(smer == "N"){
						this.smer = "E";

					}else if(smer == "E"){
						smer = "S";

					}else if(smer == "S"){
						smer = "W";

					}else if(smer == "W"){
						smer = "N";

					}
				}else if(nizKomandi[i] == 'l'){
					if(smer == "N"){
						smer = "W";

					}else if(smer == "W"){
						smer = "S";

					}else if(smer == "S"){
						smer = "E";

					}else if(smer == "E"){
						smer = "N";

					}
				}else if(nizKomandi[i] == 'b'){
					if(smer == "N"){
						drugaKordinata--;

					}else if(smer == "E"){
						prvaKordinata--;

					}else if(smer == "S"){
						drugaKordinata++;

					}else if(smer == "W"){
						prvaKordinata++;

					}
				}

			}
			return "("+prvaKordinata+","+drugaKordinata+","+smer+")";
		}

		return null;
	}


		String prviSplit = this.obstacles.replace("(","");
		String drugiSplit = prviSplit.replace(")","");
		String treciSplit = drugiSplit.replace(",","");
		char[] nizCarovaKoordinataOBST = treciSplit.toCharArray();
		int [] niz = new int [nizCarovaKoordinataOBST.length];
		for(int i = 0;i<niz.length;i++){
			niz[i] = Integer.parseInt(String.valueOf(nizCarovaKoordinataOBST[i]));
		}
		int prvaKor = niz[0];
		int drugaKor = niz[1];
	}*
}
