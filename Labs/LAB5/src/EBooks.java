
public class EBooks extends Books {
	private double discount;
	private int size;

	public EBooks(String title, String author, double price, double discount, int size) {
		super(title, author, price);
		this.discount = discount;
		this.size = size;
	}

	public double computeCost() {
		return price - discount;
	}

	public String toString() {
		return "\"" + title + "\", author= " + author + " price= " + price + " size= " + size + "Mb";
	}
}
