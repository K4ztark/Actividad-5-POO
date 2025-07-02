package Excepciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCalculosNumericos extends JFrame {

    private JTextField campoNumero;
    private JButton botonRaiz, botonLn;
    private JTextArea areaResultado;

    public VentanaCalculosNumericos() {

        setTitle("Calculos Numéricos");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel etiqueta = new JLabel("Ingrese un número: ");
        etiqueta.setBounds(30, 20, 150, 25);
        add(etiqueta);

        campoNumero = new JTextField();
        campoNumero.setBounds(170, 20, 150, 25);
        add(campoNumero);

        botonRaiz = new JButton("Raíz Cuadrada");
        botonRaiz.setBounds(30, 60, 140, 30);
        add(botonRaiz);

        botonLn = new JButton("Logaritmo Neperiano");
        botonLn.setBounds(180, 60, 170, 30);
        add(botonLn);

        areaResultado = new JTextArea();
        areaResultado.setBounds(30, 110, 320, 70);
        areaResultado.setEditable(false);
        add(areaResultado);

        botonRaiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarCalculo("Raíz");
            }
        });

        botonLn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarCalculo("Logaritmo Neperiano");
            }
        });
    }

    private void realizarCalculo(String tipo) {
        try {
            double valor = Double.parseDouble(campoNumero.getText());
            String resultado;

            if (tipo.equals("Raíz")) {
                resultado = CalculosNumericos.CalcularRaizCuadrada(valor);
            } else {
                resultado = CalculosNumericos.CalcularLogaritmoNeperiano(valor);
            }

            areaResultado.setText(resultado);

        } catch (NumberFormatException e) {
            areaResultado.setText("Error: Ingrese un número válido");
        }
    }

    public static void main(String[] args) {
        VentanaCalculosNumericos ventana = new VentanaCalculosNumericos();
        ventana.setVisible(true);
    }


}