import java.util.List;

/**
 * 
 * @author Alex
 *
 */
//class //created by alex 4/24
//all fields/enums created by alex 4/24
public enum NewsMedia {
	
	/**
	 * 
	 */
	NEWSPAPER, ONLINE, TV;
	
	/**
	 * 
	 */
	public static List<NewsMedia> VALUES_LIST;
	
	/**
	 * 
	 */
	//created by alex 4/24
	//written by alex 4/26
	public String toString(){
		switch (this) {
		case NEWSPAPER:
			return "Newspaper Story";
		case ONLINE:
			return "Online News Story";
		case TV:
			return "TV News Story";
		default:
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/24
	//written by alex 4/26
	public List<NewsMedia> valuesAsList(){
		VALUES_LIST.add(NEWSPAPER);
		VALUES_LIST.add(ONLINE);
		VALUES_LIST.add(TV);
		
		return VALUES_LIST;
	}

}
