package Clases; // Declaración del paquete al que pertenece esta clase

import javax.swing.*; // Para la interfaz gráfica

public class AgregarCliente {
    // Método estático para agregar clientes a la empresa (no necesito instanciarlo)
    public static void agregarClientes(Empresa empresa) {
        while (true) {
            // Solicitar el nombre del cliente
            String nombreCliente = SolicitarDato.solicitarString("Ingrese el nombre del cliente:");
            if (nombreCliente == null || nombreCliente.isEmpty()) {
                break; // Si no se ingresa un nombre, salir del ciclo
            }

            // Solicitar la edad del cliente
            String edadStr = SolicitarDato.solicitarString("Ingrese la edad del cliente:");
            if (edadStr == null || edadStr.isEmpty()) {
                break; // Si no se ingresa una edad, salir del ciclo
            }

            // Convertir la edad a entero
            int edad = Integer.parseInt(edadStr);
            // Solicitar datos personales del cliente
            String datosPersonales = SolicitarDato.solicitarString("Ingrese los datos personales del cliente:");
            // Solicitar el teléfono de contacto del cliente
            String telefono = SolicitarDato.solicitarString("Ingrese el teléfono de contacto del cliente:");

            // Agregar el cliente a la empresa
            empresa.agregarCliente(new Cliente(nombreCliente, edad, datosPersonales, telefono));

            // Preguntar si desea agregar otro cliente
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro cliente?", "Agregar Cliente", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.NO_OPTION) {
                break; // Salir del ciclo si la respuesta es no
            }
        }
    }
}
