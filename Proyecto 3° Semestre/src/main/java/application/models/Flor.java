package application.models;

public class Flor {

    private String nombre;
    private double precio;

    public Flor(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
