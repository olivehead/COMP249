package ground;

import transit.PublicTransportation;

public class CityBus extends PublicTransportation {
	protected long routeNumber;
	protected int beginOperationYear;
	protected String lineName;
	protected String driverName;

	public CityBus() {
		super();
		this.routeNumber = 0;
		this.beginOperationYear = 0;
		this.lineName = null;
		this.driverName = null;
	}

	public CityBus(double ticketPrice, int numStops, long routeNumber, int beginOperationYear, String lineName,
			String driverName) {
		super(ticketPrice, numStops);
		this.routeNumber = routeNumber;
		this.beginOperationYear = beginOperationYear;
		this.lineName = lineName;
		this.driverName = driverName;
	}

	public CityBus(CityBus cb) {
		super(cb);
		routeNumber = cb.routeNumber;
		beginOperationYear = cb.beginOperationYear;
		lineName = cb.lineName;
		driverName = cb.driverName;
	}

	public void setRouteNumber(long routeNumber) {
		this.routeNumber = routeNumber;
	}

	public long getRouteNumber() {
		return routeNumber;
	}

	public void setBeginOperationYear(int beginOperationYear) {
		this.beginOperationYear = beginOperationYear;
	}

	public int getBeginOperatorYear() {
		return beginOperationYear;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getLineName() {
		return lineName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverName() {
		return driverName;
	}

	public String toString() {
		return "This CityBus" + super.toString() + "\nRoute Number: " + routeNumber + "\nFirst Year of Operation: "
				+ beginOperationYear + "\nLine Name: " + lineName + "\nDriver's Name: " + driverName;
	}

	public boolean equals(Object compare) {
		if (compare == null || this == null || this.getClass() != compare.getClass())
			return false;
		else {
			CityBus cb = (CityBus) compare;

			return super.equals(compare) && this.getRouteNumber() == cb.getRouteNumber()
					&& this.getBeginOperatorYear() == cb.getBeginOperatorYear()
					&& this.getDriverName() == cb.getDriverName() && this.getLineName() == cb.getLineName();
		}
	}
}
