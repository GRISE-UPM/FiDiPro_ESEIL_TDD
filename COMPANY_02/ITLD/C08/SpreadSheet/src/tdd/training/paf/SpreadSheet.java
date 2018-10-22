package tdd.training.paf;

import com.sun.deploy.util.StringUtils;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class SpreadSheet {

	private String[][]  cellValues;

	public SpreadSheet(){
		this.cellValues = new String[3][3];
		populateSpreadSheet();
	}

	private void populateSpreadSheet(){
		this.cellValues[0][0] = "4";
		this.cellValues[0][1] = "=4+3";
		this.cellValues[0][2] = "=2*3";

		this.cellValues[1][0] = "5";
		this.cellValues[1][1] = "=A2";
		this.cellValues[1][2] = "=B1";

		this.cellValues[2][0] = "=5-3";
		this.cellValues[2][1] = "9";
		this.cellValues[2][2] = "";
	}

	/**
	 * @param cell		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @return			The cell's contents (e.g. "1", "=5", "=1+B3", "=1+(B3*4)", etc.)
	 */
	public long get(String cell) throws Exception {
		if(cell.length() > 2){
			throw new Exception("cell cannot have more than 2 literals");
		}else{
			char c = cell.charAt(0);
			char c1 = cell.charAt(1);
			int i;
			if(c == 'A'){
				i = 0;
			}else if(c == 'B'){
				i=1;
			}else if(c=='C'){
				i=2;
			}else{
				throw new Exception();
			}

			int j = Integer.parseInt(String.valueOf(c1));
			if(cellValues[i][j] == "" || cellValues[i][j].isEmpty()){
				throw new Exception();
			}else{
				return evaluate(cellValues[i][j]);
			}

		}
	}
	
	/**
	 * @param cell		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @param contents	Any String (a valid formula, or not)
	 */
	public void set(String cell, String contents) {
		cell = contents;
	}
	
	/**
	 * @param cell		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @return			The evaluation of the cell's contents (e.g. if the cell contains "1"
	 * 					then returns "1"; if the cell contains "=1+2" returns "3"; if the
	 * 					cell contains "=1+B3", then a recursive evaluation is performed). If
	 * 					the evaluation gives an incorrect value (e.g.: "=1/0") return "#Error".
	 *					In case of circular references, return #Circular
	 */
	public long evaluate(String cell) throws Exception{
		if(cell.length() == 1 && !cell.startsWith("=")){
			return Long.parseLong(cell);
		}else if(cell.startsWith("=")){
			String rem = cell.substring(1, cell.length());
			return evaluate(rem);
		}else {
			String evalCell = "";
			char[] charArray = cell.toCharArray();
			String cellInExp = "";
			for (int i = 0; i < charArray.length; i++) {
				char c = charArray[i];
				if (Character.isAlphabetic(c)) {
					cellInExp = String.valueOf(c);
				} else if (Character.isDigit(c)) {
					if (!cellInExp.isEmpty()) {
						cellInExp = cellInExp + c;
						long val = get(cellInExp);
						evalCell = evalCell +val;
						cellInExp = "";
					}else{
						evalCell = evalCell+c;
					}
				}else if(Character.isSpace(c)){

				}else{
					evalCell = evalCell+c;
				}
			}

			long value = ((Integer)new ScriptEngineManager().getEngineByName("JavaScript").eval(evalCell)).longValue();

			return value;
		}

	}

	private boolean isNumeric(){
		return false;
	}
}
