package entities;

import net.glxn.qrgen.javase.QRCode;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import repositories.PatientsRepo;

public class QrGenerator {
    public void Generator(){
        PatientsRepo patientsRepo = PatientsRepo.getInstance();
        try {
            patientsRepo.getPatients().forEach(patient -> {
                Path outputPath = Paths.get("/home/zhinon/Descargas/qrs/" + patient.affiliatenumToString() + ".png");
                File qrCodeFile = QRCode.from(patient.affiliatenumToString()).file();
                File outputFile = outputPath.toFile();

                if (outputFile.exists()) {
                    outputFile.delete();
                }

                qrCodeFile.renameTo(outputFile);
                System.out.println("QR Code generated at: " + outputFile.getAbsolutePath());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
