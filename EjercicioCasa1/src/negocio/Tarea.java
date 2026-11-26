package negocio;

public class Tarea {
    private String codigo;
    private String titulo;
    private double horas;
    private boolean completada;

    public Tarea(String codigo, String titulo, double horas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.horas = horas;
        this.completada = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getHoras() {
        return horas;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void completar() {
        completada = true;
    }

    public String mostrarInformacion() {
        String estado = completada ? "Completada" : "Pendiente";
        return "Codigo : " + codigo + "\n"
                + "Titulo : " + titulo + "\n"
                + "Horas: " + horas + " h\n"
                + "Estado : " + estado + "\n"
                + "----------------------------\n";
    }
}
