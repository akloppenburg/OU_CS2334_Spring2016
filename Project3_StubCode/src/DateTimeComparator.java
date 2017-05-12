/**
 * This class is used for the comparing of two separate NewsStory objects based on their date and time fields.
 * @author Alex
 *
 */
public class DateTimeComparator  extends Comparator{
	
	/**
	 * Allows for the creation of a single comparator at some point in the program, saving memory.
	 */
	public static final DateTimeComparator DATETIME_COMPARATOR = new DateTimeComparator();
	
	/**
	 * 
	 * @param newsStory1 A NewsStory object.
	 * @param newsStory2 A second NewsStory object.
	 * @return An integer representing the ordering of the two objects based on their date and time
	 *  in accordance with the rules of the Object class' compare method.
	 */
	public int compare(NewsStory newsStory1, NewsStory newsStory2){
		return 0;
	}

}
