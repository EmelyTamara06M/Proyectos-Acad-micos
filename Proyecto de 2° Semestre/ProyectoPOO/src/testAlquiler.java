public class testAlquiler {

    public static void main(String[] args) {
        // Primer objeto de prueba 
        Cliente cliente1 = new Cliente("Luis Angel Molina Franco", "0912569745", 20);
        Vehiculo vehiculo1 = new Vehiculo("KIA", "PICANTO", 2025, "GSP2653", 1);
        Alquiler alquiler1 = new Alquiler(cliente1, vehiculo1, 200.00);
        alquiler1.presentarDetalles();

        System.out.println("\n"); 

        // Segundo objeto de prueba 
        Cliente cliente2 = new Cliente("Emely Tamara Moreira Pino", "0987654321", 19);
        Vehiculo vehiculo2 = new Vehiculo("CHEVROLET", "ONIX", 2024, "PQR1234", 0);
        Alquiler alquiler2 = new Alquiler(cliente2, vehiculo2, 600.00);
        alquiler2.presentarDetalles();
    }
}
