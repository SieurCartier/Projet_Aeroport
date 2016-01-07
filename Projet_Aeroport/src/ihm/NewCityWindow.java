package ihm;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.PlainDocument;

import domain.City;
import fabrics.CityFabric;
import job.*;

public class NewCityWindow extends AbstractNewDatabaseItemWindow<City, CityJob> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;

	private JPanel panelAjoutVille;

	private JLabel labelAjout;
	private JLabel labelNomVille;

	JTextField name;

	public NewCityWindow() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected AbstractJob<City, CityFabric> getJob() {
		return new CityJob();
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
		setTitle("Ajouter un client");
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();

		panelAjoutVille = new JPanel(new GridBagLayout());

		labelAjout = new JLabel("Ajouter une Ville");
		labelNomVille = new JLabel("Nom de la ville");

		name = new JTextField(10);
		name.putClientProperty("fieldName", "name");
		name.setDocument(new PlainDocument());
		fields.add(name);

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
		panelAjoutVille.add(labelAjout, gbc2);

		// Liste labels ajout
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.gridy++;
		gbc2.insets = new Insets(40, 0, 0, 0);

		panelAjoutVille.add(labelNomVille, gbc2);
		gbc2.insets = new Insets(10, 0, 0, 0);
		gbc2.gridy++;

		// Liste textField ajout
		gbc2.gridx = 1;
		gbc2.gridy = 1;
		gbc2.anchor = GridBagConstraints.LINE_START;
		gbc2.insets = new Insets(40, 20, 0, 0);

		panelAjoutVille.add(name, gbc2);
		gbc2.insets = new Insets(10, 20, 0, 0);
		gbc2.gridy++;

		gbc2.gridy++;
		gbc2.gridx = 0;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnCreate.setPreferredSize(new Dimension(80, 20));
		panelAjoutVille.add(btnCreate, gbc2);

		gbc2.gridx++;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnAnnuler.setPreferredSize(new Dimension(80, 20));
		panelAjoutVille.add(btnAnnuler, gbc2);

		add(panelAjoutVille, gbc);

	}

}
