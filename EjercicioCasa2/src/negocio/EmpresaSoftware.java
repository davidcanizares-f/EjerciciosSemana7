package negocio;
import java.util.ArrayList;
public class EmpresaSoftware {
    private String nombre;
    private ArrayList<Proyecto> proyectos;

    public EmpresaSoftware(String nombre){
        this.nombre = nombre;
        proyectos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public int cantidadProyectos() {
        return proyectos.size();
    }
    public void agregarProyecto(Proyecto proyecto){
        proyectos.add(proyecto);
    }
    public boolean eliminarProyecto(String codigo){
        Proyecto eliminar = buscarProyecto(codigo);
        if(eliminar != null){
            proyectos.remove(eliminar);
            return true;
        }
        return false;
    }

    public Proyecto buscarProyecto(String codigo){
        for(Proyecto p : proyectos){
            if(p.getCodigo().equals(codigo)){
                return p;
            }
        }
        return null;
    }
    public double calcularPresupuestoTotal(){
        double total=0;
        for(Proyecto p : proyectos){
            total += p.getPresupuesto();
        }
        return total;
    }
    public String mostrarProyectos(){
        String resultado = "";
        for(Proyecto p: proyectos){
            resultado += p.mostrarInformacion();
        }
        return resultado;
    }
    public Proyecto obtenerMayorPresupuesto(){
        Proyecto mayor = null;
        for (Proyecto p : proyectos){
            if(mayor == null || p.getPresupuesto() > mayor.getPresupuesto()){
                mayor = p;
            }
        }
        return mayor;
    }
}
