import java.time.LocalDate;

public class OnlineNewsStory extends NewsStory{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4803445820974524157L;
	
	
	private PartOfDay partOfDay;
	
	public OnlineNewsStory(LocalDate date, String sourceName, int length, String topic, String subject, PartOfDay partOfDay, NewsMaker newsMaker1,
			NewsMaker newsMaker2) {
		super(date, sourceName, length, topic, subject, newsMaker1, newsMaker2);
		this.partOfDay = partOfDay;
	}
	
	public int getLengthInWords(){
		return this.getLength();
	}
	
	public PartOfDay getPartOfDay(){
		return this.partOfDay;
	}

}
