package transit;

public class PublicTransportation {
	private double ticketPrice;
	private int numStops;

	public PublicTransportation() {
		this.ticketPrice = 0.0;
		this.numStops = 0;
	}

	public PublicTransportation(double ticketPrice, int numStops) {
		this.ticketPrice = ticketPrice;
		this.numStops = numStops;
	}

	public PublicTransportation(PublicTransportation copy) {
		ticketPrice = copy.ticketPrice;
		numStops = copy.numStops;
	}
	
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public void setNumStops(int numStops) {
		this.numStops = numStops;
	}
	
	public double getTicketPrice() {
		return ticketPrice;
	}

	public int getNumStops() {
		return numStops;
	}
	public String toString() {
		return " has " + numStops + " stops, and costs " + ticketPrice + "$.";
	}
	
	public boolean equals(Object compare) {
		if (compare == null || this == null || this.getClass() != compare.getClass()) return false;
		else {
			PublicTransportation pt = (PublicTransportation) compare;
		
		return (this.getTicketPrice() == pt.getTicketPrice() &&
				this.getNumStops() == pt.getNumStops());
		}
	}
}
