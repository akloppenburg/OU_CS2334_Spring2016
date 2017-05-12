package lab2;

import java.util.ArrayList;

/**
 * Lab 2 CS 2334, Section 010 7 February 2017
 * <P>
 * This class provides a very simple model for a book. A Book has a title, an
 * author, a publication year, and one or more genres.
 * </P>
 * 
 * @author Dean Hougen and Alex Kloppenburg
 * @version 1.0
 */
public class Book implements Comparable<Book>{

	/** The title of the book. */
	private String title;

	/** The name of the book's author. */
	private String authorName;

	/** The year the book was published. */
	private int year;

	/** The genre(s) of the book. */
	private ArrayList<String> genres;

	/**
	 * This is the default constructor for the class.
	 */
	public Book() {
		this.title = "";
		this.authorName = "";
		this.year = -1;
		this.genres = null;
	}

	/**
	 * This is a constructor for the class. It instantiates the class with
	 * user-supplied values. This version of the constructor is used when only
	 * one genre is provided.
	 * <P>
	 * 
	 * @param title
	 *            The title of the book
	 * @param authorName
	 *            The name of the book's author
	 * @param year
	 *            The year that the book was published
	 * @param genre
	 *            The genre of the book
	 */
	public Book(String title, String lastName, int year, String genre) {
		this.title = title;
		this.authorName = lastName;
		this.year = year;
		this.genres = new ArrayList<String>();
		genres.add(genre);
	}

	/**
	 * This is a constructor for the class. It instantiates the class with
	 * user-supplied values. This version of the constructor is used when
	 * multiple genres are provided.
	 * <P>
	 * 
	 * @param title
	 *            The title of the book
	 * @param authorName
	 *            The name of the book's author
	 * @param year
	 *            The year that the book was published
	 * @param genres
	 *            The genres of the book
	 */
	public Book(String title, String authorName, int year, ArrayList<String> genres) {
		this.title = title;
		this.authorName = authorName;
		this.year = year;
		this.genres = genres;
	}

	/**
	 * This method returns the attributes of this class as a single string.
	 * </P>
	 * 
	 * @return bookInfo String representing the contents of this object
	 */
	public String toString() {
		// Adds title, author, and year
		String bookInfo = this.title + ", " + this.authorName + ", " + this.year;
		
		//Adds genres by iterating through the ArrayList
		for(String nextGenre: this.genres){
			bookInfo = bookInfo + ", " + nextGenre;
		}
		return bookInfo;
	}

	/**
	 * This method checks to see whether two instances of Book are equal by
	 * comparing their fields other than genres.
	 * 
	 * @return boolean as to whether this book is equal to another object
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Book) {
			Book book = (Book) o;
			boolean equivalent = this.title.equals(book.title);
			if (equivalent) {
				equivalent = this.authorName.equals(book.authorName);
			}
			if (equivalent) {
				equivalent = this.year == book.year;
			}
			return equivalent;
		}

		else {
			return false;
		}
	}
	/**
	 * This method compares an instance of this Book, with another instance of
	 * Book. It should not consider genres.
	 * <P>
	 * Algorithm:<br>
	 * ????
	 * </P>
	 * 
	 * @param obj
	 *            The object to which we are comparing this instance of Book
	 * @return comparisonNum
	 * 						  An integer that returns a positive, 0 or negative value based on whether the titles of the 
	 * 						  two books in question are the same.  Follows the rules of the Object class's compareTo.
	 */
	public int compareTo(Book book) {
		//Compares titles of books
		int equivalent = this.title.compareTo(book.title);
		
		//If titles are equal compare author names
		if (equivalent == 0) {
			equivalent = this.authorName.compareTo(book.authorName);
		}
		
		//If both are equivalent then compare year published
		if (equivalent == 0) {
			equivalent = this.year - book.year;
		}
		return equivalent;
	}
}