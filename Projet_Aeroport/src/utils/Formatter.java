package utils;

import java.sql.Time;
import java.text.*;
import java.util.*;

public class Formatter {
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
	private static final DateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.FRENCH);

	public static Date stringToDate(String s) throws ParseException {
		return dateFormat.parse(s);
	}

	public static String dateToString(Date d) throws ParseException {
		return dateFormat.format(d);
	}

	public static Time stringToTime(String s) throws ParseException {
		return new Time(timeFormat.parse(s).getTime());
	}

	public static String timeToString(Time d) throws ParseException {
		return timeFormat.format(d);
	}

}
