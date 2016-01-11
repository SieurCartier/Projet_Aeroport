package ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import domain.Customer;
import job.*;

public class SearchCustomerWindow extends AbstractSearchWindow<Customer> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;

	private JPanel panLabels;

	private JLabel labelNom;
	private JLabel labelPrenom;
	private JLabel labelAge;
	private JLabel labelVille;
	private JLabel setLabelNom;
	private JLabel setLabelPrenom;
	private JLabel setLabelAge;
	private JLabel setLabelVille;

	private JPanel panelRecherche;

	private JLabel labelRecherche;
	private JTextField rechercheField;

	private JPanel panelChange;

	private JButton recherche;
	private JButton btnSupp;
	private JButton btnModif;

	public SearchCustomerWindow() {
		super();
	}

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
	 * @see ihm.AbstractWindow#build()
	 */
	@Override
	protected void build() {
		setSize(700, 350);

		setTitle("Rechercher un client");
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();

		panLabels = new JPanel(new GridBagLayout());

		labelNom = new JLabel("Nom : ");
		labelPrenom = new JLabel("Prenom : ");
		labelAge = new JLabel("Age : ");
		labelVille = new JLabel("Ville : ");
		setLabelNom = new JLabel();
		setLabelPrenom = new JLabel();
		setLabelAge = new JLabel();
		setLabelVille = new JLabel();

		panelRecherche = new JPanel(new GridBagLayout());

		labelRecherche = new JLabel("Rechercher un client :");
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
		scrollPane.setBorder(BorderFactory.createTitledBorder("Liste des clients"));
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

		labelNom.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelNom, gbc2);
		gbc2.gridy++;
		gbc2.insets = new Insets(10, 20, 0, 0);
		labelPrenom.setFont(new Font("Serif", Font.BOLD, 14));
		panLabels.add(labelPrenom, gbc2);
		labelAge.setFont(new Font("Serif", Font.BOLD, 14));
		gbc2.gridy++;
		panLabels.add(labelAge, gbc2);
		gbc2.gridy++;
		labelVille.setFont(new Font("Serif", Font.BOLD, 14));
		gbc2.insets = new Insets(10, 20, 20, 0);
		panLabels.add(labelVille, gbc2);

		gbc2.insets = new Insets(25, 0, 0, 80);
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		gbc2.anchor = GridBagConstraints.LINE_START;
		panLabels.add(setLabelNom, gbc2);
		gbc2.gridy++;
		gbc2.insets = new Insets(10, 0, 0, 120);
		panLabels.add(setLabelPrenom, gbc2);
		gbc2.gridy++;
		panLabels.add(setLabelAge, gbc2);
		gbc2.gridy++;
		gbc2.insets = new Insets(10, 0, 20, 80);
		panLabels.add(setLabelVille, gbc2);

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
		Customer selected = liste.getSelectedValue();
		if (selected != null)
			showDetails(selected);
	}

	/**
	 * A method that shows a {@link Customer}'s details in the {@link JLabel}s.
	 * 
	 * @param selectedValue
	 *            The selected {@link Customer} .
	 */
	private void showDetails(Customer selectedValue) {
		setLabelNom.setText(selectedValue.getLastname());
		setLabelPrenom.setText(selectedValue.getFirstname());
		setLabelAge.setText(String.valueOf(selectedValue.getAge()));
		setLabelVille.setText(String.valueOf(selectedValue.getCity()));
	}

	/**
	 * A method that resets the details' {@link JLabel}s'.
	 */
	private void resetDetails() {
		setLabelNom.setText("");
		setLabelPrenom.setText("");
		setLabelAge.setText("");
		setLabelVille.setText("");
	}

	/**
	 * A method called every time the user clicks on the {@link #btnModif}.
	 */
	protected void onEditClick() {
		// TODO Auto-generated method stub

	}

	/**
	 * A method called every time the user clicks on the {@link #btnSupp}.
	 */
	protected void onDeleteClick() {
		Customer c = liste.getSelectedValue();
		if (c != null) {

			int dialogButton = JOptionPane.YES_NO_OPTION;
			int choix = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer : " + c.toString() + " ?",
					"Attention", dialogButton);

			if (choix == 0) { // OUI
				job.remove(c);
				model.removeElement(c);
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
