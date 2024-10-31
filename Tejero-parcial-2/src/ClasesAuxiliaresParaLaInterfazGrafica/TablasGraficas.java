package ClasesAuxiliaresParaLaInterfazGrafica; // Declaración del paquete al que pertenece esta clase

import javax.swing.*; // Importación para la interfaz gráfica
import javax.swing.table.DefaultTableCellRenderer; // Importación para el renderizado de tablas
import javax.swing.table.DefaultTableModel; // Importación para el modelo de tablas

import Clases.Cliente; // Importación de la clase Cliente
import Clases.Directivo; // Importación de la clase Directivo
import Clases.Empleado; // Importación de la clase Empleado
import Clases.Empresa; // Importación de la clase Empresa

public class TablasGraficas {
    public void mostrarClientes(Empresa empresa) {
        String[] columnNames = {"Nombre", "Edad", "Datos Personales", "Teléfono"}; // Nombres de las columnas
        DefaultTableModel model = new DefaultTableModel(columnNames, 0); // Modelo de tabla

        for (Cliente cliente : empresa.getClientes()) { // Itera sobre los clientes
            model.addRow(new Object[]{cliente.getNombre(), cliente.getEdad(), cliente.getDatosPersonales(), cliente.getTelefonoContacto()}); // Agrega fila de cliente
        }

        JTable table = new JTable(model); // Crea la tabla
        centrarColumnas(table); // Centra las columnas
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Clientes de " + empresa.getNombre(), JOptionPane.INFORMATION_MESSAGE); // Muestra el diálogo
    }

    public void mostrarEmpleados(Empresa empresa) {
        String[] columnNames = {"Nombre", "Edad", "Datos Personales", "Sueldo Bruto"}; // Nombres de las columnas
        DefaultTableModel model = new DefaultTableModel(columnNames, 0); // Modelo de tabla

        for (Empleado empleado : empresa.getEmpleados()) { // Itera sobre los empleados
            if (!(empleado instanceof Directivo)) { // Verifica si el empleado no es un directivo
                model.addRow(new Object[]{empleado.getNombre(), empleado.getEdad(), empleado.getDatosPersonales(), "$" + String.format("%.2f", empleado.getSueldoBruto())}); // Agrega fila de empleado
            }
        }

        JTable table = new JTable(model); // Crea la tabla
        centrarColumnas(table); // Centra las columnas
        table.getColumnModel().getColumn(3).setCellRenderer(new RightAlignedCellRenderer()); // Alinea el sueldo a la derecha
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Empleados de " + empresa.getNombre(), JOptionPane.INFORMATION_MESSAGE); // Muestra el diálogo
    }

    public void mostrarDirectivos(Empresa empresa) {
        String[] columnNames = {"Nombre", "Edad", "Datos Personales", "Categoría", "Sueldo Bruto"}; // Nombres de las columnas
        DefaultTableModel model = new DefaultTableModel(columnNames, 0); // Modelo de tabla

        for (Empleado empleado : empresa.getEmpleados()) { // Itera sobre los empleados
            if (empleado instanceof Directivo) { // Verifica si el empleado es un directivo
                Directivo directivo = (Directivo) empleado; // Cast a Directivo
                model.addRow(new Object[]{directivo.getNombre(), directivo.getEdad(), directivo.getDatosPersonales(), directivo.getCategoria(), "$" + String.format("%.2f", directivo.getSueldoBruto())}); // Agrega fila de directivo
            }
        }

        JTable table = new JTable(model); // Crea la tabla
        centrarColumnas(table); // Centra las columnas
        table.getColumnModel().getColumn(4).setCellRenderer(new RightAlignedCellRenderer()); // Alinea el sueldo a la derecha
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Directivos de " + empresa.getNombre(), JOptionPane.INFORMATION_MESSAGE); // Muestra el diálogo
    }

    private void centrarColumnas(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); // Crea un renderer para centrar el texto
        centerRenderer.setHorizontalAlignment(JLabel.CENTER); // Centra el texto
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer); // Aplica el renderer a cada columna
        }
    }

    private static class RightAlignedCellRenderer extends DefaultTableCellRenderer {
        public RightAlignedCellRenderer() {
            setHorizontalAlignment(JLabel.RIGHT); // Alinea el texto a la derecha
        }
    }
}
