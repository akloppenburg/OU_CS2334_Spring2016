import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Lab 3 CS 2334, Section 010 February 21, 2017
 * <P>
 * This class models a list of books.
 * </P>
 * 
 * @author Dean Hougen and (your name)
 * @version 1.0
 */

public class BookList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -523773774499921709L;
	private List<Book> bookList = new ArrayList<Book>();

	public void add(Book book) {
		// Check whether book is already in list
		// If so, throw illegal argument exception
		if (bookList.contains(book)) {
			throw new IllegalArgumentException("Cannot add the same book twice");
		}
		// If not, add it
		else {
			bookList.add(book);
		}
	}

	public Book get(int index) {
		if (index >= 0 && index < bookList.size()) {
			return bookList.get(index);
		} else {
			throw new IllegalArgumentException("Index out of bounds");
		}
	}

	/**
	 * This method returns the attributes of this class as a single string with
	 * one resident per line.
	 * 
	 * @return String representing the contents of this object.
	 */
	public String toString() {
		String attributesAsString = "";
		for (Book book : bookList) {
			attributesAsString += book + "\n";
		}
		return (attributesAsString);
	}
	
	public static void writeBookList(String filename, BookList books){
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(books);
			objectOutputStream.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException i){
			i.printStackTrace();
		}
	}
	
	public static BookList readBookList(String filename){
		BookList books = null;
		try{
			FileInputStream fileInputStream = new FileInputStream(filename);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			books = (BookList) objectInputStream.readObject();
			objectInputStream.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException i){
			i.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return books;
	}
}
