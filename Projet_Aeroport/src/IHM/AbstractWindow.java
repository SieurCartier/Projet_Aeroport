package IHM;

import java.awt.Window;
import javax.swing.*;

import metier.AbstractJob;

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
