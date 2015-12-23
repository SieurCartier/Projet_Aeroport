package IHM;

import java.awt.Window;
import javax.swing.*;
import domaine.DatabaseItem;
import metier.AbstractJob;

/**
 * This class is represents a generic Window parameterized by the
 * {@link AbstractJob} that will manage the {@link DatabaseItem} concerned in
 * this window.
 * 
 * @author Gaston Lemaire
 *
 * @param <J>
 *            The {@link AbstractJob}
 */
@SuppressWarnings("rawtypes")
public class AbstractWindow<J extends AbstractJob> extends JFrame {

	private static final long serialVersionUID = 1L;

	public AbstractWindow() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setType(Window.Type.UTILITY);
	}

}
