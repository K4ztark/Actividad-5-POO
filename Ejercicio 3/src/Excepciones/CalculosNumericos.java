package Excepciones;
import java.util.*;

public class CalculosNumericos {
    public static String CalcularLogaritmoNeperiano(double valor){
        try{
            if (valor<0){
                throw new ArithmeticException("El valor tiene que ser un número positivo.");
            }
            double resultado = Math.log(valor);
            return "Logaritmo neperiano: " + resultado;
        }catch (ArithmeticException e){

            return "El valor tiene que ser un número positivo para calcular el logaritmo Neperiano.";

        }catch (InputMismatchException e){

            return "El valor debe ser numérico para poder calcular el logaritmo Neperiano.";
        }
    }

    public static String CalcularRaizCuadrada(double valor){
        try{
            if (valor<0){
                throw new ArithmeticException("El valor ingresado debe ser un número no negativo.");
            }
            double resultado = Math.sqrt(valor);
            return "Raíz cuadrada: " + resultado;
        }catch (ArithmeticException e) {

            return "El valor tiene que ser un número no negativo para calcular la raíz cuadrada.";

        }catch (InputMismatchException e){

            return "El valor ingresado debe ser numérico para poder calcular la raíz cuadrada.";
        }
    }

    public static void main(String args[]){
        System.out.println("Valor numérico = ");
        Scanner teclado = new Scanner (System.in);
        double valor = teclado.nextDouble();
        CalcularLogaritmoNeperiano(valor);
        CalcularRaizCuadrada(valor);
    }
}
