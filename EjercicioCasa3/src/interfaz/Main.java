package interfaz;
import java.util.Scanner;
import negocio.Commit;
import negocio.Repositorio;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int CANTIDAD = 6;
        System.out.print("Nombre del repositorio: ");
        Repositorio repo = new Repositorio(sc.nextLine());

        System.out.println("\nRegistre " + CANTIDAD + " commits.");
        int registrados = 0;
        while (registrados < CANTIDAD) {
            System.out.println("\n--- Commit " + (registrados + 1) + " ---");
            System.out.print("Codigo: ");
            String codigo = sc.nextLine();
            System.out.print("Autor: ");
            String autor = sc.nextLine();
            System.out.print("Descripcion: ");
            String descripcion = sc.nextLine();

            if (repo.registrarCommit(codigo, autor, descripcion)) {
                registrados++;
                System.out.println("Commit registrado.");
            } else {
                System.out.println("Ya existe un commit con el codigo " + codigo + ". Intente con otro.");
            }
        }

        System.out.println("\n=== HISTORIAL DE " + repo.getNombre().toUpperCase() + " ===");
        System.out.print(repo.mostrarHistorial());

        System.out.println("\n=== PRUEBAS ===");
        System.out.print("Codigo a buscar (existente): ");
        String cod1 = sc.nextLine();
        Commit c1 = repo.buscarPorCodigo(cod1);
        if (c1 != null) {
            System.out.println("Commit encontrado:");
            System.out.print(c1.mostrarInformacion());
        } else {
            System.out.println("No se encontro el commit " + cod1);
        }

        System.out.print("Codigo a buscar (inexistente): ");
        String cod2 = sc.nextLine();
        Commit c2 = repo.buscarPorCodigo(cod2);
        if (c2 != null) {
            System.out.println("Commit encontrado:");
            System.out.print(c2.mostrarInformacion());
        } else {
            System.out.println("No se encontro el commit " + cod2);
        }

        System.out.print("\nAutor a contar: ");
        String autor = sc.nextLine();
        System.out.println("Commits de " + autor + ": " + repo.contarPorAutor(autor));

        System.out.println("\nPrueba de codigo duplicado.");
        System.out.print("Codigo: ");
        String codDup = sc.nextLine();
        System.out.print("Autor: ");
        String autDup = sc.nextLine();
        System.out.print("Descripcion: ");
        String desDup = sc.nextLine();
        if (repo.registrarCommit(codDup, autDup, desDup)) {
            System.out.println("Commit registrado.");
        } else {
            System.out.println("No se registro: el codigo " + codDup + " ya existe.");
        }

        System.out.println("\nCommits antes de eliminar: " + repo.cantidadCommits());
        if (repo.eliminarUltimoCommit()) {
            System.out.println("Ultimo commit eliminado.");
        } else {
            System.out.println("No hay commits para eliminar.");
        }
        System.out.println("Commits despues de eliminar: " + repo.cantidadCommits());

        System.out.println("\n=== HISTORIAL ACTUAL ===");
        System.out.print(repo.mostrarHistorial());

        sc.close();
    }
}
