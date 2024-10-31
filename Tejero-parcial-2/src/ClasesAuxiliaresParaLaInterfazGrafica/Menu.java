package ClasesAuxiliaresParaLaInterfazGrafica; // Declaración del paquete al que pertenece esta clase

import javax.swing.*; // Esto me ayudó para la interfaz gráfica
import Clases.Consulta; // Importa la clase Consulta
import Clases.CrearEmpresa; // Importa la clase CrearEmpresa
import Clases.Empresa;

public class Menu {
    // Atributo que almacena una instancia de Consulta para acceder a las empresas
    private final Consulta controller;
    private final CrearEmpresa crearEmpresa; // Atributo para manejar la creación de nuevas empresas

    // Constructor de la clase Menu que recibe un controlador de empresas
    public Menu(Consulta controller) {
        this.controller = controller; // Inicializa el controlador
        this.crearEmpresa = new CrearEmpresa(controller); // Inicializa la clase CrearEmpresa
    }

    // Método para mostrar el menú principal
    public void mostrarMenuPrincipal() {
        while (true) {
            // Opciones del menú principal: agregar nueva empresa y consultar
            String[] opciones = {"Agregar Nueva Empresa", "Consultar", "Salir"};

            // Mostrar un diálogo de opción para seleccionar una opción
            int seleccion = JOptionPane.showOptionDialog(null,
                    "Seleccione una opción:", 
                    "Menú Principal", 
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones, // Opciones a mostrar
                    opciones[0]); // Opción seleccionada por defecto

            // Lógica para moverse por el menú
            if (seleccion == 2) { // Opción Salir
                break; // Sale del bucle y termina el menú principal
            }

            if (seleccion == 0) { // Opción para agregar nueva empresa
                crearEmpresa.agregarNuevaEmpresa(); // Llama al método para agregar una nueva empresa
            } else if (seleccion == 1) { // Opción para consultar empresas
                mostrarMenuConsulta(); // Muestra el menú para consultar empresas
            }
        }
    }

    // Método para mostrar el menú de consulta de empresas
    private void mostrarMenuConsulta() {
        // Crear un JComboBox con los nombres de las empresas cargadas
        JComboBox<String> comboBox = new JComboBox<>();
        for (int i = 0; i < controller.getEmpresas().size(); i++) {
            comboBox.addItem(controller.getEmpresas().get(i).getNombre());
        }

        // Mostrar un diálogo para seleccionar una empresa
        int seleccionEmpresa = JOptionPane.showConfirmDialog(null,
                comboBox, 
                "Seleccione la Empresa a consultar:", 
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        // Verificar si se seleccionó una empresa válida
        if (seleccionEmpresa == JOptionPane.OK_OPTION) {
            int index = comboBox.getSelectedIndex(); // Obtener el índice de la empresa seleccionada
            mostrarSubMenu(index); // Muestra el submenú para la empresa seleccionada
        }
    }

    // Método para mostrar el submenú correspondiente a la empresa seleccionada
    private void mostrarSubMenu(int seleccionEmpresa) {
        // Obtener la empresa seleccionada
        Empresa empresaSeleccionada = controller.getEmpresas().get(seleccionEmpresa);
    
        // Construir el encabezado con los datos de la empresa
        String encabezado = "<html><b>" + empresaSeleccionada.getNombre() + "</b><br>" +
                        "CUIL: " + empresaSeleccionada.getCuil() + "<br>" +
                        "Dirección: " + empresaSeleccionada.getDireccion().toString() + "<br><br>" +
                        "<b>Seleccione qué desea consultar:</b></html>";
            while (true) {
                // Opciones del submenú: ver clientes, empleados, directivos, volver o salir
                String[] subOpciones = {"Clientes", "Empleados", "Directivos", "Volver", "Salir"};
                    
                // Mostrar un diálogo de opción para seleccionar una opción del submenú
                int seleccionSubOpcion = JOptionPane.showOptionDialog(null,
                encabezado, // Encabezado personalizado con los datos de la empresa y el mensaje
                "Menú de Opciones", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                subOpciones, // Opciones a mostrar
                subOpciones[0]); // Opción seleccionada por defecto
                    
                        // Lógica del menú
                        if (seleccionSubOpcion == 4) { // Opción Salir
                                System.exit(0); // Termina el programa
                            }
                        if (seleccionSubOpcion == 3) { // Opción Volver
                                break; // Sale del bucle y vuelve al menú principal
                            }
                    
                        mostrarInformacion(seleccionEmpresa, seleccionSubOpcion); // Muestra la información según la opción seleccionada
                        }
                    }
    // Método para mostrar la información basada en la selección de empresa y subopción
    private void mostrarInformacion(int seleccionEmpresa, int seleccionSubOpcion) {
        // Crea una instancia de TablasGraficas
        TablasGraficas tablasGraficas = new TablasGraficas();
        
        // Lógica del menú
        switch (seleccionSubOpcion) {
            case 0: // Opción Clientes
                tablasGraficas.mostrarClientes(controller.getEmpresas().get(seleccionEmpresa)); // Muestra la tabla de clientes
                break;
            case 1: // Opción Empleados
                tablasGraficas.mostrarEmpleados(controller.getEmpresas().get(seleccionEmpresa)); // Muestra la tabla de empleados
                break;
            case 2: // Opción Directivos
                tablasGraficas.mostrarDirectivos(controller.getEmpresas().get(seleccionEmpresa)); // Muestra la tabla de directivos
                break;
        }
    }
}
