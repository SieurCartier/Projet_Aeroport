package job;

import java.util.*;
import domain.City;
import domain.Customer;
import fabrics.CustomerFabric;
import utils.Formatter;

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
			Date birthdate = Formatter.stringToDate((String) fields.get("birthdate"));
			City city = (City) fields.get("city");

			ret = fab.createCustomer(firstname, lastname, birthdate, city);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#getFabric()
	 */
	@Override
	protected CustomerFabric getFabric() {
		return CustomerFabric.getInstanceOf();
	}

	@Override
	public Customer update(Customer item, HashMap<String, Object> fields) {
		Customer ret = null;
		try {
			HashMap<String, Object> updateMap = new HashMap<String, Object>();

			String firstname = (String) fields.get("firstname");
			String lastname = (String) fields.get("lastname");
			Date birthdate = Formatter.stringToDate((String) fields.get("birthdate"));
			City city = (City) fields.get("city");

			if (!firstname.equals(item.getFirstname())) {
				updateMap.put("firstname", firstname);
				item.setFirstname(firstname);
			}

			if (!lastname.equals(item.getLastname())) {
				updateMap.put("lastname", lastname);
				item.setLastname(lastname);
			}

			if (!birthdate.equals(item.getBirthdate())) {
				updateMap.put("birthdate", birthdate);
				item.setBirthdate(birthdate);
			}

			if (!city.equals(item.getCity())) {
				updateMap.put("city", firstname);
				item.setCity(city);
			}

			ret = fab.update(item, updateMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}
