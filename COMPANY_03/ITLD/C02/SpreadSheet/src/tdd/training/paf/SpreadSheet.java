package tdd.training.paf;

import tdd.training.paf.content.Cell;
import tdd.training.paf.exceptions.Errors;
import tdd.training.paf.operations.FormulaCalculator;

import java.util.HashMap;
import java.util.Map;

public class SpreadSheet {

	private Map<String, Cell> nameToCellMap;

	public SpreadSheet() {
		this.nameToCellMap = new HashMap<>();
	}

	/**
	 * @param cellName		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @return			The cell's contents (e.g. "1", "=5", "=1+B3", "=1+(B3*4)", etc.)
	 */
	public String get(String cellName) {
		if (has(cellName)) {
			return nameToCellMap.get(cellName).getContent();
		}
		return null;	// todo: see if empty cell would be better..
	}

	public boolean has(String cellName) {
		return nameToCellMap.containsKey(cellName) && null != nameToCellMap.get(cellName);
	}
	
	/**
	 * @param cellName		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @param contents	Any String (a valid formula, or not)
	 */
	public void set(String cellName, String contents) {
		Cell cell = getOrCreate(cellName);
		cell.setContent(contents);
	}

	private Cell getOrCreate(String cellName) {
		if (has(cellName)) {
			return nameToCellMap.get(cellName);
		}
		Cell cell = new Cell(cellName);
		nameToCellMap.put(cellName, cell);
		return cell;
	}
	
	/**
	 * @param cellName	A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @return			The evaluation of the cell's contents (e.g. if the cell contains "1"
	 * 					then returns "1"; if the cell contains "=1+2" returns "3"; if the
	 * 					cell contains "=1+B3", then a recursive evaluation is performed). If
	 * 					the evaluation gives an incorrect value (e.g.: "=1/0") return "#Error".
	 *					In case of circular references, return #Circular
	 */
	public String evaluate(String cellName) {
		if (has(cellName)) {
			Cell cell = nameToCellMap.get(cellName);
			switch (cell.getContentType()) {
				case NUMBER:
				case STRING:
					return cell.getContent();
				case FORMULA:
					return FormulaCalculator.evaluate(cell.getContent(), this);
			}
		}
		return Errors.ERROR.errorName;
	}
}
