package ihm;

import java.awt.*;
import javax.swing.*;
import domain.*;
import job.HotelJob;

public class ConsultWindow extends AbstractWindow<Hotel> {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;

	// Panel villes
	private JPanel paneVilles;
	private JList<City> listeVilles;
	private JScrollPane scrollVilles;
	private DefaultListModel<City> modelVilles;
	private JButton btnModifVille;
	private JButton btnSuppVille;

	// Panel Hotel
	private JPanel paneHotels;
	private JList<Hotel> listeHotels;
	private JScrollPane scrollHotels;
	private DefaultListModel<Hotel> modelHotels;
	private JButton btnModifHotel;
	private JButton btnSuppHotel;

	// Panel Hotel
	private JPanel paneChambres;
	private JList<HotelRoom> listeChambres;
	private JScrollPane scrollChambres;
	private DefaultListModel<HotelRoom> modelChambres;
	private JButton btnModifChambre;
	private JButton btnSuppChambre;
	private JButton btnAjoutChambre;

	// Panel Hotel
	private JPanel paneCateg;
	private JList<Category> listeCateg;
	private JScrollPane scrollCateg;
	private DefaultListModel<Category> modelCateg;
	private JButton btnModifCateg;
	private JButton btnSuppCateg;

	// Panel Info Chambres
	private JPanel panInfoChambres;
	private JLabel labelNomChambre;
	private JLabel labelCategChambre;
	private JLabel labelPrixChambre;
	private JLabel setLabelNomChambre;
	private JLabel setLabelCategChambre;
	private JLabel setLabelPrixChambre;

	public ConsultWindow() {
		super();
		build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected HotelJob getJob() {
		return new HotelJob();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#build()
	 */
	@Override
	protected void build() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Consultation");
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc2.gridx = 0;
		gbc2.gridy = 0;

		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc2.weightx = 1;
		gbc2.weighty = 1;

		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(40, 80, 0, 160);

		// Definition paneVilles
		paneVilles = new JPanel(new GridBagLayout());
		modelVilles = new DefaultListModel<City>();
		listeVilles = new JList<City>(modelVilles);
		listeVilles.setFont(new Font("Serif", Font.ITALIC, 14));

		scrollVilles = new JScrollPane(listeVilles);
		scrollVilles.setBorder(BorderFactory.createTitledBorder("Liste des villes"));

		btnSuppVille = new JButton("Supprimer");
		btnModifVille = new JButton("Modifier");
		btnSuppVille.setPreferredSize(new Dimension(100, 20));
		btnModifVille.setPreferredSize(new Dimension(100, 20));

		paneVilles.add(scrollVilles, gbc2);
		gbc2.gridy = 2;
		paneVilles.add(btnModifVille, gbc2);
		gbc2.gridx++;
		paneVilles.add(btnSuppVille, gbc2);

		add(paneVilles, gbc);

		// Definition paneHotel
		paneHotels = new JPanel(new GridBagLayout());
		modelHotels = new DefaultListModel<Hotel>();
		listeHotels = new JList<Hotel>(modelHotels);
		listeHotels.setFont(new Font("Serif", Font.ITALIC, 14));

		scrollHotels = new JScrollPane(listeHotels);
		scrollHotels.setBorder(BorderFactory.createTitledBorder("Liste des Hotels"));

		btnSuppHotel = new JButton("Supprimer");
		btnModifHotel = new JButton("Modifier");
		btnSuppHotel.setPreferredSize(new Dimension(100, 20));
		btnModifHotel.setPreferredSize(new Dimension(100, 20));

		gbc2.gridx = 0;
		gbc2.gridy = 0;
		paneHotels.add(scrollHotels, gbc2);
		gbc2.gridy = 2;
		paneHotels.add(btnModifHotel, gbc2);
		gbc2.gridx++;
		paneVilles.add(btnSuppHotel, gbc2);

		gbc.gridx = 3;
		add(paneHotels, gbc);

		// Definition pane Categorie
		paneCateg = new JPanel(new GridBagLayout());
		modelCateg = new DefaultListModel<Category>();
		listeCateg = new JList<Category>(modelCateg);
		listeCateg.setFont(new Font("Serif", Font.ITALIC, 14));

		scrollCateg = new JScrollPane(listeHotels);
		scrollCateg.setBorder(BorderFactory.createTitledBorder("Liste des categories"));

		btnSuppCateg = new JButton("Supprimer");
		btnModifCateg = new JButton("Modifier");
		btnSuppCateg.setPreferredSize(new Dimension(100, 20));
		btnModifCateg.setPreferredSize(new Dimension(100, 20));

		gbc2.gridx = 0;
		gbc2.gridy = 0;
		paneCateg.add(scrollCateg, gbc2);
		gbc2.gridy = 2;
		paneCateg.add(btnModifCateg, gbc2);
		gbc2.gridx++;
		paneCateg.add(btnSuppCateg, gbc2);

		gbc.gridx = 6;
		add(paneCateg, gbc);

		// Definition paneChambres
		paneChambres = new JPanel(new GridBagLayout());
		modelChambres = new DefaultListModel<HotelRoom>();
		listeChambres = new JList<HotelRoom>(modelChambres);
		listeChambres.setFont(new Font("Serif", Font.ITALIC, 14));

		scrollChambres = new JScrollPane(listeChambres);
		scrollChambres.setBorder(BorderFactory.createTitledBorder("Liste des chambres"));

		btnAjoutChambre = new JButton("Ajouter");
		btnSuppChambre = new JButton("Supprimer");
		btnModifChambre = new JButton("Modifier");
		btnSuppChambre.setPreferredSize(new Dimension(100, 20));
		btnModifChambre.setPreferredSize(new Dimension(100, 20));
		btnAjoutChambre.setPreferredSize(new Dimension(100, 20));

		gbc2.gridx = 0;
		gbc2.gridy = 0;
		paneHotels.add(scrollChambres, gbc2);
		gbc2.gridy = 2;
		paneHotels.add(btnAjoutChambre, gbc2);
		gbc2.gridx++;
		paneVilles.add(btnModifChambre, gbc2);
		gbc2.gridx++;
		paneVilles.add(btnSuppChambre, gbc2);

		gbc.gridx = 9;
		add(paneChambres, gbc);

		// Definition paneChambres

		panInfoChambres = new JPanel(new GridBagLayout());
		panInfoChambres.setBorder(BorderFactory.createEtchedBorder());
		setLabelNomChambre = new JLabel("test");
		setLabelCategChambre = new JLabel("test");
		setLabelPrixChambre = new JLabel("test");
		labelNomChambre = new JLabel("Nom de la chambre :");
		labelCategChambre = new JLabel("Categorie de la chambre :");
		labelPrixChambre = new JLabel("Prix de la chambre  :");

		gbc2.gridx = 0;
		gbc2.gridy = 0;

		gbc2.insets = new Insets(10, 20, 0, 0);
		panInfoChambres.add(labelNomChambre, gbc2);
		gbc2.gridx++;
		panInfoChambres.add(setLabelNomChambre, gbc2);

		gbc2.gridy++;
		gbc2.gridx--;
		panInfoChambres.add(labelCategChambre, gbc2);
		gbc2.gridx++;
		panInfoChambres.add(setLabelCategChambre, gbc2);

		gbc2.gridy++;
		gbc2.gridx--;
		panInfoChambres.add(labelCategChambre, gbc2);
		gbc2.gridx++;
		panInfoChambres.add(setLabelCategChambre, gbc2);

		gbc2.gridy++;
		gbc2.gridx--;
		panInfoChambres.add(labelPrixChambre, gbc2);
		gbc2.gridx++;
		panInfoChambres.add(setLabelPrixChambre, gbc2);

		gbc.gridx = 12;
		add(panInfoChambres);
	}

}
