// -----------------------------------------------------
// Assignment #3
// Part: 1
// Written by: Olivier D'Angelo #26729916
// -----------------------------------------------------

import java.io.*;

public class Book implements Serializable{
	protected long ISBN;
	protected String title;
	protected int issueYear;
	protected String authorName;
	protected double price;
	protected int numberOfPages;

	// Default constructor
	public Book() {
		ISBN = 0;
		title = null;
		issueYear = 0;
		authorName = null;
		price = 0.0;
		numberOfPages = 0;
	}

	// Constructor: accepts all attributes of the class as parameters and initiates them
	public Book(long ISBN, String title, int issueYear, String authorName, double price, int numberOfPages) {
		this.ISBN = ISBN;
		this.title = title;
		this.issueYear = issueYear;
		this.authorName = authorName;
		this.price = price;
		this.numberOfPages = numberOfPages;
	}

	// Compares ISBN number of 2 Book objects
	public boolean ISBNequals(Book newBook) {
		if (newBook == null) {
			return false;
		}
		return newBook.ISBN == this.ISBN;
	}
	//Set new value for ISBN (useful for MAIN in loop to check for duplicates)
	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
}
