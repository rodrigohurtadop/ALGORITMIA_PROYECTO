package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Reportes_Listado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportes_Listado frame = new Reportes_Listado();
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
	public Reportes_Listado() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 383, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 203, 349, 310);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("GENERAL-VENTAS");
		btnNewButton.setBounds(69, 23, 218, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PRODUCTOS-STOCK MIN");
		btnNewButton_1.setBounds(69, 63, 223, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PRODUCTOS-VENTAS ACUMULADAS");
		btnNewButton_2.setBounds(69, 102, 223, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PRODUCTOS-IMPORTE TOTAL");
		btnNewButton_3.setBounds(69, 142, 223, 23);
		contentPane.add(btnNewButton_3);
	}

}
