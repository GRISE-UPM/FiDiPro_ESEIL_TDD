package tdd.training.paf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import tdd.training.paf.Cell.cellType;

public class SpreadSheet {

	
	Map<String, Cell> sheet = new HashMap<String, Cell>();
	
	private static final String ERROR_WHILE_EVALUATING = "#Error";
	private static final String CIRCULAR_WHILE_EVALUATING = "#Circular";
	
	private static final Integer MAX_DIGITS_IN_A_VALID_NUMBER = 10;
	private static final Integer MAX_CHARS_IN_A_VALID_CELL_ID = 4;
	
	
	/**
	 * @param cell		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @return			The cell's contents (e.g. "1", "=5", "=1+B3", "=1+(B3*4)", etc.)
	 */
	public String get(String cell) {
		if (sheet.containsKey(cell)) {
			return sheet.get(cell).getContent();
		} else {
			return new String();
		}
	}
	
	/**
	 * @param cell		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @param contents	Any String (a valid formula, or not)
	 */
	public void set(String cell, String contents) {
		Cell processedCell = processCellContent(contents);
		if (!(processedCell.getType() == cellType.NOTVALID)) {
			sheet.put(cell, processedCell);
		} else {
			System.out.println("The content is not valid.");
		}
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
		if (sheet.containsKey(cell)) {
			Cell cellProcessed = sheet.get(cell);
			if (cellProcessed.equals(cellType.STRING) || cellProcessed.equals(cellType.NUMBER)) {
				return cellProcessed.getContent();
			}
			return evaluateFormula(cellProcessed.getContent());
		} else {
			return new String();
		}			
	}


	private Cell processCellContent (String content) {
		if (content.startsWith("'") && content.endsWith("'")) {
			return new Cell(cellType.STRING, content);
		}
		try {
			int number = Integer.valueOf(content);
			return new Cell(cellType.NUMBER, content);
		} catch(NumberFormatException e) {
			if (content.startsWith("=")) {
				return new Cell(cellType.FORMULA, content);
			}
		}
		return new Cell(cellType.NOTVALID, "");
	}
	
	
	private String evaluateFormula(String content) {
		content = content.trim();
		char[] charsArray = content.toCharArray();

		try {
			char ch1 = charsArray[0];
			// we have an integer
			if (Character.isDigit(ch1)) {
				Integer num = getInt(charsArray);
				
			} else if (Character.isLetter(ch1)) {
				String cell = getCell(charsArray);
			} else {
				return ERROR_WHILE_EVALUATING;
			}
			
		} catch (Exception e) {
			return ERROR_WHILE_EVALUATING;
		}
		return null;
	}

	private Integer getInt(char[] charsArray) throws Exception{
		Integer number = 0;
		int j = 0;
		for (int i = 0; i < charsArray.length; i++) {
			char ch = charsArray[i];
			char[] digits = new char[MAX_DIGITS_IN_A_VALID_NUMBER];
			digits[j] = ch;
			ch = charsArray[++i];
			while (Character.isDigit(ch)) {
				j++;
				digits[j] = ch;
				ch = charsArray[++i];
			}
			number = Integer.valueOf(new String(digits));
			charsArray = Arrays.copyOfRange(charsArray, i, charsArray.length);
			break;
		}
		
		return number;
	}

	private String getCell(char[] charsArray) throws Exception {
		String cell = new String();
		char[] cellId = new char[MAX_CHARS_IN_A_VALID_CELL_ID];
		int j = 0;
		int i = 0;
		for (i = 0; i < charsArray.length; i ++) {
			char ch = charsArray[i];
			while(Character.isLetter(ch)) {
				cellId[j++] = ch;
				ch = charsArray[++i];
			}
			while(Character.isDigit(ch)) {
				cellId[j++] = ch;
				ch = charsArray[++i];
			}
		}
		charsArray = Arrays.copyOfRange(charsArray, i, charsArray.length);
		cell = new String(cellId);
		return cell;
	}
}
