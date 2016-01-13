package ihm;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import domain.AbstractDiscount;
import domain.City;
import job.*;

public class NewDiscountWindow extends AbstractNewDatabaseItemWindow<AbstractDiscount> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;
	private GridBagConstraints gbc3;

	private JPanel panelAjoutPromo;
	private JPanel panePromoAge;
	private JPanel panePromoVille;

	private JLabel labelAjout;
	private JLabel labelNomPromo;
	private JLabel labelType;
	private JLabel labelValeur;
	private JLabel labelDebut;
	private JLabel labelFin;

	private JLabel labelAgeMini;
	private JLabel labelAgeMaxi;
	private JLabel labelVille;

	private JTextField tfNomPromo;
	private JTextField tfType;
	private JTextField tfDebut;
	private JTextField tfFin;
	private JTextField tfValeur;

	private JTextField tfAgeMini;
	private JTextField tfAgeMaxi;

	private JComboBox<String> comboBoxType;

	private DefaultComboBoxModel<City> cityModel;
	private JComboBox<City> comboBoxVilles;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected DiscountJob getJob() {
		return new DiscountJob();
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
		setTitle("Ajouter une promotion");
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();
		gbc3 = new GridBagConstraints();

		panelAjoutPromo = new JPanel(new GridBagLayout());
		panePromoAge = new JPanel(new GridBagLayout());
		panePromoVille = new JPanel(new GridBagLayout());

		labelAjout = new JLabel("Ajouter une promotion");
		labelNomPromo = new JLabel("Nom de la promo");
		labelDebut = new JLabel("Date de debut");
		labelFin = new JLabel("Date de Fin");
		labelType = new JLabel("Type de promotion");
		labelValeur = new JLabel("Valeur de la promotion");

		labelAgeMini = new JLabel("Age minimale");
		labelAgeMaxi = new JLabel("Age minimale");
		labelVille = new JLabel("Choix de la ville");

		cityModel = new DefaultComboBoxModel<City>();
		comboBoxVilles = new JComboBox<City>(cityModel);
		comboBoxVilles.putClientProperty("fieldName", "city");
		comboBoxes.add(comboBoxVilles);

		String[] listeType = { "Age", "Ville" };
		comboBoxType = new JComboBox<String>(listeType);
		comboBoxType.setPreferredSize(new Dimension(110, 20));
		comboBoxType.addActionListener(this);

		tfNomPromo = new JTextField(10);
		tfNomPromo.putClientProperty("fieldName", "name");
		tfNomPromo.setDocument(new PlainDocument());
		fields.add(tfNomPromo);

		tfDebut = new JTextField(10);
		tfDebut.putClientProperty("fieldName", "startDate");
		tfDebut.setDocument(new PlainDocument());
		fields.add(tfDebut);

		tfFin = new JTextField(10);
		tfFin.putClientProperty("fieldName", "endDate");
		tfFin.setDocument(new PlainDocument());
		fields.add(tfFin);

		tfType = new JTextField(10);
		tfType.setDocument(new PlainDocument());
		fields.add(tfType);

		tfValeur = new JTextField(10);
		tfValeur.putClientProperty("fieldName", "percentage");
		tfValeur.setDocument(new PlainDocument());
		fields.add(tfValeur);

		tfAgeMini = new JTextField(10);
		tfAgeMini.putClientProperty("fieldName", "AgeMiniPromo");
		tfAgeMini.setDocument(new PlainDocument());
		gbc2.insets = new Insets(10, 20, 0, 0);
		fields.add(tfAgeMini);

		tfAgeMaxi = new JTextField(10);
		tfAgeMaxi.putClientProperty("fieldName", "AgeMaxiPromo");
		tfAgeMaxi.setDocument(new PlainDocument());
		fields.add(tfAgeMaxi);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(40, 40, 0, 160);
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Ajout Hotel
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(40, 40, 0, 40);

		gbc2.insets = new Insets(0, 0, 0, 0);
		gbc2.gridx = 0;
		gbc2.gridy = 0;

		gbc3.insets = new Insets(0, 0, 0, 0);
		gbc3.gridx = 0;
		gbc3.gridy = 0;

		labelAjout.setFont(new Font("Serif", Font.BOLD, 18));
		panelAjoutPromo.add(labelAjout, gbc2);

		// Liste labels ajout
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.gridy = 1;
		gbc2.insets = new Insets(40, 0, 0, 0);

		panelAjoutPromo.add(labelNomPromo, gbc2);
		gbc2.insets = new Insets(10, 0, 0, 0);
		gbc2.gridy = 2;

		panelAjoutPromo.add(labelDebut, gbc2);
		gbc2.gridy = 3;

		panelAjoutPromo.add(labelFin, gbc2);
		gbc2.gridy = 4;

		panelAjoutPromo.add(labelValeur, gbc2);
		gbc2.gridy = 5;

		panelAjoutPromo.add(labelType, gbc2);
		gbc2.gridy = 6;

		// Liste textField ajout
		gbc2.gridx = 1;
		gbc2.gridy = 1;
		gbc2.anchor = GridBagConstraints.LINE_START;
		gbc2.insets = new Insets(40, 20, 0, 0);

		panelAjoutPromo.add(tfNomPromo, gbc2);
		gbc2.insets = new Insets(10, 20, 0, 0);
		gbc2.gridy = 2;

		panelAjoutPromo.add(tfDebut, gbc2);
		gbc2.gridy = 3;

		panelAjoutPromo.add(tfFin, gbc2);
		gbc2.gridy = 4;

		panelAjoutPromo.add(tfValeur, gbc2);
		gbc2.gridy = 5;

		panelAjoutPromo.add(comboBoxType, gbc2);
		gbc2.gridy = 6;

		// Dans le cas ou type = Age.

		gbc3.insets = new Insets(10, 20, 0, 0);
		panePromoAge.add(labelAgeMini, gbc3);
		gbc3.gridy = 1;
		panePromoAge.add(labelAgeMaxi, gbc3);

		gbc3.gridx = 1;
		gbc3.gridy = 0;
		gbc3.insets = new Insets(10, 40, 0, 0);
		panePromoAge.add(tfAgeMini, gbc3);
		gbc3.gridy = 1;
		panePromoAge.add(tfAgeMaxi, gbc3);

		gbc2.insets = new Insets(0, -115, 0, 0);
		panelAjoutPromo.add(panePromoAge, gbc2);
		panePromoAge.setVisible(true);

		// Dans le cas type Ville
		gbc3.gridx = 0;
		gbc3.gridy = 0;
		gbc3.insets = new Insets(10, 20, 0, 0);
		panePromoVille.add(labelVille, gbc3);
		gbc3.insets = new Insets(10, 30, 0, 0);
		gbc3.gridx = 1;
		panePromoVille.add(comboBoxVilles, gbc3);

		gbc2.insets = new Insets(0, -115, 0, 0);
		panelAjoutPromo.add(panePromoVille, gbc2);
		panePromoVille.setVisible(false);

		gbc2.gridy++;
		gbc2.gridx = 0;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnCreate.setPreferredSize(new Dimension(80, 20));
		panelAjoutPromo.add(btnCreate, gbc2);

		gbc2.gridx++;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnAnnuler.setPreferredSize(new Dimension(80, 20));
		panelAjoutPromo.add(btnAnnuler, gbc2);

		add(panelAjoutPromo, gbc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#populate()
	 */
	@Override
	protected void populate() {
		CityJob j = new CityJob();
		for (City c : j.getAll()) {
			cityModel.addElement(c);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractNewDatabaseItemWindow#actionPerformed(java.awt.event.
	 * ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == comboBoxType) {
			String selected = (String) comboBoxType.getSelectedItem();
			if (selected != null)
				showDiscountPanel(selected);
		}
	}

	/**
	 * 
	 * @param selected
	 */
	private void showDiscountPanel(String selected) {
		panePromoAge.setVisible(false);
		panePromoVille.setVisible(false);

		if (selected.equals("Age")) {
			panePromoAge.setVisible(true);
			panePromoVille.setVisible(false);
		} else {
			panePromoAge.setVisible(false);
			panePromoVille.setVisible(true);
		}

	}

}
