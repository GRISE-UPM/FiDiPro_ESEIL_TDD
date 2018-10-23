import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommand() {
		fail("Not yet implemented");
	}*
	@Test
	public void test_check_constructor()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		assertNotNull(pe);
	}


	@Test
	public void test_check_start_position()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,N)( )";

		assertEquals(expected, pe.executeCommand("s"));
	}

	@Test
	public void test_move_forth_for_1_direction_N()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,1,N)( )";

		assertEquals(expected, pe.executeCommand("f"));
	}

	@Test
	public void test_move_forth_for_2_direction_N()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,2,N)( )";

		assertEquals(expected, pe.executeCommand("ff"));
	}

	@Test
	public void test_move_forth_for_3_direction_N()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,3,N)( )";

		assertEquals(expected, pe.executeCommand("fff"));
	}

	@Test
	public void test_move_forth_for_4_direction_N()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,N)( )";

		assertEquals(expected, pe.executeCommand("ffff"));
	}

	@Test
	public void test_change_direction_E()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,E)( )";

		assertEquals(expected, pe.executeCommand("r"));
	}

	@Test
	public void test_move_forth_for_1_direction_E()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(1,0,E)( )";

		assertEquals(expected, pe.executeCommand("rf"));
	}

	@Test
	public void test_move_forth_for_2_direction_E()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(2,0,E)( )";

		assertEquals(expected, pe.executeCommand("rff"));
	}

	@Test
	public void test_move_forth_for_3_direction_E()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(3,0,E)( )";

		assertEquals(expected, pe.executeCommand("rfff"));
	}

	@Test
	public void test_change_direction_S_with_comand_r()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,S)( )";

		assertEquals(expected, pe.executeCommand("rr"));
	}

	@Test
	public void test_change_direction_W_with_comand_r()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,W)( )";

		assertEquals(expected, pe.executeCommand("rrr"));
	}

	@Test
	public void test_change_direction_N_with_comand_r()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,N)( )";

		assertEquals(expected, pe.executeCommand("rrrr"));
	}

	@Test
	public void test_change_direction_W_with_comand_l()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,W)( )";

		assertEquals(expected, pe.executeCommand("l"));
	}

	@Test
	public void test_change_direction_S_with_comand_l()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,S)( )";

		assertEquals(expected, pe.executeCommand("ll"));
	}

	@Test
	public void test_change_direction_E_with_comand_l()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,E)( )";

		assertEquals(expected, pe.executeCommand("lll"));
	}

	@Test
	public void test_change_direction_N_with_comand_l()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,N)( )";

		assertEquals(expected, pe.executeCommand("llll"));
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_wrong_command()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,N)( )";

		assertEquals(expected, pe.executeCommand("g"));
	}

	@Test
	public void test_change_direction_S_with_comand_r_move_forth_1()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,3,S)( )";

		assertEquals(expected, pe.executeCommand("rrf"));
	}

	@Test
	public void test_change_direction_S_with_comand_r_move_forth_2()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,2,S)( )";

		assertEquals(expected, pe.executeCommand("rrff"));
	}

	@Test
	public void test_change_direction_S_with_comand_r_move_forth_3()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,1,S)( )";

		assertEquals(expected, pe.executeCommand("rrfff"));
	}

	@Test
	public void test_change_direction_W_with_comand_r_move_1_forth()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(3,0,W)( )";

		assertEquals(expected, pe.executeCommand("rrrf"));
	}

	@Test
	public void test_move_backfor_1_direction_N()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,3,N)( )";

		assertEquals(expected, pe.executeCommand("b"));
	}

	@Test
	public void test_move_backfor_2_direction_N()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,2,N)( )";

		assertEquals(expected, pe.executeCommand("bb"));
	}

	@Test
	public void test_move_backfor_3_direction_N()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,1,N)( )";

		assertEquals(expected, pe.executeCommand("bbb"));
	}

	@Test
	public void test_move_backfor_4_direction_N()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,N)( )";

		assertEquals(expected, pe.executeCommand("bbbb"));
	}

	@Test
	public void test_move_backfor_1_direction_E()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(3,0,E)( )";

		assertEquals(expected, pe.executeCommand("rb"));
	}

	@Test
	public void test_move_backfor_2_direction_E()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(2,0,E)( )";

		assertEquals(expected, pe.executeCommand("rbb"));
	}

	@Test
	public void test_move_backfor_1_direction_W()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(1,0,W)( )";

		assertEquals(expected, pe.executeCommand("lb"));
	}

	@Test
	public void test_move_backfor_4_direction_W()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,W)( )";

		assertEquals(expected, pe.executeCommand("lbbbb"));
	}

	@Test
	public void test_move_backfor_1_direction_S()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,1,S)( )";

		assertEquals(expected, pe.executeCommand("llb"));
	}

	@Test
	public void test_move_backfor_4_direction_S()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, " ");
		String expected = "(0,0,S)( )";

		assertEquals(expected, pe.executeCommand("llbbbb"));
	}

	@Test(expected=PlanetExplorerException.class)
	public void test_wrong_coordinate()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(5, 5, " ");
		String expected = "(0,1,S)( )";

		assertEquals(expected, pe.executeCommand("llb"));
	}

	@Test
	public void test_obstacle()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, "1,1");
		String expected = "(0,1,S)(1,1)";
	}

	@Test(expected=PlanetExplorerException.class)
	public void test_obstacle_wihout_grid()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(0, 0, "5,5");
		String expected = "(0,1,S)(1,1)";
	}

}
