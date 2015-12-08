package domaine;

import java.util.Date;

public class AgeDiscount extends AbstractDiscount {

	public AgeDiscount(int id, String name, Date startDate, Date endDate, float percentage) {
		super(id, name, startDate, endDate, percentage);
	}

	public boolean isApplyable(Customer c) {
		return c.getBirthdate().after(startDate) && c.getBirthdate().before(endDate);
	}

}
