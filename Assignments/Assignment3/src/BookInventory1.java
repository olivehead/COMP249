
// -----------------------------------------------------
// Assignment #3
// Part: 1
// Written by: Olivier D'Angelo #26729916
// -----------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class BookInventory1 extends Book implements Serializable{
	static Book[] bkArr;

	public BookInventory1() {
		bkArr = null;
	}

	// Create array of correct size and store all the info from input file into
	// Book objects
	public BookInventory1(Scanner inFileStream, int BkArrSize) throws IOException {
		long ISBN;
		String title, authorname, garbage;
		int issueYear;
		double price;
		int numberOfPages;
		bkArr = new Book[BkArrSize];
		for (int i = 0; i < bkArr.length; i++) {
			ISBN = inFileStream.nextLong();
			title = inFileStream.next();
			issueYear = inFileStream.nextInt();
			authorname = inFileStream.next();
			price = inFileStream.nextDouble();
			numberOfPages = inFileStream.nextInt();
			inFileStream.nextLine();
			bkArr[i] = new Book(ISBN, title, issueYear, authorname, price, numberOfPages);
		}
	}

	/*
	 * Method returns inventory size if greater than 0/1 or else it terminates
	 * program
	 */
	public static int inventorySize(Scanner inFileStream) throws IOException {
		String temp;
		int size = 0;
		while (inFileStream.hasNextLine()) {
			temp = inFileStream.nextLine();
			size++;
		}
		if (size <= 1) {
			System.out.println("File  is empty or only contains one record");
			System.out.println("Program will terminate.");
			inFileStream.close();
			System.exit(0);
			return -1;
		} else {
			System.out.println("Amount of books in the inventory: " + size);
			inFileStream.close();
			return size;
		}
	}
	
	//initiates the BookInventory1 static array by calling Constructor
	public static void initiateBkArr(Scanner inFileStream, int BkArrSize) throws IOException {
		BookInventory1 bi = new BookInventory1(inFileStream, BkArrSize);
		inFileStream.close();
	}
	
	//Create copy of file
	public static void fileCopy(Scanner inFileStream, PrintWriter outFileStream) throws IOException {
		String temp;
		while (inFileStream.hasNextLine()) {
			temp = inFileStream.nextLine();
			outFileStream.println(temp);
		}
		inFileStream.close();
		outFileStream.close();
	}

	//Compare the ISBN of each Book object, and throw an the DuplicateISBNException if 2 ISBN's match
	public static void fixInventory(Scanner inFileStream, PrintWriter OutFileStream, int BkArrSize)
			throws IOException, DuplicateISBNException {

		Scanner in = new Scanner(new FileInputStream("Initial_Book_Info.txt"));

		for (int i = 0; i < BkArrSize; i++) {
			for (int j = 0; j < BkArrSize; j++) {
				if (bkArr[i].ISBNequals(bkArr[j]) && i != j)
					throw new DuplicateISBNException(bkArr[i].ISBN, i);
			}
		}
		for (int i = 0; i < BkArrSize; i++) {
			OutFileStream.println(bkArr[i].ISBN + " " + bkArr[i].title + " " + bkArr[i].authorName + " "
					+ bkArr[i].price + " " + bkArr[i].numberOfPages);
		}
		// Always close files:
		inFileStream.close();
		OutFileStream.close();
	}

	// Assumes an already open Input Stream
	public static void displayFileContent(Scanner inFileStream) throws IOException {
		while (inFileStream.hasNextLine()) {
			System.out.println(inFileStream.nextLine());
		}
		inFileStream.close();
	}
	//Returns the element of the bkArr needed to access Book attributes from main
	public static Book getBookArr(int inventoryIndex) {

		return bkArr[inventoryIndex];
	}
}
