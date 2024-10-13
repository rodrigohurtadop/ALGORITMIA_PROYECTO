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
import javax.swing.JCheckBox;

public class Mantenimiento_Clientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodCli;
	private JTextField txtNomCli;
	private JTextField txtApeCli;
	private JTextField txtDirecCli;
	private JTextField txtTelCli;
	private JTextField txtDNICli;
	private static ArrayList<Cliente> listaClientes = new ArrayList<>();
	private JScrollPane scrollPane;
	private JTextArea textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mantenimiento_Clientes frame = new Mantenimiento_Clientes();
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
	public Mantenimiento_Clientes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 468, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setBounds(51, 29, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setBounds(51, 64, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(51, 100, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dirección");
		lblNewLabel_3.setBounds(51, 130, 77, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Teléfono");
		lblNewLabel_4.setBounds(51, 163, 77, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DNI");
		lblNewLabel_5.setBounds(61, 194, 26, 14);
		contentPane.add(lblNewLabel_5);
		
		txtCodCli = new JTextField();
		txtCodCli.setEditable(false);
		txtCodCli.setBounds(127, 26, 86, 20);
		contentPane.add(txtCodCli);
		txtCodCli.setColumns(10);
		
		txtNomCli = new JTextField();
		txtNomCli.setBounds(127, 61, 86, 20);
		contentPane.add(txtNomCli);
		txtNomCli.setColumns(10);
		
		txtApeCli = new JTextField();
		txtApeCli.setBounds(127, 97, 86, 20);
		contentPane.add(txtApeCli);
		txtApeCli.setColumns(10);
		
		txtDirecCli = new JTextField();
		txtDirecCli.setBounds(127, 128, 86, 20);
		contentPane.add(txtDirecCli);
		txtDirecCli.setColumns(10);
		
		txtTelCli = new JTextField();
		txtTelCli.setBounds(127, 160, 86, 20);
		contentPane.add(txtTelCli);
		txtTelCli.setColumns(10);
		
		txtDNICli = new JTextField();
		txtDNICli.setBounds(127, 191, 86, 20);
		contentPane.add(txtDNICli);
		txtDNICli.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 278, 432, 325);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("INGRESO");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (txtNomCli.getText().trim().isEmpty() || 
		            txtApeCli.getText().trim().isEmpty() || 
		            txtDirecCli.getText().trim().isEmpty() || 
		            txtTelCli.getText().trim().isEmpty() || 
		            txtDNICli.getText().trim().isEmpty()) {

		            mensaje("Por favor, llene todos los campos antes de ingresar un cliente.");
		            return;  
		        }
		        String dniCliente = txtDNICli.getText().trim();
		        boolean clienteExistente = listaClientes.stream()
		                .anyMatch(c -> c.getDni().equalsIgnoreCase(dniCliente));
		        if (clienteExistente) {
		            mensaje("Error: Cliente ya registrado con este DNI.");
		        } else {
		            try {
		                Cliente c1 = new Cliente(
		                    0, 
		                    txtNomCli.getText().trim(), 
		                    txtApeCli.getText().trim(),
		                    txtDirecCli.getText().trim(), 
		                    txtTelCli.getText().trim(), 
		                    dniCliente
		                );
		                listaClientes.add(c1);
		                textArea.setText("");
		                for (Cliente c : listaClientes) {
		                    textArea.append("Código: " + c.getCodigoCliente() + "\n");
		                    textArea.append("Datos: " + c.getNombres() + " " + c.getApellidos() + " - " + c.getDni() + "\n");
		                    textArea.append("Dirección y Teléfono: " + c.getDireccion() + " - " + c.getTelefono() + "\n\n");
		                }
		                limpieza();  
		            } catch (Exception ex) {
		                mensaje("Error de Ingreso: " + ex.getMessage());
		            }
		        }
		    }
		});
		btnNewButton.setBounds(287, 29, 115, 23);
		contentPane.add(btnNewButton);

		
		JButton btnNewButton_1 = new JButton("MODIFICACIÓN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 	int codigo = Integer.parseInt(txtCodCli.getText()); 
			        Cliente cliente = buscarCliente(codigo); 
			        if (cliente != null) {
			            cliente.setNombres(txtNomCli.getText());
			            cliente.setApellidos(txtApeCli.getText());
			            cliente.setDireccion(txtDirecCli.getText());
			            cliente.setTelefono(txtTelCli.getText());
			            cliente.setDni(txtDNICli.getText());
			            textArea.setText("Datos del cliente modificados. Lista actualizada: "+"\n"+"\n");
			            for(Cliente c : listaClientes) {
							textArea.append("Código: "+c.getCodigoCliente()+"\n");
				            textArea.append("Datos: "+c.getNombres()+" "+ c.getApellidos()+" - "+c.getDni()+ "\n");
				            textArea.append("Direccion y Telefono: "+c.getDireccion()+ " - "+c.getTelefono()+"\n"+"\n");
						}
			        } else {
			            textArea.setText("Cliente no encontrado.");
			        }
			        limpieza();}
				catch(Exception e1){
					mensaje("Ingresa el código del cliente a modificar");
					}
			}
		});
		btnNewButton_1.setBounds(287, 96, 115, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CONSULTA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int codigo = Integer.parseInt(txtCodCli.getText()); 
		        Cliente cliente = buscarCliente(codigo);
		        
		        if (cliente != null) {
		            txtNomCli.setText(cliente.getNombres());
		            txtApeCli.setText(cliente.getApellidos());
		            txtDirecCli.setText(cliente.getDireccion());
		            txtTelCli.setText(cliente.getTelefono());
		            txtDNICli.setText(cliente.getDni());
		            textArea.setText("Cliente encontrado.");
		        } else {
		            textArea.setText("Cliente no encontrado.");
		        }}
				catch(Exception e1){
					mensaje("Ingresa el código del cliente a consultar");
					}
			}
		});
		btnNewButton_2.setBounds(287, 60, 115, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ELIMINACIÓN");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            int codigo = Integer.parseInt(txtCodCli.getText()); 
		            Cliente cliente = buscarCliente(codigo); 

		            if (cliente != null) {
		                listaClientes.remove(cliente); 
		                textArea.setText("Cliente eliminado. Lista actualizada: " + "\n" + "\n");
		                for (Cliente c : listaClientes) {
		                    textArea.append("Código: " + c.getCodigoCliente() + "\n");
		                    textArea.append("Datos: " + c.getNombres() + " " + c.getApellidos() + " - " + c.getDni() + "\n");
		                    textArea.append("Dirección y Teléfono: " + c.getDireccion() + " - " + c.getTelefono() + "\n" + "\n");
		                }
		            } else {
		                textArea.setText("Cliente no encontrado.");
		            }
		            limpieza();
		        } catch (Exception e1) {
		            mensaje("Ingresa el código del cliente a eliminar");
		        }
				
			}
		});
		btnNewButton_3.setBounds(287, 135, 115, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("LISTADO");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.append("LISTADO DE CLIENTES"+"\n"+"\n");
				for(Cliente c : listaClientes) {
					textArea.append("Código: "+c.getCodigoCliente()+"\n");
		            textArea.append("Datos: "+c.getNombres()+" "+ c.getApellidos()+" - "+c.getDni()+ "\n");
		            textArea.append("Direccion y Telefono: "+c.getDireccion()+ " - "+c.getTelefono()+"\n"+"\n");
				}
			}
		});
		btnNewButton_5.setBounds(287, 174, 115, 23);
		contentPane.add(btnNewButton_5);	
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Habilitar caja de código");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodCli.setEditable(chckbxNewCheckBox.isSelected());
			}
		});
		chckbxNewCheckBox.setBounds(52, 235, 202, 23);
		contentPane.add(chckbxNewCheckBox);
	}
	
	
	// Métodos tipo void (sin parámetros)


	void limpieza() {
	txtCodCli.setText("");
	txtNomCli.setText("");
	txtApeCli.setText("");
	txtDirecCli.setText("");
	txtTelCli.setText("");
	txtDNICli.setText("");
	txtNomCli.requestFocus();
	}

	void imprimir(String s) {
		textArea.append(s + "\n");;
	}
	void mensaje(String s) {
	JOptionPane.showMessageDialog(this, s);
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
