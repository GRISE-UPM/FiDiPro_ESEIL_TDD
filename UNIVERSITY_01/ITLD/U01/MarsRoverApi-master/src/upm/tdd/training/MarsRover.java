package upm.tdd.training;

public class MarsRover {
	int posx;
	int posy;
	int camino[][];
	int report[][];
	int coordenada[];
	
	public MarsRover(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: ?(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)? with no white spaces. 
	 *  
		Example use:
		MarsRover rover = new MarsRover(100,100,?(5,5)(7,8)?)  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		posx=0;
		posy=0;
		camino=new int[x][y];
		int cont=0;
		
		for(int fila=0;fila<camino.length;fila++)
			for(int col=0;col<camino[fila].length;col++){
				camino[fila][col]=0;
				
			}

		
		char[] Aobsta = obstacles.toCharArray();
			for (int cc=0;cc<Aobsta.length;cc++){
				if(Character.isDigit(Aobsta[cc])){
					coordenada[cont]=Aobsta[cc];
					cont++;
					
				}
				
			}
			for(int i=0;i<coordenada.length;i=i+2){
				camino[coordenada[i]][coordenada[i+1]]=1;
			}
				
		
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: ?(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)?  
		 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		String retorno;
		String facing;
		
		char[] letras = command.toCharArray();
		for (int p=0;p<letras.length;p++){
			if(letras[p]=='f'){
				forward();
				facing="NORTH";
				
			}
			else if(letras[p]=='b'){
				backward();
				facing="SOUTH";
			}else if(letras[p]=='r'){
				right();
				facing="EAST";
				
			}else if(letras[p]=='l'){
				left();
				facing="WEST";
				
			}else{
				System.out.print("opcion errada");
				break;
			}
				
			
		}
		
		retorno="?(posx,posy,facing) ";
		for(int fi=0;fi<report.length;fi++)
			for(int co=0;co<report[fi].length;co++)
				if (report[fi][co]==1)
					retorno=retorno+ "("+fi+","+co+") ";
		
		
		return retorno;
	}
	
	public void left(){
		int temp=0;
				
		if(posx>0){
			temp=posx;
			posx=posx-1;
		}
		else
			posx=camino.length;
		
		if(camino[posx][posy]==1){
			report[posx][posy]=1;
			posx=temp;
			
		}
		
	}

	
	public void right(){
		int temp=0;
	
		if(posx<camino.length){
			temp=posx;
			posx=posx+1;
			
		}
		else
			posx=0;
		
		if(camino[posx][posy]==1){
			report[posx][posy]=1;
			posx=temp;
		}
			
	}
	
	public void backward(){
		int temp=0;
		if(posy>0){
			temp=posy;
			posy=posy-1;
		}
		else
			posy=camino[1].length;
		
		if(camino[posx][posy]==1){
			report[posx][posy]=1;
			posy=temp;
		}
		
	}
	
	public void forward(){
		int temp=0;
		if(posy<camino[1].length){
			temp=posy;
			posy=posy+1;
		}
		else
			posy=0;
	
		if(camino[posx][posy]==1){
			report[posx][posy]=1;
			posy=temp;
		}
	
	
	}
	
	
	public static void main(String arg[]){
		String retorno;
		MarsRover mr=new MarsRover(100,100,"?(5,5)(7,8)?");
		retorno=mr.executeCommand("lf");
		System.out.println(retorno);
	}
	

	
	
	
}
