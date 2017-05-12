/**
 * Project #1 CS 2334, Section 010 February 22, 2017
 * <P>
 * A <code>NewsMaker</code> is the subject of a <code>NewspaperStory</code>. A
 * <code>NewsMaker</code> may be a person or an organization. A
 * <code>NewsMaker</code> consists of a name and a collection of newspaper
 * stories that feature that <code>NewsMaker</code>. There is a special
 * <code>NewsMaker</code> with the name "None" that is used for newspaper
 * stories that don't have at least two named <code>NewsMakers</code>.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 */

//TODO finish writing class
//TODO write and edit Javadoc
//TODO check against Dr. Hougen's javadoc and UML
class NewsMaker implements Comparable<NewsMaker>{
	/** The name of the news maker. */
	private String name;

	/** The list of newspaper stories in which the news maker is featured */
	private NewsStoryList newsStories = new NewsStoryList();

	/**
	 * The no-argument constructor for the class. Because we will often want to
	 * construct the special news maker "None," the no-arg constructor gives us
	 * this news maker.
	 */
	NewsMaker() {
		this.name = "None";
	}

	/**
	 * The general constructor for the class which takes the name of the news
	 * maker (generally the only thing we know about a news maker when the
	 * constructor is called) as an argument.
	 * 
	 * @param name
	 *            The name of the news maker.
	 */
	public NewsMaker(String name) {
		this.name = name;
	}

	/**
	 * An overridden <code>equals</code> method.
	 * <P>
	 * A <code>NewsMaker</code> should be equal to another object if that object
	 * is also a <code>NewsMaker</code> object and they have the same name.
	 * (Since <code>equals</code> is a method in the <code>Object</code> class
	 * that we are overriding, the parameter needs to be an
	 * <code>Object</code>.)
	 * </P>
	 * 
	 * @param o
	 *            The Object to which to compare this.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof NewsMaker) {
			NewsMaker newsMaker = (NewsMaker) o;
			return this.name.equals(newsMaker.getName());
		}
		return false;
	}

	/**
	 * The accessor for the name field.
	 * <P>
	 * Note that <code>String</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The name of the news maker.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The accessor for the list of newspaper stories.
	 * <P>
	 * Note that <code>NewsPaperstoryList</code> objects are mutable, so this
	 * really should return a copy of the list instead. However, we haven't
	 * studied that yet, so returning the list itself is acceptable for now.
	 * </P>
	 * 
	 * @return The list of stories featuring the news maker.
	 */
	public NewsStoryList getNewsStories() {
		// TODO Have it return a copy instead (Eventually)
		return this.newsStories;
	}

	/**
	 * The mutator that adds a newspaper story to a news maker's list of
	 * stories.
	 * <P>
	 * Note that since this list should contain only stories in which the news
	 * maker is featured, we should have this method verify that the
	 * <code>NewsMaker</code> object is referenced in the
	 * <code>NewspaperStory</code> object before the story is added to the list.
	 * However, to keep the project relatively simple, this requirement was not
	 * made in the project description and this check doesn't need to be made
	 * yet.
	 * </P>
	 * 
	 * @param newspaperStory
	 *            The newspaper story to add.
	 */
	public void addNewsStory(NewsStory newsStory) {
		// TODO Verify that story is about this NewsMaker (Eventually)
		this.newsStories.add(newsStory);
	}
	
	public int compareTo(NewsMaker newsMaker){
		return this.getName().compareTo(newsMaker.getName());
	}
}
