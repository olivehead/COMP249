
public class HardCopyBook extends Books {
	private double shippingCost;

	public HardCopyBook(String title, String author, double price, double shippingCost) {
		super(title, author, price);
		this.shippingCost = shippingCost;
	}

	public double computeCost() {
		return price + shippingCost;
	}
	public String toString() {
		return "\"" + title + "\", author= " + author + " price= " + price + " shipping Cost= " + shippingCost+ "$";
	}
}
