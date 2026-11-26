package negocio;
import java.util.ArrayList;

public class Repositorio {
    private String nombre;
    private ArrayList<Commit> commits;

    public Repositorio(String nombre) {
        this.nombre = nombre;
        commits = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int cantidadCommits() {
        return commits.size();
    }

    public boolean registrarCommit(String codigo, String autor, String descripcion) {
        if (buscarPorCodigo(codigo) != null) {
            return false;
        }
        commits.add(new Commit(codigo, autor, descripcion));
        return true;
    }

    public boolean eliminarUltimoCommit() {
        if (commits.isEmpty()) {
            return false;
        }
        commits.remove(commits.size() - 1);
        return true;
    }

    public Commit buscarPorCodigo(String codigo) {
        for (Commit c : commits) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    public int contarPorAutor(String autor) {
        int contador =0;
        for (Commit c: commits) {
            if (c.getAutor().equalsIgnoreCase(autor)) {
                contador++;
            }
        }
        return contador;
    }

    public String mostrarHistorial() {
        String resultado = "";
        for (Commit c : commits) {
            resultado += c.mostrarInformacion();
        }
        return resultado;
    }
}
