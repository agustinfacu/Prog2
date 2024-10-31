package Clases; // Declaración del paquete al que pertenece esta clase


public class CrearEmpresa {
    // Atributo que almacena una instancia de Consulta para acceder a las empresas
    private final Consulta controller;

    // Constructor que recibe un controlador de empresas
    public CrearEmpresa(Consulta controller) {
        this.controller = controller; // Inicializa el controlador
    }

    // Método para agregar una nueva empresa
    public void agregarNuevaEmpresa() {
        // Solicitar el nombre de la empresa
        String nombre = SolicitarDato.solicitarString("Ingrese el nombre de la empresa:");
        if (nombre == null || nombre.isEmpty()) {
            return; // Si el nombre es nulo o vacío, salir del método
        }

        // Solicitar el CUIL de la empresa
        String cuil = SolicitarDato.solicitarString("Ingrese el CUIL de la empresa:");
        if (cuil == null || cuil.isEmpty()) {
            return; // Si el CUIL es nulo o vacío, salir del método
        }

        // Solicitar los datos de la dirección de la empresa
        Direccion direccion = SolicitarDato.solicitarDireccion();
        if (direccion == null) {
            return; // Si la dirección es nula, salir del método
        }

        // Crear la nueva empresa con los datos ingresados
        Empresa nuevaEmpresa = new Empresa(nombre, cuil, direccion);
        controller.agregarEmpresa(nuevaEmpresa); // Agregar la nueva empresa al controlador

        // Agregar empleados, directivos y clientes a la nueva empresa
        AgregarEmpleado.agregarEmpleados(nuevaEmpresa);
        AgregarDirectivo.agregarDirectivos(nuevaEmpresa);
        AgregarCliente.agregarClientes(nuevaEmpresa);
    }
}
