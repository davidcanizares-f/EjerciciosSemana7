package negocio;

public class Commit {
    private String codigo;
    private String autor;
    private String descripcion;

    public Commit(String codigo, String autor, String descripcion) {
        this.codigo = codigo;
        this.autor = autor;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getAutor() {
        return autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String mostrarInformacion() {
        return "Commit: " + codigo + "\n"
                + "Autor: " + autor + "\n"
                + "Descripcion : " + descripcion + "\n"
                + "----------------------------\n";
    }
}
