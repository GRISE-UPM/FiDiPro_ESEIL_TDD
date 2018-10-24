import java.util.ArrayList;





public class PlanetExplorer {
	private String direction = "N";
	private int x;
	private int y;
	private int yPos;
	private int xPos;
	private boolean signal = false;
	private String obstacles;
	private String [] obstaclesArray;
	private String [] obstaclesHit;
	ArrayList<Integer> arl = new ArrayList<Integer>();
	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		this.x=x;
		this.y=y;
		this.obstacles=obstacles;

	}

	public void check() {
		if(obstacles==null)
		{
			signal = false;
		}
		else 
		{
			signal = true;
		}
	}
	public boolean obstacles()
	{
		if(signal==true)
		{
		obstaclesArray = obstacles.split("	       for(int i=0;i<obstaclesArray.length;i++)
	       {
	    	   arl.add(Integer.parseInt(obstaclesArray[i]));
	       }
	       for(int i =0; i<arl.size();i=i+2)
	       {
	    	   if(xPos==arl.get(i)&&yPos==arl.get(i+1))
	    	   {
	    		   obstaclesHit[i]=Integer.toString(arl.get(i));
	    		   obstaclesHit[i+1]=Integer.toString(arl.get(i+1));
	    		   return false;
	    	   }
	    	   return true;
	       }
		}
	       return true;
	}

	public String executeCommand(String command){

		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(xPos,yPos,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where xPos and yPos are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
	       for(int i=0;i<obstaclesArray.length;i++)
	       {
	    	   arl.add(Integer.parseInt(obstaclesArray[i]));
	       }*


	       if(direction=="W" || direction=="E")
			{

				if(this.xPos==x-1){
					xPos=0;
				}

				else if(command=="f")
				{
					if(obstacles())
					xPos++;



				}
				else if(command=="b")
				{
					if(obstacles())
					xPos--;

				}

			}

	       if(direction=="N" || direction=="S")
			{
				if(this.yPos==y-1){
					yPos=0;
				}
				else if(command=="f")
				{
					if(obstacles())
					yPos++;

				}
				else if(command=="b")
				{
					if(obstacles())
					yPos--;

				}
			}

			if(command=="l")
			{
				direction="W";
			}
			if(command=="r")
			{
				direction="E";

			}
			if(signal==false)
			return "("+xPos+","+yPos+","+direction+")";
			else 
				return "("+xPos+","+yPos+","+direction+")"+"("+obstaclesHit[1]+","+obstaclesHit[2]+")";

	}
}
