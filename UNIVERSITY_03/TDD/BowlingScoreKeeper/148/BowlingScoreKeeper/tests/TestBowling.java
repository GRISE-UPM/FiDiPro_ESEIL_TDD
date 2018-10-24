import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test_PocetakPartije() {
		Frame frame = new Frame();
		String rezultat =  frame.getScore();
		assertEquals("Rezultat prvog frejma na samom pocetku", "0", rezultat);
	}

	@Test 
	public void test_PoeniPrvogFrejma() throws BowlingException{
		Frame frame = new Frame(6,3);
		String rezultat = frame.getScore();
		assertEquals("Poeni ostvareni u prvom frejmu", "9", rezultat);
	}

	@Test
	public void test_ProveraStrajkaFrejma() throws BowlingException{
		Frame frame = new Frame(10,0);
		assertTrue("Provera strajka", frame.isStrike());
	}

	@Test
	public void test_ProveraSperaFrejma() throws BowlingException{
		Frame frame = new Frame(6,4);
		assertTrue("Provera spera", frame.isSpare());
	}

	@Test(expected = BowlingException.class)
	public void test_ProveraPogresnihVrednostiPrvogBacanjaUFrejmu() throws BowlingException{
		Frame frame = new Frame(11,5);
	}

	@Test(expected = BowlingException.class)
	public void test_ProveraPogresnihVrednostiDrugogBacanjaUFrejmu() throws BowlingException{
		Frame frame = new Frame(7,5);
	}

	@Test(expected = BowlingException.class)
	public void test_ProveraNegativnihVrednostiPrvogBacanjaUFrejmu() throws BowlingException{
		Frame frame = new Frame(-7,5);
	}

	@Test(expected = BowlingException.class)
	public void test_ProveraNegativnihVrednostiDrugogBacanjaUFrejmu() throws BowlingException{
		Frame frame = new Frame(7,-5);
	}

	@Test
	public void test_ProveraOdigranogBrojaFrejmovaUPartiji() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,8));
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(4,3));

		String brojOdigranihFrejmova = game.getNumberOfFrames();

		assertEquals("Provera broja odigranih frejmova", "3", brojOdigranihFrejmova);
	}

	@Test(expected = BowlingException.class)
	public void test_ProveraViseOdDozvoljenoOdigranoBrojaFrejmovaUPartiji() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,8));
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(4,3));
		game.addFrame(new Frame(1,8));
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(4,3));
		game.addFrame(new Frame(1,8));
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(4,3));
		game.addFrame(new Frame(1,8));
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(4,3));

	}

	@Test
	public void test_ProveraDobijenogBonusaNakonSpare() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(4,6));
		game.addFrame(new Frame(5,4));

		String rezultat = game.getScore();

		assertEquals("Provera dobijenog bonusa nakon spare", "24", rezultat);
	}

	@Test 
	public void test_ProveraDobijenogBonusaNakonStrike() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(5,4));

		String rezultat = game.getScore();

		assertEquals("Provera dobijenog bonusa nakon spare", "28", rezultat);
	}

	@Test
	public void test_rezultatNakonDesetBacanja() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(4,5));

		game.addFrame(new Frame(4,6));

		String ocekivano = 91 + game.getBonus().getFirstThrow() + game.getBonus().getScore();

		String rezultat = game.getScore();

		assertEquals("Provera rezultata nakon 10 bacanja plus dodatno", ocekivano, rezultat);
	}

}
