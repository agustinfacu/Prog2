package Clases;// Declaración del paquete al que pertenece esta clase

public class Direccion {
    // Atributos de la clase dirección
    private String calle;
    private String ciudad;
    private String codigoPostal;

    // Constructor
    public Direccion(String calle, String ciudad, String codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    // Getters y Setters
    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }

    // Método toString
    @Override
    public String toString() {
        return "Calle: " + calle + ", Ciudad: " + ciudad + ", Código Postal: " + codigoPostal;
    }
}
