
public class Pozicija {
	private int x = 0;
	private int y = 0;
	private String smer = "N";


	public Pozicija(){

	}

	public Pozicija(int x, int y, String smer){
		this.x = x;
		this.y = y;
		this.smer = smer;
	}

	public void pomeranje(String smer) throws PlanetExplorerException{
		if(smer == "l")
			obrnutoSmeruKazaljke();
		else if(smer == "r")
			uSmeruKazaljke();
		else if(smer == "f")
			pomeranjeNapred();
		else if(smer == "b")
			pomeranjeNazad();
		else
			throw new PlanetExplorerException("Uneta pogresna komanda");		
	}

	public void obrnutoSmeruKazaljke(){
		if(smer == "N")
			smer = "W";
		else if(smer == "W")
			smer = "S";
		else if(smer == "S")
			smer = "E";
		else
			smer = "N";
	}

	public void uSmeruKazaljke(){
		if(smer == "N")
			smer = "E";
		else if(smer == "W")
			smer = "N";
		else if(smer == "S")
			smer = "W";
		else
			smer = "S";
	}

	public void pomeranjeNapred(){
		if(smer == "N")
			y++;
		else if(smer == "W")
			x--;
		else if(smer == "S")
			y--;
		else
			x++;
	}

	public void pomeranjeNazad(){
		if(smer == "N")
			y--;
		else if(smer == "W")
			x++;
		else if(smer == "S")
			y++;
		else
			x--;
	}


	public String trenutnaPozicija(){
		return "(" + x + ", " + y + ", " + smer + ")"; 
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
