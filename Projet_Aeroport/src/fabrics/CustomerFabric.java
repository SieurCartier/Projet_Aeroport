package fabrics;

import java.sql.*;
import java.util.*;
import java.util.Date;

import domain.*;

/**
 * This class is a <code>Fabric</code> of {@link Customer}
 * 
 * @author Gaston Lemaire
 */
public class CustomerFabric extends AbstractFabric<Customer> {

	private static CustomerFabric singleton = null;

	public CustomerFabric() {
		super("Customer", "idCategorie");
	}

	public static CustomerFabric getInstanceOf() {
		if (singleton == null)
			singleton = new CustomerFabric();
		return singleton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(java.sql.ResultSet)
	 */
	@Override
	protected Customer constructObject(ResultSet customer) throws SQLException {
		return new Customer(customer.getInt("idCustomer"), customer.getString("firstname"),
				customer.getString("lastname"), customer.getDate("birthdate"), customer.getInt("fk_idCity"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(int, java.util.HashMap)
	 */
	@Override
	protected Customer constructObject(int id, HashMap<String, Object> m) {
		return new Customer(id, (String) m.get("firstName"), (String) m.get("lastName"), (Date) m.get("birthdate"),
				(int) m.get("fk_idCity"));
	}

	/**
	 * This method creates a {@link Customer}.
	 * 
	 * @param firstname
	 *            The firstname of the {@link Customer}.
	 * @param lastname
	 *            The lastname of the {@link Customer}.
	 * @param birthdate
	 *            The birthdate of the {@link Customer}.
	 * @param city
	 *            The {@link City} of the {@link Customer}.
	 * @return The new {@link Customer}.
	 */
	public Customer createCustomer(String firstname, String lastname, Date birthdate, City city) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("firstName", firstname);
		parameters.put("lastName", lastname);
		parameters.put("birthdate", birthdate);
		parameters.put("fk_idCity", city.getId());

		return super.create(parameters);
	}

}
