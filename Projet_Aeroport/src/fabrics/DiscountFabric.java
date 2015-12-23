package fabrics;

import java.sql.*;
import java.util.HashMap;
import domaine.AbstractDiscount;

/**
 * This class is a <code>Fabric</code> of {@link AbstractDiscount}
 * 
 * @author Gaston Lemaire
 */
public class DiscountFabric extends AbstractFabric<AbstractDiscount> {

	public DiscountFabric(String tableName, String primaryKeyName) {
		super(tableName, primaryKeyName);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(java.sql.ResultSet)
	 */
	@Override
	protected AbstractDiscount constructObject(ResultSet results) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(int, java.util.HashMap)
	 */
	@Override
	protected AbstractDiscount constructObject(int id, HashMap<String, Object> m) {
		// TODO Auto-generated method stub
		return null;
	}

}
