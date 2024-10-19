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
import clases.Cliente;
import clases.Producto;
import clases.Venta;


public class Ventas_Ventas extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodProd;
    private JTextField txtCodCli;
    private JTextField txtCantVen;
    private static ArrayList<Venta> listaVentas = new ArrayList<>();

	

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 505, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblCodCli = new JLabel("Código cliente");
        lblCodCli.setBounds(39, 21, 110, 14);
        contentPane.add(lblCodCli);
		
        txtCodCli = new JTextField();
        txtCodCli.setBounds(147, 18, 86, 20);
        contentPane.add(txtCodCli);
        txtCodCli.setColumns(10);
		
        JLabel lblCodProd = new JLabel("Código producto");
        lblCodProd.setBounds(39, 61, 110, 14);
        contentPane.add(lblCodProd);

        txtCodProd = new JTextField();
        txtCodProd.setBounds(147, 58, 86, 20);
        contentPane.add(txtCodProd);
        txtCodProd.setColumns(10);
        
        JLabel lblCantVen = new JLabel("Cantidad");
        lblCantVen.setBounds(39, 101, 86, 14);
        contentPane.add(lblCantVen);

        txtCantVen = new JTextField();
        txtCantVen.setBounds(147, 98, 86, 20);
        contentPane.add(txtCantVen);
        txtCantVen.setColumns(10);
		
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 134, 469, 262);
        contentPane.add(scrollPane);

		
        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
		
        ();
        scrollPane.setViewportView(textArea);

        JButton btnProcesar = new JButton("PROCESAR");
        btnProcesar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigoCliente = Integer.parseInt(txtCodCli.getText());
                    int codigoProducto = Integer.parseInt(txtCodProd.getText());
                    int cantidad = Integer.parseInt(txtCantVen.getText());

                    Cliente cliente = buscarCliente(codigoCliente);
                    Producto producto = buscarProducto(codigoProducto);

                    if (cliente == null || producto == null) {
                        mensaje("Cliente o producto no encontrado.");
                        return;
                    }

                    if (cantidad > producto.getStockActual()) {
                        mensaje("Error: La cantidad solicitada excede el stock actual.");
                        return;
                    }

                    
                    double precioUnitario = producto.getPrecio();
                    double subtotal = precioUnitario * cantidad;
                    double igv = subtotal * 0.18;
                    double total = subtotal + igv;

                   
                    producto.setStockActual(producto.getStockActual() - cantidad);

                  
                    Venta venta = new Venta(0, cliente, producto, cantidad, precioUnitario, "fecha_actual");
                    listaVentas.add(venta);

                    textArea.setText("");
                    textArea.append("BOLETA DE PAGO\n");
                    textArea.append("Código del cliente: " + cliente.getCodigoCliente() + "\n");
                    textArea.append("Nombres y apellidos del cliente: " + cliente.getNombres() + " " + cliente.getApellidos() + "\n");
                    textArea.append("Código del producto: " + producto.getCodigoProducto() + "\n");
                    textArea.append("Nombre del producto: " + producto.getNombre() + "\n");
                    textArea.append("Cantidad de unidades adquiridas: " + cantidad + "\n");
                    textArea.append("Precio unitario: S/. " + precioUnitario + "\n");
                    textArea.append("Importe subtotal: S/. " + new DecimalFormat("#.##").format(subtotal) + "\n");
                    textArea.append("Importe del IGV: S/. " + new DecimalFormat("#.##").format(igv) + "\n");
                    textArea.append("Importe total a pagar: S/. " + new DecimalFormat("#.##").format(total) + "\n");

                } catch (NumberFormatException ex) {
                    mensaje("Error: Ingrese valores numéricos válidos.");
                }
            }
        });
        btnProcesar.setBounds(302, 32, 123, 23);
        contentPane.add(btnProcesar);
    }

    protected Cliente buscarCliente(int codigo) {
        for (Cliente cliente : Mantenimiento_Clientes.listaClientes) {
            if (cliente.getCodigoCliente() == codigo) {
                return cliente;
            }
        }
        return null;
    }

    protected Producto buscarProducto(int codigo) {
        for (Producto producto : Mantenimiento_Productos.listaProductos) {
            if (producto.getCodigoProducto() == codigo) {
                return producto;
            }
        }
        return null;
    }

    void mensaje(String s) {
        JOptionPane.showMessageDialog(this, s);
    }
}
