package job;

import java.util.HashMap;

import domain.Customer;
import fabrics.CustomerFabric;

/*
 * This class will take care of the second use case : "Gestion de la liste des clients"
 */
public class CustomerJob extends AbstractJob<Customer, CustomerFabric> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public Customer create(HashMap<String, String> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#remove(domaine.DatabaseItem)
	 */
	@Override
	public void remove(Customer t) {
		// TODO Auto-generated method stub

	}

}
