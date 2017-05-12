import java.util.Comparator;

public class DateComparator implements Comparator<NewsStory>{
	
	public static final DateComparator DATE_COMPARATOR = new DateComparator();
	
	
	public int compare(NewsStory newsStory1, NewsStory newsStory2){
		int compareNum = newsStory1.getDate().compareTo(newsStory2.getDate());
		
		if(compareNum == 0 && newsStory1 instanceof TVNewsStory && newsStory2 instanceof TVNewsStory){
			TVNewsStory tvNewsStory1 = (TVNewsStory)newsStory1;
			TVNewsStory tvNewsStory2 = (TVNewsStory)newsStory2;
			
			int order = tvNewsStory1.getPartOfDay().ordinal() - tvNewsStory2.getPartOfDay().ordinal();
			return order;
		}
		else if(compareNum == 0 && newsStory1 instanceof TVNewsStory && newsStory2 instanceof OnlineNewsStory){
			TVNewsStory tvNewsStory1 = (TVNewsStory)newsStory1;
			OnlineNewsStory onlineNewsStory2 = (OnlineNewsStory)newsStory2;
			
			int order = tvNewsStory1.getPartOfDay().ordinal() - onlineNewsStory2.getPartOfDay().ordinal();
			return order;
		}
		else if(compareNum == 0 && newsStory1 instanceof OnlineNewsStory && newsStory2 instanceof OnlineNewsStory){
			OnlineNewsStory onlineNewsStory1 = (OnlineNewsStory)newsStory1;
			OnlineNewsStory onlineNewsStory2 = (OnlineNewsStory)newsStory2;
			
			int order = onlineNewsStory1.getPartOfDay().ordinal() - onlineNewsStory2.getPartOfDay().ordinal();
			return order;
		}
		else if(compareNum == 0 && newsStory1 instanceof OnlineNewsStory && newsStory2 instanceof TVNewsStory){
			OnlineNewsStory onlineNewsStory1 = (OnlineNewsStory)newsStory1;
			TVNewsStory tvNewsStory2 = (TVNewsStory)newsStory2;
			
			int order = onlineNewsStory1.getPartOfDay().ordinal() - tvNewsStory2.getPartOfDay().ordinal();
			return order;
		}
		else{
			return compareNum;
		}
	}

}
