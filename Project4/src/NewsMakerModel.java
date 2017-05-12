import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/21
//all fields created by alex 4/25
public class NewsMakerModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2955780642205516824L;
	
	/**
	 * 
	 */
	private ArrayList<ActionListener> actionListenerList;
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private NewsStoryListModel newsStoryListModel;
	
	/**
	 * 
	 */
	//created by alex 4/25
	public NewsMakerModel(){
		
	}
	
	/**
	 * 
	 * @param name
	 */
	//created by alex 4/25
	public NewsMakerModel(String name){
		
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public String getName(){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public NewsStoryListModel getNewsStoryListModel(){
		return null;
	}
	
	/**
	 * 
	 * @param newsStory
	 */
	//created by alex 4/25
	public void addNewsStory(NewsStory newsStory){
		
	}
	
	/**
	 * 
	 * @param name
	 */
	//created by alex 4/25
	public void setName(String name){
		
	}
	
	/**
	 * 
	 * @param newsStoryListModel
	 */
	//created by alex 4/25
	public void setNewsStoryListModel(NewsStoryListModel newsStoryListModel){
		
	}
	
	/**
	 * 
	 * @param newsStory
	 */
	//created by alex 4/25
	public void removeNewsStory(NewsStory newsStory){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	public boolean equals(Object o){
		return false;
	}
	
	/**
	 * 
	 * @param newsMaker
	 * @return
	 */
	//created by alex 4/25
	public int compareTo(NewsMaker newsMaker){
		return 0;
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	public String toString(){
		return null;
	}
	
	/**
	 * 
	 * @param l
	 */
	//created by alex 4/25
	public void addActionListener(ActionListener l){
		
	}
	
	/**
	 * 
	 * @param l
	 */
	//created by alex 4/25
	public void removeActionListener(ActionListener l){
		
	}
	
	/**
	 * 
	 * @param e
	 */
	//created by alex 4/25
	private void processEvent(ActionEvent e){
		
	}

}
