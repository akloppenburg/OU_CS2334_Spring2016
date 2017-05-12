import java.util.Comparator;

/**
 * Project 2, CS 2334, Section 010, February 22, 2017
 * <P>
 * The LengthComparator compares the lengths of two news stories. Since
 * different types of news stories may use different units to measure their
 * lengths, we compare by converting the lengths to a common unit (words).
 * </P>
 * <P>
 * Note that the constructor has nothing to do, so it is omitted.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 * 
 */
public class LengthComparator implements Comparator<NewsStory> {
	public static final LengthComparator LENGTH_COMPARATOR = new LengthComparator();

	/**
	 * Overridden compare method that looks at the lengths of the news stories
	 * in words.
	 * 
	 * @param newsStory1
	 *            The first news story to compare by length.
	 * @param newsStory2
	 *            The second news story to compare by length.
	 */
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2) {
		return newsStory1.getLengthInWords() - newsStory2.getLengthInWords();
	}

}
