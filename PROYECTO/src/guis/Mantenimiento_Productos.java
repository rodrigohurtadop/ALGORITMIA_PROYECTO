package guis;

import java.awt.EventQueue;

import clases.Cliente;
import clases.Producto;

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

public class Mantenimiento_Productos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodProd;
	private JTextField txtNomProd;
	private JTextField txtPreProd;
	private JTextField txtStockActual;
	private JTextField txtStockMin;
	private JTextField txtStockMax;
	private static ArrayList<Producto> listaProductos = new ArrayList<>();

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
		setBounds(100, 100, 453, 623);
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
		txtCodProd.setEditable(false);
		txtCodProd.setBounds(144, 26, 86, 20);
		contentPane.add(txtCodProd);
		txtCodProd.setColumns(10);
		
		txtNomProd = new JTextField();
		txtNomProd.setBounds(144, 61, 86, 20);
		contentPane.add(txtNomProd);
		txtNomProd.setColumns(10);
		
		txtPreProd = new JTextField();
		txtPreProd.setBounds(144, 97, 86, 20);
		contentPane.add(txtPreProd);
		txtPreProd.setColumns(10);
		
		txtStockActual = new JTextField();
		txtStockActual.setBounds(144, 127, 86, 20);
		contentPane.add(txtStockActual);
		txtStockActual.setColumns(10);
		
		txtStockMin = new JTextField();
		txtStockMin.setBounds(144, 160, 86, 20);
		contentPane.add(txtStockMin);
		txtStockMin.setColumns(10);
		
		txtStockMax = new JTextField();
		txtStockMax.setBounds(144, 191, 86, 20);
		contentPane.add(txtStockMax);
		txtStockMax.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 267, 417, 306);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("INGRESO");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (txtNomProd.getText().trim().isEmpty() || 
		            txtPreProd.getText().trim().isEmpty() || 
		            txtStockActual.getText().trim().isEmpty() || 
		            txtStockMin.getText().trim().isEmpty() || 
		            txtStockMax.getText().trim().isEmpty()) {
		            mensaje("Por favor, llene todos los campos antes de ingresar un cliente.");
		            return; 
		        }
		        String nombreProducto = txtNomProd.getText().trim();
		        boolean productoExistente = listaProductos.stream()
		                .anyMatch(p -> p.getNombre().equalsIgnoreCase(nombreProducto));

		        if (productoExistente) {
		            mensaje("Error: Producto ya registrado.");
		        } else {
		            try {
		                int stockActual = Integer.parseInt(txtStockActual.getText().trim());
		                int stockMin = Integer.parseInt(txtStockMin.getText().trim());
		                int stockMax = Integer.parseInt(txtStockMax.getText().trim());
		                double precio = Double.parseDouble(txtPreProd.getText().trim());
		                Producto p1 = new Producto(0, stockActual, stockMin, stockMax, nombreProducto, precio);
		                listaProductos.add(p1);
		                textArea.setText("");
		                for (Producto p : listaProductos) {
		                    textArea.append("Código: " + p.getCodigoProducto() + "\n");
		                    textArea.append("Nombre del producto: " + p.getNombre() + "\n");
		                    textArea.append("Precio del producto: S/." + p.getPrecio() + "\n");
		                    textArea.append("Stock Mínimo: " + p.getStockMin() + "\n");
		                    textArea.append("Stock Máximo: " + p.getStockMax() + "\n");
		                    textArea.append("Stock Actual: " + p.getStockActual() + "\n\n");
		                }
		                limpieza();  
		            } catch (NumberFormatException ex) {
		                mensaje("Error: Ingrese valores numéricos válidos en los campos correspondientes.");
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
				 	int codigo = Integer.parseInt(txtCodProd.getText()); 
				 	Producto producto = buscarProducto(codigo);
			        if (producto!= null) {
			            producto.setNombre(txtNomProd.getText());
			            producto.setPrecio(Double.parseDouble(txtPreProd.getText()));
			            producto.setStockActual(Integer.parseInt(txtStockActual.getText()));
			            producto.setStockMin(Integer.parseInt(txtStockMin.getText()));
			            producto.setStockMax(Integer.parseInt(txtStockMax.getText()));
			            textArea.setText("Datos del producto modificados. Lista actualizada: "+"\n"+"\n");
			            for(Producto p : listaProductos) {
							textArea.append("Código: " + p.getCodigoProducto() + "\n");
		                    textArea.append("Nombre del producto: " + p.getNombre() + "\n");
		                    textArea.append("Precio del producto: S/."+ p.getPrecio()+ "\n");
		                    textArea.append("Stock Mínimo: "+ p.getStockMin()+"\n");
		                    textArea.append("Stock Máximo: "+ p.getStockMax()+"\n");
		                    textArea.append("Stock Actual: "+ p.getStockActual()+"\n"+"\n");
						}
			        } else {
			            textArea.setText("Producto no encontrado.");
			        }
			        limpieza();}
				catch(Exception e1){
					mensaje("Ingresa el código del producto a modificar");
					}
			}
		});
		btnNewButton_1.setBounds(287, 108, 115, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CONSULTA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codigo = Integer.parseInt(txtCodProd.getText()); 
			        Producto producto = buscarProducto(codigo);
			        if (producto != null) {
			            txtNomProd.setText(producto.getNombre());
			            txtPreProd.setText(String.valueOf(producto.getPrecio()));
			            txtStockActual.setText(String.valueOf(producto.getStockActual()));
			            txtStockMin.setText(String.valueOf(producto.getStockMin()));
			            txtStockMax.setText(String.valueOf(producto.getStockMax()));
			            textArea.setText("Producto encontrado.");
			        } else {
			            textArea.setText("Producto no encontrado.");
			        }}
					catch(Exception e1){
						mensaje("Ingresa el código del producto a consultar");
						}
			}
		});
		btnNewButton_2.setBounds(287, 66, 115, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ELIMINACIÓN");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codigo = Integer.parseInt(txtCodProd.getText()); 
			        Producto producto = buscarProducto(codigo);
			        if (producto != null) {
			            listaProductos.remove(producto);
			            textArea.setText("Producto eliminado. Lista actualizada: " + "\n" + "\n");
			            for(Producto p : listaProductos) {
							textArea.append("Código: " + p.getCodigoProducto() + "\n");
		                    textArea.append("Nombre del producto: " + p.getNombre() + "\n");
		                    textArea.append("Precio del producto: S/."+ p.getPrecio()+ "\n");
		                    textArea.append("Stock Mínimo: "+ p.getStockMin()+"\n");
		                    textArea.append("Stock Máximo: "+ p.getStockMax()+"\n");
		                    textArea.append("Stock Actual: "+ p.getStockActual()+"\n"+"\n");
						}
			        } else {
			            textArea.setText("Producto no encontrado.");
		            }
		            limpieza();
		        } catch (Exception e1) {
		            mensaje("Ingresa el código del producto a eliminar");
		        }
			}
		});
		btnNewButton_3.setBounds(287, 146, 115, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("LISTADO");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.append("LISTADO DE PRODUCTOS"+"\n"+"\n");
				for(Producto p : listaProductos) {
					textArea.append("Código: " + p.getCodigoProducto() + "\n");
                    textArea.append("Nombre del producto: " + p.getNombre() + "\n");
                    textArea.append("Precio del producto: S/."+ p.getPrecio()+ "\n");
                    textArea.append("Stock Mínimo: "+ p.getStockMin()+"\n");
                    textArea.append("Stock Máximo: "+ p.getStockMax()+"\n");
                    textArea.append("Stock Actual: "+ p.getStockActual()+"\n"+"\n");
				}
			}
		});
		btnNewButton_5.setBounds(287, 190, 115, 23);
		contentPane.add(btnNewButton_5);
		
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Habilitar caja de código");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodProd.setEditable(chckbxNewCheckBox.isSelected());
			}
		});
		chckbxNewCheckBox.setBounds(51, 235, 179, 23);
		contentPane.add(chckbxNewCheckBox);	
	}

	protected Producto buscarProducto(int codigo) {
		for (Producto producto : listaProductos) {
	        if (producto.getCodigoProducto() == codigo) {
	            return producto;
	        }
	    }
	    return null; 
	}
	
	void limpieza() {
		txtCodProd.setText("");
		txtNomProd.setText("");
		txtPreProd.setText("");
		txtStockMin.setText("");
		txtStockMax.setText("");
		txtStockActual.setText("");
		txtNomProd.requestFocus();
		}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
		}
}
