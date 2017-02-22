import java.util.*;

public class ConjunctiveQuery {
	
	public Token2File conj;
	
	public ConjunctiveQuery(String[] filenames) throws Exception { 
		conj = new Token2File(filenames);
	}
	
	
	// Function that returns a set of filenames that contain all query terms 
	public Set<String> doQuery(Set<String> query_terms) {	
	
		
		Set<String> leastFrequent = new TreeSet<String>();
		Set<String> filesWithQueryTerms = new TreeSet<String>();
		int max = Integer.MAX_VALUE;
		
		// Gets the least frequent term
		for (String term: query_terms){
			int currentSize = conj.stringXfilesWithTerm.get(term).size();
			if (currentSize < max){
				leastFrequent = conj.stringXfilesWithTerm.get(term);
				max = currentSize;
			}
		}
		
		boolean fileContainsTerm = true;
		
		// Refine the set
		for (String file: leastFrequent){	// loops through every file of the least FrequentTerm
			for (String term: query_terms){ // Checks for the other terms, term by term, in every file
				if(conj.stringXfilesWithTerm.get(term).contains(file)) // if the term is in a file
					fileContainsTerm = true;
				else							// if the term is not in the file
					fileContainsTerm = false;	
				}
			if (!fileContainsTerm)
				leastFrequent.remove(file); // if that file doesnt contain all the terms, we remove it
		}
		
		return leastFrequent;
	}
	
	
	
	
	public SortedSet<QueryResult> doRankedQuery(Set<String> query_terms) {
		/* return a set of QueryResults, sorted by score then alphabetically by filename */
	return null;	
	}
	
	
	
	
	
}
