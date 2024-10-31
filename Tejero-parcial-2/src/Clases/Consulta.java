package Clases; // Declaración del paquete al que pertenece esta clase

import java.util.ArrayList; 
import java.util.List; 

public class Consulta {

    // Atributo que almacena una lista de objetos Empresa
    private List<Empresa> empresas;

    // Constructor
    public Consulta() {
        // Inicializa la lista de empresas como un nuevo ArrayList vacío
        this.empresas = new ArrayList<>();
    }

    // Método para agregar una nueva empresa a la lista
    public void agregarEmpresa(Empresa empresa) {
        empresas.add(empresa); 
    }

    // Método que devuelve la lista de empresas
    public List<Empresa> getEmpresas() {
        return empresas;
    }

    // Método para mostrar los datos de todas las empresas, sus empleados y clientes
    public void mostrarDatos() {
        
        // Itera sobre cada empresa en la lista de empresas
        for (Empresa empresa : empresas) {
            System.out.println(empresa); // Imprime la información de la empresa
            System.out.println("Empleados:"); // Muestra un encabezado para la sección de empleados
            
            // Itera sobre cada empleado de la empresa
            for (Empleado empleado : empresa.getEmpleados()) {
                System.out.println(" - " + empleado); // Muestra la información del empleado
            }
            System.out.println("Clientes:"); // Imprime un encabezado para la sección de clientes
            
            // Itera sobre cada cliente de la empresa
            for (Cliente cliente : empresa.getClientes()) {
                System.out.println(" - " + cliente); // Imprime la información del cliente
            }
        }
    }
}
