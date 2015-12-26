package domain;

import java.util.Date;

/**
 * A special kind of Discount which is based on the age of the {@link Customer}
 * 
 * @author Gaston Lemaire
 */
public class AgeDiscount extends AbstractDiscount implements
		IDiscount<Customer> {

	public AgeDiscount(int id, String name, Date startDate, Date endDate,
			float percentage) {
		super(id, name, startDate, endDate, percentage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.IDiscount#isApplicable(domain.DatabaseItem)
	 */
	@Override
	public boolean isApplicable(Customer c) {
		return c.getBirthdate().after(startDate)
				&& c.getBirthdate().before(endDate);
	}

}
