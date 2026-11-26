package interfaz;
import java.util.Scanner;
import negocio.Proyecto;
import negocio.EmpresaSoftware;

public class Main {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        final int CANTIDAD = 4;
        Proyecto[] creados = new Proyecto[CANTIDAD];
        System.out.println("Cree " + CANTIDAD + " proyectos.");

        for (int i = 0; i < CANTIDAD; i++) {
            System.out.println("\n- Proyecto " + (i + 1));
            System.out.print(">Codigo: ");
            String codigo = sc.nextLine();
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print(">Presupuesto: ");
            double presupuesto = Double.parseDouble(sc.nextLine());

            creados[i] = new Proyecto(codigo, nombre, presupuesto);
        }

        System.out.print("\nNombre de la empresa: ");
        EmpresaSoftware empresa = new EmpresaSoftware(sc.nextLine());

        System.out.println("\n=== PRUEBAS ===");
        System.out.println("Proyectos al inicio: " + empresa.cantidadProyectos());

        for (int i = 0; i < CANTIDAD; i++) {
            empresa.agregarProyecto(creados[i]);
        }
        System.out.println("Proyectos despues de agregar: " + empresa.cantidadProyectos());
        System.out.println("\n=== PROYECTOS DE " + empresa.getNombre().toUpperCase() + " ===");
        System.out.print(empresa.mostrarProyectos());

        System.out.print("\nCodigo a buscar (existente): ");
        String cod1 = sc.nextLine();
        Proyecto p1 = empresa.buscarProyecto(cod1);
        if (p1 != null) {
            System.out.println("Proyecto encontrado:");
            System.out.print(p1.mostrarInformacion());
        } else {
            System.out.println("No se encontro el proyecto " + cod1);
        }

        System.out.print("Codigo a buscar (inexistente): ");
        String cod2 = sc.nextLine();
        Proyecto p2 = empresa.buscarProyecto(cod2);
        if (p2 != null) {
            System.out.println("Proyecto encontrado:");
            System.out.print(p2.mostrarInformacion());
        } else {
            System.out.println("No se encontro el proyecto " + cod2);
        }

        System.out.println("\nPresupuesto total: $" + empresa.calcularPresupuestoTotal());

        Proyecto mayor = empresa.obtenerMayorPresupuesto();
        if (mayor != null) {
            System.out.println("\nProyecto de mayor presupuesto:");
            System.out.print(mayor.mostrarInformacion());
        } else {
            System.out.println("\nNo hay proyectos registrados.");
        }

        System.out.print("\nCodigo a eliminar: ");
        String codEliminar = sc.nextLine();
        if (empresa.eliminarProyecto(codEliminar)) {
            System.out.println("Proyecto " + codEliminar + " eliminado de la empresa.");
        } else {
            System.out.println("No se pudo eliminar: no existe " + codEliminar);
        }
        System.out.println("Proyectos despues de eliminar: " + empresa.cantidadProyectos());
        System.out.println("Presupuesto total actual: $" + empresa.calcularPresupuestoTotal());
        System.out.println("\n=== PROYECTOS ACTUALES ===");
        System.out.print(empresa.mostrarProyectos());

        System.out.println("\nEl proyecto eliminado sigue existiendo fuera de la empresa:");
        for (int i = 0; i < CANTIDAD; i++) {
            if (creados[i].getCodigo().equals(codEliminar)) {
                System.out.print(creados[i].mostrarInformacion());
            }
        }

        sc.close();
    }
}
