import java.io.*;
import java.util.*;

public class FreqCount {

	// HashMap that takes a string as a key, and frequency as a value
	public HashMap<String, Integer> stringXfreq;
	
	
	// Function that counts the frequencies of String tokens in an array
	// String and frequencies are added to stringXfreq HashMap
	public FreqCount(String[] array_str){ 
		
		for(String str: array_str){
			// if string is not in HashMap already, add it.
			if (!stringXfreq.containsKey(str)) 
				stringXfreq.put(str, 1);	
			
			// else if string is in HashMap, increase frequency by 1
			else
				stringXfreq.put(str, stringXfreq.get(str)+1); 
		}	
	}
	
	
	// Function that counts the frequencies of String tokens in a file
	// String and frequencies are added to stringXfreq HashMap
	public FreqCount (String filename) throws Exception{
		stringXfreq = new HashMap<String,Integer>();
		
		BufferedReader fin = new BufferedReader(new FileReader(filename));
		String[] split;
		String line = fin.readLine();
		
		
		while(line != null){
	
			line = line.toLowerCase();
			
			// Words are split and added to an array
			split = line.split("\\s+");
			
			// Frequency counting
			for (String word: split){
				if (!stringXfreq.containsKey(word))
					stringXfreq.put(word, 1);
				
				else
					stringXfreq.put(word, stringXfreq.get(word)+1);	
			}
			
			line = fin.readLine();
		}
		
		fin.close(); // close the file
	} 
	
	// Function that returns the frequency of a string
	public int getFreq(String str){	
		// Check if str is in stringXfreq, if not then return 0.
		if (!stringXfreq.containsKey(str))
			return 0;
		//Otherwise, return frequency of str
		return stringXfreq.get(str);
	}
	
		
	// Function that takes a filename and returns a corresponding HashMap
	// that contains all String tokens and their frequencies
	public static HashMap<String,Integer> file2TokenFreqs(String filename) throws Exception{
		FreqCount file = new FreqCount(filename);
		return file.stringXfreq;
	}
	
}

