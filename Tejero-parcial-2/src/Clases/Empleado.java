package Clases;// Declaración del paquete al que pertenece esta clase

public class Empleado extends Persona {
    private double sueldoBruto;

    // Constructor
    public Empleado(String nombre, int edad, String datosPersonales, double sueldoBruto) {
        super(nombre, edad, datosPersonales); // Llamada al constructor de Persona
        this.sueldoBruto = sueldoBruto;
    }
    // Getters t setters
    public double getSueldoBruto() {return sueldoBruto;}
    public void setSueldoBruto(double sueldoBruto) {this.sueldoBruto = sueldoBruto;}

    // Método toString    
    @Override
    public String toString() {
        return super.toString() + ", Sueldo Bruto: " + sueldoBruto; // Llamada al toString de Persona
    }
}
