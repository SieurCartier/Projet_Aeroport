package domain;

import java.util.Date;

/**
 * A special kind of Discount which is based on the age of the {@link Customer}
 * 
 * @author Gaston Lemaire
 */
public class AgeDiscount extends AbstractDiscount {

	public AgeDiscount(int id, String name, Date startDate, Date endDate, float percentage) {
		super(id, name, startDate, endDate, percentage);
	}

	/**
	 * This method determines if the {@link Customer} can pretend to the
	 * Discount
	 * 
	 * @param c
	 *            The customer to test
	 * @return <code>True</code> if the customer can pretend to the discount
	 *         else <code>False</code>
	 */
	public boolean isApplyable(Customer c) {
		return c.getBirthdate().after(startDate) && c.getBirthdate().before(endDate);
	}
}
