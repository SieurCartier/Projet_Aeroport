package ihm;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.PlainDocument;
import domain.*;
import job.*;

public class NewCustomerWindow extends AbstractNewDatabaseItemWindow<Customer> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;

	private JPanel panelAjoutClient;

	private JLabel labelAjout;
	private JLabel labelNomClient;
	private JLabel labelPrenomClient;
	private JLabel labelAgeClient;
	private JLabel labelVilleClient;

	private JTextField tfNom;
	private JTextField tfPrenom;
	private JTextField tfDateNaissance;

	private DefaultComboBoxModel<City> cityModel;
	private JComboBox<City> comboBoxVilles;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected CustomerJob getJob() {
		return new CustomerJob();
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

		panelAjoutClient = new JPanel(new GridBagLayout());

		labelAjout = new JLabel("Ajouter un client");
		labelNomClient = new JLabel("Nom : ");
		labelPrenomClient = new JLabel("Prenom : ");
		labelAgeClient = new JLabel("Date de naissance (dd/mm/yyy) : ");
		labelVilleClient = new JLabel("Ville :");

		tfNom = new JTextField(10);
		tfNom.putClientProperty("fieldName", "lastname");
		tfNom.setDocument(new PlainDocument());
		fields.add(tfNom);

		tfPrenom = new JTextField(10);
		tfPrenom.putClientProperty("fieldName", "firstname");
		tfPrenom.setDocument(new PlainDocument());
		fields.add(tfPrenom);

		tfDateNaissance = new JTextField(10);
		tfDateNaissance.putClientProperty("fieldName", "birthdate");
		tfDateNaissance.setDocument(new PlainDocument());
		fields.add(tfDateNaissance);

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

		// Ajout Client
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(40, 40, 0, 40);

		gbc2.insets = new Insets(0, 0, 0, 0);
		gbc2.gridx = 0;
		gbc2.gridy = 0;

		labelAjout.setFont(new Font("Serif", Font.BOLD, 18));
		panelAjoutClient.add(labelAjout, gbc2);

		// Liste labels ajout
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.gridy++;
		gbc2.insets = new Insets(40, 0, 0, 0);

		panelAjoutClient.add(labelNomClient, gbc2);
		gbc2.insets = new Insets(10, 0, 0, 0);
		gbc2.gridy++;

		panelAjoutClient.add(labelPrenomClient, gbc2);
		gbc2.gridy++;

		panelAjoutClient.add(labelAgeClient, gbc2);
		gbc2.gridy++;

		panelAjoutClient.add(labelVilleClient, gbc2);

		// Liste textField ajout
		gbc2.gridx = 1;
		gbc2.gridy = 1;
		gbc2.anchor = GridBagConstraints.LINE_START;
		gbc2.insets = new Insets(40, 20, 0, 0);

		panelAjoutClient.add(tfNom, gbc2);
		gbc2.insets = new Insets(10, 20, 0, 0);
		gbc2.gridy++;

		panelAjoutClient.add(tfPrenom, gbc2);
		gbc2.gridy++;

		panelAjoutClient.add(tfDateNaissance, gbc2);
		gbc2.gridy++;

		panelAjoutClient.add(comboBoxVilles, gbc2);

		gbc2.gridy++;
		gbc2.gridx = 0;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnCreate.setPreferredSize(new Dimension(80, 20));
		panelAjoutClient.add(btnCreate, gbc2);

		gbc2.gridx++;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(20, 0, 40, 0);
		btnAnnuler.setPreferredSize(new Dimension(80, 20));
		panelAjoutClient.add(btnAnnuler, gbc2);

		add(panelAjoutClient, gbc);
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
}
