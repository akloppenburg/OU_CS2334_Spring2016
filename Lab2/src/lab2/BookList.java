package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Dean Hougen and Alex Kloppenburg
 *
 */
public class BookList {
	private ArrayList<Book> bookList = new ArrayList<Book>();

	public void add(Book book) {
		//Checks to see if the book is in the list
		int numMatches = 0;
		for(int i = 0; i < bookList.size(); ++i){
			if(bookList.get(i).equals(book)){
				++numMatches;
			}
			// If not, add it
			else{
				numMatches = numMatches;
			}
		}
		
		if(numMatches == 0){
			bookList.add(book);
		}
		else{
			throw new IllegalArgumentException("Error in input file.  Cannot add same book twice.");
		}
	}

	public void printBooks() {
		Iterator<Book> iterator = bookList.iterator();

		while (iterator.hasNext()) {
			// Note: This line of code will automatically call the toString
			// method of the Book class.
			System.out.println(iterator.next());
		}
	}
	
	public void sortBooks() {
		Collections.sort(bookList);
	}
	
	public Book findBook(Book book) {
		//Uses binarySearch to find the book object in the list
		int searchResult = Collections.binarySearch(bookList, book);
		
		// If the book is found, return it
		if(searchResult >= 0){
			return bookList.get(searchResult);
		}
		
		// If not, return null
		else{
			return null;
		}
	}
}