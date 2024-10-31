package Clases;// Declaración del paquete al que pertenece esta clase

public class Cliente {
    //atributos de la clase Cliente
    private String nombre;
    private int edad;
    private String datosPersonales;
    private String telefonoContacto;

    //Consrtuctor
    public Cliente(String nombre, int edad, String datosPersonales, String telefonoContacto) {
        this.nombre = nombre;
        this.edad = edad;
        this.datosPersonales = datosPersonales;
        this.telefonoContacto = telefonoContacto;
    }

    // Getters
    public String getNombre() {return nombre; }

    public int getEdad() {return edad;}

    public String getDatosPersonales() { return datosPersonales;}

    public String getTelefonoContacto() {return telefonoContacto;}
}
