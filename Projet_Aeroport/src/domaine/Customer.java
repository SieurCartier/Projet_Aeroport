package domaine;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.GregorianCalendar;

public class Customer extends DatabaseItem {

	private String firstname;
	private String lastname;
	private Date birthdate;

	@SuppressWarnings("deprecation")
	public int getAge() {
		return new Date(new Date().getTime() - birthdate.getTime()).getYear();
	}
}
