package Clases; // Declaración del paquete al que pertenece esta clase

import javax.swing.*; // Para la interfaz gráfica

public class AgregarDirectivo {
    // Método estático para agregar directivos a la empresa (no necesito instanciarlo)
    public static void agregarDirectivos(Empresa empresa) {
        while (true) {
            // Solicitar el nombre del directivo
            String nombreDirectivo = SolicitarDato.solicitarString("Ingrese el nombre del directivo:");
            if (nombreDirectivo == null || nombreDirectivo.isEmpty()) {
                break; // Si no se ingresa un nombre, salir del ciclo
            }

            // Solicitar la edad del directivo
            String edadStr = SolicitarDato.solicitarString("Ingrese la edad del directivo:");
            if (edadStr == null || edadStr.isEmpty()) {
                break; // Si no se ingresa una edad, salir del ciclo
            }

            // Convertir la edad a entero
            int edad = Integer.parseInt(edadStr);
            // Solicitar datos personales del directivo
            String datosPersonales = SolicitarDato.solicitarString("Ingrese los datos personales del directivo:");
            // Solicitar el sueldo bruto del directivo
            String sueldoStr = SolicitarDato.solicitarString("Ingrese el sueldo bruto del directivo:");
            double sueldo = Double.parseDouble(sueldoStr);
            // Solicitar la categoría del directivo
            String categoria = SolicitarDato.solicitarString("Ingrese la categoría del directivo:");

            // Agregar el directivo a la empresa
            empresa.agregarEmpleado(new Directivo(nombreDirectivo, edad, datosPersonales, sueldo, categoria));

            // Preguntar si desea agregar otro directivo
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro directivo?", "Agregar Directivo", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.NO_OPTION) {
                break; // Salir del ciclo si la respuesta es no
            }
        }
    }
}
