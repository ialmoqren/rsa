import java.awt.Dimension;
import java.math.BigInteger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Receiver extends javax.swing.JFrame {
	BigInteger p, q, n, Qn, d, c;

	public Receiver() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		backButton = new javax.swing.JButton();

		dInputField = new javax.swing.JTextField();
		dLabel = new javax.swing.JLabel();

		nInputField = new javax.swing.JTextField();
		nLabel = new javax.swing.JLabel();

		cInputField = new javax.swing.JTextField();
		cLabel = new javax.swing.JLabel();

		decryptButton = new javax.swing.JButton();

		mOutputField = new javax.swing.JTextField();
		mLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Decryption");
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

		decryptButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (nValueIsCorrect() && dValueIsCorrect() && cValueIsCorrect()) {

					try {
						// Here is the main logic

						BigInteger m = c.modPow(d, n);
						String plainText = new String(m.toByteArray());

						mOutputField.setText(plainText);

					} catch (NullPointerException e) {
						mOutputField.setText("");
						JOptionPane.showMessageDialog(null, "Please enter the values for all parametrs  ",
								"Empty fields are not accepted", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					mOutputField.setText("");
				}
			}
		});

		jPanel1.add(backButton);
		jPanel1.add(dLabel);
		jPanel1.add(nLabel);
		jPanel1.add(dInputField);
		jPanel1.add(nInputField);
		jPanel1.add(cLabel);
		jPanel1.add(cInputField);
		jPanel1.add(decryptButton);
		jPanel1.add(mLabel);
		jPanel1.add(mOutputField);

		dLabel.setBounds(40, 80, 132, 35);
		nLabel.setBounds(40, 120, 132, 35);
		cLabel.setBounds(40, 160, 132, 35);
		dInputField.setBounds(220, 80, 160, 35);
		nInputField.setBounds(220, 120, 160, 35);
		cInputField.setBounds(220, 160, 160, 35);

		mLabel.setBounds(150, 220, 152, 35);
		mOutputField.setBounds(90, 250, 230, 50);

		backButton.setBounds(30, 330, 100, 50);
		decryptButton.setBounds(280, 330, 100, 50);

		decryptButton.setFont(new java.awt.Font("Tahoma", 0, 12));

		dLabel.setText("Enter the value of d:");
		nLabel.setText("Enter the value of n:");
		cLabel.setText("Enter the cipher text:");
		mLabel.setText("The plain text");
		backButton.setText("Back");
		decryptButton.setText("Decrypt");

		mOutputField.setEditable(false);

		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, 11, 610, 390);
		pack();
	}

	private boolean dValueIsCorrect() {

		try {
			d = new BigInteger(dInputField.getText());

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter a numeric value of d ", "Non-numeric value of d",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Please enter the value d first", "Empty field",
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

	private boolean cValueIsCorrect() {

		try {
			c = new BigInteger(cInputField.getText());
			if (c.compareTo(n) == 1) {
				JOptionPane.showMessageDialog(null, "Cipher text should be less than n, please re-enter:",
						"encrypted message is bigger than n", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Please enter a numeric value of cipher text ",
					"Non-numeric value of plain text", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

//	static BigInteger power(BigInteger c, BigInteger d, BigInteger n) {
//		// Initialize result
//		BigInteger res = new Bit);
//
//		// Update c if it is more
//		// than or equal to n
//		c = c.remainder(n);
//
//		while (d.compareTo(new BigInteger("0")) > 0) {
//			// If d is odd, multiply c
//			// with result
//			if (!d.mod(new BigInteger("2")).equals(BigInteger.ZERO)) // --> d is odd
//				res = (res.multiply(c)).remainder(n);
//
//			// d must be even now
//			// d = d / 2
//			d = d.shiftRight(1);
//			c = (c.multiply(c)).mod(n);
//		}
//		return res;
//	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Receiver().setVisible(true);
			}
		});
	}

	// Variables declaration
	private javax.swing.JButton decryptButton;
	private javax.swing.JButton backButton;
	private javax.swing.JLabel nLabel;
	private javax.swing.JLabel dLabel;
	private javax.swing.JLabel cLabel;
	private javax.swing.JLabel mLabel;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField nInputField;
	private javax.swing.JTextField dInputField;
	private javax.swing.JTextField cInputField;
	private javax.swing.JTextField mOutputField;
}
