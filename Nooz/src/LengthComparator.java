import java.util.Comparator;

//TODO finish writing class
//TODO write and edit Javadoc
//TODO check against Dr. Hougen's javadoc and UML
public class LengthComparator implements Comparator<NewsStory>{
	
	public static final LengthComparator LENGTH_COMPARATOR = new LengthComparator();
	
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2){
		
		if(newsStory1.getLength() < newsStory2.getLength()){
			return newsStory2.getLength() - newsStory1.getLength();
		}
		if(newsStory1.getLength() > newsStory2.getLength()){
			return newsStory1.getLength() - newsStory2.getLength();
		}
		else{
			return 0;
		}
		
	}

}
