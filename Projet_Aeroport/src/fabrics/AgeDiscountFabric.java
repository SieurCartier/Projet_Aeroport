package fabrics;

import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import domain.AgeDiscount;

public class AgeDiscountFabric extends AbstractDiscountFabric<AgeDiscount> {

	private static AgeDiscountFabric singleton = null;

	public static AgeDiscountFabric getInstanceOf() {
		if (singleton == null)
			singleton = new AgeDiscountFabric();
		return singleton;
	}

	@Override
	protected AgeDiscount constructObject(ResultSet results)
			throws SQLException {
		return new AgeDiscount(results.getInt("idDiscount"),
				results.getString("name"), results.getDate("StartDate"),
				results.getDate("EndDate"), results.getFloat("percentage"));
	}

	@Override
	protected AgeDiscount constructObject(int id,
			HashMap<String, Object> fieldMap) {
		return new AgeDiscount(id, (String) fieldMap.get("name"),
				(Date) fieldMap.get("StartDate"),
				(Date) fieldMap.get("EndDate"),
				(float) fieldMap.get("percentage"));
	}

	public AgeDiscount createAgeDiscount(String name, Date startDate,
			Date endDate, float percentage) {
		return super.createDiscount(name, startDate, endDate, percentage, null);
	}

}
