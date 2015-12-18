package fabrics;

import java.sql.*;

import domaine.Customer;

public class CustomerFabric extends AbstractFabric<Customer> {

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
	protected Customer constructObject(ResultSet customer) throws SQLException {
		return new Customer(customer.getInt(""), customer.getString(""), customer.getString(""), customer.getDate(""),
				customer.getInt(""));
	}

}
