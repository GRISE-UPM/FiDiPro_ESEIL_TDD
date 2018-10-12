package tdd.training.paf;

import java.util.HashMap;

public class SpreadSheet {
	
	private static final String CHARSTRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUMBERSTRING = "0123456789";
	
	private HashMap<String,String> spreadSheet = new HashMap<String,String>();
	
	public static void main(String args[])
	{
		SpreadSheet sheet = new SpreadSheet();
		sheet.set("A1", "=1+2+3");
		sheet.set("A2", "3");
		sheet.set("A3", "=A2+1");
		sheet.set("A4", "=");
		sheet.set("A5", "=A2+78+2");
		sheet.set("A6", "=1001%2");
		sheet.set("A7", "=A2+78&2");
		sheet.evaluate("A1");
		sheet.evaluate("A3");
		sheet.evaluate("A4");
		sheet.evaluate("A5");
		sheet.evaluate("A6");
		sheet.evaluate("A7");
	}
	/**
	 * @param cell		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @return			The cell's contents (e.g. "1", "=5", "=1+B3", "=1+(B3*4)", etc.)
	 */
	public String get(String cell) {
		// TODO: change as needed
		return spreadSheet.get(cell.trim());
	}
	
	/**
	 * @param cell		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @param contents	Any String (a valid formula, or not)
	 */
	public void set(String cell, String contents) 
	{
		// TODO: change as needed
		spreadSheet.put(cell.trim(), contents.trim());
	}
	
	/**
	 * @param cell		A String representing a cell (e.g. "A1", "XZ21", etc.)
	 * @return			The evaluation of the cell's contents (e.g. if the cell contains "1"
	 * 					then returns "1"; if the cell contains "=1+2" returns "3"; if the
	 * 					cell contains "=1+B3", then a recursive evaluation is performed). If
	 * 					the evaluation gives an incorrect value (e.g.: "=1/0") return "#Error".
	 *					In case of circular references, return #Circular
	 */
	public String evaluate(String cell) 
	{
		long result = 0;
		String evalString = spreadSheet.get(cell.trim());
		if ((evalString == null) || (evalString.length()== 0) )
		{
			System.out.println( " RESULT = 0");
		}
		else
		{
			int count=0;
			boolean operandRead = false;
			StringBuffer currentString = new StringBuffer();
			StringBuffer currentString1 = new StringBuffer();
			char currentOperand = ' ';
			
			for(char ch : evalString.toCharArray())
			{
				if (ch == ' ') 
				{
					continue;
				}
				count++;
					if (ch == '=') 
					{
						if (count != 1)
						{
							System.out.println( "Incorrect formula. it should start with = not " + ch);
							return null;
						}
						continue;
					}

				if ( (CHARSTRING.indexOf(ch) != -1) || (NUMBERSTRING.indexOf(ch) != -1))
				{
					if (!operandRead )
						currentString.append(ch);
					else
						currentString1.append(ch);
				}
				else
				{
					switch (ch)
					{	
						case '+':
							
							if (operandRead) 
							{
								result = eval(currentString, currentString1,currentOperand);
								currentString = new StringBuffer(new Long(result).toString());
								currentString1 = new StringBuffer();
							}
							currentOperand = '+';
							operandRead = true;
							break;
						case '-':
							if (operandRead) 
							{
								result = eval(currentString, currentString1,currentOperand);
								currentString = new StringBuffer(new Long(result).toString());
								currentString1 = new StringBuffer();
							}
							currentOperand = '-';
							operandRead = true;
							break;
						case '/':
							if (operandRead) 
							{
								result = eval(currentString, currentString1,currentOperand);
								currentString = new StringBuffer(new Long(result).toString());
								currentString1 = new StringBuffer();
							}
							currentOperand = '/';
							operandRead = true;
							break;
						case '*':
							if (operandRead) 
							{
								result = eval(currentString, currentString1,currentOperand);
								currentString = new StringBuffer(new Long(result).toString());
								currentString1 = new StringBuffer();
							}
							currentOperand = '*';
							operandRead = true;
							break;
						case '%':
							if (operandRead) 
							{
								result = eval(currentString, currentString1,currentOperand);
								currentString = new StringBuffer(new Long(result).toString());
								currentString1 = new StringBuffer();
							}
							currentOperand = '%';
							operandRead = true;
							break;
						case '&':
							if (operandRead) 
							{
								result = eval(currentString, currentString1,currentOperand);
								currentString = new StringBuffer(new Long(result).toString());
								currentString1 = new StringBuffer();
							}
							currentOperand = '&';
							operandRead = true;
							break;
						default:
							System.out.println( "Incorrect formula.");
							return null;
					}
				}
			}
			if (currentString1 != null)
			{
				if (operandRead) 
				{
					result = eval(currentString, currentString1,currentOperand)	;	
				}
			} 
			else if (currentString != null)
			{
					result = new Long(currentString.toString()).longValue();
			}
			System.out.println("FINAL RESULT " + result);
		}
		// TODO: change as needed
		return new Long(result).toString();
	}

	public long  eval(StringBuffer currentString, StringBuffer currentString1,char currentOperand)
	{		
		long result =0;
		try
		{
			if (CHARSTRING.indexOf(currentString.charAt(0)) != -1)
			{
				currentString = new StringBuffer(get(currentString.toString()));
						}
			if (CHARSTRING.indexOf(currentString1.charAt(0)) != -1)
			{
				currentString1 = new StringBuffer(get(currentString1.toString()));
			}
		
			long l1 = new Long(currentString.toString()).longValue();
			long l2 = new Long(currentString1.toString()).longValue();
			switch (currentOperand)
			{	
				case '+':
					result = l1 + l2;
					break;
				case '-':
					result = l1 - l2;
					break;
				case '*':
					result = l1 * l2;
					break;
				case '/':
					result = l1 / l2;
					break;
				case '%':
					result = l1 % l2;
					break;
				case '&':
					result = new Long(new Long(l1).toString()  + new Long(l2).toString()).longValue();
					break;
					
				default:
					break;
			}
			
		}
		catch(Exception ex)
		{
			
		}
		return  result;
	}
}
