import java.awt.Dimension;

import javax.swing.JFrame;

public class CipherProject {

	public static void main(String[] args) {
		JFrame frame = new MainMenu();
		frame.pack();
		frame.setResizable(false);
		Dimension d = new Dimension(410, 440);
		frame.setSize(d);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
