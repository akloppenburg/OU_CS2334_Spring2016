import java.time.LocalDate;

/**
 * Project 2, CS 2334, Section 010, February 22, 2017
 * <P>
 * A <code>TVNewsStory</code> is composed of the date the story was broadcast,
 * the name of the TV news show that broadcast the story, the length the story
 * in seconds, the topic of the story, and two lead news makers in the story.
 * </P>
 * <P>
 * Since all of these elements are present in <code>NewsStory</code>,
 * <code>TVNewsStory</code> is created as a subclass of <code>NewsStory</code>.
 * However, <code>TVNewsStory</code> can implement <code>getLengthInWords</code>
 * because we know the inherent length measurement units for TV news stories
 * (seconds), whereas different news stories may use different length units.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 * 
 */
public class TVNewsStory extends NewsStory {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1005886671153415170L;
	
	
	private PartOfDay partOfDay;

	/**
	 * The constructor which takes parameters for all of the fields can simply
	 * pass them to the constructor for <code>NewsStory</code> and let it do the
	 * work.
	 * 
	 * @param date
	 *            The date the story was published as a java.time.LocalDate.
	 * @param sourceName
	 *            The name of the source in which the story was published.
	 * @param length
	 *            The length of the story in seconds.
	 * @param topic
	 *            The broad topic of the story.
	 * @param newsMaker1
	 *            The first news maker featured in the story.
	 * @param newsMaker2
	 *            The second news maker featured in the story.
	 */
	public TVNewsStory(LocalDate date, String sourceName, int length, String topic, String subject, PartOfDay partOfDay, NewsMaker newsMaker1,
			NewsMaker newsMaker2) {
		super(date, sourceName, length, topic, subject, newsMaker1, newsMaker2);
		this.partOfDay = partOfDay;
	}

	/**
	 * Overrides the <code>getLengthInWords</code> method from
	 * <code>NewsStory</code>.
	 * <P>
	 * Because the inherent length measurement units for TV news stories are
	 * seconds, we need to convert the value we get from <code>getLength</code>.
	 * The design says we should use the conversion factor of 150 words per
	 * minute. (Of course, a minute is 60 seconds, so this is a conversion
	 * factor of 150/60.)
	 * </P>
	 * 
	 * @see NewsStory#getLengthInWords()
	 */
	@Override
	public int getLengthInWords() {
		return this.getLength() * 150 / 60;
	}
	
	public PartOfDay getPartOfDay(){
		return this.partOfDay;
	}

}
