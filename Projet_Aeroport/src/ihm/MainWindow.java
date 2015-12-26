package ihm;

import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This class represents the main <code>Window</code>. It simply consists on a
 * little menu bar with several items on it.
 * 
 * @author Gaston Lemaire
 */
public class MainWindow extends JFrame implements ActionListener,
		ListSelectionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * A window map, you store a <code>Window</code> referenced by the button
	 * that opens it
	 */
	@SuppressWarnings("rawtypes")
	private HashMap<Object, AbstractWindow> windowsMap = new HashMap<Object, AbstractWindow>();

	private JMenuBar menuBar = new JMenuBar();

	private JMenu customers = new JMenu();
	private JMenuItem searchCustomer = new JMenuItem();
	private JMenuItem newCustomer = new JMenuItem();

	private JMenu flights = new JMenu();
	private JMenuItem searchFlight = new JMenuItem();
	private JMenuItem newFlight = new JMenuItem();

	private JMenu hotels = new JMenu();
	private JMenuItem searchHotel = new JMenuItem();
	private JMenuItem newHotel = new JMenuItem();

	private JMenu cities = new JMenu();
	private JMenuItem searchCity = new JMenuItem();
	private JMenuItem newCity = new JMenuItem();

	private JMenu reservations = new JMenu();
	private JMenuItem searchReservation = new JMenuItem();
	private JMenuItem newReservation = new JMenuItem();

	private JMenu discounts = new JMenu();
	private JMenuItem manageDiscounts = new JMenuItem();
	private JMenuItem newDiscount = new JMenuItem();

	public MainWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initComponents();
	}

	/**
	 * A method that sets up every components of the window.
	 */
	private void initComponents() {
		/**
		 * For each menu items, you set its properties and put it as a reference
		 * to the proper window in the {@link #windowsMap}.
		 */

		/* Customers */

		customers.setText("Clients");

		searchCustomer.setText("Rechercher");
		searchCustomer.addActionListener(this);
		customers.add(searchCustomer);
		windowsMap.put(searchCustomer, new SearchCustomerWindow());

		newCustomer.setText("Nouveau");
		newCustomer.addActionListener(this);
		customers.add(newCustomer);
		windowsMap.put(newCustomer, new NewCustomerWindow());

		menuBar.add(customers);

		/* Reservations */

		reservations.setText("Réservations");

		searchReservation.setText("Rechercher");
		searchReservation.addActionListener(this);
		reservations.add(searchReservation);
		windowsMap.put(searchReservation, new SearchReservationWindow());

		newReservation.setText("Nouvelle");
		newReservation.addActionListener(this);
		reservations.add(newReservation);
		windowsMap.put(newReservation, new NewReservationWindow());

		menuBar.add(reservations);

		/* Flights */

		flights.setText("Vols");

		searchFlight.setText("Rechercher");
		searchFlight.addActionListener(this);
		flights.add(searchFlight);
		windowsMap.put(searchFlight, new SearchFlightWindow());

		newFlight.setText("Nouveau");
		newFlight.addActionListener(this);
		flights.add(newFlight);
		windowsMap.put(newFlight, new NewFlightWindow());

		menuBar.add(flights);

		/* Hotels */

		hotels.setText("Hotels");

		searchHotel.setText("Rechercher");
		searchHotel.addActionListener(this);
		hotels.add(searchHotel);
		windowsMap.put(searchHotel, new SearchHotelWindow());

		newHotel.setText("Nouveau");
		newHotel.addActionListener(this);
		hotels.add(newHotel);
		windowsMap.put(newHotel, new NewHotelWindow());

		menuBar.add(hotels);

		/* Cities */

		cities.setText("Villes");

		searchCity.setText("Rechercher");
		searchCity.addActionListener(this);
		cities.add(searchCity);
		windowsMap.put(searchCity, new SearchCityWindow());

		newCity.setText("Nouvelle");
		newCity.addActionListener(this);
		cities.add(newCity);
		windowsMap.put(newCity, new NewCityWindow());

		menuBar.add(cities);

		/* Discounts */

		discounts.setText("Promotions");

		manageDiscounts.setText("Gérer");
		manageDiscounts.addActionListener(this);
		discounts.add(manageDiscounts);
		windowsMap.put(manageDiscounts, new ManageDiscountWindow());

		newDiscount.setText("Nouvelle");
		newDiscount.addActionListener(this);
		discounts.add(newDiscount);
		windowsMap.put(newDiscount, new NewDiscountWindow());

		menuBar.add(discounts);

		setJMenuBar(menuBar);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 278, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

		pack();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.
	 * ListSelectionEvent)
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractWindow window = windowsMap.get(e.getSource());
		window.setVisible(true);
	}

}
