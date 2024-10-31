package Clases;// Declaración del paquete al que pertenece esta clase

public class Directivo extends Empleado {
    private String categoria;

    // Constructor
    public Directivo(String nombre, int edad, String datosPersonales, double sueldoBruto, String categoria) {
        super(nombre, edad, datosPersonales, sueldoBruto); // Llamada al constructor de Empleado
        this.categoria = categoria;
    }
    // Getters t setters
    public String getCategoria() { return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria; }

    // Método toString
    @Override
    public String toString() {
        return super.toString() + ", Categoría: " + categoria; // Llamada al toString de Empleado
    }
}
