


//importo las clases porque las puse dentro de su propia carpeta para mayor legibilidad.
import Clases.Cliente;
import Clases.Direccion;
import Clases.Directivo;
import Clases.Empleado;
import Clases.Empresa;
import Clases.Consulta;
import ClasesAuxiliaresParaLaInterfazGrafica.Menu;


public class App {
    public static void main(String[] args) {
        Consulta controller = new Consulta();
        cargarDatos(controller);

        // Menú principal
        Menu menu = new Menu(controller);
        menu.mostrarMenuPrincipal();
    }

    private static void cargarDatos(Consulta controller) {
        // Carga de datos para Empresa 1 (Grupo Arcor)
        Direccion dir1 = new Direccion("Av. Túpac Amaru 1225", "Arroyito", "C5850AAA");
        Empresa empresa1 = new Empresa("Grupo Arcor S.A.", "30-62911733-6", dir1);

        // Empleados de Arcor
        String[] nombresEmpleadosArcor = {
                "Lucas Martínez", "Sofía González", "Javier Rodríguez", "Ana Pérez", "Diego López",
                "Marta García", "Sebastián Fernández", "Valentina Sánchez", "Pablo Morales", "Camila Torres"
        };
        // Directivos de Arcor
        String[] nombresDirectivosArcor = {
                "Carlos Silva", "María Ruiz", "Fernando Castro", "Lucía Romero"
        };
        // Agregar 10 empleados a la empresa1 (Grupo Arcor S.A.)
        for (int i = 0; i < 10; i++) {
            /* Crear un nuevo objeto Empleado con nombre, edad, datos personales y sueldo bruto
               Los nombres se obtienen de la lista nombresEmpleadosArcor, y la edad se incrementa en 1 por cada iteración
               Los datos personales son genéricos y el sueldo bruto comienza en 80000, aumentando en 2000 por cada empleado */
            empresa1.agregarEmpleado(new Empleado(nombresEmpleadosArcor[i], 30 + (i % 10), "Datos Personales " + (i + 1), 80000 + (i * 2000)));
        }

        // Agregar 4 directivos a la empresa1 (Grupo Arcor S.A.)
        for (int i = 0; i < 4; i++) {
            /* Crear un nuevo objeto Directivo con nombre, edad, datos personales, sueldo bruto y categoría
               Los nombres se obtienen de la lista nombresDirectivosArcor, y la edad también se incrementa en 1 por cada iteración
               El sueldo bruto comienza en 150000, aumentando en 5000 por cada directivo
               La categoría es un string que se forma como "Categoría 1", "Categoría 2", etc. */
            empresa1.agregarEmpleado(new Directivo(nombresDirectivosArcor[i], 45 + (i % 5), "Datos Personales " + (i + 11), 150000 + (i * 5000), "Categoría " + (i + 1)));
        }

        // Agregar 10 clientes a la empresa1 (Grupo Arcor S.A.)
        for (int i = 0; i < 10; i++) {
            /*  Crear un nuevo objeto Cliente con nombre, edad, datos personales y teléfono de contacto
                Los nombres se generan como "Cliente Arcor 1", "Cliente Arcor 2", etc.
                La edad se incrementa de 25 a 29, reutilizando la misma edad con variación por módulo
                Los datos personales son genéricos y el teléfono se genera de forma secuencial */
            empresa1.agregarCliente(new Cliente("Cliente Arcor " + (i + 1), 25 + (i % 5), "Datos Personales " + (i + 1), "011-1234-567" + i));
        }


        // Carga de datos para Empresa 2 (Telecom Argentina)
        Direccion dir2 = new Direccion("Av. Leandro N. Alem 939", "Buenos Aires", "C1001ABC");
        Empresa empresa2 = new Empresa("Telecom Argentina S.A.", "30-70919310-8", dir2);

        // Empleados de Telecom
        String[] nombresEmpleadosTelecom = {
                "Martín López", "Julián Méndez", "Gabriela Ortiz", "Claudia Díaz", "Ricardo Castro",
                "Florencia Morales", "Antonio Romero", "Verónica Fernández", "Ezequiel Ruiz", "Mariana Salazar"
        };
        // Directivos de Telecom
        String[] nombresDirectivosTelecom = {
                "Hugo Martínez", "Elena González", "Patricio Torres", "Gabriela Herrera"
        };

        //Se repite la logica para agregar los empleados,directivos y clientes pero en la segunda empresa.
        for (int i = 0; i < 10; i++) {
            empresa2.agregarEmpleado(new Empleado(nombresEmpleadosTelecom[i], 30 + (i % 10), "Datos Personales " + (i + 21), 85000 + (i * 2000)));
        }
        for (int i = 0; i < 4; i++) {
            empresa2.agregarEmpleado(new Directivo(nombresDirectivosTelecom[i], 50 + (i % 5), "Datos Personales " + (i + 31), 180000 + (i * 5000), "Categoría " + (i + 1)));
        }
        for (int i = 0; i < 10; i++) {
            empresa2.agregarCliente(new Cliente("Cliente Telecom " + (i + 1), 28 + (i % 5), "Datos Personales " + (i + 21), "011-9876-543" + i));
        }

        controller.agregarEmpresa(empresa1);
        controller.agregarEmpresa(empresa2);
    }
}
