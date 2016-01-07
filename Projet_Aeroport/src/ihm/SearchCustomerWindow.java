package ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import domain.Customer;
import fabrics.CustomerFabric;
import job.AbstractJob;
import job.CustomerJob;

public class SearchCustomerWindow extends AbstractWindow<CustomerJob> implements ActionListener {

	private static final long serialVersionUID = 1L;

	public SearchCustomerWindow() {
		super();
		build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected AbstractJob<Customer, CustomerFabric> getJob() {
		return new CustomerJob();
	}

	@Override
	protected void build() {
		setSize(600, 400);
		setLocationRelativeTo(null);
		setTitle("Rechercher un client");
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints gbc2 = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(40, 40, 0, 160);
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		/*
		 * DefaultListModel<Customer> model = new DefaultListModel<Customer>();
		 * JList<Customer> listeClients = new JList<Customer>(model);
		 */
		DefaultListModel<String> model = new DefaultListModel<String>();
		model.addElement("one");
		model.addElement("two");
		model.addElement("three");
		JList<String> listeClients = new JList<String>(model);
		listeClients.setFont(new Font("Serif", Font.ITALIC, 14));
		listeClients.setBorder(BorderFactory.createTitledBorder("Liste des clients"));
		add(listeClients, gbc);

		// Panneau Label
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		gbc.gridx = 2;

		JPanel panLabels = new JPanel(new GridBagLayout());

		gbc2.gridx = 0;
		gbc2.gridy = 0;
		gbc2.weightx = 1;
		gbc2.weighty = 1;
		gbc2.anchor = GridBagConstraints.LINE_END;
		gbc2.insets = new Insets(10, 0, 0, 0);

		JLabel labelNom = new JLabel("nom :   ");
		labelNom.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelNom, gbc2);
		gbc2.gridy++;
		JLabel labelPrenom = new JLabel("prenom :   ");
		labelPrenom.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelPrenom, gbc2);
		JLabel labelAge = new JLabel("age :   ");
		labelAge.setFont(new Font("Serif", Font.BOLD, 14));
		gbc2.gridy++;
		panLabels.add(labelAge, gbc2);
		gbc2.gridy++;
		JLabel labelVille = new JLabel("ville :   ");
		labelVille.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelVille, gbc2);

		gbc2.gridx = 1;
		gbc2.gridy = 0;
		gbc2.anchor = GridBagConstraints.LINE_START;
		JLabel setLabelNom = new JLabel("test");
		panLabels.add(setLabelNom, gbc2);
		gbc2.gridy++;
		JLabel setLabelPrenom = new JLabel();
		panLabels.add(setLabelPrenom, gbc2);
		JLabel setLabelAge = new JLabel();
		gbc2.gridy++;
		panLabels.add(setLabelAge, gbc2);
		gbc2.gridy++;
		JLabel setLabelVille = new JLabel("test");
		panLabels.add(setLabelVille, gbc2);

		gbc.insets = new Insets(40, 0, 0, 0);
		add(panLabels, gbc);

		// Panneau recherche
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 10, 0, 0);
		JPanel panelRecherche = new JPanel(new GridBagLayout());

		gbc2.insets = new Insets(0, 0, 0, 0);
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		JLabel labelRecherche = new JLabel("Rechercher un client");
		panelRecherche.add(labelRecherche, gbc2);

		gbc2.gridx = 1;
		gbc2.insets = new Insets(0, 40, 0, 0);
		JTextField rechercheField = new JTextField(10);
		panelRecherche.add(rechercheField, gbc2);

		gbc2.gridy = 1;
		gbc2.insets = new Insets(20, 40, 0, 0);
		JButton recherche = new JButton("valider");
		panelRecherche.add(recherche, gbc2);

		add(panelRecherche, gbc);

		// Panel suppression/modification
		JPanel panelChange = new JPanel(new GridBagLayout());
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc2.insets = new Insets(10, 0, 0, 0);
		gbc.insets = new Insets(-15, 0, 0, 0);
		JButton btnSupp = new JButton("Supprimer");

		btnSupp.addActionListener(this);
		JButton btnModif = new JButton("Modifier");
		btnModif.addActionListener(this);
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		panelChange.add(btnModif, gbc2);
		gbc2.gridy++;
		panelChange.add(btnSupp, gbc2);

		add(panelChange, gbc);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
