package tdd.training.paf;

import java.util.HashMap;
import java.util.Map;

public class SpreadSheet {
	
	private Map <String,String> content = new HashMap<String, String> ();
	
	char [] availableOps = new char [] {'+','-','*','/','%','&'};
	
	
	/**
	 * @param cell		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @return			The cell's contents (e.g. "1", "=5", "=1+B3", "=1+(B3*4)", etc.)
	 */
	public String get(String cell) { 
		return content.get(cell);
	}
	
	/**
	 * @param cell		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @param contents	Any String (a valid formula, or not)
	 */
	public void set(String cell, String contents) {
		content.put(cell, contents);
	}
	
	/**
	 * @param cell		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @return			The evaluation of the cell's contents (e.g. if the cell contains "1"
	 * 					then returns "1"; if the cell contains "=1+2" returns "3"; if the
	 * 					cell contains "=1+B3", then a recursive evaluation is performed). If
	 * 					the evaluation gives an incorrect value (e.g.: "=1/0") return "#Error".
	 *					In case of circular references, return #Circular
	 */
	public String evaluate(String cell) {
		String content = get(cell);
		
		int evalStartPos = content.indexOf('=')+1;
		
		String evalContent = content.substring(evalStartPos);
		
		int nextOp = getNextOpPos(evalContent,0);
		
		if (nextOp < 0){
			return evalContent;
		}
		
		int result = Integer.parseInt(evalContent.substring(0, nextOp));
		
		result += Integer.parseInt(evalContent.substring(nextOp+1));
		
		return Integer.toString(result);
	}

	private int getNextOpPos(String evalContent, int startingPos) {
		return evalContent.indexOf("+",startingPos);
		
	}

	public Map<String, String> getContent() {
		return content;
	}
	
	
}
