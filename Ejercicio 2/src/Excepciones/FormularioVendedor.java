package Excepciones;

import javax.swing.*;

public class FormularioVendedor {
    public static void main(String[] args) {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del vendedor:");
            String apellidos = JOptionPane.showInputDialog("Apellidos del vendedor:");
            String edadStr = JOptionPane.showInputDialog("Edad del vendedor:");

            int edad = Integer.parseInt(edadStr);

            Vendedor vendedor = new Vendedor(nombre, apellidos);
            vendedor.verificarEdad(edad);
            vendedor.imprimir();

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
        }
    }
}
