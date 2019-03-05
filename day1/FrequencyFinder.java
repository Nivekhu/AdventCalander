import java.util.*;
import java.io.*;

public class FrequencyFinder{
	public static void main(String args[]) throws FileNotFoundException {
		File input = new File("input.txt");
		Scanner in = new Scanner(new FileInputStream(input));
		HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
		boolean stop = false;
		int modifier = 0;
		int result = 0;
		values.put(result, 1);
		while(!stop){
			if(!in.hasNext()){
				in = new Scanner(new FileInputStream(input));
			}
			else{
				modifier = in.nextInt();
				result += modifier;
				if(values.containsKey(result)){
					System.out.println(result);
					stop = true;
				}
				else{
					values.put(result, 1);
				}
			}
		}
	}
}
