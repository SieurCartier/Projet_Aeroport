package fabrics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import domaine.AbstractDiscount;

public class DiscountFabric extends AbstractFabric<AbstractDiscount> {

	public DiscountFabric(String tableName, String primaryKeyName) {
		super(tableName, primaryKeyName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AbstractDiscount constructObject(ResultSet results) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractDiscount constructObject(int id, HashMap<String, Object> m) {
		// TODO Auto-generated method stub
		return null;
	}

}
