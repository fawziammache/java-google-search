import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.*;

public class Token2File {
	
	// HashMap that stores a String as a key, and the set of filenames that contain that String as a value.
	public HashMap<String, Set<String> > stringXfilesWithTerm;
	
	public Token2File(String[] filenames) throws Exception{
		// This function loops through all the files in filenames.
		// For every file, we need to obtain the HashMap that contains the String tokens
		// and frequencies for that file. Next, for every String token, we check if it's
		// in our stringXfilesWithTerm HashMap. If it is, then we add the name of the file
		// to the set of files for that term. If not, we add the term and the file to the HashMap.
		
		stringXfilesWithTerm = new HashMap<String, Set<String>>();

		 // Looping through every file
		 for (String file: filenames){
			 
			// Get the tokens and frequencies of the current file
			HashMap<String, Integer> currentFile = FreqCount.file2TokenFreqs(file);
			
			// Loop through every String token in that file
			for (String token: currentFile.keySet()){
				
				// if token is not in HashMap
				if(!stringXfilesWithTerm.containsKey(token)){ 
					Set<String> setOfFiles = new TreeSet<String>();
					setOfFiles.add(file);
					stringXfilesWithTerm.put(token, setOfFiles);	
				} 
			
				// if token is already in HashMap and the current file contains the token
				else if (stringXfilesWithTerm.containsKey(token) && currentFile.containsKey(token)) {
					Set<String> setOfFiles = stringXfilesWithTerm.get(token); //Current Set<String> with files containing the term
					setOfFiles.add(file); // add the new filename to Set
					stringXfilesWithTerm.put(token, setOfFiles); // put back in HashMap
				}
				
				else 
					continue;
			
		 	}
		 }	 
		}
	 
	 // returns a set of filenames that contain term (at least once)	 		
	public Set<String> getFilesWithTerm(String term){
		return stringXfilesWithTerm.get(term);
	 }
}