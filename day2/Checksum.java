import java.util.*;

public class Checksum{
	public static void main(String args[]){
		partOne();
		partTwo();
	}

	public static void partOne(){
		//Out of loop variables
		Scanner in = new Scanner(System.in);
		int threeLetter = 0;
		int twoLetter = 0;
		HashMap<Character, Integer> charData = new HashMap<Character, Integer>();	
	
		//In loop variables
		Collection<Integer> results;	
		String curLine;
		Integer value;
		char curChar;

		//Runs until end of file
		while(in.hasNext()){
			curLine = in.nextLine();						//Moves to next line
			for(int i = 0; i < curLine.length(); i++){		//Loops through line
				curChar = curLine.charAt(i);				//Gets current character
				
				//Adds/incriments a value in the hashmap
				value = charData.putIfAbsent(curChar, 1);
				if(value != null)
					charData.put(curChar, ++value);
			
			}

			results = charData.values();                   //Holds the values
			if(results.contains(2))                        //Increments 2 once
					twoLetter++;
			if(results.contains(3))                        //Increments 3 once
					threeLetter++;
			charData.clear();                              //Clears the hashmap
		}
		System.out.println(twoLetter * threeLetter);       //Outputs the answer
	}

	public static void partTwo(){
		
	}
}
