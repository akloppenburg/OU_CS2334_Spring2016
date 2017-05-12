import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.time.LocalDate;

import org.junit.Test;

public class UserInterfaceTest {

	@Test
	public void testConvertToOutputFormatNewspaper() {
		NewspaperStory newspaperStory = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", null, null);
		String storyString = "December 31, 2000; Times of London; 20 words; Interesting Topic";
		String mediaType = "n";
		String returnedString = "";

		Class[] argClasses = { NewsStory.class, String.class };
		Object[] argObjects = { newspaperStory, mediaType };
		Method method;
		try {
			method = UserInterface.class.getDeclaredMethod("convertToOutputFormat", argClasses);
			method.setAccessible(true);
			returnedString = (String) method.invoke(null, argObjects);
		} catch (Exception e) {
			fail("Exception: " + e);
		}

		if (storyString.equals(returnedString)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	@Test
	public void testCreateListOfNewsStoriesForNewsmakerNewspaperTopicOrder() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");
		NewspaperStory newspaperStory1 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", null, null);
		newsMaker1.addNewsStory(newspaperStory1);

		NewspaperStory newspaperStory2 = new NewspaperStory(LocalDate.of(2001, 1, 1), "LA Times", 6000,
				"Interesting Topic 2", null, null);
		newsMaker1.addNewsStory(newspaperStory2);

		String storyListString = "December 31, 2000; Times of London; 20 words; Interesting Topic"
				+ "\nJanuary 1, 2001; LA Times; 6000 words; Interesting Topic 2"
				+ "\nNumber of Stories: 2; Number of Sources: 2; Number of Words: 6020; Number of Topics: 2";

		String mediaType = "n";
		String[] sortCriteria = { "t", "s", "l" };
		String returnedStoryList = UserInterface.createListOfNewsStoriesForNewsmaker(newsMaker1, mediaType,
				sortCriteria);

		if (storyListString.equals(returnedStoryList)) {
			return;
		} else {
			fail("Not equal");
		}
	}
	
	@Test
	public void testCreateListOfNewsStoriesForNewsmakerTVNewsTopicOrder () {

		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");
		TVNewsStory tvNewsStory1 = new TVNewsStory(LocalDate.of(2001, 1, 1), "Times of London", 20, "Interesting Topic", null, null);
		newsMaker1.addNewsStory(tvNewsStory1);

		TVNewsStory tvNewsStory2 = new TVNewsStory(LocalDate.of(2001, 1, 1), "LA Times", 20, "Interesting Topic", null, null);
		newsMaker1.addNewsStory(tvNewsStory2);

		String storyListString = "January 1, 2001; LA Times; 20 seconds; Interesting Topic"
				+ "\nJanuary 1, 2001; Times of London; 20 seconds; Interesting Topic"
				+ "\nNumber of Stories: 2; Number of Sources: 2; Seconds: 40; Number of Topics: 1";

		String mediaType = "t";
		String[] sortCriteria = {"s", "t", "l"};
		String returnedStoryList = UserInterface.createListOfNewsStoriesForNewsmaker(newsMaker1, mediaType, sortCriteria);
			
		if (storyListString.equals(returnedStoryList)) {
			return;
		} else {
			fail("Not equal");
		}
	}
}
