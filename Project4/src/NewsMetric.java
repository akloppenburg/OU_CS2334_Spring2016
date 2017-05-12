/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/24
//all fields/enums created by alex 4/24
public enum NewsMetric {
	
	/**
	 * 
	 */
	LENGTH, COUNT;
	
	/**
	 * 
	 */
	//created by alex 4/24
	public String toString(){
		switch (this) {
		case LENGTH:
			return "Length";
		case COUNT:
			return "Count";
		default:
			throw new IllegalArgumentException();
		}
	}

}
