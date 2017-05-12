import java.io.Serializable;

import javax.swing.DefaultListModel;

/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/25
//all fields created by alex 4/25
public class NewsStoryListModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2444041509351269723L;
	
	/**
	 * 
	 */
	private DefaultListModel<NewsStory> newsStories;
	
	/**
	 * 
	 */
	//created by alex 4/25
	public NewsStoryListModel(){
		
	}
	
	/**
	 * 
	 * @param newsStoryListModel
	 */
	//created by alex 4/25
	public NewsStoryListModel(NewsStoryListModel newsStoryListModel){
		
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public boolean isEmpty(){
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public int size(){
		return 0;
	}
	
	/**
	 * 
	 * @param newsStory
	 * @return
	 */
	//created by alex 4/25
	public boolean contains(NewsStory newsStory){
		return false;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	//created by alex 4/25
	public NewsStory get(int index){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public DefaultListModel<NewsStory> getNewsStories(){
		return null;
	}
	
	/**
	 * 
	 * @param newsStory
	 */
	//created by alex 4/25
	public void add(NewsStory newsStory){
		
	}
	
	/**
	 * 
	 * @param newsStory
	 */
	//created by alex 4/25
	public void remove(NewsStory newsStory){
		
	}
	
	/**
	 * 
	 * @param newsStories
	 */
	//created by alex 4/25
	public void removeListOfNewsStories(DefaultListModel<NewsStory> newsStories){
		
	}
	
	/**
	 * 
	 * @param newsStoryListModel
	 */
	//created by alex 4/25
	public void setNewsStories(NewsStoryListModel newsStoryListModel){
		
	}
	
	/**
	 * 
	 * @param newsStoryModelArray
	 */
	//created by alex 4/25
	public void setNewsStoriesFromArray(NewsStory[] newsStoryModelArray){
		
	}

}
