package fabrics;

import domaine.Customer;

public class CustomerFabric extends GenericFabric<Customer> {

	private static CustomerFabric singleton = null;

	public CustomerFabric() {
		super("", "");
	}

	public static CustomerFabric getInstanceOf() {
		if (singleton == null)
			singleton = new CustomerFabric();
		return singleton;
	}

	@Override
	public void SQLquerryById(int id) {
		// TODO Auto-generated method stub

	}

}
