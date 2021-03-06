// -----------------------------------------------------
// Assignment #3
// Part: 1
// Written by: Olivier D'Angelo #26729916
// -----------------------------------------------------

public class DuplicateISBNException extends Exception {
	private long duplicateISBN;
	private int inventoryIndex;

	public DuplicateISBNException() {
		super("Duplicate ISBN found.");
	}

	public DuplicateISBNException(String message) {
		super(message);

	}

	public DuplicateISBNException(long duplicateISBN, int inventoryIndex) {
		super("\nDuplicate ISBN " + duplicateISBN + " detected in record # " + (inventoryIndex + 1)
				+ ". Please enter the correct ISBN:");
		this.duplicateISBN = duplicateISBN;
		this.inventoryIndex = inventoryIndex;
	}

	public String getMessage() {
		return super.getMessage();
	}

	public int getInventoryIndex() {
		return inventoryIndex;
	}

	public long getDuplicateISBN() {
		return duplicateISBN;
	}
}
