public class Cliente {
    private String nombres;
    private String cedula;
    private int edad;

    // Constructor
    public Cliente(String nombres, String cedula, int edad) {
        this.nombres = nombres;
        this.cedula = cedula;
        this.edad = edad;
    }

    // Métodos Get
    public String getNombres() { 
        return nombres;
     }
    public String getCedula() { 
        return cedula; 
    }
    public int getEdad() { 
        return edad; 
    }
}