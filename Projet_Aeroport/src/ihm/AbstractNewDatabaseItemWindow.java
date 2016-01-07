package ihm;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import domain.DatabaseItem;
import job.AbstractJob;

/**
 * This class provides to the user a <code>Window</code> with a create and a
 * cancel button. Every time the create button is clicked, a pop-up is opened to
 * tell the result to the user. If the action is a success, every fields are
 * emptied.
 * 
 * @author Gaston Lemaire
 *
 * @param <D>
 *            The {@link DatabaseItem} that will be managed in this
 *            <code>Window</code>.
 * @param <J>
 *            The {@link AbstractJob} that will manage the {@link DatabaseItem}.
 */
public abstract class AbstractNewDatabaseItemWindow<D extends DatabaseItem, J extends AbstractJob<?, ?>>
		extends AbstractWindow<J> implements ActionListener {

	private static final long serialVersionUID = 1L;

	protected JButton btnCreate = new JButton("Créer");
	protected JButton btnAnnuler = new JButton("Annuler");

	protected List<JTextComponent> fields = new LinkedList<JTextComponent>();

	public AbstractNewDatabaseItemWindow() {
		super();
		btnCreate.addActionListener(this);
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		build();
		pack();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btnCreate) {
			HashMap<String, Object> fieldMaps = new HashMap<String, Object>();
			for (JTextComponent field : fields) {
				Document doc = field.getDocument();
				try {
					fieldMaps.put((String) field.getClientProperty("fieldName"), doc.getText(0, doc.getLength()));
				} catch (BadLocationException e) {
					System.out.println("Should never happen");
				}
			}

			DatabaseItem item = job.create(fieldMaps);

			String message = (item != null) ? item.toString() + " a bien été créé."
					: "Erreur, veuillez remplir correctment les champs";

			JOptionPane.showMessageDialog(this, message);

			if (item != null) {
				for (JTextComponent field : fields) {
					field.setDocument(new PlainDocument());
				}
			}
		}
	}

}
