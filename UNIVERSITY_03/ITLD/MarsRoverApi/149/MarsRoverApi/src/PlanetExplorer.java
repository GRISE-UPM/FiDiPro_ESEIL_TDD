import java.util.List;





public class PlanetExplorer {

		private int xPoz;
		private int yPoz;
		private String face;
		private int x;
		private int y;
		private String obstacles;
	public PlanetExplorer(int x, int y, String obstacles){
		x=x;
		y=y;
		obstacles=obstacles;
		face="N";
	}

	public String executeCommand(String command) throws PlanetExplorerException{
		char[] com = command.toCharArray();
		String[] parts = obstacles.split(",");
		boolean moze=false;
		for(int j=0; j<com.length; j++){
		if(com[j]=='f'){
			for(int i=0; i<parts.length; i+=2){
				if(xPoz+1!=Integer.parseInt(parts[i])){
					moze=true;
				}
			}
			if(moze=true && xPoz+1<=x){
				xPoz++;
				if(xPoz==x){
					if(face=="N"){
						face="S";
					}
					else if(face=="S"){
						face="N";
					}
					else if(face=="W"){
						face="E";
					}
					else if(face=="E"){
						face="W";
					}
				}
				return "("+xPoz+","+yPoz+ "," +face+")";
			}
			moze=false;
		} else if(com[j]=='b'){
			for(int i=1; i<parts.length; i+=2){
				if(yPoz+1!=Integer.parseInt(parts[i])){
					moze=true;
				}

		}
			if(moze=true && yPoz+1<=y){
				yPoz++;
				if(xPoz==y){
					if(face=="N"){
						face="S";
					}
					else if(face=="S"){
						face="N";
					}
					else if(face=="W"){
						face="E";
					}
					else if(face=="E"){
						face="W";
					}
				}
				return "("+xPoz+","+yPoz+ "," +face+")";
			} 
			moze=false;
			} else if(com[j]=='l'){
				if(face=="N"){
					face="W";
				}
				else if(face=="S"){
					face="E";
				}
				else if(face=="W"){
					face="S";
				}
				else if(face=="E"){
					face="N";
				}
			}
			else if(com[j]=='r'){
				if(face=="N"){
					face="E";
				}
				else if(face=="S"){
					face="W";
				}
				else if(face=="W"){
					face="N";
				}
				else if(face=="E"){
					face="S";
				}
			}

		else throw new PlanetExplorerException();
		}
		return "("+xPoz+","+yPoz+ "," +face+")";
	}
	public String toString(){
		return "("+xPoz+","+yPoz+ "," +face+")";
	}

}
