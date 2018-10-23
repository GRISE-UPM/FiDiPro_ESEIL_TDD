




public class PlanetExplorer {

	int x;
	int y;
	String obstacles;
	String[] vozilo;

	public PlanetExplorer(int x, int y, String obstacles){
		this.x=x;
		this.y=y;
		this.obstacles=obstacles;
		vozilo=new String[]{"0,0,n"};
	}



	public String executeCommand(String command){

		String[] komande=command.split(",");

		for(int i=0;i<komande.length;i++){

			if(komande[i]=="f"){
				int broj=Integer.parseInt(vozilo[1]);
				broj++;
				vozilo[i]=Integer.toString(broj);

			}else if(komande[i]=="b"){
				int broj=Integer.parseInt(vozilo[1]);
				broj--;
				vozilo[i]=Integer.toString(broj);
			}
		}


		return vozilo[0]+","+vozilo[1]+","+vozilo[2];
	}
}
