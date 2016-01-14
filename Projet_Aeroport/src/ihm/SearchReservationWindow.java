package ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import domain.Reservation;
import job.ReservationJob;

public class SearchReservationWindow extends AbstractSearchWindow<Reservation> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;

	private JPanel panLabels;

	private JLabel labelNomClient;
	private JLabel labelVolAller;
	private JLabel labelVolRetour;
	private JLabel labelHotel;
	private JLabel labelChambre;

	private JLabel setLabelNomClient;
	private JLabel setLabelVolAller;
	private JLabel setLabelVolRetour;
	private JLabel setLabelHotel;
	private JLabel setLabelChambre;

	private JPanel panelRecherche;

	private JLabel labelRecherche;
	private JTextField rechercheField;

	private JPanel panelChange;

	private JButton recherche;
	private JButton btnSupp;
	private JButton btnModif;

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
		setSize(700, 350);

		setTitle("Rechercher une reservation");
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();

		panLabels = new JPanel(new GridBagLayout());

		labelNomClient = new JLabel("Client : ");
		labelVolAller = new JLabel("vol aller : ");
		labelVolRetour = new JLabel("Vol retour : ");
		labelHotel = new JLabel("Hotel : ");
		labelChambre = new JLabel("Chambre : ");

		setLabelNomClient = new JLabel();
		setLabelVolAller = new JLabel();
		setLabelVolRetour = new JLabel();
		setLabelHotel = new JLabel();
		setLabelChambre = new JLabel();

		panelRecherche = new JPanel(new GridBagLayout());

		labelRecherche = new JLabel("Rechercher une reservation :");
		rechercheField = new JTextField(8);

		panelChange = new JPanel(new GridBagLayout());

		recherche = new JButton("Ok");
		btnSupp = new JButton("Supprimer");
		btnModif = new JButton("Modifier");

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(40, 80, 0, 160);
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		liste.setFont(new Font("Serif", Font.ITALIC, 14));
		scrollPane.setBorder(BorderFactory.createTitledBorder("Liste des reservations "));
		add(scrollPane, gbc);

		// Panneau Label
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		gbc.gridx = 3;

		panLabels.setBorder(BorderFactory.createEtchedBorder());

		gbc2.gridx = 0;
		gbc2.gridy = 0;
		gbc2.weightx = 1;
		gbc2.weighty = 1;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(25, 20, 0, 0);

		labelNomClient.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelNomClient, gbc2);
		gbc2.gridy++;
		gbc2.insets = new Insets(10, 20, 0, 0);
		labelVolAller.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelVolAller, gbc2);
		gbc2.gridy++;
		labelVolRetour.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelVolRetour, gbc2);
		gbc2.gridy++;
		labelHotel.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelHotel, gbc2);
		gbc2.gridy++;
		gbc2.insets = new Insets(10, 20, 20, 0);
		labelChambre.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelChambre, gbc2);

		gbc2.insets = new Insets(25, 0, 0, 80);
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		gbc2.anchor = GridBagConstraints.LINE_START;
		panLabels.add(setLabelNomClient, gbc2);
		gbc2.gridy++;
		gbc2.insets = new Insets(10, 0, 0, 120);
		panLabels.add(setLabelVolAller, gbc2);
		gbc2.gridy++;
		panLabels.add(setLabelVolRetour, gbc2);
		gbc2.gridy++;
		panLabels.add(setLabelHotel, gbc2);
		gbc2.gridy++;
		gbc2.insets = new Insets(10, 0, 20, 80);
		panLabels.add(setLabelChambre, gbc2);

		gbc.insets = new Insets(50, -50, 0, 0);
		add(panLabels, gbc);

		// Panneau recherche
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(-40, 80, 0, 0);

		gbc2.insets = new Insets(0, 0, 0, 0);
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		panelRecherche.add(labelRecherche, gbc2);

		gbc2.gridx = 0;
		gbc2.gridy = 1;
		gbc2.insets = new Insets(10, 20, 0, 0);
		panelRecherche.add(rechercheField, gbc2);

		gbc2.gridx++;
		gbc2.insets = new Insets(10, 5, 0, 0);
		recherche.setPreferredSize(new Dimension(50, 20));
		recherche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onSearchClick();
			}
		});
		panelRecherche.add(recherche, gbc2);

		add(panelRecherche, gbc);

		// Panel suppression/modification
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc2.insets = new Insets(10, 0, 0, 0);
		gbc.insets = new Insets(-45, -50, 0, 0);
		btnSupp.setPreferredSize(new Dimension(100, 20));
		btnModif.setPreferredSize(new Dimension(90, 20));
		btnSupp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onDeleteClick();
			}
		});
		btnModif.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onEditClick();
			}
		});
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		panelChange.add(btnModif, gbc2);
		gbc2.insets = new Insets(10, 20, 0, 0);
		gbc2.gridx++;
		panelChange.add(btnSupp, gbc2);

		add(panelChange, gbc);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.
	 * ListSelectionEvent)
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Reservation selected = liste.getSelectedValue();
		if (selected != null)
			showDetails(selected);
	}

	/**
	 * A method that shows a {@link Reservation}'s details in the {@link JLabel}
	 * s.
	 * 
	 * @param selectedValue
	 *            The selected {@link Reservation} .
	 */
	private void showDetails(Reservation selectedValue) {
		setLabelNomClient.setText(selectedValue.getCustomer().toString());
		setLabelVolAller.setText(selectedValue.getDepartureFlight().toString());
		setLabelVolRetour.setText(selectedValue.getReturnFlight().toString());
		setLabelHotel.setText(selectedValue.getRoom().getOwnerHotel().toString());
		setLabelChambre.setText(selectedValue.getRoom().toString());
	}

	/**
	 * A method that resets the details' {@link JLabel}s'.
	 */
	private void resetDetails() {
		setLabelNomClient.setText("");
		setLabelVolAller.setText("");
		setLabelVolRetour.setText("");
		setLabelHotel.setText("");
		setLabelChambre.setText("");
	}

	/**
	 * A method called every time the user clicks on the {@link #btnModif}.
	 */
	protected void onEditClick() {
		Reservation r = liste.getSelectedValue();
		if (r != null) {
			NewReservationWindow w = new NewReservationWindow(r);
			w.setVisible(true);
		}

	}

	/**
	 * A method called every time the user clicks on the {@link #btnSupp}.
	 */
	protected void onDeleteClick() {
		Reservation r = liste.getSelectedValue();
		if (r != null) {

			int dialogButton = JOptionPane.YES_NO_OPTION;
			int choix = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer : " + r.toString() + " ?",
					"Attention", dialogButton);

			if (choix == 0) { // OUI
				job.remove(r);
				model.removeElement(r);
				resetDetails();
			}
		}

	}

	/**
	 * A method called every time the user clicks on the {@link #recherche}.
	 */
	protected void onSearchClick() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractSearchWindow#close()
	 */
	@Override
	public void close() {
		resetDetails();
		super.close();
	}

}
