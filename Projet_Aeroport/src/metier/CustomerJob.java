package metier;

import java.util.HashMap;
import domaine.Customer;
import fabrics.CustomerFabric;

/*
 * This class will take care of the second use case : "Gestion de la liste des clients"
 */
public class CustomerJob extends AbstractJob<Customer, CustomerFabric> {

	@Override
	public Customer create(HashMap<String, String> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Customer t) {
		// TODO Auto-generated method stub

	}

}
