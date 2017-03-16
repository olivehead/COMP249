
abstract class Books {
	String title;
	String author;
	double price;

	public Books() {
		title = null;
		author = null;
		price = 0;
	}

	public Books(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	abstract public double computeCost();
	abstract public String toString();
}
