package job;

import java.text.*;
import java.util.*;

import domain.City;
import domain.Customer;
import fabrics.CityFabric;
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
		Customer ret = null;
		try {
			String firstname = fields.get("firstname");
			String lastname = fields.get("lastname");

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
			Date birthdate = df.parse(fields.get("birthdate"));

			City city = CityFabric.getInstanceOf().getByName(fields.get("city")).get(0);

			ret = fab.createCustomer(firstname, lastname, birthdate, city);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#remove(domaine.DatabaseItem)
	 */
	@Override
	public void remove(Customer t) {
		fab.delete(t);
	}

}
