/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/24
//all fields/enums created by alex 4/24
public enum NewsContent {
	
	/**
	 * 
	 */
	SOURCE, TOPIC, SUBJECT;
	
	/**
	 * 
	 */
	//created by alex 4/24
	//written by alex 4/26
	public String toString(){
		switch (this) {
		case SOURCE:
			return "Source";
		case TOPIC:
			return "Topic";
		case SUBJECT:
			return "Subject";
		default:
			throw new IllegalArgumentException();
		}
	}

}
