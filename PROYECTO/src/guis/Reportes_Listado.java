package guis;

import java.awt.EventQueue;
import java.util.ArrayList;
import clases.Producto;
import clases.Venta;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Reportes_Listado extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;
    private static ArrayList<Venta> listaVentas = Ventas_Ventas.listaVentas;
    private static ArrayList<Producto> listaProductos = Mantenimiento_Productos.listaProductos;

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
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        
        JButton btnGeneralVentas = new JButton("GENERAL-VENTAS");
        btnGeneralVentas.addActionListener(e -> generarReporteGeneralVentas());
        btnGeneralVentas.setBounds(69, 23, 218, 23);
        contentPane.add(btnGeneralVentas);

        JButton btnProductosStockMin = new JButton("PRODUCTOS-STOCK MIN");
        btnProductosStockMin.addActionListener(e -> generarReporteProductosStockMin());
        btnProductosStockMin.setBounds(69, 63, 223, 23);
        contentPane.add(btnProductosStockMin);

        JButton btnProductosVentasAcumuladas = new JButton("PRODUCTOS-VENTAS ACUMULADAS");
        btnProductosVentasAcumuladas.addActionListener(e -> generarReporteProductosVentasAcumuladas());
        btnProductosVentasAcumuladas.setBounds(69, 102, 223, 23);
        contentPane.add(btnProductosVentasAcumuladas);

        JButton btnProductosImporteTotal = new JButton("PRODUCTOS-IMPORTE TOTAL");
        btnProductosImporteTotal.addActionListener(e -> generarReporteProductosImporteTotal());
        btnProductosImporteTotal.setBounds(69, 142, 223, 23);
        contentPane.add(btnProductosImporteTotal);
    }

    private void generarReporteGeneralVentas() {
        textArea.setText("LISTADO GENERAL DE VENTAS\n\n");
        for (Venta v : listaVentas) {
            double subtotal = v.getCantidad() * v.getPrecio();
            double igv = subtotal * 0.18;
            double total = subtotal + igv;
            textArea.append("Código de venta: " + v.getCodigoVenta() + "\n");
            textArea.append("Código de cliente: " + v.getCodigoCliente().getCodigoCliente() + "\n");
            textArea.append("Código de producto: " + v.getCodigoProducto().getCodigoProducto() + "\n");
            textArea.append("Fecha: " + v.getFecha() + "\n");
            textArea.append("Importe subtotal: S/. " + subtotal + "\n");
            textArea.append("Importe del IGV: S/. " + igv + "\n");
            textArea.append("Importe total: S/. " + total + "\n\n");
        }
    }

    private void generarReporteProductosStockMin() {
        textArea.setText("PRODUCTOS CON STOCK POR DEBAJO DEL MÍNIMO\n\n");
        for (Producto p : listaProductos) {
            if (p.getStockActual() < p.getStockMin()) {
                textArea.append("Código del producto: " + p.getCodigoProducto() + "\n");
                textArea.append("Nombre del producto: " + p.getNombre() + "\n");
                textArea.append("Stock actual: " + p.getStockActual() + "\n");
                textArea.append("Stock mínimo: " + p.getStockMin() + "\n\n");
            }
        }
    }

    private void generarReporteProductosVentasAcumuladas() {
        textArea.setText("PRODUCTOS POR UNIDADES VENDIDAS ACUMULADAS\n\n");
        for (Producto p : listaProductos) {
            int unidadesVendidas = 0;
            for (Venta v : listaVentas) {
                if (v.getCodigoProducto().getCodigoProducto() == p.getCodigoProducto()) {
                    unidadesVendidas += v.getCantidad();
                }
            }
            textArea.append("Código del producto: " + p.getCodigoProducto() + "\n");
            textArea.append("Nombre del producto: " + p.getNombre() + "\n");
            textArea.append("Cantidad de unidades vendidas acumuladas: " + unidadesVendidas + "\n\n");
        }
    }

    private void generarReporteProductosImporteTotal() {
        textArea.setText("PRODUCTOS POR IMPORTE TOTAL ACUMULADO\n\n");
        for (Producto p : listaProductos) {
            double importeTotal = 0;
            for (Venta v : listaVentas) {
                if (v.getCodigoProducto().getCodigoProducto() == p.getCodigoProducto()) {
                    importeTotal += v.getCantidad() * v.getPrecio();
                }
            }
            textArea.append("Código del producto: " + p.getCodigoProducto() + "\n");
            textArea.append("Nombre del producto: " + p.getNombre() + "\n");
            textArea.append("Importe total acumulado: S/. " + importeTotal + "\n\n");
        }
    }
}
