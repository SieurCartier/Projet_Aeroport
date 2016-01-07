package fabrics;

import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import domain.AbstractDiscount;
import domain.City;

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

	protected D createDiscount(String name, Date startDate, Date endDate, float percentage, City city) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);
		parameters.put("startDate", startDate);
		parameters.put("endDate", endDate);
		parameters.put("percentage", percentage);
		parameters.put("fk_idVille", (city == null) ? null : city.getId());

		return super.create(parameters);
	}

}
