package negocio;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<ItemCarrito> items;

    public Carrito(){
        items = new ArrayList<>();

    }
    public void agregarProducto(Producto producto, int cantidad){
        if(cantidad <= 0){
            return;
        }
        items.add(new ItemCarrito(producto, cantidad));
    }
}
