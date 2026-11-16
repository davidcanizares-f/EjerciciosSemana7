package interfaz;

import negocio.Desarrollador;
import negocio.Proyecto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del proyecto: ");
        Proyecto proyecto = new Proyecto(sc.nextLine());

        System.out.println("Equipo inicial:");
        System.out.print(proyecto.mostrarEquipo());

        Desarrollador[] creados = new Desarrollador[3];
        for (int i = 0; i < creados.length; i++) {
            System.out.println();
            System.out.println("Desarrollador " + (i + 1));
            System.out.print("Identificacion: ");
            String id = sc.nextLine();
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Especialidad: ");
            String especialidad = sc.nextLine();
            System.out.print("Horas asignadas: ");
            double horas = sc.nextDouble();
            sc.nextLine();
            creados[i] = new Desarrollador(id, nombre, especialidad, horas);
        }

        for (int i = 0; i < creados.length; i++) {
            proyecto.agregarDesarrollador(creados[i]);
        }

        System.out.println();
        System.out.print(proyecto.mostrarEquipo());
        System.out.println("Total de horas: " + proyecto.calcularTotalHoras());

        System.out.print("Identificacion a buscar: ");
        String buscada = sc.nextLine();
        Desarrollador encontrado = proyecto.buscarDesarrollador(buscada);
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.mostrarInformacion());
        } else {
            System.out.println("No existe un desarrollador con la identificacion " + buscada);
        }

        System.out.print("Identificacion a eliminar: ");
        String eliminar = sc.nextLine();
        if (proyecto.eliminarDesarrollador(eliminar)) {
            System.out.println("Desarrollador eliminado");
        } else {
            System.out.println("No se pudo eliminar, identificacion inexistente");
        }

        System.out.println();
        System.out.print(proyecto.mostrarEquipo());
        System.out.println("Desarrolladores en el proyecto: " + proyecto.cantidadDesarrolladores());
        System.out.println("Total de horas: " + proyecto.calcularTotalHoras());

        Desarrollador mayor = proyecto.obtenerMayorCarga();
        if (mayor != null) {
            System.out.println("Mayor carga: " + mayor.mostrarInformacion());
        }

        sc.close();
    }
}