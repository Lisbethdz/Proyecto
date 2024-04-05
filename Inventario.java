/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda_lis;

/**
 *
 * @author MINEDUCYT
 */

import java.util.ArrayList;
import java.util.List;
public class Inventario extends Main {
    protected List<Transaccion> transacciones;
    protected List<Producto> productos;
    public Inventario()  {
        productos = new ArrayList<>();
        transacciones = new ArrayList<>();
    }
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    public void registrarVenta(int idProducto, int cantidad) {
        Producto producto = buscarProducto(idProducto);
        if (producto != null) {
            Transaccion transaccion = new Transaccion(producto, cantidad, "venta");
            transaccion.registroTransaccion();
            transacciones.add(transaccion);
        } else {
            System.out.println("El producto con ID " + idProducto + " fue vendido");
        }
    }
    public void registrarReabastecimiento(int idProducto, int cantidad) {
        Producto producto = buscarProducto(idProducto);
        if (producto != null) {
            Transaccion transaccion = new Transaccion(producto, cantidad, "reabastecimiento");
            transaccion.registroTransaccion();
            transacciones.add(transaccion);
        } else {
            System.out.println("El producto con ID " + idProducto + " fue agregado al stock");
        }
    }
    public void generarInformeVentas() {
        System.out.println("-------------------------------------------");
        System.out.println("Se está generando un informe de ventas...");
        System.out.println("-------------------------------------------");
        System.out.println("Informe de ventas:");
        for (Transaccion transaccion : transacciones) {
            if (transaccion.getTipo().equals("venta")) {
                System.out.println("Del producto: " + transaccion.getProducto().getNombre() + ", Cantidad del producto: " + transaccion.getCantidad());
            }
        }
    }
    public void generarInformeStock() {
        System.out.println("-------------------------------------------");
        System.out.println("Se está generando un informe de stock....");
        System.out.println("-------------------------------------------");
        System.out.println("Informe de stock:");
        for (Producto producto : productos) {
            System.out.println("Productos: " + producto.getNombre() + ", Disponibles en la actualización del Stock: " + producto.getCantidadStock());
        }
    }
    private Producto buscarProducto(int idProducto) {
        for (Producto producto : productos) {
            if (producto.getId() == idProducto) {
                return producto;
            }
        }
        return null;
    }
}
