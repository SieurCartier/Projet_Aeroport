package job;

import java.sql.*;
import java.util.*;
import domain.*;
import fabrics.FlightFabric;
import utils.DayOfWeek;
import utils.Formatter;

/**
 * This class will take care of the first use case : "Gestion des voyages"
 */
public class FlightJob extends AbstractJob<Flight, FlightFabric> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public Flight create(HashMap<String, Object> fields) {
		Flight ret = null;
		try {

			String flightNumber = (String) fields.get("flightNumber");

			City departure = (City) fields.get("departure");
			City arrival = (City) fields.get("arrival");

			DayOfWeek dayOfWeekDeparture = (DayOfWeek) fields.get("dayOfWeekDeparture");

			Time departureTime = new Time(Formatter.stringToDate((String) fields.get("departureTime")).getTime());
			Time flightDuration = new Time(Formatter.stringToDate((String) fields.get("flightDuration")).getTime());

			int nbFirstClassSits = Integer.parseInt((String) fields.get("nbFirstClassSits"));

			float priceFirstClassSits = Float.parseFloat((String) fields.get("priceFirstClassSits"));

			int nbSecondClassSits = Integer.parseInt((String) fields.get("nbSecondClassSits"));

			float priceSecondClassSits = Float.parseFloat((String) fields.get("priceSecondClassSits"));

			int nbDayCancelling = Integer.parseInt((String) fields.get("nbDayCancelling"));

			ret = fab.createFlight(flightNumber, departure, arrival, dayOfWeekDeparture, departureTime, flightDuration,
					nbFirstClassSits, priceFirstClassSits, nbSecondClassSits, priceSecondClassSits, nbDayCancelling);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#getFabric()
	 */
	@Override
	protected FlightFabric getFabric() {
		return FlightFabric.getInstanceOf();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.IJob#update(domain.DatabaseItem, java.util.HashMap)
	 */
	@Override
	public Flight update(Flight item, HashMap<String, Object> fieldsmap) {
		// TODO Auto-generated method stub
		return null;
	}

}
