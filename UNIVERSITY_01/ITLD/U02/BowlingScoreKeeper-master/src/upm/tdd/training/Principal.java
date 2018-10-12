package upm.tdd.training;

public class Principal {
	public static void main(String args[]){
		Game game=new Game();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		Frame strike=new Frame(10,0);
		strike.setLastFrame();
		game.addFrame(strike);
		Frame specialFrame=new Frame(0,0);
		specialFrame.setTirada(0, 10);
		specialFrame.setTirada(1, 10);
		System.out.print(specialFrame.score());
		game.addBonus(specialFrame);
		System.out.print(game.score());
	}
}
