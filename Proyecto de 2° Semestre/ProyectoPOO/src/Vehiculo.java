public class Vehiculo {

    private String marca;
    private String modelo;
    private int año;
    private String placa;
    private int numeroPasajeros;

    // Constructor

    public Vehiculo(String marca, String modelo, int año, String placa, int numeroPasajeros) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.placa = placa;
        this.numeroPasajeros = numeroPasajeros;
    }

    // Métodos Get

    public String getMarca() { 
        return marca;
     }
    public String getModelo() { 
        return modelo;
     }
    public int getAnio() { 
        return año;
     }
    public String getPlaca() { 
        return placa;
     }
    public int getNumeroPasajeros() { 
        return numeroPasajeros; 
    }
}

