import java.text.DecimalFormat;
public class Alquiler {

    private Cliente cliente;
    private Vehiculo vehiculo;
    private double kilometrosRecorridos;
    public static final double IVA_PORCENTAJE = 0.15;

    // Constructor
    public Alquiler(Cliente cliente, Vehiculo vehiculo, double kilometrosRecorridos) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    // Método para calcular el subtotal del alquiler
    public double calcularSubtotal() {
        double subtotal = 25.0; 
        if (kilometrosRecorridos > 500) {
            subtotal += (kilometrosRecorridos - 500) * 3.5 + (350 * 5); 
        } else if (kilometrosRecorridos > 150) {
            subtotal += (kilometrosRecorridos - 150) * 5.0;
        }
        return subtotal;
    }

    // Métodos para calcular IVA y Total
    public double calcularIVA() {
        return calcularSubtotal() * IVA_PORCENTAJE;
    }

    public double calcularTotal() {
        return calcularSubtotal() + calcularIVA();
    }

    //Método para presentar los datos
    public void presentarDetalles() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("=========================================================");
        System.out.println("                     SERVICE RENTA CAR");
        System.out.println("=========================================================");
        System.out.println("CEDULA: " + cliente.getCedula() + "\t\tNOMBRES: " + cliente.getNombres());
        System.out.println("---------------------------------------------------------");
        System.out.println("MARCA: " + vehiculo.getMarca() + "\t\t\tMODELO: " + vehiculo.getModelo());
        System.out.println("PLACA: " + vehiculo.getPlaca() + "\t\t\tAÑO: " + vehiculo.getAnio());
        System.out.println("No. PASAJEROS: " + vehiculo.getNumeroPasajeros());
        System.out.println("=========================================================");
        System.out.println("RECORRIDO: " + df.format(kilometrosRecorridos) + " km.");
        System.out.println("SUBTOTAL: $ " + df.format(calcularSubtotal()) + "\t\t\t% IVA: " + (int)(IVA_PORCENTAJE * 100) + "%");
        System.out.println("IVA:      $ " + df.format(calcularIVA()));
        System.out.println("TOTAL:    $ " + df.format(calcularTotal()));
        System.out.println("=========================================================");
    }
}


