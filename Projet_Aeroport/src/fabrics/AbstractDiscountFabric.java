package fabrics;

import java.sql.*;
import java.util.HashMap;
import domain.AbstractDiscount;

/**
 * This class is a <code>Fabric</code> of {@link AbstractDiscount}
 * 
 * @author Gaston Lemaire
 */
public abstract class AbstractDiscountFabric<D extends AbstractDiscount> extends AbstractFabric<D> {

	protected AbstractDiscountFabric() {
		super("Discount", "idDiscount");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(java.sql.ResultSet)
	 */
	@Override
	protected abstract D constructObject(ResultSet results) throws SQLException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(int, java.util.HashMap)
	 */
	@Override
	protected abstract D constructObject(int id, HashMap<String, Object> m);

}
