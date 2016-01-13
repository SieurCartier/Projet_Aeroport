package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Formatter {
	private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);

	public static Date stringToDate(String s) throws ParseException {
		return df.parse(s);
	}

	public static String dateToString(Date d) throws ParseException {
		return df.format(d);
	}

}
