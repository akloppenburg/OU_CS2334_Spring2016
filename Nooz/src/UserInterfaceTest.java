import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.time.LocalDate;

import org.junit.Test;

public class UserInterfaceTest {

	@Test
	public void testCreateListOfNewspaperStoriesForNewsmakerMultiple() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");
		NewspaperStory newspaperStory1 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", null, null);
		newsMaker1.addNewspaperStory(newspaperStory1);

		NewspaperStory newspaperStory2 = new NewspaperStory(LocalDate.of(2001, 1, 1), "LA Times", 6000,
				"Interesting Topic 2", null, null);
		newsMaker1.addNewspaperStory(newspaperStory2);

		String storyListString = "December 31, 2000; Times of London; 20 words; Interesting Topic"
				+ "\nJanuary 1, 2001; LA Times; 6000 words; Interesting Topic 2"
				+ "\nNumber of Stories: 2; Number of Newspapers: 2; Number of Words: 6020; Number of Topics: 2";

		String returnedStoryList = UserInterface.createListOfNewspaperStoriesForNewsmaker(newsMaker1);
		
		if (storyListString.equals(returnedStoryList)) {
			return;
		} else {
			fail("Not equal");
		}
	}

	@Test
	public void testCreateListOfNewspaperStoriesForNewsmakerSingle() {
		NewsMaker newsMaker1 = new NewsMaker("Interesting Person");
		NewspaperStory newspaperStory1 = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", null, null);
		newsMaker1.addNewspaperStory(newspaperStory1);

		String storyListString = "December 31, 2000; Times of London; 20 words; Interesting Topic"
				+ "\nNumber of Stories: 1; Number of Newspapers: 1; Number of Words: 20; Number of Topics: 1";

		String returnedStoryList = UserInterface.createListOfNewspaperStoriesForNewsmaker(newsMaker1);
		
		if (storyListString.equals(returnedStoryList)) {
			return;
		} else {
			fail("Not equal");
		}
	}
	
	@Test
	public void testConvertToOutputFormat() {

		NewspaperStory newspaperStory = new NewspaperStory(LocalDate.of(2000, 12, 31), "Times of London", 20,
				"Interesting Topic", null, null);
		String storyString = "December 31, 2000; Times of London; 20 words; Interesting Topic";
		String returnedString = "";

		Class[] argClasses = { NewspaperStory.class };
		Object[] argObjects = { newspaperStory };
		Method method;
		try {
			method = UserInterface.class.getDeclaredMethod("convertToOutputFormat", argClasses);
			System.err.println(method);
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
}
