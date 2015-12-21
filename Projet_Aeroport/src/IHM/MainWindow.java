package IHM;

import java.awt.event.*;
import javax.swing.*;

import domaine.Customer;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar = new JMenuBar();

	private JMenu clients = new JMenu();
	private JMenuItem rechercherClient = new JMenuItem();;
	private JMenuItem nouveauClient = new JMenuItem();;

	private JMenu vols = new JMenu();
	private JMenuItem rechercherVol = new JMenuItem();;
	private JMenuItem nouveauVol = new JMenuItem();;

	private JMenu hotels = new JMenu();
	private JMenuItem rechercherHotel = new JMenuItem();;
	private JMenuItem nouvelHotel = new JMenuItem();;

	private JMenu reservations = new JMenu();
	private JMenuItem rechercherReservation = new JMenuItem();;
	private JMenuItem nouvelleReservation = new JMenuItem();;

	private JMenu promotions = new JMenu();
	private JMenuItem gererPromos = new JMenuItem();;
	private JMenuItem nouvelPromo = new JMenuItem();;

	public MainWindow() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		clients.setText("Clients");

		rechercherClient.setText("Rechercher");
		rechercherClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rechercherClient(evt);
			}
		});
		clients.add(rechercherClient);

		nouveauClient.setText("Nouveau");
		clients.add(nouveauClient);

		menuBar.add(clients);

		reservations.setText("Réservations");

		rechercherReservation.setText("Rechercher");
		reservations.add(rechercherReservation);

		nouvelleReservation.setText("Nouvelle");
		reservations.add(nouvelleReservation);

		menuBar.add(reservations);

		vols.setText("Vols");

		rechercherVol.setText("Rechercher");
		vols.add(rechercherVol);

		nouveauVol.setText("Nouveau");
		vols.add(nouveauVol);

		menuBar.add(vols);

		hotels.setText("Hotels");

		rechercherHotel.setText("Rechercher");
		hotels.add(rechercherHotel);

		nouvelHotel.setText("Nouveau");
		hotels.add(nouvelHotel);

		menuBar.add(hotels);

		promotions.setText("Promotions");

		gererPromos.setText("Gérer");
		promotions.add(gererPromos);

		nouvelPromo.setText("Nouvelle");
		promotions.add(nouvelPromo);

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

	private void rechercherClient(ActionEvent evt) {
		SearchWindow<Customer> s = new SearchWindow<Customer>(null, null);
		s.setVisible(true);
	}
}
