import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        double pesoKg = leerDoubleEnRango("Ingresa el peso del paquete (0.1 - 50 kg):", sc, 0.1, 50);
        int distanciaKm = leerIntEnRango("Ingresa la distancia en km (1 - 2000):", sc, 1, 2000);
        int tipoServicio = getValidServicio("Ingresa el tipo de servicio (1=Estándar, 2=Express):", sc);
        boolean esZonaRemota = leerBoolean("¿La zona es remota? (true/false):", sc);

        // Process
        ShippingCalculator calc = new ShippingCalculator();
        double subtotal = calc.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva);

        // Output
        imprimirTicket(pesoKg, distanciaKm, tipoServicio, esZonaRemota, subtotal, iva, total);
    }

    // Métodos de input
    public static double leerDoubleEnRango(String message, Scanner sc, double min, double max) {
        while (true) {
            System.out.println(message);
            if (sc.hasNextDouble()) {
                double value = sc.nextDouble();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("El número está fuera del rango (" + min + " - " + max + ")");
            } else {
                System.out.println("Entrada inválida. Ingresa un número decimal.");
                sc.nextLine();
            }
        }
    }

    public static int leerIntEnRango(String message, Scanner sc, int min, int max) {
        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("El número está fuera del rango (" + min + " - " + max + ")");
            } else {
                System.out.println("Entrada inválida. Ingresa un número entero.");
                sc.nextLine();
            }
        }
    }

    public static boolean leerBoolean(String message, Scanner sc) {
        while (true) {
            System.out.println(message);
            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("Entrada inválida. Escribe 'true' o 'false'.");
                sc.nextLine();
            }
        }
    }

    public static int getValidServicio(String message, Scanner sc) {
        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                int servicio = sc.nextInt();
                if (servicio == 1 || servicio == 2) {
                    return servicio;
                }
                System.out.println("Servicio inválido. Ingresa 1 (Estándar) o 2 (Express).");
            } else {
                System.out.println("Entrada inválida. Ingresa un número entero (1 o 2).");
                sc.nextLine();
            }
        }
    }

    // output
    public static void imprimirTicket(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota, double subtotal, double iva, double total) {
        System.out.println("--- Ticket ---");
        System.out.println("Servicio: " +tipoServicio);
        System.out.println("Peso: " + pesoKg + " kg");
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Zona remota: " + esZonaRemota);
        System.out.println("Subtotal (antes de IVA): $" + subtotal);
        System.out.println("IVA (16%): $" + iva);
        System.out.println("Total final: $" + total);
        System.out.println("--- Ticket ---");
    }
}
