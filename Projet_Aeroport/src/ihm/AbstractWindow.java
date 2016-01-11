package ihm;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import domain.DatabaseItem;
import job.*;

/**
 * This class represents a generic <code>Window</code> parameterized by the
 * {@link DatabaseItem} concerned in this <code>Window</code>.
 * 
 * @author Gaston Lemaire
 * 
 * @param <D>
 *            The {@link DatabaseItem} that will be managed .
 */
public abstract class AbstractWindow<D extends DatabaseItem> extends JFrame {

	private static final long serialVersionUID = 1L;

	protected IJob<D> job;

	public AbstractWindow() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setType(Window.Type.UTILITY);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		job = getJob();
	}

	/**
	 * This method is called by {@link #AbstractWindow()}. It is used to get an
	 * instance of the job that will manage the {@link DatabaseItem}.
	 * 
	 * @return The {@link AbstractJob} that will manage the {@link DatabaseItem}
	 *         .
	 */
	protected abstract IJob<D> getJob();

	/**
	 * This method is called in the {@link AbstractWindow#AbstractWindow()}. It
	 * is used to set up every components of the window.
	 */
	protected abstract void build();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Window#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		populate();
	}

	/**
	 * A method that will populate every existing {@link JComboBox} or
	 * {@link JList} when the window is set to visible (
	 * {@link #setVisible(boolean)}).
	 */
	protected void populate() {

	}

	/**
	 * A method called when the user closes the window.
	 */
	public void close() {
		dispose();
	}

}
