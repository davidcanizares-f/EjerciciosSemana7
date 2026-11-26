package negocio;
import java.util.ArrayList;

public class Sprint {
    private ArrayList<Tarea> tareas;
    private String nombre;
    public Sprint(String nombre){
        this.nombre = nombre;
        tareas = new ArrayList<>();

    }
    public String getNombre(){
        return nombre;
    }
    public boolean crearTarea(String codigo, String titulo, double horas){
        if(buscarTarea(codigo) != null){
            return false;
        }
        tareas.add(new Tarea(codigo, nombre, horas));
        return true;
    }

    public boolean completarTarea(String codigo){
        Tarea t = buscarTarea(codigo);
        if(t != null){
            t.completar();
            return true;
        }
        return false;

    }
    public Tarea buscarTarea(String codigo){
        for(Tarea t : tareas){
            if(t.getCodigo().equals(codigo)){
                return t;
            }
        }
        return null;
    }
    public int contarCompletadas(){
        int completadas = 0;
        for(Tarea t : tareas){
            if(t != null && t.isCompletada()){
                completadas++;

            }
        }
        return completadas;
    }
    public double calcularHorasPendientes(){
        double horasPendientes=0;
        for(Tarea t: tareas){
            if(!t.isCompletada()){
                horasPendientes += t.getHoras();
            }
        }
        return horasPendientes;
    }
    public String mostrarTareas(){
        String resultado = "";
        for(Tarea t: tareas){
            resultado = resultado + t.mostrarInformacion();
        }
        return resultado;
    }

}
