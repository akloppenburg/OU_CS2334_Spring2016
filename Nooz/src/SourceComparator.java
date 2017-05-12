import java.util.Comparator;

//TODO finish writing class
//TODO write and edit Javadoc
//TODO check against Dr. Hougen's javadoc and UML
public class SourceComparator implements Comparator<NewsStory>{
	
	public static SourceComparator SOURCE_COMPARATOR = new SourceComparator();
	
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2){
		return newsStory1.getSource().compareTo(newsStory2.getSource());
	}

}
