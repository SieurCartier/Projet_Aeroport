package ihm;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import domain.DatabaseItem;
import job.IJob;

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
 */
public abstract class AbstractNewDatabaseItemWindow<D extends DatabaseItem> extends AbstractWindow<D>
		implements ActionListener {

	private static final long serialVersionUID = 1L;

	protected JButton btnCreate = new JButton("Créer");
	protected JButton btnAnnuler = new JButton("Annuler");

	protected List<JTextComponent> fields = new LinkedList<JTextComponent>();
	protected List<JComboBox<? extends DatabaseItem>> comboBoxes = new LinkedList<JComboBox<? extends DatabaseItem>>();

	protected boolean editing = false;

	protected D object = null;

	public AbstractNewDatabaseItemWindow() {
		super();
		btnCreate.addActionListener(this);
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		build();
		pack();
	}

	public AbstractNewDatabaseItemWindow(D d) {
		super();
		btnCreate.addActionListener(this);
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		build();
		pack();
		editing = true;
		object = d;
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
			DatabaseItem item = null;

			HashMap<String, Object> fieldMaps = new HashMap<String, Object>();
			for (JTextComponent field : fields) {
				Document doc = field.getDocument();
				try {
					fieldMaps.put((String) field.getClientProperty("fieldName"), doc.getText(0, doc.getLength()));
				} catch (BadLocationException e) {
					System.out.println("Should never happen");
				}
			}
			for (JComboBox<? extends DatabaseItem> c : comboBoxes) {
				DatabaseItem d = (DatabaseItem) c.getSelectedItem();
				fieldMaps.put((String) c.getClientProperty("fieldName"), d);
			}

			addSpecificValues(fieldMaps);

			item = (editing) ? job.update(object, fieldMaps) : job.create(fieldMaps);

			String message = (item != null) ? item.toString() + " a bien été" + ((editing) ? " modifié" : " créé") + "."
					: "Erreur, veuillez remplir correctment les champs";

			JOptionPane.showMessageDialog(this, message);

			if (item != null) {
				for (JTextComponent field : fields) {
					field.setDocument(new PlainDocument());
				}
				if (editing) {
					editing = false;
					object = null;
					close();
				}
			}
		}
	}

	/**
	 * A method that allows subclasses to add specific values to the
	 * {@link HashMap} before it is sent to the {@link IJob}.
	 * 
	 * @param fieldMaps
	 *            The {@link HashMap} that will be sent to the {@link IJob}.
	 *            <code>Keys</code> are the {@link DatabaseItem} attributes
	 *            names. <code>Values</code> are their values.
	 */
	protected void addSpecificValues(HashMap<String, Object> fieldMaps) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#close()
	 */
	@Override
	public void close() {
		for (JTextComponent field : fields) {
			field.setDocument(new PlainDocument());
		}
		for (JComboBox<? extends DatabaseItem> c : comboBoxes) {
			c.removeAllItems();
		}
		super.close();
	}

}
