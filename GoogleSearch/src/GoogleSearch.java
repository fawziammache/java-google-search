import java.io.*;
import java.util.*;


public class GoogleSearch {

	public static void main(String[] args) throws Exception {
		
		// Array of filenames
		String[] filenames = {"input1.txt", "input2.txt", "input3.txt"};
		

		// Returns token and frequencies from one file
		HashMap<String, Integer> test1 = FreqCount.file2TokenFreqs("input1.txt");
		System.out.println(test1);
		
		
		
		
		
		
	}

}
