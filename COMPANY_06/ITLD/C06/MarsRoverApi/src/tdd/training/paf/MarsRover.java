package tdd.training.paf;

public class MarsRover {
	private int m_PosX;
	private int m_PosY;
	private int m_Facing;
	private int m_Grid[][];
	
	public MarsRover(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)" with no white spaces. 
	 *  
		Example use:
		MarsRover rover = new MarsRover(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		m_PosX = x;
		m_PosY = y;
		m_Facing = 0;
		m_Grid = new int[100][100];
		SetupGrid(obstacles);
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)"  
		 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		//TODO: check, fix.
		/*for (int i = 0; i < command.length(); i++)
		{
			executeOneCommand(Character.toString(command.charAt(i)));
			System.out.print(Character.toString(command.charAt(i)));
			System.out.print("\n");
		}*/
		executeOneCommand(command);
		
		return ToString();
	}
	
	private String executeOneCommand(String command)
	{
		if ( command.length() == 1 )
		{
			ExecuteRotation(command);
			ExecuteMovement(command);
		}
		return ToString();
	}
	
	private void ExecuteRotation(String command)
	{
		if ( command == "l" )
		{
			m_Facing--;
			CapFacing();
		}
		if ( command == "r" )
		{
			m_Facing++;
			CapFacing();
		}
	}
	
	private void ExecuteMovement(String command)
	{
		if ( command == "f" )
		{
			if ( m_Facing == 0 && m_Grid[m_PosX][m_PosY + 1] == 0 )
			{
				m_PosY++;
			}
			if ( m_Facing == 1 && m_Grid[m_PosX + 1][m_PosY] == 0 )
			{
				m_PosX++;
			}
			if ( m_Facing == 2 && m_Grid[m_PosX][m_PosY - 1] == 0 )
			{
				m_PosY--;
			}
			if ( m_Facing == 3 && m_Grid[m_PosX - 1][m_PosY] == 0 )
			{
				m_PosX--;
			}
			CapPosition();
		}
		if ( command == "b" )
		{
			if ( m_Facing == 0 && m_Grid[m_PosX][m_PosY - 1] == 0 )
			{
				m_PosY--;
			}
			if ( m_Facing == 1 && m_Grid[m_PosX - 1][m_PosY] == 0 )
			{
				m_PosX--;
			}
			if ( m_Facing == 2 && m_Grid[m_PosX][m_PosY + 1] == 0 )
			{
				m_PosY++;
			}
			if ( m_Facing == 3 && m_Grid[m_PosX + 1][m_PosY] == 0 )
			{
				m_PosX++;
			}
			CapPosition();
		}
	}
	
	private void SetupGrid(String obstacles)
	{
		InitGrid();
		//TODO: parse obstacles string.
	}
	
	private void InitGrid()
	{
		for (int i = 0; i < 100; i++)
		{
			for (int j = 0; j < 100; j++)
			{
				m_Grid[i][j] = 0;
			}
		}
	}
	
	private void CapFacing()
	{
		if ( m_Facing < 0 )
		{
			m_Facing = 3;
		}
		if ( m_Facing > 3 )
		{
			m_Facing = 0;
		}
	}
	
	private void CapPosition()
	{
		if ( m_PosX > 99 && m_Grid[0][m_PosY] == 0 )
		{
			m_PosX = 0;
		}
		if ( m_PosX < 0 && m_Grid[99][m_PosY] == 0 )
		{
			m_PosX = 99;
		}
		if ( m_PosY > 99 && m_Grid[m_PosX][0] == 0 )
		{
			m_PosY = 0;
		}
		if ( m_PosY < 0 && m_Grid[m_PosX][99] == 0 )
		{
			m_PosY = 99;
		}
	}
	
	private String GetFacing()
	{
		switch (m_Facing) {
			case 0:
				return "N";
			case 1:
				return "E";
			case 2:
				return "S";
			case 3:
				return "W";
		}
		return "N";
	}
	
	private String ToString()
	{
		String result = "";
		result += "(";
		result += Integer.toString(m_PosX);
		result += ",";
		result += Integer.toString(m_PosY);
		result += ",";
		result += GetFacing();
		result += ")";
		return result;
	}
}
