public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int number;

	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}

	public int getFirstThrow() {
		return firstThrow;
	} 

	public int getSecondThrow() {
		return secondThrow;
	}


	public int score(){
	firstThrow=0;
	 secondThrow=0;
	 public int Frame(String number) throws BowlingException{

	 		if(number==""){
	 			return 0;
	 		}
	 		else{
	 			String  brojevi [] =numbersStr.split(",|\\\n");
	 			int duzina=brojevi.length;
	 			int rezultat=0;
	 			for(int i=0;i<10;i++){
	 				int broj=Integer.parseInt(brojevi[i]);
	 				if(broj>0){
	 					rezultat=rezultat+broj; 
	 				}
	 				else{
	 					throw new BowlingException();
	 				}

	 			}
	 			if(rezultat==Integer.parseInt(brojevi[0]))
	 			{
	 				throw new BowlingException();
	 			}
	 			else{
	 				return rezultat;
	 			}
	 		}
	 	}
	}


	public boolean isStrike(){
	int rezultat; 
		for(int i=1;i<10;i++){
				int broj=Integer.parseInt(brojevi[i]);
				if(firstThrow=10 && secondThrow =10){
					rezultat= firstThrow+ secondThrow;
				}
				else{
					throw new BolwingException();
				}

			}
			if(rezultat==Integer.parseInt(brojevi[0]))
			{
				throw new BolwingException();
			}
			else{
				return rezultat;
			}
		}
	}


	public boolean isSpare(){

			public int Spare(String numbers) throws BowlingException {
				int res=0;
				if(number == "")
					return 0;
				else{
					String[] stringNumbers = numbersStr.split(",|\\\n");
					for(int i=0; i<stringNumbers.length; i++)
					{
						if(Integer.parseInt(stringNumbers[i]) < 0)
							throw new BowlingException();
						else
							res+=Integer.parseInt(stringNumbers[i]);
					}
					return res;
				}

			}
		return false;
	}
}

