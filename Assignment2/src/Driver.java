
import transit.PublicTransportation;
import ground.CityBus;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		PublicTransportation pt1 = new CityBus();
		CityBus cb1 = new CityBus(3.25, 20, 12, 2000, "St-Leonard", "Alexander Mcpherson");
		pt1.setNumStops(8);
		System.out.println("pt1 = " + pt1 + "\n\ncb1 = " + cb1);
		
		
	}

}
