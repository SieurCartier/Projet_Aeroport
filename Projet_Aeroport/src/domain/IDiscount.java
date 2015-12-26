package domain;

/**
 * This <code>Interface</code> represents every <code>Discount</code>. It is
 * parameterized by the {@link DatabaseItem} subject to the
 * <code>Discount</code>.
 * 
 * @author Gaston Lemaire
 *
 */
public interface IDiscount<D extends DatabaseItem> {

	/**
	 * This method applies a <code>Discount</code> on the specified price by
	 * simply multiplying it.
	 * 
	 * @param p
	 *            The price you want to apply a <code>Discount</code> on.
	 * @return The price multiplied by the <code>Discount</code>.
	 */
	public float apply(float p);

	/**
	 * This method checks if a <code>Discount</code> is applicable to a
	 * {@link DatabaseItem}.
	 * 
	 * @param d
	 *            The {@link DatabaseItem}.
	 * @return <code>True</code> if the <code>Discount</code> is applicable else
	 *         <code>False</code>.
	 */
	public boolean isApplicable(D d);

}
