//TODO add javadoc
package Nooz;
import java.util.ArrayList;
import java.util.Collections;

public class NewsMakerList {
	
	//Creates a list of nesmakers as the relevant data for the class
	private ArrayList<NewsMaker> newsMakers = new ArrayList<NewsMaker>();
	
	//Empty constructor
	public NewsMakerList(){
		
	}
	
	//Adds a newsmaker object to the list
	public void add(NewsMaker newsMaker){
		newsMakers.add(newsMaker);
	}
	
	//Tests to see if the list contains a certain newsmaker Object
	public boolean contains(NewsMaker newsMaker){
		
		int numMatches = 0;
		
		for(int i = 0; i < newsMakers.size(); ++i){
			if(newsMakers.get(i).equals(newsMaker)){
				++numMatches;
			}
			else{
				
			}
		}
		
		if(numMatches == 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	//Returns the given Newsmaker Object from the list
	public NewsMaker get(NewsMaker newsMaker){
		
		int indexToGetFrom = -1;
		for(int i = 0; i < newsMakers.size(); ++i){
			if(newsMakers.get(i).equals(newsMaker)){
				indexToGetFrom = i;
			}
		}
		
		return newsMakers.get(indexToGetFrom);
		
	}
	
}
