package GUI;

import javax.swing.*;

import entities.QrGenerator;
import entities.XlsxReader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooserApp extends JFrame implements ActionListener{
    private JButton btnChooseFile1, btnChooseFile2, btnChooseFile3, btnRunApp;
    private JLabel lblFile1, lblFile2, lblFile3;
    private File file1, file2, file3;

    public FileChooserApp() {
        setTitle("Seleccionar Archivos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Botones y etiquetas para los archivos
        btnChooseFile1 = new JButton("Seleccionar archivo 1");
        btnChooseFile2 = new JButton("Seleccionar archivo 2");
        btnChooseFile3 = new JButton("Seleccionar archivo 3");

        lblFile1 = new JLabel("Archivo 1: No seleccionado");
        lblFile2 = new JLabel("Archivo 2: No seleccionado");
        lblFile3 = new JLabel("Archivo 3: No seleccionado");

        btnRunApp = new JButton("Correr aplicación");

        // Añadir ActionListeners
        btnChooseFile1.addActionListener(this);
        btnChooseFile2.addActionListener(this);
        btnChooseFile3.addActionListener(this);
        btnRunApp.addActionListener(this);

        // Añadir componentes al panel
        add(btnChooseFile1);
        add(lblFile1);
        add(btnChooseFile2);
        add(lblFile2);
        add(btnChooseFile3);
        add(lblFile3);
        add(new JLabel());  // Espacio vacío
        add(btnRunApp);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnChooseFile1) {
            file1 = chooseFile(lblFile1);
        } else if (e.getSource() == btnChooseFile2) {
            file2 = chooseFile(lblFile2);
        } else if (e.getSource() == btnChooseFile3) {
            file3 = chooseFile(lblFile3);
        } else if (e.getSource() == btnRunApp) {
            if (file1 != null && file2 != null && file3 != null) {
                try {
                    runApp();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona los tres archivos primero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private File chooseFile(JLabel label) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            label.setText("Seleccionado: " + selectedFile.getName());
            return selectedFile;
        }
        return null;
    }

    private void runApp() throws Exception {
        XlsxReader xr = new XlsxReader();
        xr.ListadoCupReader(file1.getAbsolutePath());
        xr.ListadoCajaReader(file2.getAbsolutePath());
        xr.ListadoTurnosReader(file3.getAbsolutePath());
        QrGenerator qrg = new QrGenerator();
        qrg.Generator();
    }

    public static void main(String[] args) {
        new FileChooserApp();
    }
}
