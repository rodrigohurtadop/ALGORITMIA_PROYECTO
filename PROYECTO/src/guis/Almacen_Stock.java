package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Almacen_Stock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodProdAlm;
	private JTextField txtStockAlm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Almacen_Stock frame = new Almacen_Stock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Almacen_Stock() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 487, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 451, 216);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Código producto");
		lblNewLabel.setBounds(62, 21, 107, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nuevo Stock");
		lblNewLabel_1.setBounds(62, 57, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCodProdAlm = new JTextField();
		txtCodProdAlm.setBounds(174, 18, 86, 20);
		contentPane.add(txtCodProdAlm);
		txtCodProdAlm.setColumns(10);
		
		txtStockAlm = new JTextField();
		txtStockAlm.setBounds(174, 54, 86, 20);
		contentPane.add(txtStockAlm);
		txtStockAlm.setColumns(10);
		
		JButton btnNewButton = new JButton("INGRESAR");
		btnNewButton.setBounds(334, 34, 89, 23);
		contentPane.add(btnNewButton);
	}

}
