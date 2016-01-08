package ihm;

import java.awt.*;
import javax.swing.*;
import domain.Reservation;
import fabrics.ReservationFabric;
import job.*;

public class NewReservationWindow extends
		AbstractNewDatabaseItemWindow<Reservation, ReservationJob> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;

	private DefaultListModel<String> modelClients;
	private JList<String> listeClients;
	private JScrollPane scrollPaneClients;

	private DefaultListModel<String> modelVols;
	private JList<String> listeVols;
	private JScrollPane scrollPaneVols;

	private DefaultListModel<String> modelHotels;
	private JList<String> listeHotels;
	private JScrollPane scrollPaneHotels;

	private DefaultListModel<String> modelChambres;
	private JList<String> listeChambres;
	private JScrollPane scrollPaneChambres;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected AbstractJob<Reservation, ReservationFabric> getJob() {
		return new ReservationJob();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractNewDatabaseItemWindow#build()
	 */
	@Override
	protected void build() {
		setSize(700, 350);
		setLocationRelativeTo(null);
		setTitle("Rechercher un client");
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();

		modelClients = new DefaultListModel<String>();
		scrollPaneClients = new JScrollPane(listeClients);

		modelVols = new DefaultListModel<String>();
		scrollPaneVols = new JScrollPane(listeVols);

		modelHotels = new DefaultListModel<String>();

		scrollPaneHotels = new JScrollPane(listeHotels);

		modelChambres = new DefaultListModel<String>();
		scrollPaneChambres = new JScrollPane(listeChambres);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(40, 80, 0, 160);
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		modelClients.addElement("one");
		modelClients.addElement("two");
		listeClients = new JList<String>(modelClients);
		listeClients.setFont(new Font("Serif", Font.ITALIC, 14));
		scrollPaneClients.setBorder(BorderFactory
				.createTitledBorder("Liste des clients"));
		add(scrollPaneClients, gbc);
		gbc.gridx++;

		modelVols.addElement("one");
		modelVols.addElement("two");
		listeVols = new JList<String>(modelVols);
		listeVols.setFont(new Font("Serif", Font.ITALIC, 14));
		scrollPaneVols.setBorder(BorderFactory
				.createTitledBorder("Liste des vols"));
		add(scrollPaneVols, gbc);
		gbc.gridx++;

		modelHotels.addElement("one");
		modelHotels.addElement("two");
		listeHotels = new JList<String>(modelHotels);
		listeHotels.setFont(new Font("Serif", Font.ITALIC, 14));
		scrollPaneHotels.setBorder(BorderFactory
				.createTitledBorder("Liste des hotels"));
		add(scrollPaneHotels, gbc);
		gbc.gridx++;

		modelChambres.addElement("one");
		modelChambres.addElement("two");
		listeChambres = new JList<String>(modelChambres);
		listeChambres.setFont(new Font("Serif", Font.ITALIC, 14));
		scrollPaneChambres.setBorder(BorderFactory
				.createTitledBorder("Liste des chambres"));
		add(scrollPaneChambres, gbc);
		gbc.gridx++;

		gbc.gridy++;
		btnCreate = new JButton("Valider");
		add(btnCreate, gbc);

	}

}
