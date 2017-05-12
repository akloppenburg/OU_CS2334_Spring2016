import java.util.Comparator;

/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/24
//all fields created by alex 4/24
public class SubjectComparator implements Comparator<NewsStory>{
	
	public static final SubjectComparator SUBJECT_COMPARATOR = new SubjectComparator();
	
	//created by alex 4/24
	//method body written by alex 4/24
	//TODO check and make sure this is an okay method of comparison
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2) {
		return newsStory1.getSubject().compareTo(newsStory2.getSubject());
	}

}
