import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project 2, CS 2334, Section 010, February 22, 2017
 * <P>
 * A <code>NewsMakerList</code> is a list of <code>NewsMaker</code> objects.
 * Each <code>NewsMaker</code> in the list must have a unique name.
 * </P>
 * 
 * @author Dean Hougen
 * @version 2.0
 *
 */
class NewsMakerList  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1432293424436720480L;
	/** The list of news makers. */
	private List<NewsMaker> newsMakers;
	private boolean sorted;

	/**
	 * The no-argument constructor initializes the list to be an empty
	 * <code>ArrayList</code> of <code>NewsMaker</code> objects.
	 */
	public NewsMakerList() {
		this.newsMakers = new ArrayList<NewsMaker>();
	}

	/**
	 * The mutator for adding news makers to the list.
	 * <P>
	 * By using our own class with its own <code>add</code> method, rather than
	 * directly using the <code>add</code> method of <code>ArrayList</code>, we
	 * can ensure that we don't add multiple <code>NewsMaker</code> objects with
	 * the same name to our list (thereby keeping the names unique).
	 * </P>
	 * 
	 * @param newsMaker
	 *            The news maker to add.
	 * @throws IllegalArgumentException
	 *             If the news maker to add is already in the list.
	 */
	void add(NewsMaker newsMaker) {
		if (!this.newsMakers.contains(newsMaker)) {
			this.newsMakers.add(newsMaker);
			this.sorted = false;
		} else {
			throw new IllegalArgumentException("NewsMaker " + newsMaker.getName() + " already in list.");
		}
	}

	/**
	 * An accessor method to test whether the list already contains a news
	 * maker.
	 * <P>
	 * Simply makes use of the <code>contains</code> method of
	 * <code>ArrayList</code>.
	 * </P>
	 * 
	 * @param newsMaker
	 *            The news maker to check for in the list.
	 * @return The boolean value true if the news maker is in the list, false
	 *         otherwise.
	 */
	public boolean contains(NewsMaker newsMaker) {
		return this.newsMakers.contains(newsMaker);
	}

	/**
	 * An accessor method to get a news maker from the list.
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @param newsMaker
	 *            The news maker to get from the list.
	 * @return The news maker found, if any. Otherwise, null.
	 */
	public NewsMaker get(NewsMaker newsMaker) {
		int index = newsMakers.indexOf(newsMaker);
		if (index >= 0) {
			// TODO Have it return a copy instead (Eventually)
			return this.newsMakers.get(index);
		} else {
			return null;
		}
	}

	/**
	 * An accessor method to get a news maker from the list based on the exact
	 * name provided.
	 * <P>
	 * Note that this method uses a binary search. A binary search will only
	 * work for a sorted list. For Project 3 (Nooz 3.0), this method should
	 * check whether the list is sorted before using the binary search. If the
	 * list is not sorted, it should send a warning to standard error
	 * (""Attempted to conduct binary search on unsorted list.") and use a
	 * linear search instead.
	 * </P>
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @param newsMakerName
	 *            The exact name for which to search.
	 * @return The news maker found, if any. Otherwise null.
	 */
	public NewsMaker getExactMatch(String newsMakerName) {
		int index = Collections.binarySearch(newsMakers, new NewsMaker(newsMakerName));
		if (index >= 0) {
			// TODO Have it return a copy instead (Eventually)
			return this.newsMakers.get(index);
		}
		return null;
	}

	/**
	 * An accessor method to get a news maker from the list based on the partial
	 * name provided.
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @param newsMakerName
	 *            The exact name for which to search.
	 * @return The news maker found, if any. Otherwise null.
	 */
	public NewsMaker getPartialMatch(String newsMakerName) {
		for (NewsMaker newsMaker : newsMakers) {
			if (newsMaker.getName().contains(newsMakerName)) {
				return newsMaker;
			}
		}
		return null;
	}

	/**
	 * The sort method for the class.
	 * <P>
	 * It simply calls <code>Collections.sort</code> on the list of news makers
	 * and lets it use the natural ordering of news makers (as defined by the
	 * <code>compareTo</code> method of <code>NewsMaker</code>) to determine the
	 * ordering.
	 */
	public void sort() {
		Collections.sort(newsMakers);
		this.sorted = true;
	}
}
