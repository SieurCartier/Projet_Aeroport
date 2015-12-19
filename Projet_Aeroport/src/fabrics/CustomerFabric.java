package fabrics;

import java.sql.*;
import java.util.*;
import java.util.Date;
import domaine.*;

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

	@Override
	protected Customer constructObject(ResultSet customer) throws SQLException {
		return new Customer(customer.getInt("idCustomer"), customer.getString("firstname"),
				customer.getString("lastname"), customer.getDate("birthdate"), customer.getInt("fk_idCity"));
	}

	@Override
	protected Customer constructObject(int id, HashMap<String, Object> m) {
		return new Customer(id, (String) m.get("firstName"), (String) m.get("lastName"), (Date) m.get("birthdate"),
				(int) m.get("fk_idCity"));
	}

	public Customer createCustomer(String firstname, String lastname, Date birthdate, City city) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("firstName", firstname);
		parameters.put("lastName", lastname);
		parameters.put("birthdate", birthdate);
		parameters.put("fk_idCity", city.getId());

		return super.create(parameters);
	}

}
