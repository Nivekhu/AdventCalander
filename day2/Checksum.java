import java.util.*;

public class Checksum{
		public static void main(String args[]){
				final long startTime = System.currentTimeMillis();
				if(args.length == 0)
						System.out.println("Please input either 1 or 2. Example: Checksum 1");
				else if(args[0].equals("1"))
						partOne();
				else if(args[0].equals("2"))
						partTwo();
				else
						System.out.println("Please input either 1 or 2. Example: Checksum 1" + "Milliseconds");
				final long endTime = System.currentTimeMillis();
				System.out.println("Toal execution time: " + (endTime - startTime) + " ms");
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
						twoLetter += results.contains(2)   ? 1 : 0;	   //incriments if 2 is found
						threeLetter += results.contains(3) ? 1 : 0;    //incriments if 3 is found
						charData.clear();                              //Clears the hashmap
				}
				System.out.println(twoLetter * threeLetter);       //Outputs the answer
		}

		public static void partTwo(){
				//Takes the input and places it into an arraylist
				Scanner in = new Scanner(System.in);
				ArrayList<String> input = new ArrayList<String>();
				while(in.hasNext()){
						input.add(in.nextLine());
				}

				//out of loop variables
				String longest = "";

				//in Loop variables	
				String curLine;
				String compLine;
				String curString = "";
				char curChar;

				//Runs n
				for(int i = 0; i < input.size(); i++){
						curLine = input.get(i);
						//Runs Log(n)
						for(int j = i+1; j < input.size(); j++){
								compLine = input.get(j);
								for(int k = 0; k < curLine.length(); k++){
										if(curLine.charAt(k) == compLine.charAt(k))
												curString = curString + curLine.charAt(k);
								}
								if(curString.length() > longest.length())
										longest = curString;
								curString = "";

						}
				}

				System.out.println(longest);
		}
}
