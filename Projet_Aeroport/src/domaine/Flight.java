package domaine;

import java.util.Date;

public class Flight extends DatabaseItem {

	private City departure;
	private City arrival;
	private Date departureDate;
	private Date arrivalDate;

	public Date getTravelTime() {
		return new Date(arrivalDate.getTime() - departureDate.getTime());
	}

}
