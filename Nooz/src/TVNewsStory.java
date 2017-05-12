import java.time.LocalDate;

//TODO finish writing class
//TODO write and edit Javadoc
//TODO check against Dr. Hougen's javadoc and UML
public class TVNewsStory extends NewsStory{

	TVNewsStory(LocalDate date, String source, int length, String topic, NewsMaker newsMaker1, NewsMaker newsMaker2){
		super(date, source, length, topic, newsMaker1, newsMaker2);
	}
	
	@Override
	public int getLengthInWords(){
		int approximateNumWords = 0;
		
		approximateNumWords = (int)(((super.getLength())/60.0)*150);
		
		return approximateNumWords;
	}
	
}
