import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.DefaultListModel;

//TODO add to class when he releases UML
//TODO write Javadoc
/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/21
//all fields created by alex 4/25
public class NewsDataBaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4731282697611876377L;
	
	/**
	 * 
	 */
	private ArrayList<ActionListener> actionListenerList;
	
	/**
	 * 
	 */
	private Map<String, String> newsSourceMap;
	
	/**
	 * 
	 */
	private Map<String, String> newsTopicMap;
	
	/**
	 * 
	 */
	private Map<String, String> newsSubjectMap;
	
	/**
	 * 
	 */
	NewsMakerModel none;
	
	/**
	 * 
	 */
	private NewsMakerListModel newsMakerListModel;
	
	/**
	 * 
	 */
	private NewsStoryListModel newsStoryListModel;
	
	/**
	 * 
	 */
	//created by alex 4/25
	public NewsDataBaseModel(){
		
	}
	
	/**
	 * 
	 * @param newsMakerListModel
	 * @param newsStoryListModel
	 */
	//created by alex 4/25
	public NewsDataBaseModel(NewsMakerListModel newsMakerListModel, NewsStoryListModel newsStoryListModel){
		
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public Map<String, String> getNewsSourceMap(){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public String[] getNewsSources(){
		return null;
	}
	
	/**
	 * 
	 * @param newsSourceMap
	 */
	//created by alex 4/25
	public void setNewsSourceMap(Map<String, String> newsSourceMap){
		
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public Map<String, String> getNewsTopicMap(){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public String[] getNewsTopics(){
		return null;
	}
	
	/**
	 * 
	 * @param newsTopicMap
	 */
	//created by alex 4/25
	public void setNewsTopicMap(Map<String, String> newsTopicMap){
		
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public Map<String, String> getNewsSubjectMap(){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public String[] getNewsSubjects(){
		return null;
	}
	
	/**
	 * 
	 * @param newsSubjectMap
	 */
	//created by alex 4/25
	public void setNewsSubjectMap(Map<String, String> newsSubjectMap){
		
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public boolean newsMakerListIsEmpty(){
		return false;
	}
	
	/**
	 * 
	 * @param newsMakerModel
	 * @return
	 */
	//created by alex 4/25
	public boolean containsNewsMakerModel(NewsMakerModel newsMakerModel){
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public NewsMakerListModel getNewsMakerListModel(){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public  String[] getNewsMakerNames(){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public DefaultListModel<NewsMakerModel> getNewsMakers(){
		return null;
	}
	
	/**
	 * 
	 * @param newsMakerListModel
	 */
	//created by alex 4/25
	public void setNewsMakerListModel(NewsMakerListModel newsMakerListModel){
		
	}
	
	/**
	 * 
	 * @param newsMakerModel
	 */
	//created by alex 4/25
	public void addNewsMakerModel(NewsMakerModel newsMakerModel){
		
	}
	
	/**
	 * 
	 * @param newsMakerModel
	 */
	//created by alex 4/25
	public void replaceNewsMakerModel(NewsMakerModel newsMakerModel){
		
	}
	
	/**
	 * 
	 * @param newsMakers
	 */
	//created by alex 4/25
	public void removeNewsMakers(DefaultListModel<NewsMakerModel> newsMakers){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	public void removeAllNewsMakers(){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	public void sortNewsMakerListModel(){
		
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public boolean newsStoryListIsEmpty(){
		return false;
	}
	
	/**
	 * 
	 * @param newsStory
	 * @return
	 */
	//created by alex 4/25
	public boolean containsNewsStory(NewsStory newsStory){
		return false;
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
	 * @return
	 */
	//created by alex 4/25
	public DefaultListModel<NewsStory> getNewsStories(){
		return null;
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
	 * @param newsStoryModelArray
	 */
	//created by alex 4/25
	public void setNewsStoryListModelFromArray(NewsStory[] newsStoryModelArray){
		
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
	 * @param newsStories
	 */
	//created by alex 4/25
	public void removeNewsStories(DefaultListModel<NewsStory> newsStories){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	public void removeAllNewsStories(){
		
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
