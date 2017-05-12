import java.time.LocalDate;


//TODO finish writing class
//TODO write and edit Javadoc
//TODO check against Dr. Hougen's javadoc and UML
abstract class NewsStory implements Comparable<NewsStory>{
	
	/**
	 * The date the story was published as a <code>java.time.LocalDate</code>.
	 */
	private LocalDate date;

	/** The name of the newspaper in which the story was published. */
	private String source;

	/** The count of words in the story. */
	private int length;

	/** The broad topic of the story. */
	private String topic;

	/** The first news maker featured in the story. */
	private NewsMaker newsMaker1;

	/** The second news maker featured in the story. */
	private NewsMaker newsMaker2;

	/**
	 * The constructor for the class which takes objects of appropriate types to
	 * initialize all of the fields.
	 * <P>
	 * Note that in the world the count of words in a story cannot be negative,
	 * so our class should model that fact. However, to keep the project
	 * relatively simple, this requirement was not made in the project
	 * description and this check doesn't need to be made yet.
	 * </P>
	 * 
	 * @param date
	 *            The date the story was published as a java.time.LocalDate.
	 * @param newspaperName
	 *            The name of the newspaper in which the story was published.
	 * @param wordCount
	 *            The count of words in the story.
	 * @param topic
	 *            The broad topic of the story.
	 * @param newsMaker1
	 *            The first news maker featured in the story.
	 * @param newsMaker2
	 *            The second news maker featured in the story.
	 */
	protected NewsStory(LocalDate date, String source, int length, String topic, NewsMaker newsMaker1,
			NewsMaker newsMaker2) {
		this.date = date;
		this.source = source;
		this.length = length;
		this.topic = topic;
		this.newsMaker1 = newsMaker1;
		this.newsMaker2 = newsMaker1;
	}

	/**
	 * The accessor for the date field.
	 * <P>
	 * Note that <code>LocalDate</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The date the story was published.
	 */
	public LocalDate getDate() {
		return date; // Note that LocalDate is immutable
	}

	/**
	 * The accessor for the newspaper name field.
	 * <P>
	 * Note that <code>String</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The name of the newspaper in which the story was published.
	 */
	public String getSource() {
		return this.source;
	}
	
	public int getLength(){
		return this.length;
	}

	/**
	 * An abstract method that returns the length as an approximate number of words.
	 */
	public abstract int getLengthInWords();

	/**
	 * The accessor for the topic field.
	 * <P>
	 * Note that <code>String</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The broad topic of the story.
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * The accessor for the first news maker field.
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @return The first news maker featured in the story.
	 */
	public NewsMaker getNewsMaker1() {
		// TODO Have it return a copy instead (Eventually)
		return newsMaker1;
	}

	/**
	 * The accessor for the second news maker field.
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @return The second news maker featured in the story.
	 */
	public NewsMaker getNewsMaker2() {
		// TODO Have it return a copy instead (Eventually)
		return newsMaker2;
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o instanceof NewsStory){
			NewsStory newsStory = (NewsStory)o;
			
			if(newsStory.getSource().equalsIgnoreCase(this.getSource())){
				if(newsStory.getTopic().equalsIgnoreCase(this.getTopic())){
					if(newsStory.getLength() == this.getLength()){
						return true;
					}
					
					else{
						return false;
					}
				}
				
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
	}
	
	public int compareTo(NewsStory newsStory){
		int equals = this.topic.compareTo(newsStory.getTopic());
		
		if(equals == 0){
			
			equals = this.source.compareTo(newsStory.getSource());
		
			if(equals == 0){
				
				if(this.getLength() < newsStory.getLength()){
					return newsStory.getLength() - this.getLength();
				}
				if(this.getLength() > newsStory.getLength()){
					return this.getLength() - newsStory.getLength();
				}
				else{
					return equals;
				}
			}
			
			else{
				return equals;
			}
		}
		
		else{
			return equals;
		}
	}
			
}
