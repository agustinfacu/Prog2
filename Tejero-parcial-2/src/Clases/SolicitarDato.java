package Clases; // Declaración del paquete al que pertenece esta clase

import javax.swing.*; // Para la interfaz gráfica

public class SolicitarDato {
    // Método para solicitar un String al usuario
    public static String solicitarString(String mensaje) {
        return JOptionPane.showInputDialog(mensaje); // Muestra un cuadro de entrada
    }

    // Método para solicitar una dirección al usuario
    public static Direccion solicitarDireccion() {
        String calle = solicitarString("Ingrese la calle de la dirección de la empresa:");
        if (calle == null || calle.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La calle de la dirección de la empresa no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return null; // Si la calle es nula o vacía, retornar null
        }

        String ciudad = solicitarString("Ingrese la ciudad de la dirección de la empresa:");
        if (ciudad == null || ciudad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La ciudad de la dirección de la empresa no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return null; // Si la ciudad es nula o vacía, retornar null
        }

        String codigoPostal = solicitarString("Ingrese el código postal de la dirección de la empresa:");
        if (codigoPostal == null || codigoPostal.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El código postal de la dirección de la empresa no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return null; // Si el código postal es nulo o vacío, retornar null
        }

        // Retornar una nueva instancia de Direccion con los datos ingresados
        return new Direccion(calle, ciudad, codigoPostal);
    }
}
