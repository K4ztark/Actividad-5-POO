package Excepciones;

public class PruebaExcepciones {
    public static void main(String args[]) {
        try {
            System.out.println("Ingresando al primer try");
            double cociente = 10000 / 0;
            System.out.println("Después de la división");
        } catch (ArithmeticException e) {
            System.out.println("División por cero");
        } finally {
            System.out.println("Ingresando al primer finalmente");
        }

        try {
            System.out.println("Ingresando al segundo try");
            Object objeto = null;
            objeto.toString();
            System.out.println("Imprimiendo objeto");
        } catch (ArithmeticException e) {
            System.out.println("División por cero");
        } catch (Exception e) {
            System.out.println("Ocurrió una excepción");
        } finally {
            System.out.println("Ingresando al segundo finalmente");
        }
    }
}
