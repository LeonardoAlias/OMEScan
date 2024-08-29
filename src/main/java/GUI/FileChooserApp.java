package GUI;

import javax.swing.*;
import entities.QrGenerator;
import entities.XlsxReader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import controllers.PatientFilterController;
import entities.Patient;
import repositories.PatientsRepo;
import GUI.QRTableDisplay;


public class FileChooserApp extends JFrame implements ActionListener{
    private JButton btnChooseFile1, btnChooseFile2, btnChooseFile3, btnRunApp;
    private JLabel lblFile1, lblFile2, lblFile3;
    private File file1, file2, file3;
    private File lastDirectory;

    public FileChooserApp() {
        // Establecer Nimbus Look and Feel para una apariencia más moderna
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

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
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona los tres archivos primero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private File chooseFile(JLabel label) {
        JFileChooser fileChooser = new JFileChooser();
        if (lastDirectory != null) {
            fileChooser.setCurrentDirectory(lastDirectory);
        }
        // Mejorar el diseño del JFileChooser
        fileChooser.setDialogTitle("Seleccione un archivo");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos Excel", "xlsx", "xls"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            lastDirectory = fileChooser.getCurrentDirectory(); // Guarda la última ubicación
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
        PatientFilterController pfc = new PatientFilterController();
        ArrayList<Patient> curated_patients = pfc.filterPatients();

        QRTableDisplay qrTableDisplay = new QRTableDisplay(curated_patients);
        qrTableDisplay.setVisible(true);
        setVisible(false);


    }

    public static void main(String[] args) {
        new FileChooserApp();
    }
}
