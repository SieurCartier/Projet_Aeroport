package ihm;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.PlainDocument;
import domain.City;
import domain.Hotel;
import fabrics.HotelFabric;
import job.AbstractJob;
import job.CityJob;
import job.HotelJob;

public class NewHotelWindow extends
		AbstractNewDatabaseItemWindow<Hotel, HotelJob> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;

	private JPanel panelAjoutHotel;

	private JLabel labelAjout;
	private JLabel labelNomHotel;
	private JLabel labelVille;
	private JLabel labelDelai;

	private JTextField tfNomHotel;

	private DefaultComboBoxModel<City> cityModel;
	private JComboBox<City> comboBoxVilles;

	private JTextField tfDelai;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected AbstractJob<Hotel, HotelFabric> getJob() {
		return new HotelJob();
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
		setTitle("Ajouter un hotel");
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();

		panelAjoutHotel = new JPanel(new GridBagLayout());

		labelAjout = new JLabel("Ajouter un Hotel");
		labelNomHotel = new JLabel("Nom de l'hotel");
		labelVille = new JLabel("Ville de l'hotel");
		labelDelai = new JLabel("Delai max avant annul.");

		tfNomHotel = new JTextField(10);
		tfNomHotel.putClientProperty("fieldName", "nomHotel");
		tfNomHotel.setDocument(new PlainDocument());
		fields.add(tfNomHotel);

		tfDelai = new JTextField(10);
		tfDelai.putClientProperty("fieldName", "delaiHotel");
		tfDelai.setDocument(new PlainDocument());
		fields.add(tfDelai);

		cityModel = new DefaultComboBoxModel<City>();
		comboBoxVilles = new JComboBox<City>(cityModel);
		comboBoxVilles.putClientProperty("fieldName", "city");
		comboBoxes.add(comboBoxVilles);

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

		labelAjout.setFont(new Font("Serif", Font.BOLD, 18));
		panelAjoutHotel.add(labelAjout, gbc2);

		// Liste labels ajout
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.gridy++;
		gbc2.insets = new Insets(40, 0, 0, 0);

		panelAjoutHotel.add(labelNomHotel, gbc2);
		gbc2.insets = new Insets(10, 0, 0, 0);
		gbc2.gridy++;

		panelAjoutHotel.add(labelVille, gbc2);
		gbc2.gridy++;

		panelAjoutHotel.add(labelDelai, gbc2);
		gbc2.gridy++;

		// Liste textField ajout
		gbc2.gridx = 1;
		gbc2.gridy = 1;
		gbc2.anchor = GridBagConstraints.LINE_START;
		gbc2.insets = new Insets(40, 20, 0, 0);

		panelAjoutHotel.add(tfNomHotel, gbc2);
		gbc2.insets = new Insets(10, 20, 0, 0);
		gbc2.gridy++;

		comboBoxVilles.setPreferredSize(new Dimension(110, 20));
		panelAjoutHotel.add(comboBoxVilles, gbc2);
		gbc2.gridy++;

		panelAjoutHotel.add(tfDelai, gbc2);
		gbc2.gridy++;

		gbc2.gridy++;
		gbc2.gridx = 0;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnCreate.setPreferredSize(new Dimension(80, 20));
		panelAjoutHotel.add(btnCreate, gbc2);

		gbc2.gridx++;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnAnnuler.setPreferredSize(new Dimension(80, 20));
		panelAjoutHotel.add(btnAnnuler, gbc2);

		add(panelAjoutHotel, gbc);

	}

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		populate();
	}

	private void populate() {
		CityJob j = new CityJob();
		for (City c : j.getAll()) {
			cityModel.addElement(c);
		}
	}

}
