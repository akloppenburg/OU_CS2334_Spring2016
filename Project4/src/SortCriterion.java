/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/24
//all fields/enums created by alex 4/24
public enum SortCriterion {
	
	/**
	 * 
	 */
	SOURCE, TOPIC, SUBJECT, LENGTH, DATE_TIME;
	
	/**
	 * 
	 */
	//created by alex 4/24
	//written by alex 4/27
	public String toString(){
		switch (this) {
		case SOURCE:
			return "Source";
		case TOPIC:
			return "Topic";
		case SUBJECT:
			return "Subject";
		case LENGTH:
			return "Length";
		case DATE_TIME:
			return "Date/Time";
		default:
			throw new IllegalArgumentException();
		}
	}

}
