package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Ventas_Ventas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodVen;
	private JTextField txtCantVen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas_Ventas frame = new Ventas_Ventas();
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
	public Ventas_Ventas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código producto");
		lblNewLabel.setBounds(39, 21, 110, 14);
		contentPane.add(lblNewLabel);
		
		txtCodVen = new JTextField();
		txtCodVen.setBounds(147, 18, 86, 20);
		contentPane.add(txtCodVen);
		txtCodVen.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(39, 61, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCantVen = new JTextField();
		txtCantVen.setBounds(147, 58, 86, 20);
		contentPane.add(txtCantVen);
		txtCantVen.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 469, 201);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("PROCESAR");
		btnNewButton.setBounds(302, 32, 89, 23);
		contentPane.add(btnNewButton);
	}
}
