package Excepciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazExcepcionesXD extends JFrame {
    private JButton btnEjecutar;
    private JTextArea areaResultado;

    public InterfazExcepcionesXD() {
        setTitle("Prueba de Excepciones");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);

        btnEjecutar = new JButton("Ejecutar Excepciones");

        add(btnEjecutar, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnEjecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaResultado.setText(""); // Limpia el área

                try {
                    areaResultado.append("Ingresando al primer try\n");
                    double cociente = 10000 / 0;
                    areaResultado.append("Después de la división\n");
                } catch (ArithmeticException ex) {
                    areaResultado.append("División por cero\n");
                } finally {
                    areaResultado.append("Ingresando al primer finally\n");
                }

                try {
                    areaResultado.append("Ingresando al segundo try\n");
                    Object objeto = null;
                    objeto.toString();
                    areaResultado.append("Imprimiendo objeto\n");
                } catch (ArithmeticException ex) {
                    areaResultado.append("División por cero\n");
                } catch (Exception ex) {
                    areaResultado.append("Ocurrió una excepción\n");
                } finally {
                    areaResultado.append("Ingresando al segundo finally\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InterfazExcepcionesXD().setVisible(true);
        });
    }
}
