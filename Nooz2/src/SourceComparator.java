import java.util.Comparator;

/**
 * Project 2, CS 2334, Section 010, February 22, 2017
 * <P>
 * The SourceComparator compares the sources of two news stories.
 * </P>
 * <P>
 * Note that the constructor has nothing to do, so it is omitted.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 * 
 */
public class SourceComparator implements Comparator<NewsStory> {
	public static final SourceComparator SOURCE_COMPARATOR = new SourceComparator();

	/**
	 * Overridden compare method that looks at the sources of the news stories.
	 * 
	 * @param newsStory1
	 *            The first news story to compare by source.
	 * @param newsStory2
	 *            The second news story to compare by source.
	 */
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2) {
		return newsStory1.getSource().compareTo(newsStory2.getSource());
	}

}