package fabrics;

public class HotelFabric {

	private static HotelFabric singleton = null;

	private HotelFabric() {

	}

	public static HotelFabric getInstanceOf() {
		if (singleton == null)
			singleton = new HotelFabric();
		return singleton;
	}
}
