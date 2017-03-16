package ground;

public class Tram extends CityBus {
	private int maxSpeed;

	public Tram() {
		super();
		maxSpeed = 0;
	}

	public Tram(double ticketPrice, int numStops, long routeNumber, int beginOperationYear, String lineName,
			String driverName, int maxSpeed) {
		super(ticketPrice, numStops, routeNumber, beginOperationYear, lineName, driverName);
		this.maxSpeed = maxSpeed;
	}

	public Tram(Tram tr) {
		super(tr);
		this.maxSpeed = tr.maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public String toString() {
		return "This Tram" + super.toString() + "\nRoute Number: " + routeNumber + "\nFirst Year of Operation: "
				+ beginOperationYear + "\nLine Name: " + lineName + "\nDriver's Name: " + driverName + "\nMax. Speed: "
				+ maxSpeed;
	}

	public boolean equals(Object compare) {
		if (compare == null || this == null || this.getClass() != compare.getClass())
			return false;
		else {
			Tram tr = (Tram) compare;

			return super.equals(compare) && this.getRouteNumber() == tr.getRouteNumber()
					&& this.getBeginOperatorYear() == tr.getBeginOperatorYear()
					&& this.getDriverName() == tr.getDriverName() && this.getLineName() == tr.getLineName()
					&& this.maxSpeed == tr.maxSpeed;
		}
	}
}
