package ihm;

import java.awt.Window;
import javax.swing.*;

import domain.DatabaseItem;
import job.AbstractJob;

/**
 * This class represents a generic <code>Window</code> parameterized by the
 * {@link AbstractJob} that will manage the {@link DatabaseItem} concerned in
 * this <code>Window</code>.
 * 
 * @author Gaston Lemaire
 * 
 * @param <J>
 *            The {@link AbstractJob} that will manage the {@link DatabaseItem}.
 */
public abstract class AbstractWindow<J extends AbstractJob<?, ?>> extends
		JFrame {

	private static final long serialVersionUID = 1L;

	protected AbstractJob<?, ?> job;

	public AbstractWindow() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setType(Window.Type.UTILITY);
		job = getJob();
	}

	/**
	 * This method is called by {@link #AbstractWindow()}. It is used to get an
	 * instance of the job that will manage the {@link DatabaseItem}.
	 * 
	 * @return The {@link AbstractJob} that will manage the {@link DatabaseItem}
	 *         .
	 */
	protected abstract AbstractJob<?, ?> getJob();

	/**
	 * This method is called in the {@link AbstractWindow#AbstractWindow()}. It
	 * is used to set up every components of the window.
	 */
	protected abstract void build();

}
