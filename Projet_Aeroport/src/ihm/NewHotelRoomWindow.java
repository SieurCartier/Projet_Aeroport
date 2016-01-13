package ihm;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.PlainDocument;

import domain.*;
import job.CategoryJob;
import job.HotelJob;
import job.HotelRoomJob;

public class NewHotelRoomWindow extends AbstractNewDatabaseItemWindow<HotelRoom> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;

	private JLabel labelAjout;
	private JLabel labelNumero;
	private JLabel labelHotel;
	private JLabel labelCategorie;

	private JTextField tfNumero;

	private JPanel panelAjoutRoom;

	private DefaultComboBoxModel<Hotel> hotelModel;
	private JComboBox<Hotel> comboBoxHotels;

	private DefaultComboBoxModel<Category> categoryModel;
	private JComboBox<Category> comboBoxCategories;

	@Override
	protected HotelRoomJob getJob() {
		return new HotelRoomJob();
	}

	@Override
	protected void build() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Ajouter une chambre");
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();

		panelAjoutRoom = new JPanel(new GridBagLayout());

		labelAjout = new JLabel("Ajouter une chambre");
		labelNumero = new JLabel("Numero de la chambre: ");
		labelHotel = new JLabel("Hotel d'appartenance: ");
		labelCategorie = new JLabel("Categorie de la chambre: ");

		tfNumero = new JTextField(10);
		tfNumero.putClientProperty("fieldName", "roomNumber");
		tfNumero.setDocument(new PlainDocument());
		fields.add(tfNumero);

		hotelModel = new DefaultComboBoxModel<Hotel>();
		comboBoxHotels = new JComboBox<Hotel>(hotelModel);
		comboBoxHotels.putClientProperty("fieldName", "ownerHotel");
		comboBoxes.add(comboBoxHotels);

		categoryModel = new DefaultComboBoxModel<Category>();
		comboBoxCategories = new JComboBox<Category>(categoryModel);
		comboBoxCategories.putClientProperty("fieldName", "category");
		comboBoxes.add(comboBoxCategories);

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
		panelAjoutRoom.add(labelAjout, gbc2);

		// Liste labels ajout
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.gridy++;
		gbc2.insets = new Insets(40, 0, 0, 0);

		panelAjoutRoom.add(labelNumero, gbc2);
		gbc2.insets = new Insets(10, 0, 0, 0);
		gbc2.gridy++;

		panelAjoutRoom.add(labelHotel, gbc2);
		gbc2.gridy++;

		panelAjoutRoom.add(labelCategorie, gbc2);
		gbc2.gridy++;

		// Liste textField ajout
		gbc2.gridx = 1;
		gbc2.gridy = 1;
		gbc2.anchor = GridBagConstraints.LINE_START;
		gbc2.insets = new Insets(40, 20, 0, 0);

		panelAjoutRoom.add(tfNumero, gbc2);
		gbc2.insets = new Insets(10, 20, 0, 0);
		gbc2.gridy++;

		panelAjoutRoom.add(comboBoxHotels, gbc2);
		gbc2.gridy++;

		panelAjoutRoom.add(comboBoxCategories, gbc2);
		gbc2.gridy++;

		gbc2.gridy++;
		gbc2.gridx = 0;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnCreate.setPreferredSize(new Dimension(80, 20));
		panelAjoutRoom.add(btnCreate, gbc2);

		gbc2.gridx++;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnAnnuler.setPreferredSize(new Dimension(80, 20));
		panelAjoutRoom.add(btnAnnuler, gbc2);

		add(panelAjoutRoom, gbc);
	}

	@Override
	protected void populate() {
		CategoryJob j = new CategoryJob();
		for (Category c : j.getAll()) {
			categoryModel.addElement(c);
		}

		HotelJob i = new HotelJob();
		for (Hotel h : i.getAll()) {
			hotelModel.addElement(h);
		}
	}

}
