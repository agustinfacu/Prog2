package Clases; // Declaración del paquete al que pertenece esta clase

import javax.swing.*; // Para la interfaz gráfica

public class AgregarEmpleado {
    // Método estático para agregar empleados a la empresa (no necesito instanciarlo)
    public static void agregarEmpleados(Empresa empresa) {
        while (true) {
            // Solicitar el nombre del empleado
            String nombreEmpleado = SolicitarDato.solicitarString("Ingrese el nombre del empleado:");
            if (nombreEmpleado == null || nombreEmpleado.isEmpty()) {
                break; // Si no se ingresa un nombre, salir del ciclo
            }

            // Solicitar la edad del empleado
            String edadStr = SolicitarDato.solicitarString("Ingrese la edad del empleado:");
            if (edadStr == null || edadStr.isEmpty()) {
                break; // Si no se ingresa una edad, salir del ciclo
            }

            // Convertir la edad a entero
            int edad = Integer.parseInt(edadStr);
            // Solicitar datos personales del empleado
            String datosPersonales = SolicitarDato.solicitarString("Ingrese los datos personales del empleado:");
            // Solicitar el sueldo bruto del empleado
            String sueldoStr = SolicitarDato.solicitarString("Ingrese el sueldo bruto del empleado:");
            double sueldo = Double.parseDouble(sueldoStr);

            // Agregar el empleado a la empresa
            empresa.agregarEmpleado(new Empleado(nombreEmpleado, edad, datosPersonales, sueldo));

            // Preguntar si desea agregar otro empleado
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro empleado?", "Agregar Empleado", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.NO_OPTION) {
                break; // Salir del ciclo si la respuesta es no
            }
        }
    }
}
