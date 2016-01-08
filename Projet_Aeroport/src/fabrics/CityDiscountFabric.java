package fabrics;

import java.sql.*;
import java.util.*;
import java.util.Date;
import domain.City;
import domain.CityDiscount;

/**
 * This class represents a <code>Fabric</code> of {@link CityDiscount}.
 * 
 * @author Gaston Lemaire
 * 
 */
public class CityDiscountFabric extends AbstractDiscountFabric<CityDiscount> {

	private static CityDiscountFabric singleton = null;

	public static CityDiscountFabric getInstanceOf() {
		if (singleton == null)
			singleton = new CityDiscountFabric();
		return singleton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractDiscountFabric#constructObject(java.sql.ResultSet)
	 */
	@Override
	protected CityDiscount constructObject(ResultSet results)
			throws SQLException {
		return new CityDiscount(results.getInt("idDiscount"),
				results.getString("name"), results.getDate("StartDate"),
				results.getDate("EndDate"), results.getFloat("percentage"),
				results.getInt("fk_idVille"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractDiscountFabric#constructObject(int,
	 * java.util.HashMap)
	 */
	@Override
	protected CityDiscount constructObject(int id,
			HashMap<String, Object> fieldMap) {
		return new CityDiscount(id, (String) fieldMap.get("name"),
				(Date) fieldMap.get("StartDate"),
				(Date) fieldMap.get("EndDate"),
				(float) fieldMap.get("percentage"), (City) fieldMap.get("city"));
	}

	public CityDiscount createCityDiscount(String name, Date startDate,
			Date endDate, float percentage, City city) {
		return super.createDiscount(name, startDate, endDate, percentage, city);
	}

}
