




public class PlanetExplorer {
	private int x, y, x_Pos=0, y_Pos=0;
	private String facing="N";
	private String obstacles;
	public PlanetExplorer(int x, int y, String obstacles){
		this.x=x;
		this.y=y;
		this.obstacles=obstacles;
	}

public boolean checkIfCorrectX (int position) {
	if (position>0 && position<x) {
		return true;
	}
	return false;
}
public boolean checkIfCorrectY (int position) {
	if (position>0 && position<y) {
		return true;
	}
	return false;
}


	String[] obst=obstacles.split("[ || ( || , || ) || ]");
	for (int i=0; i<obst.length; i++) {

	}
}*

	public String executeCommand(String command){
		char[] commands=command.toCharArray();
		for (int i=0; i<commands.length; i++) {
			char cmd=commands[i];
		if (cmd=='f') {
			if (facing=="N") {
			if (checkIfCorrectY(y_Pos+1)) {
			y_Pos++;
		} else 
			{
				y_Pos=0;
			}
		}
			else if (facing=="E") {
				if (checkIfCorrectX(x_Pos+1)) {
				x_Pos++;
				} else {
					x_Pos=0;
				}
			}
			else if (facing=="S") {
				if (checkIfCorrectY(y_Pos-1)) { 
				y_Pos--;
				} else {
					y_Pos=y-1;
				}
			}
			else {
				if (checkIfCorrectX(x_Pos-1)) {
				x_Pos--;
				} else {
					x_Pos=x-1;
				}
			}

		}

		if (cmd=='b') {
			if (facing=="N") {
				if (checkIfCorrectY(y_Pos-1)) {
			y_Pos--; 
				} else {
					y_Pos=y-1;
				}
			}
			else if (facing=="E") {
				if (checkIfCorrectX(x_Pos-1)) {
				x_Pos--;
				} else {
					x_Pos=x-1;
				}
			}
			else if (facing=="S") {
				if (checkIfCorrectY(y_Pos+1)) {
				y_Pos++;
				} else {
					y_Pos=0;
				}
			}
			else {
				if (checkIfCorrectX(x_Pos+1)) {
				x_Pos++; 
				} else {
					x_Pos=0;
				}
			}
		}
		if (cmd=='r') {
			if (facing=="N") {
				facing="E";
			}
			else if (facing=="E") {
				facing="S";
			}
			else if (facing=="S") {
				facing="W";
			}
			else {
				facing="N";
			}
		}
		if (cmd=='l') {
			if (facing=="N") {
				facing="W";
			}
			else if (facing=="E") {
				facing="N";
			}
			else if (facing=="S") {
				facing="E";
			}
			else {
				facing="S";
			}
		} 
		}

		return "("+x_Pos+","+y_Pos+","+facing+")";
	}
}
