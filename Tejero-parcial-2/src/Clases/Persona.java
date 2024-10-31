package Clases;// Declaración del paquete al que pertenece esta clase

public class Persona {
    // Atributos generales
    private String nombre;
    private int edad;
    private String datosPersonales;

    // Constructor
    public Persona(String nombre, int edad, String datosPersonales) {
        this.nombre = nombre;
        this.edad = edad;
        this.datosPersonales = datosPersonales;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getDatosPersonales() { return datosPersonales; }
    public void setDatosPersonales(String datosPersonales) { this.datosPersonales = datosPersonales; }

    // Método toString
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Datos Personales: " + datosPersonales;
    }
}
