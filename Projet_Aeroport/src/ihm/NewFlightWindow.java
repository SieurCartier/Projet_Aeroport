package ihm;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.PlainDocument;
import utils.DayOfWeek;
import domain.*;
import job.*;

public class NewFlightWindow extends AbstractNewDatabaseItemWindow<Flight> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;

	private JPanel panelAjoutVol;

	private JLabel labelAjout;
	private JLabel labelNumVol;
	private JLabel labelVilleDep;
	private JLabel labelVilleDest;
	private JLabel labelJourDepart;
	private JLabel labelHeureDepart;
	private JLabel labelDuree;
	private JLabel labelNbFC;
	private JLabel labelPrixFC;
	private JLabel labelNbSC;
	private JLabel labelPrixSC;
	private JLabel labelDelai;

	private JTextField tfNumVol;
	private JTextField tfHeureDepart;
	private JTextField tfDuree;
	private JTextField tfNbFC;
	private JTextField tfPrixFC;
	private JTextField tfNbSC;
	private JTextField tfPrixSC;
	private JTextField tfDelai;

	private DayOfWeek[] listeJours;
	private JComboBox<DayOfWeek> comboBoxJours;

	private java.util.List<City> cityList;
	private DefaultComboBoxModel<City> cityDepartureModel;
	private JComboBox<City> comboBoxVillesDep;
	private DefaultComboBoxModel<City> cityArrivalModel;
	private JComboBox<City> comboBoxVillesDest;

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
		setLocationRelativeTo(null);
		setTitle("Ajouter un vol");
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();

		panelAjoutVol = new JPanel(new GridBagLayout());

		labelAjout = new JLabel("Ajouter un vol");
		labelNumVol = new JLabel("Numero du vol");
		labelVilleDep = new JLabel("Ville de depart");
		labelVilleDest = new JLabel("Ville d'arrivée");
		labelJourDepart = new JLabel("Jour de depart");
		labelHeureDepart = new JLabel("Heure de depart");
		labelDuree = new JLabel("Duree du vol");
		labelNbFC = new JLabel("Nb. places premiere classe");
		labelPrixFC = new JLabel("Prix place premiere classe");
		labelNbSC = new JLabel("Nb. places seconde classe");
		labelPrixSC = new JLabel("Prix place seconde classe");
		labelDelai = new JLabel("Delai max avant resilation");

		tfNumVol = new JTextField(10);
		tfNumVol.putClientProperty("fieldName", "flightNumber");
		tfNumVol.setDocument(new PlainDocument());
		fields.add(tfNumVol);

		tfHeureDepart = new JTextField(10);
		tfHeureDepart.putClientProperty("fieldName", "departureTime");
		tfHeureDepart.setDocument(new PlainDocument());
		fields.add(tfHeureDepart);

		tfDuree = new JTextField(10);
		tfDuree.putClientProperty("fieldName", "flightDuration");
		tfDuree.setDocument(new PlainDocument());
		fields.add(tfDuree);

		tfNbFC = new JTextField(10);
		tfNbFC.putClientProperty("fieldName", "nbFirstClassSits");
		tfNbFC.setDocument(new PlainDocument());
		fields.add(tfNbFC);

		tfPrixFC = new JTextField(10);
		tfPrixFC.putClientProperty("fieldName", "priceFirstClassSits");
		tfPrixFC.setDocument(new PlainDocument());
		fields.add(tfPrixFC);

		tfNbSC = new JTextField(10);
		tfNbSC.putClientProperty("fieldName", "nbSecondClassSits");
		tfNbSC.setDocument(new PlainDocument());
		fields.add(tfNbSC);

		tfPrixSC = new JTextField(10);
		tfPrixSC.putClientProperty("fieldName", "priceSecondClassSits");
		tfPrixSC.setDocument(new PlainDocument());
		fields.add(tfPrixSC);

		tfDelai = new JTextField(10);
		tfDelai.putClientProperty("fieldName", "nbDayCancelling");
		tfDelai.setDocument(new PlainDocument());
		fields.add(tfDelai);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(40, 40, 0, 160);
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Ajout Vol
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(40, 40, 0, 40);

		gbc2.insets = new Insets(0, 0, 0, 0);
		gbc2.gridx = 0;
		gbc2.gridy = 0;

		labelAjout.setFont(new Font("Serif", Font.BOLD, 18));
		panelAjoutVol.add(labelAjout, gbc2);

		// Liste labels ajout
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.gridy++;
		gbc2.insets = new Insets(40, 0, 0, 0);

		panelAjoutVol.add(labelNumVol, gbc2);
		gbc2.insets = new Insets(10, 0, 0, 0);
		gbc2.gridy++;

		panelAjoutVol.add(labelVilleDep, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(labelVilleDest, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(labelJourDepart, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(labelHeureDepart, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(labelDuree, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(labelNbFC, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(labelPrixFC, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(labelNbSC, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(labelPrixSC, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(labelDelai, gbc2);
		gbc2.gridy++;

		// Liste textField ajout
		gbc2.gridx = 1;
		gbc2.gridy = 1;
		gbc2.anchor = GridBagConstraints.LINE_START;
		gbc2.insets = new Insets(40, 20, 0, 0);

		panelAjoutVol.add(tfNumVol, gbc2);
		gbc2.insets = new Insets(10, 20, 0, 0);
		gbc2.gridy++;

		cityDepartureModel = new DefaultComboBoxModel<City>();
		comboBoxVillesDep = new JComboBox<City>(cityDepartureModel);
		comboBoxVillesDep.setPreferredSize(new Dimension(110, 20));
		comboBoxVillesDep.putClientProperty("fieldName", "departure");
		comboBoxes.add(comboBoxVillesDep);
		panelAjoutVol.add(comboBoxVillesDep, gbc2);
		gbc2.gridy++;

		cityArrivalModel = new DefaultComboBoxModel<City>();
		comboBoxVillesDest = new JComboBox<City>(cityArrivalModel);
		comboBoxVillesDest.setPreferredSize(new Dimension(110, 20));
		comboBoxVillesDest.putClientProperty("fieldName", "arrival");
		comboBoxes.add(comboBoxVillesDest);
		panelAjoutVol.add(comboBoxVillesDest, gbc2);
		gbc2.gridy++;

		listeJours = DayOfWeek.values();
		comboBoxJours = new JComboBox<DayOfWeek>(listeJours);
		comboBoxJours.setPreferredSize(new Dimension(110, 20));
		comboBoxJours.putClientProperty("fieldName", "dayOfWeekDeparture");
		panelAjoutVol.add(comboBoxJours, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(tfHeureDepart, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(tfDuree, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(tfNbFC, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(tfPrixFC, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(tfNbSC, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(tfPrixSC, gbc2);
		gbc2.gridy++;

		panelAjoutVol.add(tfDelai, gbc2);
		gbc2.gridy++;

		gbc2.gridy++;
		gbc2.gridx = 0;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnCreate.setPreferredSize(new Dimension(80, 20));
		panelAjoutVol.add(btnCreate, gbc2);

		gbc2.gridx++;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnAnnuler.setPreferredSize(new Dimension(80, 20));
		panelAjoutVol.add(btnAnnuler, gbc2);

		add(panelAjoutVol, gbc);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#populate()
	 */
	@Override
	protected void populate() {
		CityJob j = new CityJob();
		cityList = j.getAll();

		for (City c : cityList) {
			cityDepartureModel.addElement(c);
			cityArrivalModel.addElement(c);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ihm.AbstractNewDatabaseItemWindow#addSpecificValues(java.util.HashMap)
	 */
	@Override
	protected void addSpecificValues(HashMap<String, Object> fieldMaps) {
		super.addSpecificValues(fieldMaps);
		DayOfWeek d = (DayOfWeek) comboBoxJours.getSelectedItem();
		fieldMaps.put((String) comboBoxJours.getClientProperty("fieldName"), d);
	}

}
