import java.io.Serializable;
import java.util.Collections;

import javax.swing.DefaultListModel;

/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/25
//all fields created by alex 4/25
public class NewsMakerListModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8123344962471830086L;
	
	/**
	 * 
	 */
	private DefaultListModel<NewsMakerModel> newsMakerDefaultListModel;

	/**
	 * 
	 */
	//created by alex 4/25
	public NewsMakerListModel(){
		
	}
	
	/**
	 * 
	 * @param newsMakerListModel
	 */
	//created by alex 4/25
	public NewsMakerListModel(NewsMakerListModel newsMakerListModel){
		
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
	 * @param newsMakerModel
	 * @return
	 */
	//created by alex 4/25
	public boolean contains(NewsMakerModel newsMakerModel){
		return false;
	}
	
	/**
	 * 
	 * @param newsMakerModel
	 * @return
	 */
	//created by alex 4/25
	public NewsMakerModel get(NewsMakerModel newsMakerModel){
		return null;
	}
	
	/**
	 * 
	 * @param newsMakerName
	 * @return
	 */
	//created by alex 4/25
	public NewsMakerModel getExactMatch(String newsMakerName){
		return null;
	}
	
	/**
	 * 
	 * @param newsMakerName
	 * @return
	 */
	//created by alex 4/25
	public NewsMakerModel getPartialMatch(String newsMakerName){
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
	 * @param index
	 * @return
	 */
	//created by alex 4/25
	public NewsMakerModel get(int index){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	public String[] getNewsMakerNames(){
		return null;
	}
	
	/**
	 * 
	 * @param newsMakerModel
	 */
	//created by alex 4/25
	public void add(NewsMakerModel newsMakerModel){
		
	}
	
	/**
	 * 
	 * @param newsMakerModel
	 */
	//created by alex 4/25
	public void replace(NewsMakerModel newsMakerModel){
		
	}
	
	/**
	 * 
	 * @param newsMakerModel
	 */
	//created by alex 4/25
	public void remove(NewsMakerModel newsMakerModel){
		
	}
	
	/**
	 * 
	 * @param newsMakers
	 */
	//created by alex 4/25
	public void removeListOfNewsMakers(DefaultListModel<NewsMakerModel> newsMakers){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	public void removeAllNewsMakers(){
		
	}
	
	/**
	 * 
	 * @param newsMakerListModel
	 */
	//created by alex 4/25
	public void setNewsMakersFromNewsMakerList(NewsMakerListModel newsMakerListModel){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	//written by alex 4/26
	public void sort(){
		/*TODO as far as I can tell we have to remove the objects to another list, sort them, clear the
		 * DefaultListModel, and then add them back in.
		 */
	}

}
