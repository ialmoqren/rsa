import java.awt.Dimension;

import javax.swing.JFrame;

public class MainMenu extends javax.swing.JFrame {
	public MainMenu() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		generateKeysButton = new javax.swing.JButton();
		encryptButton = new javax.swing.JButton();
		decryptButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("RSA");

		jPanel1.setLayout(null);

		generateKeysButton.setText("Generate Kays");
		encryptButton.setText("Encrypt");
		decryptButton.setText("Decrypt");

		generateKeysButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JFrame frame = new GenerateKeys();

				frame.setResizable(false);
				Dimension d = new Dimension(410, 440);
				frame.setSize(d);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

				dispose();
			}
		});

		encryptButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JFrame frame = new Sender();

				frame.setResizable(false);
				Dimension d = new Dimension(410, 440);
				frame.setSize(d);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

				dispose();
			}
		});

		decryptButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JFrame frame = new Receiver();
				frame.setResizable(false);
				Dimension d1 = new Dimension(410, 440);
				frame.setSize(d1);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});

		jPanel1.add(generateKeysButton);
		jPanel1.add(encryptButton);
		jPanel1.add(decryptButton);

		generateKeysButton.setBounds(135, 105, 140, 60);
		encryptButton.setBounds(135, 175, 140, 60);
		decryptButton.setBounds(135, 245, 140, 60);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE));

		pack();
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainMenu().setVisible(true);
			}
		});
	}

	// Variables declaration
	private javax.swing.JButton generateKeysButton;
	private javax.swing.JButton encryptButton;
	private javax.swing.JButton decryptButton;
	private javax.swing.JPanel jPanel1;
}
