public class ShippingCalculator {

    public ShippingCalculator(){

    }//Constructor por default
    //Constantes
    private final double ZONAREMOTA = 0.10;
    private final double IVA = 0.16;
    private final double ESTANDAR = 50;
    private final double EXPRES = 90;
    private final double PRECIOCKG = 12;

//Atributos
    public double iva;
    public double subtotal;
    public double total;


    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota) {
        double subtotal = pesoKg * PRECIOCKG;

        // Tipo de servicio
        if (tipoServicio == 1) {
            subtotal += ESTANDAR;
        } else {
            subtotal += EXPRES;
        }

        // Distancia
        if (distanciaKm <= 50) {
            subtotal += 20;
        } else if (distanciaKm <= 200) {
            subtotal += 60;
        } else {
            subtotal += 120;
        }

        // Zona remota
        if (esZonaRemota) {
            subtotal *= (1 + ZONAREMOTA);
        }
        this.subtotal = subtotal; // guardar en atributo
        return subtotal;
    }
    public double calcularIVA(double subtotal){
        double iva = subtotal * IVA;
        this.iva = iva;
        return iva;

    }
    public double calcularTotal(double subtotal, double iva){
        double total = subtotal + iva;
        this.total = total;
        return total;
    }


}
