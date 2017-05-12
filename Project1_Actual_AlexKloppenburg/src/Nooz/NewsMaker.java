//TODO add javadoc
package Nooz;
public class NewsMaker{
	
	//Data
	private String name;
	private NewspaperStoryList newspaperStories = new NewspaperStoryList();
	
	//Empty constructor
	public NewsMaker(){
	
	}
	
	//Constructor with name used when reading in data
	public NewsMaker(String name){
		this.name = name;
	}
	
	//If there is no name, compares objects.  Otherwise, compars newsmaker names
	public boolean equals(Object o){
		if (o instanceof NewsMaker) {
			NewsMaker newsMaker = (NewsMaker) o;
			if(newsMaker.getName() == null){
				
				boolean equal = this == newsMaker;
				return equal;
			}
			else{
				
				boolean equal = this.name.equals(newsMaker.getName());
				return equal;
				
			}
		}
		else {
			return false;
		}
	}
	
	//Returns newsmaker name
	public String getName(){
		return this.name;
	}
	
	//Returns the stories associated with the newsmaker
	public NewspaperStoryList getNewspaperStories(){
		return this.newspaperStories;
	}
	
	//adds a story to the list of stories associated with a particular newsmaker
	public void addNewspaperStory(NewspaperStory newspaperStory){
		newspaperStories.add(newspaperStory);
	}
	
}
