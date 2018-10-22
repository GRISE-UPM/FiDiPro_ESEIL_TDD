package tdd.training.paf;

public class SpreadSheet {

	private CellContainer cells;

	public SpreadSheet() {
		cells = new CellContainer();
	}

	/**
	 * @param address		A String representing a cell address (e.g. "A1", "XZ21", etc.)
	 * @return			The cell's contents (e.g. "1", "=5", "=1+B3", "=1+(B3*4)", etc.)
	 */
	public String get(String address) {
		Cell response = cells.getCell(address);
		return (response != null) ? response.getContent(): null;
	}
	
	/**
	 * @param address		A String representing a cell address (e.g. "A1", "XZ21", etc.)
	 * @param contents	Any String (a valid formula, or not)
	 */
	public void set(String address, String contents) {

		cells.addCell(new Cell(address, contents));
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
		// TODO: change as needed
		return null;
	}
}
