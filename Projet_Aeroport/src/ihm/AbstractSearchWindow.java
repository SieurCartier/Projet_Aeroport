package ihm;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import domain.DatabaseItem;

public abstract class AbstractSearchWindow<D extends DatabaseItem> extends AbstractWindow<D>
		implements ListSelectionListener {

	private static final long serialVersionUID = 1L;

	protected DefaultListModel<D> model;
	protected JList<D> liste;
	protected JScrollPane scrollPane;

	public AbstractSearchWindow() {
		super();
		setLocationRelativeTo(null);
		model = new DefaultListModel<D>();
		liste = new JList<D>(model);
		liste.addListSelectionListener(this);
		scrollPane = new JScrollPane(liste);
		build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#populate()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void populate() {
		for (DatabaseItem c : job.getAll()) {
			model.addElement((D) c);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#close()
	 */
	@Override
	public void close() {
		model.removeAllElements();
		super.close();
	}
}
