package guis;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JMenuItem mntmClientes;
    private JMenuItem mntmProductos;
    private JMenuItem mntmVentas;
    private JMenuItem mntmStock;
    private JMenuItem mntmListado;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
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
    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 688, 445);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 672, 22);
        contentPane.add(menuBar);

        JMenu mnMantenimiento = new JMenu("Mantenimiento");
        menuBar.add(mnMantenimiento);

        mntmClientes = new JMenuItem("Clientes");
        mntmClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentana(new Mantenimiento_Clientes());
            }
        });
        mnMantenimiento.add(mntmClientes);

        mntmProductos = new JMenuItem("Productos");
        mntmProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentana(new Mantenimiento_Productos());
            }
        });
        mnMantenimiento.add(mntmProductos);

        JMenu mnVentas = new JMenu("Ventas");
        menuBar.add(mnVentas);

        mntmVentas = new JMenuItem("Ventas");
        mntmVentas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentana(new Ventas_Ventas());
            }
        });
        mnVentas.add(mntmVentas);

        JMenu mnAlmacen = new JMenu("Almacen");
        menuBar.add(mnAlmacen);

        mntmStock = new JMenuItem("Stock");
        mntmStock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentana(new Almacen_Stock());
            }
        });
        mnAlmacen.add(mntmStock);

        JMenu mnReportes = new JMenu("Reportes");
        menuBar.add(mnReportes);

        mntmListado = new JMenuItem("Listado");
        mntmListado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentana(new Reportes_Listado());
            }
        });
        mnReportes.add(mntmListado);
    }

    /**
     * Método para abrir una ventana secundaria y desactivar los menús.
     */
    private void abrirVentana(JFrame ventana) {
        setMenuItemsEnabled(false);

        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setMenuItemsEnabled(true);
            }
        });
    }

    /**
     * Método para habilitar o deshabilitar los JMenuItem.
     */
    private void setMenuItemsEnabled(boolean enabled) {
        mntmClientes.setEnabled(enabled);
        mntmProductos.setEnabled(enabled);
        mntmVentas.setEnabled(enabled);
        mntmStock.setEnabled(enabled);
        mntmListado.setEnabled(enabled);
    }
}
