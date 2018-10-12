package upm.tdd.training;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sudoku {
	
	public static final int NUM_MAX_OF_CHARACTERS = 81;
	public static final int NUM_MAX_OF_CHARACTERS_PER_ROW = 9;
	public static final int NUM_MAX_OF_ROWS = 9;
	public static final int RETURN_VALID_SOLUTION = 0;
	public static final int RETURN_VIOLATE_RULE_1= -1;
	public static final int RETURN_VIOLATE_RULE_2= -2;
	public static final int RETURN_VIOLATE_RULE_3= -3;
	public static final int NUM_MIN_OF_FILES_OR_SUBGRID = 1;
	public static final int NUM_MAX_OF_FILES_OR_SUBGRID = 9; 

	
	public Sudoku() {

		// Sudoku is a game with few simple rules, where the goal is to place
		// nine sets of positive digits (1...9) into the cells of a
		// fixed grid structure (i.e. board). The Sudoku board (or global grid)
		// consists of a 3x3 arrangement of sub-grids, and each sub-grid
		// is a 3x3 arrangement of cells. This yields a 9x9 arrangement of cells
		// on the Sudoku board. A valid Sudoku solution should conform
		// to the following rules:
		// • R1: A cell in a Sudoku game can only store positive digits, i.e.
		// 1...9.
		// • R2: All digits appear only once in a sub-grid, i.e. they cannot
		// repeat.
		// • R3: A digit can appear only once in the rows of the global grid.
		// • R4: A digit can appear only once in the columns of the global
		// grid.
	}

	public int verify(String candidateSolution) {

		// Return 0: means it is a valid Sudoku solution
		// • Return -1: means it is violating Rule #1
		// • Return -2: means it is violating Rule #2
		// • Return -3: means it is violating Rule #3
		// • Return -4: means it is violating Rule #4

		return 0;
	}

	/**
	 * Assemble file to list of Strings
	 * @return
	 */
	public List<String> assembleFileToListOfStrings() {
		List<String> rows = new ArrayList<String>();
		File file = new File("D:\\workspace\\SudokuVerifier-master\\sudo1.txt");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			while ((text = reader.readLine()) != null) {
				rows.add(text);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
		return rows;
	}
	
	
	/**
	 * Valida if the file have less than 81 characters
	 * @param rows
	 * @return
	 */
	public boolean validate81Characters(List<String> rows){
		int countTotalCharacters = 0;
		for(String row:rows){
			countTotalCharacters = countTotalCharacters + row.length();
			if(countTotalCharacters > NUM_MAX_OF_CHARACTERS){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Validates if exists 9 character per columns and files
	 * @param rows
	 * @return
	 */
	public boolean validate9x9Characters(List<String> rows){
		int countCharactersPerFiles = 0;
		int countNumberOfRows= 0;
		for(String row:rows){
			if(row.length() > NUM_MAX_OF_CHARACTERS_PER_ROW){
				return false;
			}
			if(countCharactersPerFiles > NUM_MAX_OF_CHARACTERS){
				return false;
			}
			countNumberOfRows ++;
		}
		if(countNumberOfRows > NUM_MAX_OF_ROWS){
			return false;
		}
		
		return true;
	}
	
	public int fullValidation(){
		//int result = RETURN_VALID_SOLUTION;
		List<String> rows = assembleFileToListOfStrings();
		//validates rule 1
		if(!validate81Characters(rows)){
			return RETURN_VIOLATE_RULE_1;
		//validates rule 2
		}if(!validate9x9Characters(rows)){
			return RETURN_VIOLATE_RULE_2;
		}if(!validateSudokuRules(rows)){
			return RETURN_VIOLATE_RULE_3;
		}
		
		return RETURN_VALID_SOLUTION;
	}
	
	/**
	 * Validate all sudoku rules
	 * @param rows
	 * @return
	 */
	private boolean validateSudokuRules(List<String> rows){
		for(String row:rows){
			//validate that the row to be a number
			if(!isNumeric(row)){
				return false;
			}else if(!validateDigitsInRowsAndColumns(rows)){
				return false;
			}
		}
		
		
		return true;
	}
	
	/**
	 * Validates that the row to be a number
	 * @param str
	 * @return
	 */
	private boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  
	}
	
	
	private boolean validateDigitsInRowsAndColumns(List<String> rows){
		
		List<Integer> listDigits = new ArrayList<Integer>();
		for(String row:rows){
			//puts all digits of the row in a List of Integers
			for(int i = NUM_MIN_OF_FILES_OR_SUBGRID -1; i <= NUM_MAX_OF_FILES_OR_SUBGRID - 1; i++){
				char digitChar = row.charAt(i);
				int digit = Character.getNumericValue(digitChar);
				if(!validateDigitNotRepeatedBetween1And9(listDigits, digit)){
					return false;
				}
				listDigits.add(digit);
			}
			listDigits = new ArrayList<Integer>();
		}
		
		
		
		//invert the rows to columns lists
		listDigits = new ArrayList<Integer>();
		int rowIndex = 0;
		for(int i = NUM_MIN_OF_FILES_OR_SUBGRID -1; i <= NUM_MAX_OF_FILES_OR_SUBGRID - 1; i++){
			for(String row:rows){
					char digitChar = row.charAt(rowIndex);
					int digit = Character.getNumericValue(digitChar);
					if(!validateDigitNotRepeatedBetween1And9(listDigits, digit)){
						return false;
					}
					listDigits.add(digit);
				}
				listDigits = new ArrayList<Integer>();
			}
			
		
		for(int i = NUM_MIN_OF_FILES_OR_SUBGRID -1; i <= NUM_MAX_OF_FILES_OR_SUBGRID - 1; i++){
			
			
		}
		
		
		return true;
	}

	/**
	 * validate that the digit not repeated between 1 and 9
	 * @param listDigit
	 * @param newDigit
	 * @return
	 */
	private boolean validateDigitNotRepeatedBetween1And9(List<Integer> listDigit, int newDigit){
		for(Integer digitAux:listDigit){
			if(newDigit == digitAux){
				return false;
			}
		}
		return true;
	}
	
}
