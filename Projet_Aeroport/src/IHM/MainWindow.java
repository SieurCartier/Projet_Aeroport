package IHM;

import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.*;

public class MainWindow extends JFrame implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	private HashMap<Object, AbstractWindow> windowsMap = new HashMap<Object, AbstractWindow>();

	private JMenuBar menuBar = new JMenuBar();

	private JMenu clients = new JMenu();
	private JMenuItem rechercherClient = new JMenuItem();
	private JMenuItem nouveauClient = new JMenuItem();

	private JMenu vols = new JMenu();
	private JMenuItem rechercherVol = new JMenuItem();
	private JMenuItem nouveauVol = new JMenuItem();

	private JMenu hotels = new JMenu();
	private JMenuItem rechercherHotel = new JMenuItem();
	private JMenuItem nouvelHotel = new JMenuItem();

	private JMenu villes = new JMenu();
	private JMenuItem rechercherVille = new JMenuItem();
	private JMenuItem nouvelleVille = new JMenuItem();

	private JMenu reservations = new JMenu();
	private JMenuItem rechercherReservation = new JMenuItem();
	private JMenuItem nouvelleReservation = new JMenuItem();

	private JMenu promotions = new JMenu();
	private JMenuItem gererPromos = new JMenuItem();
	private JMenuItem nouvelPromo = new JMenuItem();

	public MainWindow() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		clients.setText("Clients");

		rechercherClient.setText("Rechercher");
		rechercherClient.addActionListener(this);
		clients.add(rechercherClient);
		windowsMap.put(rechercherClient, new SearchCustomerWindow());

		nouveauClient.setText("Nouveau");
		nouveauClient.addActionListener(this);
		clients.add(nouveauClient);
		windowsMap.put(nouveauClient, new NewCustomerWindow());

		menuBar.add(clients);

		reservations.setText("Réservations");

		rechercherReservation.setText("Rechercher");
		rechercherReservation.addActionListener(this);
		reservations.add(rechercherReservation);
		windowsMap.put(rechercherReservation, new SearchReservationWindow());

		nouvelleReservation.setText("Nouvelle");
		nouvelleReservation.addActionListener(this);
		reservations.add(nouvelleReservation);
		windowsMap.put(nouvelleReservation, new NewReservationWindow());

		menuBar.add(reservations);

		vols.setText("Vols");

		rechercherVol.setText("Rechercher");
		rechercherVol.addActionListener(this);
		vols.add(rechercherVol);
		windowsMap.put(rechercherVol, new SearchFlightWindow());

		nouveauVol.setText("Nouveau");
		nouveauVol.addActionListener(this);
		vols.add(nouveauVol);
		windowsMap.put(nouveauVol, new NewFlightWindow());

		menuBar.add(vols);

		hotels.setText("Hotels");

		rechercherHotel.setText("Rechercher");
		rechercherHotel.addActionListener(this);
		hotels.add(rechercherHotel);
		windowsMap.put(rechercherHotel, new SearchHotelWindow());

		nouvelHotel.setText("Nouveau");
		nouvelHotel.addActionListener(this);
		hotels.add(nouvelHotel);
		windowsMap.put(nouvelHotel, new NewHotelWindow());

		menuBar.add(hotels);

		villes.setText("Hotels");

		rechercherVille.setText("Rechercher");
		rechercherVille.addActionListener(this);
		villes.add(rechercherVille);
		windowsMap.put(rechercherVille, new SearchCityWindow());

		nouvelleVille.setText("Nouvelle");
		nouvelleVille.addActionListener(this);
		villes.add(nouvelleVille);
		windowsMap.put(nouvelleVille, new NewCityWindow());

		menuBar.add(villes);

		promotions.setText("Promotions");

		gererPromos.setText("Gérer");
		gererPromos.addActionListener(this);
		promotions.add(gererPromos);
		windowsMap.put(gererPromos, new ManageDiscountWindow());

		nouvelPromo.setText("Nouvelle");
		nouvelPromo.addActionListener(this);
		promotions.add(nouvelPromo);
		windowsMap.put(nouvelPromo, new NewDiscountWindow());

		menuBar.add(promotions);

		setJMenuBar(menuBar);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 278, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

		pack();
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractWindow window = windowsMap.get(e);
		window.setVisible(true);
	}

}
