package GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import com.google.zxing.WriterException;

import entities.Patient;
import entities.QrGenerator;

public class QRTableDisplay extends JFrame {

    public QRTableDisplay(ArrayList<Patient> patientData) throws WriterException {
        setTitle("Datos de Pacientes");

        // Columnas de la tabla
        String[] columnNames = {"Número de Afiliado", "Nombre del Paciente", "Número de OME", "Código QR"};

        // Modelo de la tabla
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 3) {
                    return ImageIcon.class;  // La columna del QR usará imágenes
                }
                return String.class;  // Las otras columnas usan texto
            }
        };

        QrGenerator qrg = new QrGenerator();

        // Agregar los datos de los pacientes
        for (Patient patient : patientData) {
            String aff_number = (String) patient.affiliatenumToString();
            String name = (String) patient.getName();
            String ome = (String) patient.getOmeListToString();
            String qrText = (String) patient.affiliatenumToString();

            // Generar imagen QR
            BufferedImage qrImage = qrg.generateQRCodeImage(qrText);
            ImageIcon qrIcon = new ImageIcon(qrImage);

            // Agregar fila a la tabla
            model.addRow(new Object[]{aff_number, name, ome, qrIcon});
        }

        // Crear la tabla con el modelo
        JTable table = new JTable(model);
        table.setRowHeight(300);  // Ajustar la altura de las filas para que se vea el QR

        // Renderizador para mostrar imágenes en la columna del QR
        table.getColumnModel().getColumn(2).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return new JLabel((ImageIcon) value);
            }
        });

        // Añadir la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar la ventana
    }
}
