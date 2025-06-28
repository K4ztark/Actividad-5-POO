package Excepciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazEquipoMaraton extends JFrame {
    private JTextField nombreEquipoField, universidadField, lenguajeField;
    private JTextField[] nombresProgramadores = new JTextField[3];
    private JTextField[] apellidosProgramadores = new JTextField[3];
    private JButton crearEquipoButton;

    public InterfazEquipoMaraton() {
        setTitle("Registro de Equipo de Maratón");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        // Campos básicos
        add(new JLabel("Nombre del equipo:"));
        nombreEquipoField = new JTextField();
        add(nombreEquipoField);

        add(new JLabel("Universidad:"));
        universidadField = new JTextField();
        add(universidadField);

        add(new JLabel("Lenguaje de programación:"));
        lenguajeField = new JTextField();
        add(lenguajeField);

        // Campos de los programadores
        for (int i = 0; i < 3; i++) {
            add(new JLabel("Nombre del programador " + (i + 1) + ":"));
            nombresProgramadores[i] = new JTextField();
            add(nombresProgramadores[i]);

            add(new JLabel("Apellidos del programador " + (i + 1) + ":"));
            apellidosProgramadores[i] = new JTextField();
            add(apellidosProgramadores[i]);
        }

        crearEquipoButton = new JButton("Crear equipo");
        add(crearEquipoButton);

        crearEquipoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearEquipo();
            }
        });
    }

    private void crearEquipo() {
        try {
            String nombreEquipo = nombreEquipoField.getText();
            String universidad = universidadField.getText();
            String lenguaje = lenguajeField.getText();

            EquipoMaratónProgramación equipo = new EquipoMaratónProgramación(nombreEquipo, universidad, lenguaje);

            for (int i = 0; i < 3; i++) {
                String nombre = nombresProgramadores[i].getText();
                String apellidos = apellidosProgramadores[i].getText();
                EquipoMaratónProgramación.validarCampo(nombre);
                EquipoMaratónProgramación.validarCampo(apellidos);
                Programador p = new Programador(nombre, apellidos);
                equipo.añadir(p);
            }

            JOptionPane.showMessageDialog(this, "¡Equipo creado exitosamente!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazEquipoMaraton().setVisible(true));
    }
}
