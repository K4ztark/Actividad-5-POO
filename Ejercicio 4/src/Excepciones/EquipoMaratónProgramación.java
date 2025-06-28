package Excepciones;

import java.util.Scanner;

public class EquipoMaratónProgramación {

    String nombreEquipo;
    String universidad;
    String lenguajeProgramación;
    Programador[] programadores;
    int tamañoEquipo;

    public EquipoMaratónProgramación(String nombreEquipo, String universidad, String lenguajeProgramación) {
        this.nombreEquipo = nombreEquipo;
        this.universidad = universidad;
        this.lenguajeProgramación = lenguajeProgramación;
        this.programadores = new Programador[3];
        this.tamañoEquipo = 0;
    }

    boolean estáLleno() {
        return tamañoEquipo == programadores.length;
    }


    void añadir(Programador programador) throws Exception {
        if (estáLleno()) {
            throw new Exception("El equipo está completo. No se pudo agregar programador.");
        }
        programadores[tamañoEquipo] = programador;
        tamañoEquipo++;
    }


    static void validarCampo(String campo) throws Exception {
        for (int j = 0; j < campo.length(); j++) {
            char c = campo.charAt(j);
            if (Character.isDigit(c)) {
                throw new Exception("El nombre no puede tener dígitos.");
            }
        }
        if (campo.length() > 20) {
            throw new Exception("La longitud no debe ser superior a 20 caracteres.");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nombre del equipo: ");
        String nombre = teclado.next();
        System.out.print("Universidad: ");
        String universidad = teclado.next();
        System.out.print("Lenguaje de programación: ");
        String lenguaje = teclado.next();

        EquipoMaratónProgramación equipo = new EquipoMaratónProgramación(nombre, universidad, lenguaje);

        System.out.println("Datos de los integrantes del equipo:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Nombre del integrante: ");
            String nombreProgramador = teclado.next();
            validarCampo(nombreProgramador);

            System.out.print("Apellidos del integrante: ");
            String apellidosProgramador = teclado.next();
            validarCampo(apellidosProgramador);

            Programador programador = new Programador(nombreProgramador, apellidosProgramador);
            equipo.añadir(programador);
        }

        System.out.println("¡Equipo creado exitosamente!");
    }
}
