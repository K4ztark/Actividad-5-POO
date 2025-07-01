package Excepciones;
import java.util.*;

public class CalculosNumericos {
    static void CalcularLogaritmoNeperiano(double valor){
        try{
            if (valor<0){
                throw new ArithmeticException("El valor tiene que ser un número positivo.");
            }
            double resultado = Math.log(valor);
            System.out.println("El resultado es: "+resultado);
        }catch (ArithmeticException e){

            System.out.println("El valor tiene que ser un número positivo para calcular el logaritmo Neperiano.");

        }catch (InputMismatchException e){

            System.out.println("El valor debe ser numérico para poder calcular el logaritmo Neperiano.");
        }
    }

    static void CalcularRaizCuadrada(double valor){
        try{
            if (valor<0){
                throw new ArithmeticException("El valor ingresado debe ser un número no negativo.");
            }
            double resultado = Math.sqrt(valor);
            System.out.println("El resultado es: "+resultado);
        }catch (ArithmeticException e) {

            System.out.println("El valor tiene que ser un número no negativo para calcular la raíz cuadrada.");

        }catch (InputMismatchException e){

            System.out.println("El valor ingresado debe ser numérico para poder calcular la raíz cuadrada.");
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
