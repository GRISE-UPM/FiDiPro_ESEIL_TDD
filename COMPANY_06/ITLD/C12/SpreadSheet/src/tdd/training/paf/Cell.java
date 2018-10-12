package tdd.training.paf;

import tdd.training.paf.Cell.cellType;

public class Cell {
	
	public enum cellType {
		NUMBER,
		STRING,
		FORMULA,
		NOTVALID
	}
	
	private cellType type;
	private String content;
	
	public Cell(cellType type, String content) {
		this.type = type;
		this.content = content;
	}
	public cellType getType() {
		return type;
	}
	public void setType(cellType type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
