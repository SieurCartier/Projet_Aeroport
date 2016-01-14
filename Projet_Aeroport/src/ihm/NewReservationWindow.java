package ihm;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import domain.*;
import job.*;

public class NewReservationWindow extends AbstractNewDatabaseItemWindow<Reservation> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;

	private DefaultListModel<Customer> modelClients;
	private JList<Customer> listeClients;
	private JScrollPane scrollPaneClients;

	private DefaultListModel<Flight> modelDepartureVols;
	private JList<Flight> listeVols;
	private JScrollPane scrollPaneVols;

	private DefaultListModel<Flight> modelArrivalVols;
	private JList<Flight> listeVolsRetour;
	private JScrollPane scrollPaneVolsRetour;

	private DefaultListModel<Hotel> modelHotels;
	private JList<Hotel> listeHotels;
	private JScrollPane scrollPaneHotels;

	private DefaultListModel<Category> modelCategories;
	private JList<Category> listeCategories;
	private JScrollPane scrollPaneCategories;

	// Panel Info Chambres
	private JPanel panInfoChambres;
	private JLabel labelNomChambre;
	private JLabel labelPrixChambre;
	private JLabel setLabelNomChambre;
	private JLabel setLabelPrixChambre;

	public NewReservationWindow() {
		super();
	}

	public NewReservationWindow(Reservation r) {
		super();
		try {
			listeClients.setSelectedValue(r.getCustomer(), true);
			listeVols.setSelectedValue(r.getDepartureFlight(), true);
			listeVolsRetour.setSelectedValue(r.getReturnFlight(), true);
			listeHotels.setSelectedValue(r.getRoom().getOwnerHotel(), true);
			listeCategories.setSelectedValue(r.getRoom().getCategory(), true);

			editing = true;
			object = r;
			btnCreate.setText("Modifier");
			setTitle("Modifier une réservation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected ReservationJob getJob() {
		return new ReservationJob();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractNewDatabaseItemWindow#build()
	 */
	@Override
	protected void build() {
		setSize(800, 350);
		setLocationRelativeTo(null);
		setTitle("Faire une réservation");
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();

		modelClients = new DefaultListModel<Customer>();
		listeClients = new JList<Customer>(modelClients);
		scrollPaneClients = new JScrollPane(listeClients);

		modelDepartureVols = new DefaultListModel<Flight>();
		listeVols = new JList<Flight>(modelDepartureVols);
		listeVols.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				flightSelected();
			}
		});
		scrollPaneVols = new JScrollPane(listeVols);

		modelArrivalVols = new DefaultListModel<Flight>();
		listeVolsRetour = new JList<Flight>(modelArrivalVols);
		scrollPaneVolsRetour = new JScrollPane(listeVolsRetour);

		modelHotels = new DefaultListModel<Hotel>();
		listeHotels = new JList<Hotel>(modelHotels);
		listeHotels.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				hotelSelected();
			}
		});
		scrollPaneHotels = new JScrollPane(listeHotels);

		modelCategories = new DefaultListModel<Category>();
		listeCategories = new JList<Category>(modelCategories);
		scrollPaneCategories = new JScrollPane(listeCategories);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;

		gbc2.gridx = 0;
		gbc2.gridy = 0;
		gbc2.weightx = 1;
		gbc2.weighty = 1;

		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(40, 80, 0, 0);
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		listeClients.setFont(new Font("Serif", Font.ITALIC, 14));
		scrollPaneClients.setBorder(BorderFactory.createTitledBorder("Clients"));
		add(scrollPaneClients, gbc);
		gbc.gridx = 3;

		listeVols.setFont(new Font("Serif", Font.ITALIC, 14));
		scrollPaneVols.setBorder(BorderFactory.createTitledBorder("Vols"));
		add(scrollPaneVols, gbc);
		gbc.gridx = 6;

		listeVolsRetour.setFont(new Font("Serif", Font.ITALIC, 14));
		scrollPaneVolsRetour.setBorder(BorderFactory.createTitledBorder("Vols retour"));
		add(scrollPaneVolsRetour, gbc);
		gbc.gridx = 9;

		listeHotels.setFont(new Font("Serif", Font.ITALIC, 14));
		scrollPaneHotels.setBorder(BorderFactory.createTitledBorder("Hotels"));
		add(scrollPaneHotels, gbc);
		gbc.gridx = 12;

		gbc.insets = new Insets(40, 80, 0, 0);
		listeCategories.setFont(new Font("Serif", Font.ITALIC, 14));
		scrollPaneCategories.setBorder(BorderFactory.createTitledBorder("Catégorie"));
		add(scrollPaneCategories, gbc);
		gbc.gridx = 15;

		panInfoChambres = new JPanel(new GridBagLayout());
		panInfoChambres.setBorder(BorderFactory.createEtchedBorder());
		gbc2.anchor = GridBagConstraints.FIRST_LINE_END;
		setLabelNomChambre = new JLabel("");
		setLabelPrixChambre = new JLabel("");
		labelNomChambre = new JLabel("Nom :");
		labelPrixChambre = new JLabel("Prix :");

		gbc2.insets = new Insets(10, 20, 0, 0);
		panInfoChambres.add(labelNomChambre, gbc2);
		gbc2.gridy++;
		gbc2.insets = new Insets(10, 20, 20, 0);
		panInfoChambres.add(labelPrixChambre, gbc2);

		gbc2.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc2.insets = new Insets(10, 20, 0, 20);
		gbc2.gridx++;
		gbc2.gridy = 0;
		panInfoChambres.add(setLabelNomChambre, gbc2);
		gbc2.gridy++;
		gbc2.insets = new Insets(10, 20, 20, 20);
		panInfoChambres.add(setLabelPrixChambre, gbc2);

		gbc.insets = new Insets(40, 80, 0, 80);
		add(panInfoChambres, gbc);

		gbc.gridx++;
		gbc.gridy++;
		btnCreate = new JButton("Valider");
		gbc.insets = new Insets(-60, 80, 60, 80);
		add(btnCreate, gbc);
	}

	protected void hotelSelected() {
		Hotel h = listeHotels.getSelectedValue();
		if (h != null) {
			modelCategories.removeAllElements();
			for (Category c : h.getCategories()) {
				modelCategories.addElement(c);
			}
		}
	}

	protected void flightSelected() {
		Flight f = listeVols.getSelectedValue();
		if (f != null) {
			modelHotels.removeAllElements();
			for (Hotel h : f.getArrival().getHotels()) {
				modelHotels.addElement(h);
			}
			modelArrivalVols.removeAllElements();
			for (Flight ftemp : f.getArrival().getDepartingFlights()) {
				modelArrivalVols.addElement(ftemp);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#populate()
	 */
	@Override
	protected void populate() {
		CustomerJob cj = new CustomerJob();
		for (Customer c : cj.getAll()) {
			modelClients.addElement(c);
		}

		FlightJob fj = new FlightJob();
		for (Flight f : fj.getAll()) {
			modelDepartureVols.addElement(f);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#close()
	 */
	@Override
	public void close() {
		modelClients.removeAllElements();
		modelCategories.removeAllElements();
		modelHotels.removeAllElements();
		modelDepartureVols.removeAllElements();
		modelArrivalVols.removeAllElements();

		super.close();
	}

}
