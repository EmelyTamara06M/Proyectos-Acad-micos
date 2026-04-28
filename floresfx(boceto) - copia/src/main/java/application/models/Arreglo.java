package application.models;

public class Arreglo {

    private String nombre;
    private double precio;
    private int cantidad;
    private String rutaImagen;

    //  Constructor completo (para BD)
    public Arreglo(String nombre, double precio, int cantidad, String rutaImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.rutaImagen = rutaImagen;
    }

    // Constructor simple (para catálogo)
    public Arreglo(String nombre, double precio, String rutaImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = 1; 
        this.rutaImagen = rutaImagen;
    }

    // ---------------- GETTERS ----------------

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    // ---------------- SETTERS ----------------

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
