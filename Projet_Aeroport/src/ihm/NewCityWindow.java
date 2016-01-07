package ihm;

import javax.swing.*;
import domain.City;
import fabrics.CityFabric;
import job.*;

public class NewCityWindow extends AbstractNewDatabaseItemWindow<City, CityJob> {

	private static final long serialVersionUID = 1L;

	JTextField name;

	public NewCityWindow() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected AbstractJob<City, CityFabric> getJob() {
		return new CityJob();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractNewDatabaseItemWindow#build()
	 */
	@Override
	protected void build() {
		name = new JTextField();
		name.putClientProperty("fieldName", "name");
		fields.add(name);
	}

}
