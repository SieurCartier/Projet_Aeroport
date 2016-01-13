package ihm;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.PlainDocument;

import domain.Category;
import domain.Hotel;
import job.CategoryJob;
import job.HotelJob;

public class NewCategoryWindow extends AbstractNewDatabaseItemWindow<Category> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;

	private JLabel labelAjout;
	private JLabel labelNomCateg;
	private JLabel labelCapacite;
	private JLabel labelPrix;
	private JLabel labelHotel;

	private JTextField tfNom;
	private JTextField tfCapacite;
	private JTextField tfPrix;

	private JPanel panelAjoutCateg;

	private DefaultComboBoxModel<Hotel> hotelModel;
	private JComboBox<Hotel> comboBoxHotels;

	@Override
	protected CategoryJob getJob() {
		return new CategoryJob();
	}

	@Override
	protected void build() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Ajouter une categorie");
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();

		panelAjoutCateg = new JPanel(new GridBagLayout());

		labelAjout = new JLabel("Ajouter une categorie");
		labelNomCateg = new JLabel("Nom de la categorie : ");
		labelCapacite = new JLabel("Capacite : ");
		labelPrix = new JLabel("Prix : ");
		labelHotel = new JLabel("Hotel d'appartenance : ");

		tfNom = new JTextField(10);
		tfNom.putClientProperty("fieldName", "name");
		tfNom.setDocument(new PlainDocument());
		fields.add(tfNom);

		tfCapacite = new JTextField(10);
		tfCapacite.putClientProperty("fieldName", "capacity");
		tfCapacite.setDocument(new PlainDocument());
		fields.add(tfCapacite);

		tfPrix = new JTextField(10);
		tfPrix.putClientProperty("fieldName", "price");
		tfPrix.setDocument(new PlainDocument());
		fields.add(tfPrix);

		hotelModel = new DefaultComboBoxModel<Hotel>();
		comboBoxHotels = new JComboBox<Hotel>(hotelModel);
		comboBoxHotels.putClientProperty("fieldName", "ownerHotel");
		comboBoxes.add(comboBoxHotels);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(40, 40, 0, 160);
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Ajout Client
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(40, 40, 0, 40);

		gbc2.insets = new Insets(0, 0, 0, 0);
		gbc2.gridx = 0;
		gbc2.gridy = 0;

		labelAjout.setFont(new Font("Serif", Font.BOLD, 18));
		panelAjoutCateg.add(labelAjout, gbc2);

		// Liste labels ajout
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.gridy++;
		gbc2.insets = new Insets(40, 0, 0, 0);

		panelAjoutCateg.add(labelNomCateg, gbc2);
		gbc2.insets = new Insets(10, 0, 0, 0);
		gbc2.gridy++;

		panelAjoutCateg.add(labelHotel, gbc2);
		gbc2.gridy++;

		panelAjoutCateg.add(labelCapacite, gbc2);
		gbc2.gridy++;

		panelAjoutCateg.add(labelPrix, gbc2);

		// Liste textField ajout
		gbc2.gridx = 1;
		gbc2.gridy = 1;
		gbc2.anchor = GridBagConstraints.LINE_START;
		gbc2.insets = new Insets(40, 20, 0, 0);

		panelAjoutCateg.add(tfNom, gbc2);
		gbc2.insets = new Insets(10, 20, 0, 0);
		gbc2.gridy++;

		panelAjoutCateg.add(comboBoxHotels, gbc2);
		gbc2.gridy++;

		panelAjoutCateg.add(tfCapacite, gbc2);
		gbc2.gridy++;

		panelAjoutCateg.add(tfPrix, gbc2);

		gbc2.gridy++;
		gbc2.gridx = 0;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnCreate.setPreferredSize(new Dimension(80, 20));
		panelAjoutCateg.add(btnCreate, gbc2);

		gbc2.gridx++;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnAnnuler.setPreferredSize(new Dimension(80, 20));
		panelAjoutCateg.add(btnAnnuler, gbc2);

		add(panelAjoutCateg, gbc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#populate()
	 */
	@Override
	protected void populate() {
		HotelJob i = new HotelJob();
		for (Hotel h : i.getAll()) {
			hotelModel.addElement(h);
		}
	}

}
