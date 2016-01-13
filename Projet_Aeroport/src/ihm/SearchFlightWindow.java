package ihm;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

import domain.Flight;
import job.FlightJob;
import utils.Formatter;

public class SearchFlightWindow extends AbstractSearchWindow<Flight> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;

	private JPanel panLabels;

	private JLabel labelNumeroVol;
	private JLabel labelJourDepart;
	private JLabel labelHeureDepart;
	private JLabel labelVilleDepart;
	private JLabel labelVilleArrivee;
	private JLabel LabelDuree;
	private JLabel labelNbPlacesFC;
	private JLabel labelPrixPlacesFC;
	private JLabel labelNbPlacesSC;
	private JLabel labelPrixPlacesSC;
	private JLabel labelDelai;

	private JLabel setLabelNumeroVol;
	private JLabel setLabelJourDepart;
	private JLabel setLabelHeureDepart;
	private JLabel setLabelVilleDepart;
	private JLabel setLabelVilleArrivee;
	private JLabel setLabelDuree;
	private JLabel setLabelNbPlacesFC;
	private JLabel setLabelPrixPlacesFC;
	private JLabel setLabelNbPlacesSC;
	private JLabel setLabelPrixPlacesSC;
	private JLabel setLabelDelai;

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
	protected FlightJob getJob() {
		return new FlightJob();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractNewDatabaseItemWindow#build()
	 */
	@Override
	protected void build() {
		setSize(800, 600);

		setTitle("Rechercher un vol");
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();

		panLabels = new JPanel(new GridBagLayout());

		labelNumeroVol = new JLabel("Numero du vol : ");
		labelJourDepart = new JLabel("Jour du depart : ");
		labelHeureDepart = new JLabel("Heure de depart : ");
		labelVilleDepart = new JLabel("Ville de depart : ");
		labelVilleArrivee = new JLabel("Ville d'arrivée : ");
		LabelDuree = new JLabel("Durée du vol : ");
		labelNbPlacesFC = new JLabel("Nombre de places 1C : ");
		labelPrixPlacesFC = new JLabel("Prix places 1C : ");
		labelNbPlacesSC = new JLabel("Nombre de places 2C : ");
		labelPrixPlacesSC = new JLabel("Prix places 2C : ");
		labelDelai = new JLabel("Delai avant résiliation : ");

		setLabelNumeroVol = new JLabel();
		setLabelJourDepart = new JLabel();
		setLabelHeureDepart = new JLabel();
		setLabelVilleDepart = new JLabel();
		setLabelVilleArrivee = new JLabel();
		setLabelDuree = new JLabel();
		setLabelNbPlacesFC = new JLabel();
		setLabelPrixPlacesFC = new JLabel();
		setLabelNbPlacesSC = new JLabel();
		setLabelPrixPlacesSC = new JLabel();
		setLabelDelai = new JLabel();

		panelRecherche = new JPanel(new GridBagLayout());

		labelRecherche = new JLabel("Rechercher un vol :");
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
		scrollPane.setBorder(BorderFactory.createTitledBorder("Liste des vol"));
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

		labelNumeroVol.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelNumeroVol, gbc2);
		gbc2.gridy++;
		gbc2.insets = new Insets(10, 20, 0, 0);
		labelJourDepart.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelJourDepart, gbc2);
		gbc2.gridy++;
		labelHeureDepart.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelHeureDepart, gbc2);
		gbc2.gridy++;
		labelVilleDepart.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelVilleDepart, gbc2);
		gbc2.gridy++;
		labelVilleArrivee.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelVilleArrivee, gbc2);
		gbc2.gridy++;
		LabelDuree.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(LabelDuree, gbc2);
		gbc2.gridy++;
		labelNbPlacesFC.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelNbPlacesFC, gbc2);
		gbc2.gridy++;
		labelPrixPlacesFC.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelPrixPlacesFC, gbc2);
		gbc2.gridy++;
		labelNbPlacesSC.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelNbPlacesSC, gbc2);
		gbc2.gridy++;
		labelPrixPlacesSC.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelPrixPlacesSC, gbc2);
		gbc2.gridy++;
		gbc2.insets = new Insets(10, 20, 20, 0);
		labelDelai.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelDelai, gbc2);

		gbc2.insets = new Insets(25, 0, 0, 80);
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		gbc2.anchor = GridBagConstraints.LINE_START;
		panLabels.add(setLabelNumeroVol, gbc2);
		gbc2.insets = new Insets(10, 0, 0, 120);
		gbc2.gridy++;
		panLabels.add(setLabelJourDepart, gbc2);
		gbc2.gridy++;
		panLabels.add(setLabelHeureDepart, gbc2);
		gbc2.gridy++;
		panLabels.add(setLabelVilleDepart, gbc2);
		gbc2.gridy++;
		panLabels.add(setLabelVilleArrivee, gbc2);
		gbc2.gridy++;
		panLabels.add(setLabelDuree, gbc2);
		gbc2.gridy++;
		panLabels.add(setLabelNbPlacesFC, gbc2);
		gbc2.gridy++;
		panLabels.add(setLabelPrixPlacesFC, gbc2);
		gbc2.gridy++;
		panLabels.add(setLabelNbPlacesSC, gbc2);
		gbc2.gridy++;
		panLabels.add(setLabelPrixPlacesSC, gbc2);
		gbc2.gridy++;
		gbc2.insets = new Insets(10, 0, 20, 80);
		panLabels.add(setLabelDelai, gbc2);

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
		Flight selected = liste.getSelectedValue();
		if (selected != null)
			showDetails(selected);
	}

	/**
	 * A method that shows a {@link Flight}'s details in the {@link JLabel}s.
	 * 
	 * @param selectedValue
	 *            The selected {@link Flight} .
	 */
	private void showDetails(Flight selectedValue) {
		setLabelNumeroVol.setText(selectedValue.getFlightNumber());
		setLabelJourDepart.setText(selectedValue.getDayOfWeekDeparture().toString());
		try {
			setLabelHeureDepart.setText(Formatter.timeToString(selectedValue.getDepartureTime()));
			setLabelDuree.setText(Formatter.timeToString(selectedValue.getFlightDuration()));
		} catch (ParseException e) {
			setLabelHeureDepart.setText("");
			setLabelDuree.setText("");
		}
		setLabelVilleDepart.setText(selectedValue.getDeparture().toString());
		setLabelVilleArrivee.setText(selectedValue.getArrival().toString());
		setLabelNbPlacesFC.setText(Integer.toString(selectedValue.getNbFirstClassSits()));
		setLabelPrixPlacesFC.setText(Float.toString(selectedValue.getPriceFirstClassSits()));
		setLabelNbPlacesSC.setText(Integer.toString(selectedValue.getNbSecondClassSits()));
		setLabelPrixPlacesSC.setText(Float.toString(selectedValue.getPriceSecondClassSits()));
		setLabelDelai.setText(Integer.toString(selectedValue.getNbDayCancelling()));
	}

	/**
	 * A method that resets the details' {@link JLabel}s'.
	 */
	private void resetDetails() {
		setLabelNumeroVol.setText("");
		setLabelJourDepart.setText("");
		setLabelHeureDepart.setText("");
		setLabelVilleDepart.setText("");
		setLabelVilleArrivee.setText("");
		setLabelDuree.setText("");
		setLabelNbPlacesFC.setText("");
		setLabelPrixPlacesFC.setText("");
		setLabelNbPlacesSC.setText("");
		setLabelPrixPlacesSC.setText("");
		setLabelDelai.setText("");
	}

	/**
	 * A method called every time the user clicks on the {@link #btnModif}.
	 */
	protected void onEditClick() {
		Flight f = liste.getSelectedValue();
		if (f != null) {
			NewFlightWindow w = new NewFlightWindow(f);
			w.setVisible(true);
		}

	}

	/**
	 * A method called every time the user clicks on the {@link #btnSupp}.
	 */
	protected void onDeleteClick() {
		Flight f = liste.getSelectedValue();
		if (f != null) {
			int choix = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer : " + f.toString() + " ?",
					"Attention", JOptionPane.YES_NO_OPTION);

			if (choix == 0) { // OUI
				job.remove(f);
				model.removeElement(f);
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
