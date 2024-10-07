package guis;

import java.awt.EventQueue;

import clases.Cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Mantenimiento_Productos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodProd;
	private JTextField txtNomProd;
	private JTextField txtPreProd;
	private JTextField txtStockActual;
	private JTextField txtStockMin;
	private JTextField txtStockMax;
	private static ArrayList<Cliente> listaClientes = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mantenimiento_Productos frame = new Mantenimiento_Productos();
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
	public Mantenimiento_Productos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setBounds(51, 29, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(51, 64, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(51, 100, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Stock Actual");
		lblNewLabel_3.setBounds(51, 130, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Stock Mínimo");
		lblNewLabel_4.setBounds(51, 163, 102, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Stock Máximo");
		lblNewLabel_5.setBounds(51, 194, 115, 14);
		contentPane.add(lblNewLabel_5);
		
		txtCodProd = new JTextField();
		txtCodProd.setBounds(127, 26, 86, 20);
		contentPane.add(txtCodProd);
		txtCodProd.setColumns(10);
		
		txtNomProd = new JTextField();
		txtNomProd.setBounds(127, 61, 86, 20);
		contentPane.add(txtNomProd);
		txtNomProd.setColumns(10);
		
		txtPreProd = new JTextField();
		txtPreProd.setBounds(127, 97, 86, 20);
		contentPane.add(txtPreProd);
		txtPreProd.setColumns(10);
		
		txtStockActual = new JTextField();
		txtStockActual.setBounds(127, 128, 86, 20);
		contentPane.add(txtStockActual);
		txtStockActual.setColumns(10);
		
		txtStockMin = new JTextField();
		txtStockMin.setBounds(127, 160, 86, 20);
		contentPane.add(txtStockMin);
		txtStockMin.setColumns(10);
		
		txtStockMax = new JTextField();
		txtStockMax.setBounds(127, 191, 86, 20);
		contentPane.add(txtStockMax);
		txtStockMax.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 224, 392, 284);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("INGRESO");
		btnNewButton.setBounds(287, 29, 115, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("MODIFICACIÓN");
		btnNewButton_1.setBounds(287, 60, 115, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CONSULTA");
		btnNewButton_2.setBounds(287, 96, 115, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ELIMINACIÓN");
		btnNewButton_3.setBounds(287, 130, 115, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("LIMPIAR");
		btnNewButton_4.setBounds(297, 190, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("LISTADO");
		btnNewButton_5.setBounds(287, 159, 115, 23);
		contentPane.add(btnNewButton_5);
		
		

		
	}

	protected Cliente buscarCliente(int codigo) {
		for (Cliente cliente : listaClientes) {
	        if (cliente.getCodigoCliente() == codigo) {
	            return cliente;
	        }
	    }
	    return null; 
	}
}
