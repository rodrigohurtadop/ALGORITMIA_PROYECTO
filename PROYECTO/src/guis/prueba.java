package guis;

import java.awt.EventQueue;
import clases.Cliente;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prueba extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodCli;
    private JTextField txtNomCli;
    private JTextField txtApeCli;
    private JTextField txtDirecCli;
    private JTextField txtTelCli;
    private JTextField txtDNICli;
    private JTextArea textArea;

    // ArrayList to store Cliente objects
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    prueba frame = new prueba();
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
    public prueba() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 453, 558);
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
        txtCodCli.setBounds(127, 26, 86, 20);
        txtCodCli.setEditable(false); // Código autogenerado, no editable
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
        scrollPane.setBounds(20, 224, 392, 284);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        // Ingreso button logic
        JButton btnNewButton = new JButton("INGRESO");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Step 1: Gather data from text fields after the user clicks the button
                String nombres = txtNomCli.getText();
                String apellidos = txtApeCli.getText();
                String direccion = txtDirecCli.getText();
                String telefono = txtTelCli.getText();
                String dni = txtDNICli.getText();

                // Step 2: Create new Cliente object
                Cliente nuevoCliente = new Cliente(0, nombres, apellidos, direccion, telefono, dni);

                // Step 3: Add new Cliente to ArrayList
                listaClientes.add(nuevoCliente);

                // Step 4: Display the new client in the textArea
                textArea.setText("Cliente agregado:\n");
                textArea.append("Código Cliente: " + nuevoCliente.getCodigoCliente() + "\n");
                textArea.append("Nombres: " + nuevoCliente.getNombres() + "\n");
                textArea.append("Apellidos: " + nuevoCliente.getApellidos() + "\n");
                textArea.append("Dirección: " + nuevoCliente.getDireccion() + "\n");
                textArea.append("Teléfono: " + nuevoCliente.getTelefono() + "\n");
                textArea.append("DNI: " + nuevoCliente.getDni() + "\n");
             

                // Optional: Clear the input fields for the next entry
                limpiarCampos();
            }
        });
        btnNewButton.setBounds(287, 29, 115, 23);
        contentPane.add(btnNewButton);
    }

    // Clear input fields after a client is added
    private void limpiarCampos() {
        txtNomCli.setText("");
        txtApeCli.setText("");
        txtDirecCli.setText("");
        txtTelCli.setText("");
        txtDNICli.setText("");
    }
}

