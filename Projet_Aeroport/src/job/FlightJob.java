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

			Time departureTime = new Time(Formatter.stringToTime((String) fields.get("departureTime")).getTime());
			Time flightDuration = new Time(Formatter.stringToTime((String) fields.get("flightDuration")).getTime());

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
	public Flight update(Flight item, HashMap<String, Object> fields) {
		Flight ret = null;
		try {
			HashMap<String, Object> updateMap = new HashMap<String, Object>();

			String flightNumber = (String) fields.get("flightNumber");

			City departure = (City) fields.get("departure");
			City arrival = (City) fields.get("arrival");

			DayOfWeek dayOfWeekDeparture = (DayOfWeek) fields.get("dayOfWeekDeparture");

			Time departureTime = new Time(Formatter.stringToTime((String) fields.get("departureTime")).getTime());
			Time flightDuration = new Time(Formatter.stringToTime((String) fields.get("flightDuration")).getTime());

			int nbFirstClassSits = Integer.parseInt((String) fields.get("nbFirstClassSits"));

			float priceFirstClassSits = Float.parseFloat((String) fields.get("priceFirstClassSits"));

			int nbSecondClassSits = Integer.parseInt((String) fields.get("nbSecondClassSits"));

			float priceSecondClassSits = Float.parseFloat((String) fields.get("priceSecondClassSits"));

			int nbDayCancelling = Integer.parseInt((String) fields.get("nbDayCancelling"));

			if (!flightNumber.equals(item.getFlightNumber())) {
				updateMap.put("flightNumber", flightNumber);
				item.setFlightNumber(flightNumber);
			}

			if (!departure.equals(item.getDeparture())) {
				updateMap.put("departure", departure);
				item.setDeparture(departure);
			}

			if (!arrival.equals(item.getArrival())) {
				updateMap.put("arrival", arrival);
				item.setArrival(arrival);
			}

			if (!dayOfWeekDeparture.equals(item.getDayOfWeekDeparture())) {
				updateMap.put("dayOfWeekDeparture", dayOfWeekDeparture);
				item.setDayOfWeekDeparture(dayOfWeekDeparture);
			}
			if (!departureTime.equals(item.getDepartureTime())) {
				updateMap.put("departureTime", departureTime);
				item.setDepartureTime(departureTime);
			}
			if (!flightDuration.equals(item.getFlightDuration())) {
				updateMap.put("flightDuration", flightDuration);
				item.setFlightDuration(flightDuration);
			}
			if (nbFirstClassSits != item.getNbFirstClassSits()) {
				updateMap.put("nbFirstClassSits", nbFirstClassSits);
				item.setNbFirstClassSits(nbFirstClassSits);
			}
			if (priceFirstClassSits != item.getPriceFirstClassSits()) {
				updateMap.put("priceFirstClassSits", priceFirstClassSits);
				item.setPriceFirstClassSits(priceFirstClassSits);
			}
			if (nbSecondClassSits != item.getNbSecondClassSits()) {
				updateMap.put("nbSecondClassSits", nbSecondClassSits);
				item.setNbSecondClassSits(nbSecondClassSits);
			}
			if (priceSecondClassSits != item.getPriceSecondClassSits()) {
				updateMap.put("priceSecondClassSits", priceSecondClassSits);
				item.setPriceSecondClassSits(priceSecondClassSits);
			}
			if (nbDayCancelling != item.getNbDayCancelling()) {
				updateMap.put("nbDayCancelling", nbDayCancelling);
				item.setNbDayCancelling(nbDayCancelling);
			}

			ret = fab.update(item, updateMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}
