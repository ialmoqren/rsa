import java.awt.Dimension;
import java.math.BigInteger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Sender extends javax.swing.JFrame {
	BigInteger e, n, m, message;

	public Sender() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		backButton = new javax.swing.JButton();

		eInputField = new javax.swing.JTextField();
		eLabel = new javax.swing.JLabel();

		nInputField = new javax.swing.JTextField();
		nLabel = new javax.swing.JLabel();

		mInputField = new javax.swing.JTextField();
		mLabel = new javax.swing.JLabel();

		encryptButton = new javax.swing.JButton();

		cOutputField = new javax.swing.JTextField();
		cLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Encryption");
		getContentPane().setLayout(null);

		jPanel1.setLayout(null);

		backButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dispose();
				JFrame frame = new MainMenu();
				frame.pack();
				frame.setResizable(false);
				Dimension d = new Dimension(410, 440);
				frame.setSize(d);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});

		encryptButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (eValueIsCorrect() && nValueIsCorrect() && mValueIsCorrect()) {
					try {
						// Here is the main logic

						cOutputField.setText(m.modPow(e, n) + "");

					} catch (NullPointerException e) {
						cOutputField.setText("");
						JOptionPane.showMessageDialog(null, "Please enter the values for all parametrs  ",
								"Empty fields are not accepted", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					cOutputField.setText("");
				}
			}
		});

		jPanel1.add(backButton);
		jPanel1.add(eLabel);
		jPanel1.add(nLabel);
		jPanel1.add(eInputField);
		jPanel1.add(nInputField);
		jPanel1.add(mLabel);
		jPanel1.add(mInputField);
		jPanel1.add(encryptButton);
		jPanel1.add(cLabel);
		jPanel1.add(cOutputField);

		eLabel.setBounds(40, 80, 132, 35);
		nLabel.setBounds(40, 120, 132, 35);
		mLabel.setBounds(40, 160, 132, 35);
		eInputField.setBounds(220, 80, 160, 35);
		nInputField.setBounds(220, 120, 160, 35);
		mInputField.setBounds(220, 160, 160, 35);

		cLabel.setBounds(150, 220, 152, 35);
		cOutputField.setBounds(90, 250, 230, 50);

		backButton.setBounds(30, 330, 100, 50);
		encryptButton.setBounds(280, 330, 100, 50);

		encryptButton.setFont(new java.awt.Font("Tahoma", 0, 12));

		eLabel.setText("Enter the value of e:");
		nLabel.setText("Enter the value of n:");
		mLabel.setText("Enter the plain text:");
		cLabel.setText("The cipher text");
		backButton.setText("Back");
		encryptButton.setText("Encrypt");

		cOutputField.setEditable(false);

		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, 11, 610, 390);
		pack();
	}

	private boolean eValueIsCorrect() {

		try {
			e = new BigInteger(eInputField.getText());

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter a numeric value of e ", "Non-numeric value of e",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Please enter the value e first", "Empty field",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean nValueIsCorrect() {

		try {
			n = new BigInteger(nInputField.getText());

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter a numeric value of n ", "Non-numeric value of n",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Please enter the value of n first", "Empty field",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean mValueIsCorrect() {

		try {
			// And here
			byte[] bytes = mInputField.getText().getBytes();

			m = new BigInteger(bytes);

			if (m.compareTo(n) == 1) { // --> Greater than
				JOptionPane.showMessageDialog(null, "The message should be less than n, please re-enter:",
						"Message is bigger than n", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Please enter a numeric value of plain text ",
					"Non-numeric value of plain text", JOptionPane.WARNING_MESSAGE);
			return false;
		} catch (NullPointerException e) {

			JOptionPane.showMessageDialog(null, "Please enter a value for plain text ", "Empty value of plain text  ",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

//	static BigInteger power(BigInteger m, BigInteger e, BigInteger n) {
//		// Initialize result
//		BigInteger res = new BigInteger("1");
//
//		// Update c if it is more
//		// than or equal to n
//		m = m.remainder(n);
//
//		while (e.compareTo(new BigInteger("0")) > 0) {
//			// If d is odd, multiply c
//			// with result
//			if (!e.mod(new BigInteger("2")).equals(BigInteger.ZERO)) // --> d is odd
//				res = (res.multiply(m)).remainder(n);
//
//			// d must be even now
//			// d = d / 2
//			e = e.shiftRight(1);
//			m = (m.multiply(m)).mod(n);
//		}
//		return res;
//	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Sender().setVisible(true);
			}
		});
	}

	// Variables declaration
	private javax.swing.JButton encryptButton;
	private javax.swing.JButton backButton;
	private javax.swing.JLabel cLabel;
	private javax.swing.JLabel eLabel;
	private javax.swing.JLabel nLabel;
	private javax.swing.JLabel mLabel;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField eInputField;
	private javax.swing.JTextField nInputField;
	private javax.swing.JTextField mInputField;
	private javax.swing.JTextField cOutputField;
}
