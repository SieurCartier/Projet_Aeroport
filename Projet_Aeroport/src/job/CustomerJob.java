package job;

import java.text.*;
import java.util.*;
import domain.City;
import domain.Customer;
import fabrics.CustomerFabric;

/**
 * This class will take care of the second use case :
 * "Gestion de la liste des clients"
 */
public class CustomerJob extends AbstractJob<Customer, CustomerFabric> {

	public CustomerJob() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public Customer create(HashMap<String, Object> fields) {
		Customer ret = null;
		try {
			String firstname = (String) fields.get("firstname");
			String lastname = (String) fields.get("lastname");

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
			Date birthdate = df.parse((String) fields.get("birthdate"));

			City city = (City) fields.get("city");

			ret = fab.createCustomer(firstname, lastname, birthdate, city);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	protected CustomerFabric getFabric() {
		return CustomerFabric.getInstanceOf();
	}

}
