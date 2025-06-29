package Archivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class VentanaLeerArchivo extends JFrame {

    private JTextField campoRuta;
    private JButton botonLeer;
    private JTextArea areaTexto;

    public VentanaLeerArchivo() {
        setTitle("Lector de Archivos .txt");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panelSuperior = new JPanel(new BorderLayout());

        campoRuta = new JTextField("C:/prueba.txt");
        botonLeer = new JButton("Leer archivo");

        panelSuperior.add(new JLabel("Ruta del archivo: "), BorderLayout.WEST);
        panelSuperior.add(campoRuta, BorderLayout.CENTER);
        panelSuperior.add(botonLeer, BorderLayout.EAST);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        add(panelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        botonLeer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leerArchivo();
            }
        });
    }

    private void leerArchivo() {
        String ruta = campoRuta.getText();
        try {
            String contenido = LeerArchivo.leerContenidoArchivo(ruta);
            areaTexto.setText(contenido);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo leer el archivo:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaLeerArchivo().setVisible(true);
        });
    }
}
