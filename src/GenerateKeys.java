import java.awt.Dimension;
import java.math.BigInteger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GenerateKeys extends javax.swing.JFrame {
	BigInteger p, q, e, n, phi, d;

	public GenerateKeys() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		backButton = new javax.swing.JButton();

		pInputField = new javax.swing.JTextField();
		pLabel = new javax.swing.JLabel();

		qInputField = new javax.swing.JTextField();
		qLabel = new javax.swing.JLabel();

		eInputField = new javax.swing.JTextField();
		eLabel = new javax.swing.JLabel();

		generateKeysButton = new javax.swing.JButton();

		keysOutputField = new javax.swing.JTextField();
		keysLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Generate Keys");
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

		generateKeysButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (pValueIsCorrect() && qValueIsCorrect() && eValueIsCorrect()) {
					try {
						keysOutputField.setText("PU = ( " + e + " , " + n + " ),  PR = ( " + d + " , " + n + " )");
					} catch (NullPointerException e) {
						keysOutputField.setText("");
						JOptionPane.showMessageDialog(null, "Please enter the values for all parametrs  ",
								"Empty fields are not accepted", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					keysOutputField.setText("");
				}
			}
		});

		jPanel1.add(backButton);
		jPanel1.add(pInputField);
		jPanel1.add(pLabel);
		jPanel1.add(qLabel);
		jPanel1.add(qInputField);
		jPanel1.add(eLabel);
		jPanel1.add(eInputField);
		jPanel1.add(generateKeysButton);
		jPanel1.add(keysLabel);
		jPanel1.add(keysOutputField);

		pLabel.setBounds(40, 80, 132, 35);
		qLabel.setBounds(40, 120, 132, 35);
		eLabel.setBounds(40, 160, 132, 35);
		pInputField.setBounds(220, 80, 160, 35);
		qInputField.setBounds(220, 120, 160, 35);
		eInputField.setBounds(220, 160, 160, 35);

		keysLabel.setBounds(150, 220, 152, 35);
		keysOutputField.setBounds(90, 250, 230, 50);

		backButton.setBounds(30, 330, 100, 50);
		generateKeysButton.setBounds(280, 330, 100, 50);

		generateKeysButton.setFont(new java.awt.Font("Tahoma", 0, 12));

		pLabel.setText("Enter the value of p:");
		qLabel.setText("Enter the value of q:");
		eLabel.setText("Enter the value of e:");
		keysLabel.setText("The keys");
		backButton.setText("Back");
		generateKeysButton.setText("Generate");

		keysOutputField.setEditable(false);

		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, 11, 610, 390);
		pack();
	}

	private boolean qValueIsCorrect() {
		try {
			q = new BigInteger(qInputField.getText());
			if (!q.isProbablePrime(1)) {
				JOptionPane.showMessageDialog(null, "Please re-enter a prime value of q ", "Wrong value of q",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter a numeric value of q ", "Non-numeric value of q",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Please enter a value for q ", "Empty value of q  ",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean pValueIsCorrect() {
		try {
			p = new BigInteger(pInputField.getText());
			if (!p.isProbablePrime(1)) {
				JOptionPane.showMessageDialog(null, "Please re-enter a prime value of p ", "Wrong value of p",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter a numeric value of p ", "Non-numeric value of p",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Please enter a value for p ", "Empty value of p  ",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean eValueIsCorrect() {

		try {
			BigInteger one = new BigInteger("1");

			n = p.multiply(q);
			phi = p.subtract(one).multiply(q.subtract(one));

			e = new BigInteger(eInputField.getText());

			// if (e < 1 | e > phi | gcd(e,phi)!=1)
			if (e.compareTo(one) != 1 | e.compareTo(phi) != -1 | e.gcd(phi).compareTo(one) != 0) {
				JOptionPane.showMessageDialog(null, "Please re-enter another value of e ", "Wrong value of e",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}
			d = e.modInverse(phi);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter a numeric value of e ", "Non-numeric value of e",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Please enter the values of p and q first", "Empty fields",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public BigInteger cipher(BigInteger message, BigInteger e, BigInteger n) {
		BigInteger res = message.pow(e.intValue());
		BigInteger mo = res.remainder(n);
		return mo;
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GenerateKeys().setVisible(true);
			}
		});
	}

	// Variables declaration
	private javax.swing.JButton generateKeysButton;
	private javax.swing.JButton backButton;
	private javax.swing.JLabel keysLabel;
	private javax.swing.JLabel pLabel;
	private javax.swing.JLabel eLabel;
	private javax.swing.JLabel qLabel;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField pInputField;
	private javax.swing.JTextField eInputField;
	private javax.swing.JTextField qInputField;
	private javax.swing.JTextField keysOutputField;
}
