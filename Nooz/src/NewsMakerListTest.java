import static org.junit.Assert.*;

import org.junit.Test;

public class NewsMakerListTest {

	@Test
	public void testNewsMakerListEmptyList() {
		NewsMakerList newsMakerList1 = new NewsMakerList();
		NewsMaker newsMaker1 = new NewsMaker();
		if (newsMakerList1.contains(newsMaker1)) {
			fail("Contains reports true even when list empty.");
		} else {
			return;
		}
	}

	@Test
	public void testNewsMakerListItemInList() {
		NewsMakerList newsMakerList1 = new NewsMakerList();
		NewsMaker newsMaker1 = new NewsMaker("News Maker 1");
		newsMakerList1.add(newsMaker1);
		if (newsMakerList1.contains(newsMaker1)) {
			return;
		} else {
			fail("Contains reports false even when news maker in list.");
		}
	}

	@Test
	public void testNewsMakerListNotEmptyItemNotInList() {
		NewsMakerList newsMakerList1 = new NewsMakerList();
		NewsMaker newsMaker1 = new NewsMaker("News Maker 1");
		NewsMaker newsMaker2 = new NewsMaker("News Maker 2");

		newsMakerList1.add(newsMaker1);
		if (newsMakerList1.contains(newsMaker2)) {
			fail("Contains reports true even when news maker not in list.");
		} else {
			return;

		}
	}

}
