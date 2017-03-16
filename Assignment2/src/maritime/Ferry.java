package maritime;

import transit.PublicTransportation;

public class Ferry extends PublicTransportation {
	private int buildYear;
	private String shipName;

	public Ferry() {
		super();
		buildYear = 0;
		shipName = null;
	}

	public Ferry(double ticketPrice, int numStops, int buidYear, String shipName) {
		super(ticketPrice, numStops);
		this.buildYear=buidYear;
		this.shipName=shipName; 
	}

	public Ferry(PublicTransportation copy) {
		super(copy);
		// TODO Auto-generated constructor stub
	}

}
