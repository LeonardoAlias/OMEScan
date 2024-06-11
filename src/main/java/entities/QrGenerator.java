package entities;

import net.glxn.qrgen.javase.QRCode;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QrGenerator {
    public void Generator(){
        Path outputPath = Paths.get("C:\\Users\\leoal\\Downloads\\qrs\\hola.png");

        try {
            // Generate QR code and save to specified path
            File qrCodeFile = QRCode.from("150409569709-01").file();
            File outputFile = outputPath.toFile();

            if (outputFile.exists()) {
                outputFile.delete();
            }

            qrCodeFile.renameTo(outputFile);
            System.out.println("QR Code generated at: " + outputFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
