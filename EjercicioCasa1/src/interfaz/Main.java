package interfaz;

import negocio.Sprint;
import negocio.Tarea;

import java.util.Scanner;

public class Main {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        final int CANTIDAD = 5;

        System.out.print("Nombre del sprint: ");
        Sprint sprint = new Sprint(sc.nextLine());

        System.out.println("\nRegistre " + CANTIDAD + " tareas.");
        int creadas = 0;
        while (creadas < CANTIDAD) {
            System.out.println("\n- Tarea " + (creadas + 1));
            System.out.print(">Codigo: ");
            String codigo = sc.nextLine();
            System.out.print(">Titulo: ");
            String titulo = sc.nextLine();
            System.out.print(">Horas estimadas: ");
            double horas = Double.parseDouble(sc.nextLine());

            if (sprint.crearTarea(codigo, titulo, horas)) {
                creadas++;
                System.out.println("Tarea creada.");
            } else {
                System.out.println("Ya existe una tarea con el codigo " + codigo + ". Intente con otro.");
            }
        }

        System.out.println("\n=== TAREAS DEL SPRINT " + sprint.getNombre().toUpperCase() + " ===");
        System.out.print(sprint.mostrarTareas());

        System.out.println("\n=== PRUEBAS ===");
        System.out.print("Codigo de la tarea a completar: ");
        String codCompletar = sc.nextLine();
        if (sprint.completarTarea(codCompletar)) {
            System.out.println("Tarea " + codCompletar + " completada.");
        } else {
            System.out.println("No existe la tarea " + codCompletar);
        }

        System.out.print("Codigo de la tarea a completar (inexistente): ");
        String codInexistente = sc.nextLine();
        if (sprint.completarTarea(codInexistente)) {
            System.out.println("Tarea " + codInexistente + " completada.");
        } else {
            System.out.println("No existe la tarea " + codInexistente);
        }

        System.out.print("\nCodigo a buscar: ");
        String codBuscar = sc.nextLine();
        Tarea encontrada = sprint.buscarTarea(codBuscar);
        if (encontrada != null) {
            System.out.println("Tarea encontrada:");
            System.out.print(encontrada.mostrarInformacion());
        } else {
            System.out.println("No se encontro la tarea " + codBuscar);
        }

        System.out.println("\nTareas completadas: " + sprint.contarCompletadas());
        System.out.println("Horas pendientes: " + sprint.calcularHorasPendientes() + " h");

        System.out.println("\nPrueba de codigo duplicado.");
        System.out.print("Codigo: ");
        String codDup = sc.nextLine();
        System.out.print("Titulo: ");
        String titDup = sc.nextLine();
        System.out.print("Horas estimadas: ");
        double horasDup = Double.parseDouble(sc.nextLine());
        if (sprint.crearTarea(codDup, titDup, horasDup)) {
            System.out.println("Tarea creada.");
        } else {
            System.out.println("No se creo: el codigo " + codDup + " ya existe.");
        }

        System.out.println("\n=== ESTADO FINAL ===");
        System.out.print(sprint.mostrarTareas());

        sc.close();
    }
}
