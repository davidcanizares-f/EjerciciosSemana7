package interfaz;

import negocio.Desarrollador;
import negocio.Proyecto;

import java.util.Scanner;

public class Main {

    public static void main(){
        final int CANTIDAD = 2;
        Scanner sc = new Scanner(System.in);
        Desarrollador[] creados = new Desarrollador[CANTIDAD];
        System.out.println("Ingrese los datos de " + CANTIDAD + " desarrolladores.");
        for(int i = 0; i < creados.length; i++){
            System.out.println("- Desarrollador " + (i+1));
            System.out.print("> Identificacion: ");
            String identificacion = sc.nextLine();
            System.out.print("> Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("> Especialidad: ");
            String especialidad = sc.nextLine();
            System.out.print("> Horas Asignadas: ");
            int horas = Integer.parseInt(sc.nextLine());

            creados[i] = new Desarrollador(identificacion, nombre, especialidad, horas);
        }
        System.out.print("Ingrese el nombre del Proyecto: ");
        String nombreProyecto = sc.nextLine();
        Proyecto proyecto = new Proyecto(nombreProyecto);
        System.out.println("\n=== PRUEBAS ===");
        System.out.println("Desarrolladores al inicio: " + proyecto.cantidadDesarrolladores());
        if (proyecto.mostrarEquipo().equals("")) {
            System.out.println("El proyecto esta vacio.");
        }

        for (int i = 0; i < CANTIDAD; i++) {
            proyecto.agregarDesarrollador(creados[i]);
        }
        System.out.println("\nDesarrolladores despues de agregar: " + proyecto.cantidadDesarrolladores());
        System.out.println("Equipo:");
        System.out.print(proyecto.mostrarEquipo());

        System.out.print("\nIdentificacion a buscar (existente): ");
        String id1 = sc.nextLine();
        Desarrollador d1 = proyecto.buscarDesarrollador(id1);
        if (d1 != null) {
            System.out.println("Encontrado: " + d1.mostrarInformacion());
        } else {
            System.out.println("No se encontro el desarrollador " + id1);
        }

        System.out.print("Identificacion a buscar (inexistente): ");
        String id2 = sc.nextLine();
        Desarrollador d2 = proyecto.buscarDesarrollador(id2);
        if (d2 != null) {
            System.out.println("Encontrado: " + d2.mostrarInformacion());
        } else {
            System.out.println("No se encontro el desarrollador " + id2);
        }

        System.out.println("\nHoras totales: " + proyecto.calcularTotalHoras());
        Desarrollador mayor = proyecto.obtenerMayorCarga();
        if (mayor != null){
            System.out.println("Mayor carga: " + mayor.mostrarInformacion());
        } else {
            System.out.println("No hay desarrolladores en el proyecto.");
        }

        System.out.print("\nIdentificacion a eliminar: ");
        String idEliminar = sc.nextLine();
        if (proyecto.eliminarDesarrollador(idEliminar)) {
            System.out.println("Desarrollador " + idEliminar + " eliminado del proyecto.");
        } else {
            System.out.println("No se pudo eliminar: no existe " + idEliminar);
        }
        System.out.println("Desarrolladores despues de eliminar: " + proyecto.cantidadDesarrolladores());
        System.out.println("Equipo actual:");
        System.out.print(proyecto.mostrarEquipo());
        System.out.println("Horas totales actuales: " + proyecto.calcularTotalHoras());

        System.out.println("\nEl objeto eliminado sigue existiendo fuera del proyecto:");
        for (int i = 0; i < CANTIDAD; i++) {
            if (creados[i].getIdentificacion().equals(idEliminar)) {
                System.out.println(creados[i].mostrarInformacion());
            }
        }
        sc.close();
    }
}
