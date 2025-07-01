package Excepciones;

import javax.swing.*;
import java.awt.*;

public class VentanaCalculosNumericos extends JFrame{

    private JTextField campoNumero;
    private JLabel muestraResultado;
    private CalculosNumericos calculosNumericos;

    public VentanaCalculosNumericos(){
        calculosNumericos = new CalculosNumericos();

        setTitle("Calculadora de logaritmo neperiano y raiz cuadrada");
        setSize (500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));

        campoNumero = new JTextField();
        panel.add(new JLabel("Ingrese un número: "));
        panel.add(campoNumero);

        JPanel panelBotones = new JPanel();
        JButton botonLn = new JButton("Logaritmo Neperiano");
        JButton botonRaiz = new JButton("Raíz Cuadrada");

        panelBotones.add(botonLn);
        panelBotones.add(botonRaiz);
        panel.add(panelBotones);

        muestraResultado = new JLabel ("Resultado: ");

        botonLn.addActionListener(e -> CalcularLogaritmoNeperiano());

    }
}
