package fabrics;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domaine.City;
import domaine.Customer;
import utils.Enums;

public class CustomerFabric extends AbstractFabric<Customer> {

	private enum ColumnNames {
		firstName, lastName, birthdate, fk_idCity
	}

	private static final int FIRSTNAME = ColumnNames.firstName.ordinal();
	private static final int LASTNAME = ColumnNames.lastName.ordinal();
	private static final int BIRTHDATE = ColumnNames.birthdate.ordinal();
	private static final int FK_ID_CITY = ColumnNames.fk_idCity.ordinal();

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
	protected Customer constructObject(int id, Object[] m) {
		return new Customer(id, (String) m[FIRSTNAME], (String) m[LASTNAME], (Date) m[BIRTHDATE], (int) m[FK_ID_CITY]);
	}

	public Customer createCustomer(String firstname, String lastname, Date birthdate, City city) {
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(firstname);
		parameters.add(lastname);
		parameters.add(birthdate);
		parameters.add(city.getId());

		return super.create(Enums.toStringArray(ColumnNames.values()), parameters.toArray());
	}

}
