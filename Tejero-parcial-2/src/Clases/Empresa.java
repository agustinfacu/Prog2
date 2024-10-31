package Clases;// Declaración del paquete al que pertenece esta clase

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    //atributos de la clase Empresa
    private String nombre;
    private String cuil;
    private Direccion direccion;
    private List<Empleado> empleados;
    private List<Cliente> clientes;

    //Constructor
    public Empresa(String nombre, String cuil, Direccion direccion) {
        this.nombre = nombre;
        this.cuil = cuil;
        this.direccion = direccion;
        this.empleados = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    // Getters t setters
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getCuil() { return cuil;}
    public void setCuil(String cuil) { this.cuil = cuil;}

    public Direccion getDireccion() {return direccion;}
    public void setDireccion(Direccion direccion) {this.direccion = direccion;}

    public List<Empleado> getEmpleados() { return empleados;}
    public void agregarEmpleado(Empleado empleado) { empleados.add(empleado);}

    public List<Cliente> getClientes() { return clientes;}
    public void agregarCliente(Cliente cliente) { clientes.add(cliente);}

    // Método toString     
    @Override
    public String toString() {
        return "Empresa: " + nombre + ", CUIL: " + cuil + ", Dirección: " + direccion;
    }
}